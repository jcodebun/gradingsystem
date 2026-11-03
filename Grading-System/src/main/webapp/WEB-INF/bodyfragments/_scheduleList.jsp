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

<c:url var="addUrl" value="/ctl/schedule_add" />

<c:url var="addSearch" value="/ctl/schedule_list" />

<c:url var="editUrl" value="/ctl/schedule_add?id=" />


<br>
<nav aria-label="breadcrumb">
	<ol class="breadcrumb primary-color">
		<li class="breadcrumb-item"><a class="white-text" href="#">Home</a></li>
		<li class="breadcrumb-item active">Schedule List</li>
	</ol>
</nav>

<div class="col-md-5">
	<div class="form-area">
		<h4>Schedule List</h4>
	</div>
</div>
<b><%@ include file="businessMessage.jsp"%></b>
<hr>
<sf:form action="${addSearch}" method="post" modelAttribute="form">

	<div class="container">
		<div class="row row-cols-4">
			<div class="col">
				<s:bind path="locationName">
					<div class="input-group">
						<sf:input path="${status.expression}" type="text" placeholder="Location Name"
							class="form-control" />
					</div>
				</s:bind>
			</div>
			
			<div class="col">
				<s:bind path="courseName">
					<div class="input-group">
						<sf:input path="${status.expression}" type="text" placeholder="Course Name"
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
				
				<th class="th-sm">Course Name</th>
				<th class="th-sm">Location Name</th>
				<th class="th-sm">Start Hour</th>
				<th class="th-sm">Start Minute</th>
				<th class="th-sm">End Hour</th>
				<th class="th-sm">End Minute</th>
				<th class="th-sm">Date</th>
				<th class="th-sm">Entry Amount</th>
				<th class="th-sm">Edit</th>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="sd" varStatus="sed">
				<tr>
					<td><input type="checkbox" class="case" name="ids"
						value="${sd.id}"></td>
					<td><c:out value="${sd.courseName}" /></td>
					<td><c:out value="${sd.locationName}" /></td>
					<td><c:out value="${sd.startHour}" /></td>
					<td><c:out value="${sd.startMinute}" /></td>
					<td><c:out value="${sd.endHour}" /></td>
					<td><c:out value="${sd.endMinute}" /></td>
					<td><c:out value="${sd.date}" /></td>
					<td><c:out value="${sd.amount}" /></td>
					<td><a href="${editUrl}${sd.id}" class="btn btn-primary">Edit</a>
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