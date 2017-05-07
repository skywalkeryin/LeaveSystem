<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Request</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/LeaveStyle.css" />
</head>
<body>
 <div class="container-fluid">
 <h2>New Request</h2>
 <div class="form"> 
 <form action="NewRequestServlet" method="post" onsubmit="return validateForm()" id="form" class= "form-horizontal">
   <div class="form-group">
    
    <label for="InputTitle" class="col-md-2 control-label">Request Title:</label>
    
     <div class="col-md-5" >
     <input type="text" class="form-control required" id="InputTitle" placeholder="Title" name="leavetitle" > 
    
      
    
    </div >
    <div class="col-md-2">
    <p  id="titlevalid" style="color:red"> </p>
    </div>
     
   </div>
    <div class="form-group">
    <label for="InputReason" class="col-md-2 control-label">Leave Reason:</label>
    <div class="col-md-5" >
    <textarea name="leavereason" cols="40" rows="2" id="InputReason" name="leavereason"> </textarea>
    </div>
    <div class="col-md-2">
    <p  id="reasonvalid" style="color:red"> </p>
    </div>
    </div>
   
    <div class="form-group">
    <label for="InputStart" class="col-md-2 control-label">Start Date:</label>
    <div class="input-group date form_datetime col-md-4"  data-date-format="yyyy-mm-dd" data-link-field="InputStart">
                    <input class="form-control required" size="16" type="text" value="" readonly name="startdate" id="InputStart"  >
                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
					<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
    </div> 
     <div class="col-md-1">
    <p  id="startdatevalid" style="color:red"> </p>
    </div>
     
    </div>
    <div class="form-group">
    <label for="InputEnd" class="col-md-2 control-label">End Date:</label>
    <div class="input-group date form_datetime col-md-2" data-date="2017-01-01" data-date-format="yyyy-mm-dd H:m:s" data-link-field="InputEnd">
                    <input class="form-control required" size="16" type="text" value="" readonly name="enddate" id="InputEnd" >
                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
					<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
    </div>
     <div class="col-md-1">
    <p  id="enddatevalid" style="color:red"> </p>
    </div>
     
    </div>
   <div class="form-group">
  <input type="submit" value="Submit Request" class="btn-default" >
  <input type="button" value="Back to Home" class="btn-default"  >
  <input type="reset" value="Reset"  class="btn-default">
   </div>
</form>
</div>
</div>
<script type="text/javascript">


    $('.form_datetime').datetimepicker({
        //language:  'fr',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 3,
		forceParse: 0,
        showMeridian: false,
        startDate:'2017-02-01',
        format: "yyyy-mm-dd HH-m-00",
        minViewMode: 3
    });
    function validateForm(){
    	
    	var form = document.getElementById("form");
    	var title = form.elements.leavetitle;
    	var startdate = form.elements.startdate;
    	var enddate = form.elements.enddate;
    	if(title.value.length <=0 ){ 		
    		$("#titlevalid").text("required");
    		return false;
    	}
    	 if(startdate.value.length<=0){
    		$("#startdatevalid").text("required");
    		return false;
    	}
    	 if(enddate.value.length<=0){
    		$("#enddatevalid").text("required");
    		return false;
    	}
    	
    	
    	
    	   	
    };
  
    
</script>
</body>
</html>