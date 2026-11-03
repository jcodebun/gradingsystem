package in.co.grade.sys.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "COURSE_TO_STUDENT")
public class CourseToStudentDTO extends BaseDTO {

	@Column(name = "COURSE_ID")
	private long courseId;
	@Column(name = "COURSE_NAME", length = 225)
	private String courseName;
	@Column(name = "STUDENT_ID")
	private long studentId;
	@Column(name = "STUDENT_NAME", length = 225)
	private String studentName;

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

	@Override
	public String getKey() {
		return null;
	}

	@Override
	public String getValue() {
		return null;
	}

}
