package in.co.grade.sys.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="SCHEDULE")
public class ScheduleDTO extends BaseDTO {

	@Column(name = "LOCATION_ID")
	private long locationId;
	@Column(name = "LOCATION_NAME",length = 225)
	private String locationName;
	@Column(name = "COURSE_ID")
	private long courseId;
	@Column(name = "COURSE_NAME",length = 225)
	private String courseName;
	@Column(name = "START_HOUR",length = 225)
	private String startHour;
	@Column(name = "END_HOUR",length = 225)
	private String endHour;
	@Column(name = "START_MINUTE",length = 225)
	private String startMinute;
	@Column(name = "END_MINUTE",length = 225)
	private String endMinute;
	@Column(name = "DATE")
	@Temporal(TemporalType.DATE)
	private Date date;
	@Column(name = "ENTRY_AMOUNT")
	private long amount;
	
	
	
	
	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "ScheduleDTO [locationId=" + locationId + ", locationName=" + locationName + ", courseId=" + courseId
				+ ", courseName=" + courseName + ", startHour=" + startHour + ", endHour=" + endHour + ", startMinute="
				+ startMinute + ", endMinute=" + endMinute + ", date=" + date + ", id=" + id + ", createdBy="
				+ createdBy + ", modifiedBy=" + modifiedBy + ", createdDatetime=" + createdDatetime
				+ ", modifiedDatetime=" + modifiedDatetime + "]";
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
