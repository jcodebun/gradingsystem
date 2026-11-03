package in.co.grade.sys.form;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import in.co.grade.sys.dto.BaseDTO;
import in.co.grade.sys.dto.ScheduleDTO;
import in.co.grade.sys.util.DataUtility;

public class ScheduleForm extends BaseForm {
	
	@Min(value = 1, message = "Select Location Name")
	private long locationId;
	private String locationName;
	
	@Min(value = 1, message = "Select Course Name")
	private long courseId;
	private String courseName;
	
	@Min(value = 0, message = "Minimum hour must be 0")
	@Max(value = 23, message = "Max hour must be 23")
	@Pattern(regexp = "[+-]?[0-9]+", message = "Start Hour is Invalid")
	@NotEmpty(message = "Start Hour is required")
	private String startHour;
	
	@Min(value = 0, message = "Minimum hour must be 0")
	@Max(value = 23, message = "Max hour must be 23")
	@Pattern(regexp = "[+-]?[0-9]+", message = "End Hour is Invalid")
	@NotEmpty(message = "End Hour is required")
	private String endHour;
	
	@Min(value = 0, message = "Minimum minute must be 0")
	@Max(value = 59, message = "Max minute must be 59")
	@Pattern(regexp = "[+-]?[0-9]+", message = "Start Minute is Invalid")
	@NotEmpty(message = "Start Minute Password is required")
	private String startMinute;
	
	@Min(value = 0, message = "Minimum minute must be 0")
	@Max(value = 59, message = "Max minute must be 59")
	@Pattern(regexp = "[+-]?[0-9]+", message = "End Minute is Invalid")
	@NotEmpty(message = "End Minute is required")
	private String endMinute;
	
	@NotEmpty(message = "Date is required")
	private String date;
	
	@Pattern(regexp = "[+-]?[0-9]+", message = "Entry Amount is Invalid")
	@NotEmpty(message = "Entry Amount is required")
	private String amount;
	
	
	
	
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public long getLocationId() {
		return locationId;
	}
	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getStartHour() {
		return startHour;
	}
	public void setStartHour(String startHour) {
		this.startHour = startHour;
	}
	public String getEndHour() {
		return endHour;
	}
	public void setEndHour(String endHour) {
		this.endHour = endHour;
	}
	public String getStartMinute() {
		return startMinute;
	}
	public void setStartMinute(String startMinute) {
		this.startMinute = startMinute;
	}
	public String getEndMinute() {
		return endMinute;
	}
	public void setEndMinute(String endMinute) {
		this.endMinute = endMinute;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public BaseDTO getDTO() {
		ScheduleDTO dto=new ScheduleDTO();
		dto.setId(id);
		dto.setCourseId(courseId);
		dto.setLocationId(locationId);
		dto.setCourseName(courseName);
		dto.setLocationName(locationName);
		dto.setStartHour(startHour);
		dto.setStartMinute(startMinute);
		dto.setEndHour(endHour);
		dto.setEndMinute(endMinute);
		dto.setDate(DataUtility.getDate(date));
		dto.setAmount(DataUtility.getLong(amount));
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);
		dto.setCreatedDatetime(createdDateTime);
		dto.setModifiedDatetime(modifiedDateTime);
		return dto;
	}
	@Override
	public void populate(BaseDTO bdto) {
		ScheduleDTO dto=(ScheduleDTO)bdto;
		id=dto.getId();
		courseId=dto.getCourseId();
		courseName=dto.getCourseName();
		locationId=dto.getLocationId();
		locationName=dto.getLocationName();
		startHour=dto.getStartHour();
		endHour=dto.getEndHour();
		startMinute=dto.getStartMinute();
		endMinute=dto.getEndMinute();
		amount=String.valueOf(dto.getAmount());
		date=DataUtility.getDateString(dto.getDate());
		createdBy = dto.getCreatedBy();
		modifiedBy = dto.getModifiedBy();
		createdDateTime = dto.getCreatedDatetime();
		modifiedDateTime = dto.getModifiedDatetime();
	}

}
