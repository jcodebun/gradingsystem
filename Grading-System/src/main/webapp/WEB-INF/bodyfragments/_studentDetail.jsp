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

<c:url var="editUrl" value="/ctl/student_add?id=" />

<c:url var="courseEditUrl" value="/ctl/course_list_student?sId=" />

<c:url var="paymentEditUrl" value="/ctl/payment_list?sId=" />

<c:url var="resultEditUrl" value="/ctl/result_list?sId=" />


<br>
<nav aria-label="breadcrumb">
	<ol class="breadcrumb primary-color">
		<li class="breadcrumb-item"><a class="white-text" href="#">Home</a></li>
		<li class="breadcrumb-item active">Student Detail</li>
	</ol>
</nav>

<div class="col-md-5">
	<div class="form-area">
		<h4>Student Detail</h4>
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
				<th class="th-sm">Organization</th>
				<th class="th-sm">Telephone</th>
				<th class="th-sm">Gender</th>
				<th class="th-sm">DOB</th>
				<th class="th-sm">Country</th>
				<th class="th-sm">State</th>
				<th class="th-sm">City</th>
				<th class="th-sm">Fax</th>
				<th class="th-sm">Edit</th>
		</thead>
		<tbody>
			<tr>
				<td><c:out value="${sDto.firstName}" /></td>
				<td><c:out value="${sDto.lastName}" /></td>
				<td><c:out value="${sDto.emailId}" /></td>
				<td><c:out value="${sDto.organization}" /></td>
				<td><c:out value="${sDto.telephone}" /></td>
				<td><c:out value="${sDto.gender}" /></td>
				<td><c:out value="${sDto.dob}" /></td>
				<td><c:out value="${sDto.country}" /></td>
				<td><c:out value="${sDto.state}" /></td>
				<td><c:out value="${sDto.city}" /></td>
				<td><c:out value="${sDto.fax}" /></td>
				<td><a href="${editUrl}${sDto.id}" class="btn btn-primary">Edit</a>
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
			<h4>Student Course Detail</h4>
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
	<a href="${courseEditUrl}${sDto.id}" class="btn btn-primary">Edit Course Detail</a>
	<hr>
	<div class="col-md-5">
		<div class="form-area">
			<h4>Student Payment Detail</h4>
		</div>
	</div>
	<table class="table table-striped table-bordered table-sm" width="99%">
		<thead>
			<tr>
				<th class="th-sm">Date </th>
				<th class="th-sm">Amount</th>
		</thead>
		<tbody>
		<c:forEach items="${pList}" var="py" varStatus="payment">
			<tr>
				<td><c:out value="${py.date}" /></td>
				<td><c:out value="${py.amount}" /></td>
				</td>
			</tr>
		</c:forEach>
		</tbody>
		
	</table>
	<a href="${paymentEditUrl}${sDto.id}" class="btn btn-primary">Edit Payment Detail</a>
	<hr>
	<div class="col-md-5">
		<div class="form-area">
			<h4>Student Result Detail</h4>
		</div>
	</div>
	<table class="table table-striped table-bordered table-sm" width="99%">
		<thead>
			<tr>
				<th class="th-sm">Course Name</th>
				<th class="th-sm">Session No</th>
				<th class="th-sm">Mark</th>
		</thead>
		<tbody>
		<c:forEach items="${rList}" var="rs" varStatus="result">
			<tr>
				<td><c:out value="${rs.courseName}" /></td>
				<td><c:out value="${rs.sessionNo}" /></td>
				<td><c:out value="${rs.mark}" /></td>
				</td>
			</tr>
		</c:forEach>
		</tbody>
		
	</table>
<a href="${resultEditUrl}${sDto.id}" class="btn btn-primary">Edit Result Detail</a>
</div>
<div class="col-md-2">
</div>
</sf:form>