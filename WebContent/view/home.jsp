<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>


<style type="text/css">
body{
background-color:red;
}

</style>
</head>
<body>
<h2> Requests Pending Approval </h2>
<div class="disTable">
 <table border="1" cellpadding="2" cellspacing="1"  class="table table-striped" BorderColor="#336666">
       <tr>
          <th>ID</th>
          <th>Title</th>
          <th>RequesterID</th>
           <th>Reason</th>
           <th>Start</th>
           <th>End</th>
           <th>Status</th>
       </tr>
       <c:forEach items="${leavelist}" var="leave" >
          <tr>
             <td>${leave.leaveId}</td>
             <td>${leave.leaveTitle}</td>
             <td>${leave.leaveUserid}</td>
             <td>${leave.leaveReason}</td>
             <td>${leave.leaveStart}</td>
             <td>${leave.leaveEnd}</td>
             <td>${leave.leaveStatus}</td>
            </tr>
       </c:forEach>
    </table>
    </div>

</body>
</html>

