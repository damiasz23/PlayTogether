
<%@ page import="java.util.HashMap" %>
<%@ page import="playTogether.*" %>
<%@ page language="java" contentType="text/html; harset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
   HashMap<String, String> error = (HashMap<String, String>)request.getAttribute("error");
   HashMap<String, String> variable = (HashMap<String, String>)request.getAttribute("variable");
   if(error!=null)
       pageContext.setAttribute("error", error);
    if(variable!=null)
        pageContext.setAttribute("variable", variable);

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
                <form class="form-signin" action="/register" method="post">
                    <span id="reauth-email" class="reauth-email"></span>
                    <input type="email" value="${variable.get("email")}" id="inputEmail" name="email" class="form-control" placeholder="Email address" required autofocus>
                    <p>${error.get("email")}</p>
                    <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
                    <p>${error.get("password")}</p>
                    <input type="password" id="inputPassword2" name="passwordRepeat" class="form-control" placeholder="Password repeat" required>
                    <p>${error.get("passwordRepeat")}</p>
                    <input type="text" id="nickName" value="${variable.get("nickName")}"  name="nickName" class="form-control" placeholder="Nick Name" required>
                    <p>${error.get("nickName")}</p>

                    <select class="form-control" name="position">
                        <c:forEach var="position" items="${Position.values()}">
                            <c:if test="${player.position.equals(position)}">
                                <option value="${position}" selected="selected">${position}</option>
                            </c:if>
                            <c:if test="${!player.position.equals(position)}">
                                <option value="${position}">${position}</option>
                            </c:if>
                        </c:forEach>
                    </select>

                    <label>Day if birth</label>
                    <input type="date" id="dayOfBirth" name="dayOfBirth" class="form-control">
                    <p>${error.get("dayOfBirth")}</p>

                    <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Sign up</button>


                </form><!-- /form -->
            </div>
        </div>
<jsp:include page="footer.jsp"/>