<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.min.css" />
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/LeaveStyle.css" />
  <script src="${pageContext.request.contextPath}/js/jquery-3.2.0.min.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
  
 </head>  

<body>


<nav class="navbar navbar-default">
  <div class="container-fluid">
    
                 <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Leave System <span class="sr-only">(current)</span></a></li>
        <li><a href="NewRequestServlet">New Request</a></li>
       </ul>
      
      <ul class="nav navbar-nav navbar-right">     
          <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><b>Hello,<% if (session.getAttribute("logineduser") != null) { %>
    ${logineduser.fullname}
<% } else {%>
     No name
<% } %></b><span class="caret"></span></a>
            <ul class="dropdown-menu">
            <li><a href="LogoutServlet">LogOut</a></li>
           </ul>
         </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div>
</nav>


<div id="decbody">
    <decorator:body />
   
</div>
    <div id="footer" align="center" style="background: #E0E0E0; text-align: center; padding: 5px; margin-top: 10px;">			           
	<small><i><font color='blue'> &copy; Leave System </font></i></small>
	</div>
 
</body>
</html>