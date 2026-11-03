package in.co.grade.sys.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "COURSE_TO_TEACHER")
public class CourseToTeacherDTO extends BaseDTO {

	@Column(name = "COURSE_ID")
	private long courseId;
	@Column(name = "COURSE_NAME", length = 225)
	private String courseName;
	@Column(name = "TEACHER_ID")
	private long teacherId;
	@Column(name = "TEACHER_NAME", length = 225)
	private String teacherName;

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	
	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
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
	public String getKey() {
		return null;
	}

	@Override
	public String getValue() {
		return null;
	}

}
