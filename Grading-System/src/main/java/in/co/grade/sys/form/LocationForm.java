package in.co.grade.sys.form;

import javax.validation.constraints.NotEmpty;

import in.co.grade.sys.dto.BaseDTO;
import in.co.grade.sys.dto.CourseToStudentDTO;
import in.co.grade.sys.dto.LocationDTO;
import in.co.grade.sys.dto.PaymentDTO;
import in.co.grade.sys.dto.ResultDTO;
import in.co.grade.sys.util.DataUtility;

public class LocationForm extends BaseForm {

	@NotEmpty(message = "Location Name is required")
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public BaseDTO getDTO() {
		LocationDTO dto = new LocationDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);
		dto.setCreatedDatetime(createdDateTime);
		dto.setModifiedDatetime(modifiedDateTime);
		return dto;
	}

	@Override
	public void populate(BaseDTO bdto) {
		LocationDTO dto = (LocationDTO) bdto;
		id = dto.getId();
		name=dto.getName();
		createdBy = dto.getCreatedBy();
		modifiedBy = dto.getModifiedBy();
		createdDateTime = dto.getCreatedDatetime();
		modifiedDateTime = dto.getModifiedDatetime();
	}

}
