package in.co.grade.sys.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "RESULT")
public class ResultDTO extends BaseDTO {

	@Column(name="COURSE_ID")
	private long courseId;
	@Column(name="COURSE_NAME",length = 225)
	private String courseName;
	@Column(name="STUDENT_ID")
	private long studentId;
	@Column(name="STUDENT_NAME",length = 225)
	private String studentName;
	@Column(name="SESSION_NO")
	private long sessionNo;
	@Column(name="MARK")
	private long mark;
	
	
	
	
	@Override
	public String toString() {
		return "ResultDTO [courseId=" + courseId + ", courseName=" + courseName + ", studentId=" + studentId
				+ ", studentName=" + studentName + ", sessionNo=" + sessionNo + ", mark=" + mark + ", id=" + id
				+ ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + ", createdDatetime=" + createdDatetime
				+ ", modifiedDatetime=" + modifiedDatetime + "]";
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

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public long getSessionNo() {
		return sessionNo;
	}

	public void setSessionNo(long sessionNo) {
		this.sessionNo = sessionNo;
	}

	public long getMark() {
		return mark;
	}

	public void setMark(long mark) {
		this.mark = mark;
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
