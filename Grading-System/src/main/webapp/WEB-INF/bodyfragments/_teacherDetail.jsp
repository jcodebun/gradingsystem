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

<c:url var="addUrl" value="/ctl/student_add" />

<c:url var="addSearch" value="/ctl/student_list" />

<c:url var="editUrl" value="/ctl/teacher_add?id=" />

<c:url var="courseEditUrl" value="/ctl/course_list_teacher?tId=" />

<c:url var="courseDetail" value="/ctl/course_details/" />


<br>
<nav aria-label="breadcrumb">
	<ol class="breadcrumb primary-color">
		<li class="breadcrumb-item"><a class="white-text" href="#">Home</a></li>
		<li class="breadcrumb-item active">Teacher Detail</li>
	</ol>
</nav>

<div class="col-md-5">
	<div class="form-area">
		<h4>Teacher Detail</h4>
	</div>
</div>
<b><%@ include file="businessMessage.jsp"%></b>
<hr>
<br>
<sf:form action="${addSearch}" method="post" modelAttribute="form">

	<table class="table table-striped table-bordered table-sm" width="99%">
		<thead>
			<tr>

<th class="th-sm">First Name</th>

				<th class="th-sm">Last Name</th>
				<th class="th-sm">Email Id</th>
				<th class="th-sm">Phone No</th>
				<th class="th-sm">Salary</th>
				<th class="th-sm">Country</th>
				<th class="th-sm">State</th>
				<th class="th-sm">City</th>
				<th class="th-sm">Address</th>
				<th class="th-sm">Edit</th>
		</thead>
		<tbody>
			<tr>
					<td><c:out value="${tDto.firstName}" /></td>
					<td><c:out value="${tDto.lastName}" /></td>
					<td><c:out value="${tDto.emailId}" /></td>
					<td><c:out value="${tDto.phoneNo}" /></td>
					<td><c:out value="${tDto.salary}" /></td>
					<td><c:out value="${tDto.country}" /></td>
					<td><c:out value="${tDto.state}" /></td>
					<td><c:out value="${tDto.city}" /></td>
					<td><c:out value="${tDto.address}" /></td>
					<td><a href="${editUrl}${tDto.id}" class="btn btn-primary">Edit</a>
				</td>
			</tr>

		</tbody>
	</table>
<hr>
<div class="col-md-2">
</div>
<div class="col-md-8">
	<div class="col-md-5">
		<div class="form-area">
			<h4>Teacher Course Detail</h4>
		</div>
	</div>
	<table class="table table-striped table-bordered table-sm" width="99%">
		<thead>
			<tr>
				<th class="th-sm">Course Name</th>
				<th class="th-sm">View Detail</th>
		</thead>
		<tbody>
		<c:forEach items="${cList}" var="co" varStatus="course">
			<tr>
				<td><c:out value="${co.courseName}" /></td>
				<td><a href="${courseDetail}${co.courseId}" class="btn btn-primary">View Course Detail</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
		
	</table>
	<a href="${courseEditUrl}${tDto.id}" class="btn btn-primary">Edit Course Detail</a>
	
</div>
<div class="col-md-2">
</div>
</sf:form>