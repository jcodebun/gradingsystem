<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<nav aria-label="breadcrumb" role="navigation">
	<ol class="breadcrumb">

		<li class="breadcrumb-item active" aria-current="page">Add Result</li>
	</ol>
</nav>

<div col-md-5img-thumbnail">
	<div id="feedback">
		<div class="container">
			<div class="col-md-7">
				<div class="form-area">
					<sf:form method="post"
						action="${pageContext.request.contextPath}/ctl/result_add"
						modelAttribute="form">
						<br style="clear: both">
						<h3 style="margin-bottom: 15px; text-align: left:;">Add
							Result</h3>
						<b><%@ include file="businessMessage.jsp"%></b>
						<sf:hidden path="id" />

						<div class="form-group">
							<s:bind path="courseId">
								<label>Course Name:</label>
								<sf:select style="margin-bottom: 10px" class="form-control"
									path="${status.expression}">
									<sf:option value="-1" label="Select" />
									<sf:options itemLabel="name" itemValue="id"
										items="${courseList}" />
								</sf:select>
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>

						<div class="form-group">
							<s:bind path="studentId">
								<label>Student Name:</label>
								<sf:select style="margin-bottom: 10px" class="form-control"
									path="${status.expression}">
									<sf:option value="-1" label="Select" />
									<sf:options itemLabel="firstName" itemValue="id"
										items="${studentList}" />
								</sf:select>
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>

						<div class="form-group">
							<s:bind path="sessionNo">
								<label>Session Number:</label>
								<sf:input path="${status.expression}"
									placeholder="Enter Session Number" class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>

						<div class="form-group">
							<s:bind path="mark">
								<label>Mark:</label>
								<sf:input path="${status.expression}"
									placeholder="Enter Mark" class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>


						<input type="submit" name="operation"
							class="btn btn-primary pull-right" value="Save">or<input
							type="submit" name="operation" class="btn btn-primary pull-right"
							value="Reset">
					</sf:form>
				</div>
			</div>
		</div>
	</div>
	<!--feedback-->
	<br>