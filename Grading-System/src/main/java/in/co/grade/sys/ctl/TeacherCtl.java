package in.co.grade.sys.ctl;

import java.util.HashMap;
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

import in.co.grade.sys.dto.CourseToStudentDTO;
import in.co.grade.sys.dto.CourseToTeacherDTO;
import in.co.grade.sys.dto.PaymentDTO;
import in.co.grade.sys.dto.ResultDTO;
import in.co.grade.sys.dto.StudentDTO;
import in.co.grade.sys.dto.TeacherDTO;
import in.co.grade.sys.exception.DuplicateRecordException;
import in.co.grade.sys.form.StudentForm;
import in.co.grade.sys.form.TeacherForm;
import in.co.grade.sys.service.CourseToTeacherServiceInt;
import in.co.grade.sys.service.TeacherServiceInt;

@Controller
public class TeacherCtl extends BaseCtl {

	private Logger log = Logger.getLogger(TeacherCtl.class.getName());

	@Autowired
	private TeacherServiceInt service;
	
	@Autowired
	private CourseToTeacherServiceInt courseService;

	@GetMapping("/ctl/teacher_add")
	public String display(@ModelAttribute("form") TeacherForm form, Model model) {
		log.info("TeacherCtl Teacher display method start");
		if (form.getId() > 0) {
			form.populate(service.findBypk(form.getId()));
		}
		log.info("TeacherCtl Teacher display method end");
		return "teacher";
	}
	


	@PostMapping("/ctl/teacher_add")
	public String submit(@RequestParam String operation, @Valid @ModelAttribute("form") TeacherForm form,
			BindingResult bindingResult, Model model) {

		log.info("TeacherCtl Teacher submit method start");

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/teacher_add";
		}

		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "teacher";
		}

		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				System.out.println("in Save");
				TeacherDTO dto = (TeacherDTO) form.getDTO();
				System.out.println(dto);
				if (dto.getId() > 0) {
					service.update(dto);
					model.addAttribute("success", "Data Update Successfully!!!!");
				} else {
					service.add(dto);
					model.addAttribute("success", "Data Saved Successfully!!!!");
				}
				return "teacher";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "teacher";
		}

		log.info("TeacherCtl airort submit method end");
		return "teacher";
	}

	@RequestMapping(value = "/ctl/teacher_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(HttpSession session, @ModelAttribute("form") TeacherForm form,
			@RequestParam(required = false) String operation, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/teacher_list";
		}

		if (OP_NEW.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/teacher_add";
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
					TeacherDTO dto = new TeacherDTO();
					dto.setId(id);
					service.delete(dto);
				}

				model.addAttribute("success", "Record Deleted Successfully");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		TeacherDTO dto = (TeacherDTO) form.getDTO();

		List<TeacherDTO> list = service.search(dto, pageNo, pageSize);

		List<TeacherDTO> totallist = service.search(dto);

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

		return "teacherList";

	}
	

	@RequestMapping(value = "/ctl/teacher_details/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public String detail(HttpSession session, @ModelAttribute("form") TeacherForm form,
			@RequestParam(required = false) String operation, @PathVariable Long id, Model model) {

		TeacherDTO tdto = service.findBypk(id);
		model.addAttribute("tDto",tdto);

		CourseToTeacherDTO tDto = new CourseToTeacherDTO();
		tDto.setTeacherId(id);
		List<CourseToTeacherDTO> courseList = courseService.search(tDto);
		model.addAttribute("cList", courseList);
	
		return "teacherDetail";

	}


}
