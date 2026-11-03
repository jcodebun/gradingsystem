package in.co.grade.sys.ctl;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.grade.sys.dto.CourseDTO;
import in.co.grade.sys.dto.CourseToStudentDTO;
import in.co.grade.sys.dto.CourseToTeacherDTO;
import in.co.grade.sys.dto.PaymentDTO;
import in.co.grade.sys.dto.ResultDTO;
import in.co.grade.sys.dto.ScheduleDTO;
import in.co.grade.sys.dto.StudentDTO;
import in.co.grade.sys.exception.DuplicateRecordException;
import in.co.grade.sys.form.CourseForm;
import in.co.grade.sys.form.StudentForm;
import in.co.grade.sys.service.CourseServiceInt;
import in.co.grade.sys.service.CourseToStudentServiceInt;
import in.co.grade.sys.service.CourseToTeacherServiceInt;
import in.co.grade.sys.service.ResultServiceInt;
import in.co.grade.sys.service.ScheduleServiceInt;

@Controller
public class CourseCtl extends BaseCtl {

	private Logger log = Logger.getLogger(CourseCtl.class.getName());

	@Autowired
	private CourseServiceInt service;
	
	@Autowired
	private CourseToStudentServiceInt courseStudnetService;
	
	@Autowired
	private CourseToTeacherServiceInt courseTeacherService;
	
	@Autowired
	private ResultServiceInt resultService;
	
	@Autowired
	private ScheduleServiceInt scheduleService;

	@GetMapping("/ctl/course_add")
	public String display(@ModelAttribute("form") CourseForm form, Model model) {
		log.info("CourseCtl Course display method start");
		if (form.getId() > 0) {
			form.populate(service.findBypk(form.getId()));
		}
		log.info("CourseCtl Course display method end");
		return "course";
	}
	


	@PostMapping("/ctl/course_add")
	public String submit(@RequestParam String operation, @Valid @ModelAttribute("form") CourseForm form,
			BindingResult bindingResult, Model model) {

		log.info("CourseCtl Course submit method start");

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/course_add";
		}

		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "course";
		}

		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				CourseDTO dto = (CourseDTO) form.getDTO();
				System.out.println(dto);
				if (dto.getId() > 0) {
					service.update(dto);
					model.addAttribute("success", "Data Update Successfully!!!!");
				} else {
					service.add(dto);
					model.addAttribute("success", "Data Saved Successfully!!!!");
				}
				return "course";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "course";
		}

		log.info("CourseCtl airort submit method end");
		return "course";
	}

	@RequestMapping(value = "/ctl/course_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(HttpSession session, @ModelAttribute("form") CourseForm form,
			@RequestParam(required = false) String operation, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/course_list";
		}

		if (OP_NEW.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/course_add";
		}
		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equalsIgnoreCase(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equalsIgnoreCase(operation)) {
			pageNo--;
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equalsIgnoreCase(operation)) {

			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					CourseDTO dto = new CourseDTO();
					dto.setId(id);
					service.delete(dto);
				}

				model.addAttribute("success", "Record Deleted Successfully");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		CourseDTO dto = (CourseDTO) form.getDTO();

		List<CourseDTO> list = service.search(dto, pageNo, pageSize);

		List<CourseDTO> totallist = service.search(dto);

		model.addAttribute("list", list);

		if (list.size() == 0) {
			model.addAttribute("error", "Record Not found");
		}
		int listsize = list.size();
		int total = totallist.size();
		int pageNoPageSize = pageNo * pageSize;

		form.setPageNo(pageNo);
		form.setPageSize(pageSize);

		model.addAttribute("total", total);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("listsize", listsize);
		model.addAttribute("pagenosize", pageNoPageSize);

		return "courseList";

	}
	
	@RequestMapping(value = "/ctl/course_details/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public String detail(HttpSession session, @ModelAttribute("form") CourseForm form,
			@RequestParam(required = false) String operation, @PathVariable Long id, Model model) {

		CourseDTO cdto = service.findBypk(id);
		model.addAttribute("cDto", cdto);

		CourseToStudentDTO sDto = new CourseToStudentDTO();
		sDto.setCourseId(id);
		List<CourseToStudentDTO> courseStList = courseStudnetService.search(sDto);
		model.addAttribute("sList", courseStList);
		
		CourseToTeacherDTO tDto = new CourseToTeacherDTO();
		tDto.setCourseId(id);
		List<CourseToTeacherDTO> courseTchList = courseTeacherService.search(tDto);
		model.addAttribute("tList", courseTchList);
		
		ScheduleDTO sdDto=new ScheduleDTO();
		sdDto.setCourseId(id);
		List<ScheduleDTO> sdList=scheduleService.search(sdDto);
		model.addAttribute("sdList",sdList);
		
		ResultDTO rDto=new ResultDTO();
		rDto.setCourseId(id);
		List<ResultDTO> rList=resultService.search(rDto);
		model.addAttribute("rList",rList);
		

		return "courseDetail";

	}

}
