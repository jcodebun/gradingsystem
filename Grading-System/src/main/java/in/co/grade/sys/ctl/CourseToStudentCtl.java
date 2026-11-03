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
import in.co.grade.sys.dto.CourseToStudentDTO;
import in.co.grade.sys.dto.StudentDTO;
import in.co.grade.sys.exception.DuplicateRecordException;
import in.co.grade.sys.form.CourseToStudentForm;
import in.co.grade.sys.service.CourseServiceInt;
import in.co.grade.sys.service.CourseToStudentServiceInt;
import in.co.grade.sys.service.StudentServiceInt;
import in.co.grade.sys.util.DataUtility;

@Controller
public class CourseToStudentCtl extends BaseCtl {

	private Logger log = Logger.getLogger(CourseToStudentCtl.class.getName());

	@Autowired
	private CourseToStudentServiceInt service;

	@Autowired
	private CourseServiceInt courseService;

	@Autowired
	private StudentServiceInt studentService;

	@ModelAttribute
	public void preload(Model model, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		List<CourseDTO> cList = courseService.list();
		if (cList == null || cList.size() == 0) {
			request.getRequestDispatcher("/ctl/course_add").forward(request, response);
		}
		model.addAttribute("courseList", cList);

		List sList = studentService.list();
		if (sList == null || sList.size() == 0) {
			request.getRequestDispatcher("/ctl/student_add").forward(request, response);
		}
		model.addAttribute("studentList", sList);

	}

	@GetMapping("/ctl/course_add_student")
	public String display(@ModelAttribute("form") CourseToStudentForm form, Model model) {
		log.info("CourseToStudentCtl CourseToStudent display method start");
		if (form.getId() > 0) {
			form.populate(service.findBypk(form.getId()));
		}
		log.info("CourseToStudentCtl CourseToStudent display method end");
		return "courseToStudent";
	}

	@PostMapping("/ctl/course_add_student")
	public String submit(@RequestParam String operation, @Valid @ModelAttribute("form") CourseToStudentForm form,
			BindingResult bindingResult, Model model) {

		log.info("CourseToStudentCtl CourseToStudent submit method start");

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/course_add_student";
		}

		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "courseToStudent";
		}

		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				CourseToStudentDTO dto = (CourseToStudentDTO) form.getDTO();
				StudentDTO sDto = studentService.findBypk(dto.getStudentId());
				CourseDTO cDto = courseService.findBypk(dto.getCourseId());
				dto.setStudentName(sDto.getFirstName() + " " + sDto.getLastName());
				dto.setCourseName(cDto.getName());
				if (dto.getId() > 0) {
					service.update(dto);
					model.addAttribute("success", "Data Update Successfully!!!!");
				} else {
					service.add(dto);
					model.addAttribute("success", "Data Saved Successfully!!!!");
				}
				return "courseToStudent";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "courseToStudent";
		}

		log.info("CourseToStudentCtl airort submit method end");
		return "courseToStudent";
	}

	@RequestMapping(value = "/ctl/course_list_student", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(HttpSession session, @ModelAttribute("form") CourseToStudentForm form,

			@RequestParam(required = false) String operation,Long sId, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/course_list_student";
		}

		if (OP_NEW.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/course_add_student";
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
					CourseToStudentDTO dto = new CourseToStudentDTO();
					dto.setId(id);
					service.delete(dto);
				}

				model.addAttribute("success", "Record Deleted Successfully");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		CourseToStudentDTO dto = (CourseToStudentDTO) form.getDTO();

		if(DataUtility.getLong(String.valueOf(sId))>0) {
			dto.setStudentId(DataUtility.getLong(String.valueOf(sId)));
		}
		
		List<CourseToStudentDTO> list = service.search(dto, pageNo, pageSize);

		List<CourseToStudentDTO> totallist = service.search(dto);

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

		return "courseToStudentList";

	}

}
