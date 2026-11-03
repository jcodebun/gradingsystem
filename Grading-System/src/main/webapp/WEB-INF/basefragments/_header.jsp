<%@page import="in.co.grade.sys.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

	<a class="navbar-brand" href="#">Grading System</a>

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">

			<li class="nav-item active"><a class="nav-link"
				href="<c:url value="/welcome"/>">Home <span class="sr-only">(current)</span></a>
			</li>

			<%
				UserDTO userBean = (UserDTO) session.getAttribute("user");
			boolean userLoggedIn = userBean != null;
			%>
			<%
				if (userLoggedIn) {
			%>

			<%
				if (userBean.getRoleId() == 1) {
			%>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-bs-toggle="dropdown" aria-expanded="false">
					Student</a>
				<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
					<li><a class="dropdown-item" href="<c:url value="/ctl/student_add"/>">Add Student</a></li>
					<li><a class="dropdown-item" href="<c:url value="/ctl/student_list"/>">Student List</a></li>
					<li><a class="dropdown-item" href="<c:url value="/ctl/course_add_student"/>">Add Course To Student</a></li>
					<li><a class="dropdown-item" href="<c:url value="/ctl/course_list_student"/>">Course To Student List</a></li>
					
				</ul></li>
				
				<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-bs-toggle="dropdown" aria-expanded="false">
				Teacher</a>
				<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
					<li><a class="dropdown-item" href="<c:url value="/ctl/teacher_add"/>">Add Teacher</a></li>
					<li><a class="dropdown-item" href="<c:url value="/ctl/teacher_list"/>">Teacher List</a></li>
					<li><a class="dropdown-item" href="<c:url value="/ctl/course_add_teacher"/>">Add Course To Teacher</a></li>
					<li><a class="dropdown-item" href="<c:url value="/ctl/course_list_teacher"/>">Course To Teacher List</a></li>
				</ul></li>
				
				<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-bs-toggle="dropdown" aria-expanded="false">
				Course</a>
				<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
					<li><a class="dropdown-item" href="<c:url value="/ctl/course_add"/>">Add Course</a></li>
					<li><a class="dropdown-item" href="<c:url value="/ctl/course_list"/>">Course List</a></li>
					
				</ul></li>
				
				<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-bs-toggle="dropdown" aria-expanded="false">
				Result</a>
				<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
					<li><a class="dropdown-item" href="<c:url value="/ctl/result_add"/>">Add Result</a></li>
					<li><a class="dropdown-item" href="<c:url value="/ctl/result_list"/>">Result List</a></li>
					
				</ul></li>
				
				<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-bs-toggle="dropdown" aria-expanded="false">
				Payment</a>
				<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
					<li><a class="dropdown-item" href="<c:url value="/ctl/payment_add"/>">Add Payment</a></li>
					<li><a class="dropdown-item" href="<c:url value="/ctl/payment_list"/>">Payment List</a></li>
					
				</ul></li>
				
				<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-bs-toggle="dropdown" aria-expanded="false">
				Location</a>
				<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
					<li><a class="dropdown-item" href="<c:url value="/ctl/location_add"/>">Add Location</a></li>
					<li><a class="dropdown-item" href="<c:url value="/ctl/location_list"/>">Location List</a></li>
					
				</ul></li>
				
				<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-bs-toggle="dropdown" aria-expanded="false">
				Schedule</a>
				<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
					<li><a class="dropdown-item" href="<c:url value="/ctl/schedule_add"/>">Add Schedule</a></li>
					<li><a class="dropdown-item" href="<c:url value="/ctl/schedule_list"/>">Schedule List</a></li>
					
				</ul></li>


			<li class="nav-item "><a class="nav-link"
				href="<c:url value="/profile"/>">My Profile</a></li>
			<li class="nav-item "><a class="nav-link"
				href="<c:url value="/changepassword"/>">Change Password</a></li>
			<%
				}
			%>
			<%
				}
			%>
		</ul>


	</div>


	<ul class="nav justify-content-end">


		<%
			if (userLoggedIn) {
		%>
		<li class="nav-item"><a class="nav-link"
			href="<c:url value="/login"/>">Logout</a></li>
		<%
			} else {
		%>
		<li class="nav-item"><a class="nav-link"
			href="<c:url value="/login"/>">Sign In</a></li>
		<li class="nav-item "><a class="nav-link"
			href="<c:url value="/signUp"/>">Sign Up</a></li>
		<%
			}
		%>

	</ul>

</nav>

