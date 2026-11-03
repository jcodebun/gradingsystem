<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<nav aria-label="breadcrumb" role="navigation">
	<ol class="breadcrumb">

		<li class="breadcrumb-item active" aria-current="page">Add Schedule</li>
	</ol>
</nav>

<div col-md-5img-thumbnail">
	<div id="feedback">
		<div class="container">
			<div class="col-md-7">
				<div class="form-area">
					<sf:form method="post"
						action="${pageContext.request.contextPath}/ctl/schedule_add"
						modelAttribute="form">
						<br style="clear: both">
						<h3 style="margin-bottom: 15px; text-align: left:;">Add
							Schedule</h3>
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
							<s:bind path="locationId">
								<label>Location Name:</label>
								<sf:select style="margin-bottom: 10px" class="form-control"
									path="${status.expression}">
									<sf:option value="-1" label="Select" />
									<sf:options itemLabel="name" itemValue="id"
										items="${locationList}" />
								</sf:select>
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>

						<div class="form-row">
    							<div class="form-group col-md-6">
								<s:bind path="startHour">
								<label >Start Hour:</label> 
								<sf:input path="${status.expression}" placeholder="Enter Start Hour" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
							</s:bind>
							</div>
        					<div class="form-group col-md-6">
								<s:bind path="startMinute">
								<label >Start Minute :</label> 
								<sf:input path="${status.expression}" placeholder="Enter Start Minute" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
							</s:bind>
							</div>
							</div>
							
							<div class="form-row">
    							<div class="form-group col-md-6">
								<s:bind path="endHour">
								<label >End Hour:</label> 
								<sf:input path="${status.expression}" placeholder="Enter End Hour" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
							</s:bind>
							</div>
        					<div class="form-group col-md-6">
								<s:bind path="endMinute">
								<label >End Minute :</label> 
								<sf:input path="${status.expression}" placeholder="Enter End Minute" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
							</s:bind>
							</div>
							</div>
							
							
							<div class="form-group">
							<s:bind path="date">
								<label>Date:</label>
								<sf:input path="${status.expression}"
									placeholder="Enter Date(YYYY-MM-DD)" class="form-control" />
								<font color="red" style="font-size: 13px"><sf:errors
										path="${status.expression}" /></font>
							</s:bind>
						</div>
						
						<div class="form-group">
							<s:bind path="amount">
								<label>Entry Amount:</label>
								<sf:input path="${status.expression}"
									placeholder="Enter Entry Amount" class="form-control" />
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