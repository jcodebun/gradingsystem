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

<c:url var="addUrl" value="/ctl/teacher_add" />

<c:url var="addSearch" value="/ctl/teacher_list" />

<c:url var="editUrl" value="/ctl/teacher_add?id=" />

<c:url var="detailUrl" value="/ctl/teacher_details/" />

<br>
<nav aria-label="breadcrumb">
	<ol class="breadcrumb primary-color">
		<li class="breadcrumb-item"><a class="white-text" href="#">Home</a></li>
		<li class="breadcrumb-item active">Teacher List</li>
	</ol>
</nav>

<div class="col-md-5">
	<div class="form-area">
		<h4>Teacher List</h4>
	</div>
</div>
<b><%@ include file="businessMessage.jsp"%></b>
<hr>
<sf:form action="${addSearch}" method="post" modelAttribute="form">

	<div class="container">
		<div class="row row-cols-4">
			<div class="col">
				<s:bind path="firstName">
					<div class="input-group">
						<sf:input path="${status.expression}" type="text" placeholder="First Name"
							class="form-control" />
					</div>
				</s:bind>
			</div>
			<div class="col">
				<s:bind path="emailId">
					<div class="input-group">
						<sf:input path="${status.expression}" type="text" placeholder="Email Id"
							class="form-control" />
					</div>
				</s:bind>
			</div>
			<div class="col">
				<div class="input-group">

					<input type="submit" name="operation" class="btn btn-md btn-info"
						value="Search">&nbsp;&nbsp; <input type="submit"
						name="operation" class="btn btn-md btn-info" value="Reset">
				</div>
			</div>
		</div>
	</div>

	<br>

	<sf:input type="hidden" path="pageNo" />
	<sf:input type="hidden" path="pageSize" />

	<sf:input type="hidden" path="listsize" />
	<sf:input type="hidden" path="total" />
	<sf:input type="hidden" path="pagenosize" />

	<table class="table table-striped table-bordered table-sm" width="99%">
		<thead>
			<tr>
				
				<th class="th-sm"><input type="checkbox" id="selectall">Select
					All</th>
				
				<th class="th-sm">First Name</th>
				<th class="th-sm">Last Name</th>
				<th class="th-sm">Email Id</th>
				<th class="th-sm">Phone No</th>
				<th class="th-sm">Salary</th>
				<th class="th-sm">Country</th>
				<th class="th-sm">State</th>
				<th class="th-sm">City</th>
				<th class="th-sm">Address</th>
				<th class="th-sm">Detail</th>
				<th class="th-sm">Edit</th>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="tc" varStatus="tch">
				<tr>
					<td><input type="checkbox" class="case" name="ids"
						value="${tc.id}"></td>
					<td><c:out value="${tc.firstName}" /></td>
					<td><c:out value="${tc.lastName}" /></td>
					<td><c:out value="${tc.emailId}" /></td>
					<td><c:out value="${tc.phoneNo}" /></td>
					<td><c:out value="${tc.salary}" /></td>
					<td><c:out value="${tc.country}" /></td>
					<td><c:out value="${tc.state}" /></td>
					<td><c:out value="${tc.city}" /></td>
					<td><c:out value="${tc.address}" /></td>
					<td><a href="${detailUrl}${tc.id}" class="btn btn-primary">View Detail</a>
					<td><a href="${editUrl}${tc.id}" class="btn btn-primary">Edit</a>
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<div style="margin: 10px" class="row row-cols-4">
		<div class="col">
			<div class="input-group">
				<input type="submit" name="operation"
					<c:if test="${form.pageNo == 1}">disabled="disabled"</c:if>
					class="btn btn-primary" value="Previous">
			</div>
		</div>
		<div class="col">
			<div class="input-group">
				<input type="submit" name="operation"
					<c:if test="${listsize== 0}">disabled="disabled"</c:if>
					class="btn btn-primary" value="Delete">
			</div>
		</div>
		<div class="col">
			<div class="input-group">
				<input type="submit" name="operation" class="btn btn-primary"
					value="New">
			</div>
		</div>
		<div class="col">
			<div class="input-group">

				<input type="submit" name="operation"
					<c:if test="${total == pagenosize  || listsize < pageSize   }">disabled="disabled"</c:if>
					class="btn btn-primary" value="Next">
			</div>
		</div>
	</div>
</sf:form>