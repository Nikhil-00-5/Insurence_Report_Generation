<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="in.MiniProject.beans.CitizenPlan" %>
    <%@ page import="java.util.List" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  </head>
</head>
<body>

    <div class="container">
       <h2>Hello, world!</h2>
   </div>
 <div class="container">
		<form:form action="search" modelAttribute="search" method="POST">
			<table>
				<tr>
					<td>Plan Name :</td>
					<td><form:select path="planName">
							<form:option value="">-select-</form:option>
							<form:options items="${names}"/>
						</form:select></td>

					<td>Plan Status :</td>
					<td><form:select path="planStatus">
							<form:option value="">-select-</form:option>
							<form:options items="${status}"/>
						</form:select></td>
						
					<td>Gender :</td> 
					<td><form:select path="gender">
							<form:option value="">-select-</form:option>
							<form:option value="Male">Male</form:option>
							<form:option value="Female">Female</form:option>
						</form:select></td>	
				</tr>
				<tr>
					<td>Start Date :</td>
					<td><form:input type="date" path="startDate" /></td>
					
				    <td>End Date :</td>
					<td><form:input type="date" path="endDate" /></td>
				</tr>
				
				<tr>
				<td>
				     <a href="/" class="btn btn-danger" >Reset</a>
				</td>
				<td>
				     <input type="submit" value="Search" class="btn btn-primary" />
				</td>
				</tr>

			</table>
		</form:form>
		        <hr/>
		        
		        
<table border="1" class="table table-striped table-hover">
    <thead>
        <tr>
            <th>ID</th>
            <th>Holder Name</th>
            <th>Plan Name</th>
            <th>Plan Status</th>
            <th>Benefit Amt</th>
            <th>Start Date</th>
            <th>End Date</th>
        </tr>
    </thead>
    <tbody>
        <% 
            // Retrieve the list of CitizenPlan objects from the request
            List<CitizenPlan> plans = (List<CitizenPlan>) request.getAttribute("plans");
            if (plans != null && !plans.isEmpty()) {
                for (CitizenPlan plan : plans) {
        %>
        <tr>
            <td><%= plan.getCitizenId() %></td>
            <td><%= plan.getCitizenName() %></td>
            <td><%= plan.getPlanName() %></td>
            <td><%= plan.getPlanStatus() %></td>
			<td><%=(plan.getBenefitAmt() != null ? plan.getBenefitAmt() : "")%></td>
			<td><%=(plan.getPlanStartDate() != null ? plan.getPlanStartDate() : "")%></td>
			<td><%=(plan.getPlanEndDate() != null ? plan.getPlanEndDate() : "")%></td>
				</tr>
<% 
        }
    } else {
        // If plans is empty, show the "Record not found" message
%>
        <tr>
            <td colspan="7" style="text-align:center;">Record not found</td>
        </tr>
<% 
    }
%>
    </tbody>
</table>
     
				     
				<hr/> 
				
				Export : <a href="excel">Excel</a>  <a href="pdf">Pdf</a>
		        
	</div>
	
	
	
	
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</body>
</html>