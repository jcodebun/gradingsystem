package in.co.grade.sys.form;

import javax.validation.constraints.Min;

import in.co.grade.sys.dto.BaseDTO;
import in.co.grade.sys.dto.CourseToTeacherDTO;

public class CourseToTeacherForm extends BaseForm {

	@Min(value = 1, message = "Select Course Name")
	private long courseId;
	@Min(value = 1, message = "Select Teacher Name")
	private long teacherId;
	private String courseName;
	private String teacherName;

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

	

	public long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(long teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	@Override
	public BaseDTO getDTO() {
		CourseToTeacherDTO dto = new CourseToTeacherDTO();
		dto.setId(id);
		dto.setCourseId(courseId);
		dto.setTeacherId(teacherId);
		dto.setCourseName(courseName);
		dto.setTeacherName(teacherName);
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);
		dto.setCreatedDatetime(createdDateTime);
		dto.setModifiedDatetime(modifiedDateTime);
		return dto;
	}

	@Override
	public void populate(BaseDTO bdto) {
		CourseToTeacherDTO dto = (CourseToTeacherDTO) bdto;
		id = dto.getId();
		courseId = dto.getCourseId();
		teacherId = dto.getTeacherId();
		courseName = dto.getCourseName();
		teacherName = dto.getTeacherName();
		createdBy = dto.getCreatedBy();
		modifiedBy = dto.getModifiedBy();
		createdDateTime = dto.getCreatedDatetime();
		modifiedDateTime = dto.getModifiedDatetime();
	}

}
