package in.co.grade.sys.ctl;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.grade.sys.dto.CourseDTO;
import in.co.grade.sys.dto.CourseToTeacherDTO;
import in.co.grade.sys.dto.TeacherDTO;
import in.co.grade.sys.exception.DuplicateRecordException;
import in.co.grade.sys.form.CourseToTeacherForm;
import in.co.grade.sys.service.CourseServiceInt;
import in.co.grade.sys.service.CourseToTeacherServiceInt;
import in.co.grade.sys.service.TeacherServiceInt;
import in.co.grade.sys.util.DataUtility;

@Controller
public class CourseToTeacherCtl extends BaseCtl {

	private Logger log = Logger.getLogger(CourseToTeacherCtl.class.getName());

	@Autowired
	private CourseToTeacherServiceInt service;

	@Autowired
	private CourseServiceInt courseService;

	@Autowired
	private TeacherServiceInt teacherService;

	@ModelAttribute
	public void preload(Model model, HttpServletResponse response, HttpServletRequest request)
			throws IOException, ServletException {
		List cList = courseService.list();
		if (cList == null || cList.size() == 0) {
			request.getRequestDispatcher("/ctl/course_add").forward(request, response);
		}
		model.addAttribute("courseList", cList);

		List tList = teacherService.list();
		if (tList == null || tList.size() == 0) {
			request.getRequestDispatcher("/ctl/teacher_add").forward(request, response);
		}
		model.addAttribute("teacherList", tList);

	}

	@GetMapping("/ctl/course_add_teacher")
	public String display(@ModelAttribute("form") CourseToTeacherForm form, Model model) {
		log.info("CourseToTeacherCtl CourseToTeacher display method start");
		if (form.getId() > 0) {
			form.populate(service.findBypk(form.getId()));
		}
		log.info("CourseToTeacherCtl CourseToTeacher display method end");
		return "courseToTeacher";
	}

	@PostMapping("/ctl/course_add_teacher")
	public String submit(@RequestParam String operation, @Valid @ModelAttribute("form") CourseToTeacherForm form,
			BindingResult bindingResult, Model model) {

		log.info("CourseToTeacherCtl CourseToTeacher submit method start");

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/course_add_teacher";
		}

		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "courseToTeacher";
		}

		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				CourseToTeacherDTO dto = (CourseToTeacherDTO) form.getDTO();
				TeacherDTO sDto = teacherService.findBypk(dto.getTeacherId());
				CourseDTO cDto = courseService.findBypk(dto.getCourseId());
				dto.setTeacherName(sDto.getFirstName() + " " + sDto.getLastName());
				dto.setCourseName(cDto.getName());
				if (dto.getId() > 0) {
					service.update(dto);
					model.addAttribute("success", "Data Update Successfully!!!!");
				} else {
					service.add(dto);
					model.addAttribute("success", "Data Saved Successfully!!!!");
				}
				return "courseToTeacher";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "courseToTeacher";
		}

		log.info("CourseToTeacherCtl airort submit method end");
		return "courseToTeacher";
	}

	@RequestMapping(value = "/ctl/course_list_teacher", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(HttpSession session, @ModelAttribute("form") CourseToTeacherForm form,

			@RequestParam(required = false) String operation,Long tId, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/course_list_teacher";
		}

		if (OP_NEW.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/course_add_teacher";
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
					CourseToTeacherDTO dto = new CourseToTeacherDTO();
					dto.setId(id);
					service.delete(dto);
				}

				model.addAttribute("success", "Record Deleted Successfully");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		CourseToTeacherDTO dto = (CourseToTeacherDTO) form.getDTO();
		if(DataUtility.getLong(String.valueOf(tId))>0) {
			dto.setTeacherId(DataUtility.getLong(String.valueOf(tId)));
		}


		List<CourseToTeacherDTO> list = service.search(dto, pageNo, pageSize);

		List<CourseToTeacherDTO> totallist = service.search(dto);

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

		return "courseToTeacherList";

	}

}
