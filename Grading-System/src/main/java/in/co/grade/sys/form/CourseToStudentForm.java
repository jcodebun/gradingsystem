package in.co.grade.sys.form;

import javax.validation.constraints.Min;

import in.co.grade.sys.dto.BaseDTO;
import in.co.grade.sys.dto.CourseToStudentDTO;

public class CourseToStudentForm extends BaseForm {

	@Min(value = 1, message = "Select Course Name")
	private long courseId;
	@Min(value = 1, message = "Select Student Name")
	private long studentId;
	private String courseName;
	private String studentName;

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
		CourseToStudentDTO dto = new CourseToStudentDTO();
		dto.setId(id);
		dto.setCourseId(courseId);
		dto.setStudentId(studentId);
		dto.setCourseName(courseName);
		dto.setStudentName(studentName);
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);
		dto.setCreatedDatetime(createdDateTime);
		dto.setModifiedDatetime(modifiedDateTime);
		return dto;
	}

	@Override
	public void populate(BaseDTO bdto) {
		CourseToStudentDTO dto = (CourseToStudentDTO) bdto;
		id = dto.getId();
		courseId = dto.getCourseId();
		studentId = dto.getStudentId();
		courseName = dto.getCourseName();
		studentName = dto.getStudentName();
		createdBy = dto.getCreatedBy();
		modifiedBy = dto.getModifiedBy();
		createdDateTime = dto.getCreatedDatetime();
		modifiedDateTime = dto.getModifiedDatetime();
	}

}
