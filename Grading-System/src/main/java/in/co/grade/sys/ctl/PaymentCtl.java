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
import in.co.grade.sys.dto.PaymentDTO;
import in.co.grade.sys.dto.StudentDTO;
import in.co.grade.sys.exception.DuplicateRecordException;
import in.co.grade.sys.form.PaymentForm;
import in.co.grade.sys.service.CourseServiceInt;
import in.co.grade.sys.service.PaymentServiceInt;
import in.co.grade.sys.service.StudentServiceInt;
import in.co.grade.sys.util.DataUtility;


@Controller
public class PaymentCtl extends BaseCtl {

	private Logger log = Logger.getLogger(PaymentCtl.class.getName());

	@Autowired
	private PaymentServiceInt service;

	@Autowired
	private StudentServiceInt studentService;

	@ModelAttribute
	public void preload(Model model, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List sList = studentService.list();
		if (sList == null || sList.size() == 0) {
			request.getRequestDispatcher("/ctl/student_add").forward(request, response);
		}
		model.addAttribute("studentList", sList);

	}

	@GetMapping("/ctl/payment_add")
	public String display(@ModelAttribute("form") PaymentForm form, Model model) {
		log.info("PaymentCtl Payment display method start");
		if (form.getId() > 0) {
			form.populate(service.findBypk(form.getId()));
		}
		log.info("PaymentCtl Payment display method end");
		return "payment";
	}

	@PostMapping("/ctl/payment_add")
	public String submit(@RequestParam String operation, @Valid @ModelAttribute("form") PaymentForm form,
			BindingResult bindingResult, Model model) {

		log.info("PaymentCtl Payment submit method start");

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/payment_add";
		}

		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "payment";
		}

		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				PaymentDTO dto = (PaymentDTO) form.getDTO();
				StudentDTO sDto = studentService.findBypk(dto.getStudentId());
				dto.setStudentName(sDto.getFirstName() + " " + sDto.getLastName());
				System.out.println(dto);
				if (dto.getId() > 0) {
					service.update(dto);
					model.addAttribute("success", "Data Update Successfully!!!!");
				} else {
					service.add(dto);
					model.addAttribute("success", "Data Saved Successfully!!!!");
				}
				return "payment";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "payment";
		}

		log.info("PaymentCtl airort submit method end");
		return "payment";
	}

	@RequestMapping(value = "/ctl/payment_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(HttpSession session, @ModelAttribute("form") PaymentForm form,
			@RequestParam(required = false) String operation, Long sId, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/payment_list";
		}

		if (OP_NEW.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/payment_add";
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
					PaymentDTO dto = new PaymentDTO();
					dto.setId(id);
					service.delete(dto);
				}

				model.addAttribute("success", "Record Deleted Successfully");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		PaymentDTO dto = (PaymentDTO) form.getDTO();
		if (DataUtility.getLong(String.valueOf(sId)) > 0) {
			dto.setStudentId(DataUtility.getLong(String.valueOf(sId)));
		}

		List<PaymentDTO> list = service.search(dto, pageNo, pageSize);

		List<PaymentDTO> totallist = service.search(dto);

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

		return "paymentList";

	}

}
