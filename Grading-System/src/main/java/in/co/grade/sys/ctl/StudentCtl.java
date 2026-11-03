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

import in.co.grade.sys.dto.CourseDTO;
import in.co.grade.sys.dto.CourseToStudentDTO;
import in.co.grade.sys.dto.PaymentDTO;
import in.co.grade.sys.dto.ResultDTO;
import in.co.grade.sys.dto.StudentDTO;
import in.co.grade.sys.exception.DuplicateRecordException;
import in.co.grade.sys.form.StudentForm;
import in.co.grade.sys.service.CourseToStudentServiceInt;
import in.co.grade.sys.service.PaymentServiceInt;
import in.co.grade.sys.service.ResultServiceInt;
import in.co.grade.sys.service.StudentServiceInt;

@Controller
public class StudentCtl extends BaseCtl {

	private Logger log = Logger.getLogger(StudentCtl.class.getName());

	@Autowired
	private StudentServiceInt service;
	
	@Autowired
	private PaymentServiceInt paymentService;

	@Autowired
	private CourseToStudentServiceInt courseStudnetservice;
	
	@Autowired
	private ResultServiceInt resultService;

	@GetMapping("/ctl/student_add")
	public String display(@ModelAttribute("form") StudentForm form, Model model) {
		log.info("StudentCtl Student display method start");
		if (form.getId() > 0) {
			form.populate(service.findBypk(form.getId()));
		}
		log.info("StudentCtl Student display method end");
		return "student";
	}

	@ModelAttribute
	public void preload(Model model) {

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Male", "Male");
		map.put("Female", "Female");
		model.addAttribute("gender", map);

	}

	@PostMapping("/ctl/student_add")
	public String submit(@RequestParam String operation, @Valid @ModelAttribute("form") StudentForm form,
			BindingResult bindingResult, Model model) {

		log.info("StudentCtl Student submit method start");

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/student_add";
		}

		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "student";
		}

		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				System.out.println("in Save");
				StudentDTO dto = (StudentDTO) form.getDTO();
				System.out.println(dto);
				if (dto.getId() > 0) {
					service.update(dto);
					model.addAttribute("success", "Data Update Successfully!!!!");
				} else {
					service.add(dto);
					model.addAttribute("success", "Data Saved Successfully!!!!");
				}
				return "student";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "student";
		}

		log.info("StudentCtl airort submit method end");
		return "student";
	}

	@RequestMapping(value = "/ctl/student_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(HttpSession session, @ModelAttribute("form") StudentForm form,
			@RequestParam(required = false) String operation, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/student_list";
		}

		if (OP_NEW.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/student_add";
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
					StudentDTO dto = new StudentDTO();
					dto.setId(id);
					service.delete(dto);
				}

				model.addAttribute("success", "Record Deleted Successfully");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		StudentDTO dto = (StudentDTO) form.getDTO();

		List<StudentDTO> list = service.search(dto, pageNo, pageSize);

		List<StudentDTO> totallist = service.search(dto);

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

		return "studentList";

	}

	@RequestMapping(value = "/ctl/student_details/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public String detail(HttpSession session, @ModelAttribute("form") StudentForm form,
			@RequestParam(required = false) String operation, @PathVariable Long id, Model model) {

		StudentDTO sdto = service.findBypk(id);
		model.addAttribute("sDto", sdto);

		CourseToStudentDTO cDto = new CourseToStudentDTO();
		cDto.setStudentId(id);
		List<CourseToStudentDTO> courseList = courseStudnetservice.search(cDto);
		model.addAttribute("cList", courseList);
		
		PaymentDTO pDto=new PaymentDTO();
		pDto.setStudentId(id);
		List<PaymentDTO> pList=paymentService.search(pDto);
		model.addAttribute("pList",pList);
		
		ResultDTO rDto=new ResultDTO();
		rDto.setStudentId(id);
		List<ResultDTO> rList=resultService.search(rDto);
		model.addAttribute("rList",rList);
		

		return "studentDetail";

	}

}
