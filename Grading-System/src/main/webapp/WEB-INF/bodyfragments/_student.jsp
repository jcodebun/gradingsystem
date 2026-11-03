<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
 <nav
		aria-label="breadcrumb" role="navigation"  >
	<ol class="breadcrumb">
		
		<li class="breadcrumb-item active" aria-current="page">Add Student</li>
	</ol>
	</nav>

<div col-md-5 img-thumbnail">
           <div id="feedback"> <div class="container">
<div class="col-md-7">
    <div class="form-area">  
       <sf:form method="post" action="${pageContext.request.contextPath}/ctl/student_add"  modelAttribute="form">
        <br style="clear:both">
                    <h3 style="margin-bottom: 15px; text-align: left: ;">Add Student</h3>
                    <b><%@ include file="businessMessage.jsp"%></b>
                    <sf:hidden path="id"/>
                		<div class="form-row">
    							<div class="form-group col-md-6">
								<s:bind path="firstName">
								<label >First Name :</label> 
								<sf:input path="${status.expression}" placeholder="Enter First Name" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
							</s:bind>
							</div>
        					<div class="form-group col-md-6">
								<s:bind path="lastName">
								<label >Last Name :</label> 
								<sf:input path="${status.expression}" placeholder="Enter Last Name" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
							</s:bind>
							</div>
							</div>
							<div class="form-group">
								<s:bind path="emailId">
								<label >Email Id :</label> 
								<sf:input path="${status.expression}" placeholder="Enter Email Id" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
							</s:bind>
							</div>
							
							<div class="form-group">
								<s:bind path="organization">
								<label >Organization :</label> 
								<sf:input path="${status.expression}" placeholder="Enter Organization" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
							</s:bind>
							</div>
							
							
								<div class="form-group">
								<s:bind path="telephone">
								<label >Telephone:</label> 
								<sf:input path="${status.expression}" placeholder="Enter Teliphone" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
							</s:bind>
							</div>
						
							
							<div class="form-group">
								<s:bind path="gender">
								<label >Gender:</label> 
								<sf:select class="form-control" path="${status.expression}">
									<sf:option value="" label="Select" />
									<sf:options   items="${gender}" />
								</sf:select>
								<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
							</s:bind>
							</div>
							
							<div class="form-group">
								<s:bind path="dob">
								<label >Date Of Birth:</label> 
								<sf:input path="${status.expression}" placeholder="Enter Date Of Birth(YYYY-MM-DD)" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
							</s:bind>
							</div>
							
							
							
							<div class="form-row">
    							<div class="form-group col-md-4">
								<s:bind path="country">
									<label for="pwd">Country:</label>
									<sf:input  path="${status.expression}"
									placeholder="Enter Country" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
								</s:bind>
							</div>
							
							<div class="form-group col-md-4">
								<s:bind path="state">
									<label for="pwd">State:</label>
									<sf:input  path="${status.expression}"
									placeholder="Enter State" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
								</s:bind>
							</div>
							
							<div class="form-group col-md-4">
								<s:bind path="city">
									<label for="pwd">City:</label>
									<sf:input  path="${status.expression}"
									placeholder="Enter City" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
								</s:bind>
							</div>
							</div>
							
						
							
							<div class="form-group">
								<s:bind path="fax">
								<label >Fax:</label> 
								<sf:input path="${status.expression}" placeholder="Enter Fax" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
							</s:bind>
							</div>
						
							
							
        					 <input type="submit" name="operation"
								class="btn btn-primary pull-right" value="Save">or<input type="submit" name="operation"
								class="btn btn-primary pull-right" value="Reset">
        </sf:form>
    </div>
</div>
</div> </div> <!--feedback-->
<br>

	