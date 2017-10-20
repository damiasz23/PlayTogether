
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; harset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
   String error = request.getParameter("error");
   if(error!=null && error.equals("true"))
       pageContext.setAttribute("error", error);

%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Shop Item - Start Bootstrap Template</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/shop-item.css" rel="stylesheet">

</head>

<body>

<!-- Page Content -->
<div class="container">

            <div class="card card-container">
                <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
                <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
                <p id="profile-name" class="profile-name-card"></p>
                <a href="#" class="forgot-password">
                    Forgot the password?
                </a>
                <form class="form-signin" action="login" method="post">
                    <span id="reauth-email" class="reauth-email"></span>
                    <input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email address" required autofocus>
                    <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
                    <c:if test="${not empty error}">
                    <div>
                        <p class="alert alert-danger">Wrong Login or Password</p>

                    </div>
                    </c:if>
                    <div id="remember" class="checkbox">
                        <label>
                            <input type="checkbox" value="remember-me"> Remember me
                        </label>
                    </div>
                    <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Sign in</button>
                    <a class="btn btn-lg btn-primary btn-block btn-signin" href="register.jsp">Sign up</a>

                </form><!-- /form -->
            </div>
        </div>
<jsp:include page="footer.jsp"/>