package in.co.grade.sys.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import in.co.grade.sys.dto.BaseDTO;
import in.co.grade.sys.dto.CourseToStudentDTO;
import in.co.grade.sys.dto.ResultDTO;
import in.co.grade.sys.util.DataUtility;

public class ResultForm extends BaseForm {

	@Min(value = 1, message = "Select Course Name")
	private long courseId;
	@Min(value = 1, message = "Select Student Name")
	private long studentId;
	private String courseName;
	private String studentName;
	
	@Min(value = 101, message = "Minimum value must be 101")
	@Max(value = 1299, message = "Max value must be 1299")
	@Pattern(regexp = "[+-]?[0-9]+", message = "Session Number is Invalid")
	@NotEmpty(message = "Session Number is required")
	private String sessionNo;
	
	@Min(value = 0, message = "Minimum mark must be 0")
	@Max(value = 20, message = "Max mark must be 20")
	@Pattern(regexp = "[+-]?[0-9]+", message = "Mark is Invalid")
	@NotEmpty(message = "Mark is required")
	private String mark;
	
	

	public String getSessionNo() {
		return sessionNo;
	}

	public void setSessionNo(String sessionNo) {
		this.sessionNo = sessionNo;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Override
	public BaseDTO getDTO() {
		ResultDTO dto = new ResultDTO();
		dto.setId(id);
		dto.setCourseId(courseId);
		dto.setStudentId(studentId);
		dto.setCourseName(courseName);
		dto.setStudentName(studentName);
		dto.setSessionNo(DataUtility.getLong(sessionNo));
		dto.setMark(DataUtility.getLong(mark));
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);
		dto.setCreatedDatetime(createdDateTime);
		dto.setModifiedDatetime(modifiedDateTime);
		return dto;
	}

	@Override
	public void populate(BaseDTO bdto) {
		ResultDTO dto = (ResultDTO) bdto;
		id = dto.getId();
		courseId = dto.getCourseId();
		studentId = dto.getStudentId();
		courseName = dto.getCourseName();
		studentName = dto.getStudentName();
		createdBy = dto.getCreatedBy();
		modifiedBy = dto.getModifiedBy();
		createdDateTime = dto.getCreatedDatetime();
		modifiedDateTime = dto.getModifiedDatetime();
		sessionNo=String.valueOf(dto.getSessionNo());
		mark=String.valueOf(dto.getMark());
	}

}
