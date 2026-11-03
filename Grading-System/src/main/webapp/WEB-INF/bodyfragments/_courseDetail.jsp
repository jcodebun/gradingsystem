<%@page import="in.co.grade.sys.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>

<c:url var="addUrl" value="/ctl/course_add" />

<c:url var="addSearch" value="/ctl/course_list" />

<c:url var="editUrl" value="/ctl/course_add?id=" />

<c:url var="studentDetail" value="/ctl/student_details/" />

<c:url var="teacherDetail" value="/ctl/teacher_details/" />

<c:url var="resultEditUrl" value="/ctl/result_list?cId=" />

<c:url var="scheduleEditUrl" value="/ctl/schedule_list?cId=" />

<br>
<nav aria-label="breadcrumb">
	<ol class="breadcrumb primary-color">
		<li class="breadcrumb-item"><a class="white-text" href="#">Home</a></li>
		<li class="breadcrumb-item active">Course Detail</li>
	</ol>
</nav>

<div class="col-md-5">
	<div class="form-area">
		<h4>Course Detail</h4>
	</div>
</div>
<b><%@ include file="businessMessage.jsp"%></b>
<hr>
<br>
<sf:form action="${addSearch}" method="post" modelAttribute="form">

	<table class="table table-striped table-bordered table-sm" width="99%">
		<thead>
			<tr>


				<th class="th-sm">Name</th>
				<th class="th-sm">Credit Number</th>
				<th class="th-sm">Description</th>
				<th class="th-sm">Edit</th>
		</thead>
		<tbody>
			<tr>
				<td><c:out value="${cDto.name}" /></td>
				<td><c:out value="${cDto.creaditNumber}" /></td>
				<td><c:out value="${cDto.description}" /></td>
				<td><a href="${editUrl}${cDto.id}" class="btn btn-primary">Edit</a>
				</td>
			</tr>

		</tbody>
	</table>
	<hr>
	<div class="col-md-2"></div>
	<div class="col-md-8">
		<div class="col-md-5">
			<div class="form-area">
				<h4>Course Student Detail</h4>
			</div>
		</div>
		<table class="table table-striped table-bordered table-sm" width="99%">
			<thead>
				<tr>
					<th class="th-sm">Student Name</th>
					<th class="th-sm">View Detail</th>
			</thead>
			<tbody>
				<c:forEach items="${sList}" var="st" varStatus="student">
					<tr>
						<td><c:out value="${st.studentName}" /></td>
						<td><a href="${studentDetail}${st.studentId}"
							class="btn btn-primary">View Student Detail</a></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
		<hr>
		<div class="col-md-5">
			<div class="form-area">
				<h4>Course Teacher Detail</h4>
			</div>
		</div>
		<table class="table table-striped table-bordered table-sm" width="99%">
			<thead>
				<tr>
					<th class="th-sm">Teacher Name</th>
					<th class="th-sm">View Detail</th>
			</thead>
			<tbody>
				<c:forEach items="${tList}" var="tch" varStatus="teacher">
					<tr>
						<td><c:out value="${tch.teacherName}" /></td>
						<td><a href="${teacherDetail}${tch.teacherId}"
							class="btn btn-primary">View Teacher Detail</a></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
		<hr>
		<div class="col-md-5">
			<div class="form-area">
				<h4>Course Result Detail</h4>
			</div>
		</div>
		<table class="table table-striped table-bordered table-sm" width="99%">
			<thead>
				<tr>
					<th class="th-sm">Student Name</th>
					<th class="th-sm">Session No</th>
					<th class="th-sm">Mark</th>
			</thead>
			<tbody>
				<c:forEach items="${rList}" var="rs" varStatus="result">
					<tr>
						<td><c:out value="${rs.studentName}" /></td>
						<td><c:out value="${rs.sessionNo}" /></td>
						<td><c:out value="${rs.mark}" /></td>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	<a href="${resultEditUrl}${cDto.id}" class="btn btn-primary">Edit Result Detail</a>
		<hr>
		<div class="col-md-5">
			<div class="form-area">
				<h4>Course Schedule Detail</h4>
			</div>
		</div>
		<table class="table table-striped table-bordered table-sm" width="99%">
			<thead>
				<tr>
					<th class="th-sm">Location Name</th>
					<th class="th-sm">Start Hour</th>
					<th class="th-sm">Start Minute</th>
					<th class="th-sm">End Hour</th>
					<th class="th-sm">End Minute</th>
					<th class="th-sm">Date</th>
			</thead>
			<tbody>
				<c:forEach items="${sdList}" var="sd" varStatus="schedule">
					<tr>
						<td><c:out value="${sd.locationName}" /></td>
						<td><c:out value="${sd.startHour}" /></td>
						<td><c:out value="${sd.startMinute}" /></td>
						<td><c:out value="${sd.endHour}" /></td>
						<td><c:out value="${sd.endMinute}" /></td>
						<td><c:out value="${sd.date}" /></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
		<a href="${scheduleEditUrl}${cDto.id}" class="btn btn-primary">Edit Schedule Detail</a>
	</div>
	<div class="col-md-2"></div>
</sf:form>