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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.grade.sys.dto.CourseDTO;
import in.co.grade.sys.dto.LocationDTO;
import in.co.grade.sys.dto.StudentDTO;
import in.co.grade.sys.exception.DuplicateRecordException;
import in.co.grade.sys.form.LocationForm;
import in.co.grade.sys.service.CourseServiceInt;
import in.co.grade.sys.service.LocationServiceInt;
import in.co.grade.sys.service.StudentServiceInt;

@Controller
public class LocationCtl extends BaseCtl {

	private Logger log = Logger.getLogger(LocationCtl.class.getName());

	@Autowired
	private LocationServiceInt service;
	
	
	@GetMapping("/ctl/location_add")
	public String display(@ModelAttribute("form") LocationForm form, Model model) {
		log.info("LocationCtl Location display method start");
		if (form.getId() > 0) {
			form.populate(service.findBypk(form.getId()));
		}
		log.info("LocationCtl Location display method end");
		return "location";
	}
	


	@PostMapping("/ctl/location_add")
	public String submit(@RequestParam String operation, @Valid @ModelAttribute("form") LocationForm form,
			BindingResult bindingResult, Model model) {

		log.info("LocationCtl Location submit method start");

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/ctl/location_add";
		}

		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "location";
		}

		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				LocationDTO dto = (LocationDTO) form.getDTO();
				if (dto.getId() > 0) {
					service.update(dto);
					model.addAttribute("success", "Data Update Successfully!!!!");
				} else {
					service.add(dto);
					model.addAttribute("success", "Data Saved Successfully!!!!");
				}
				return "location";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "location";
		}

		log.info("LocationCtl airort submit method end");
		return "location";
	}

	@RequestMapping(value = "/ctl/location_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(HttpSession session, @ModelAttribute("form") LocationForm form,
			@RequestParam(required = false) String operation, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/location_list";
		}

		if (OP_NEW.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/location_add";
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
					LocationDTO dto = new LocationDTO();
					dto.setId(id);
					service.delete(dto);
				}

				model.addAttribute("success", "Record Deleted Successfully");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		LocationDTO dto = (LocationDTO) form.getDTO();

		List<LocationDTO> list = service.search(dto, pageNo, pageSize);

		List<LocationDTO> totallist = service.search(dto);

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

		return "locationList";

	}

}
