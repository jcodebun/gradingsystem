package in.co.grade.sys.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import in.co.grade.sys.dto.BaseDTO;
import in.co.grade.sys.dto.CourseDTO;
import in.co.grade.sys.util.DataUtility;

public class CourseForm extends BaseForm {

	@NotEmpty(message = "Name is required")
	private String name;


	
	@Min(value = 1, message = "Minimum value must be 1")
	@Max(value = 8, message = "Max value must be 8")
	@Pattern(regexp = "[+-]?[0-9]+", message = "Creadit Number is Invalid")
	@NotEmpty(message = "Creadit Number is required")
	private String creaditNumber;

	@NotEmpty(message = "Description is required")
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreaditNumber() {
		return creaditNumber;
	}

	public void setCreaditNumber(String creaditNumber) {
		this.creaditNumber = creaditNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public BaseDTO getDTO() {
		CourseDTO dto = new CourseDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setCreaditNumber(DataUtility.getLong(creaditNumber));
		dto.setDescription(description);
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);
		dto.setCreatedDatetime(createdDateTime);
		dto.setModifiedDatetime(modifiedDateTime);
		return dto;
	}

	@Override
	public void populate(BaseDTO bdto) {
		CourseDTO dto = (CourseDTO) bdto;
		id = dto.getId();
		name = dto.getName();
		creaditNumber = String.valueOf(dto.getCreaditNumber());
		description = dto.getDescription();
		createdBy = dto.getCreatedBy();
		modifiedBy = dto.getModifiedBy();
		createdDateTime = dto.getCreatedDatetime();
		modifiedDateTime = dto.getModifiedDatetime();
	}

}
