<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leave System</title>
<style>
        body {
            background: linear-gradient(to right, 
                    rgba(105,105,105,0) 0%, 
                    rgba(105,105,105,0.2) 50%, 
                    rgba(105,105,105,0.3) 100%);
            box-sizing: border-box;
            color:  rgba(105,105,105,1);
            font-family: Calibri, 'Trebuchet MS', sans-serif;
        }
        .login {
            background-color: white;
            border: none;
            box-shadow: 2px 4px 8px 0 rgba(128, 128, 128, 0.8), 
                        2px 4px 8px 0 rgba(128, 128, 128, 0.8);
            width: 300px;
            height: 300px;
            margin: auto;
            margin-top: 50px;
            padding: 15px;
        }
        .login img {
            padding-left: 110px;
        } 
        .login h2 {
            text-align: center;
            margin-top: 0;
        }
        .login h4 {
            color:  rgba(105,105,105,0.7);
            margin: 10px 0;
        }
        /*.login input[type="text"], .login input[type="password"] {
            padding-left: 10px;
        }*/
        .login input {
            padding-left: 10px;
        }
        #tbUserID, #tbPassword {
            border: none;
            box-shadow: 2px 4px 8px 0 rgba(128, 128, 128, 0.5), 
                        2px 4px 8px 0 rgba(128, 128, 128, 0.5);
            width: 290px;
            height: 30px;
        }
        #errorMsg{
            color:red;
            font-size: 16px;
        }
        
        #btnLogin {
            background-color: rgba(105,105,105,0.3);
            border:none;
            font-size: 16px;
            margin: auto;
            margin-top: 30px;
            width: 300px;
            height: 35px;
        }
        #btnLogin:hover {
            background-color: rgba(105,105,105,1);
            color: white;
        }
    </style>
</head>
<body>

<form id="form1"  action="LoginServlet" method="post">
    <div class="login">
      <%-- <img alt="M1 logo" src="image/M1 logo.png" width="80" height="80" /> --%>  
        <h2 id="title">Leave System</h2>
        <h4>User ID</h4> 
        <input type="text" name="userid"  id="tbUserID"/>
      
        <h4>Password</h4>
        <input type="password" name="password"  id="tbPassword"/>
       
        <br />
        <p id="errorMsg" >${ErrorMsg}</p> 
        <input type="submit" value="Login" id="btnLogin"/>
    </div>
    </form>

</body>
</html>