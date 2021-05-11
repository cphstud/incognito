<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Demo Page for Employee Roles
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        You are now logged in as a EMPLOYEE of our wonderful site.

        <div class="d-flex justify-content-center mt-5">
            <br>
            <a href="${pageContext.request.contextPath}/fc/seallcustomersrequests" type="button" class="btn btn-primary btn-lg ms-5">Se alle kunders forespørgelser</a>
        </div>

        <div class="d-flex justify-content-center mt-5">
            <br>
            <a href="${pageContext.request.contextPath}/fc/seallconfirmedorders" type="button" class="btn btn-primary btn-lg ms-5">Bekræftede order</a>
        </div>

        <div class="d-flex justify-content-center mt-5">
            <br>
            <a href="${pageContext.request.contextPath}/fc/seallcustomers" type="button" class="btn btn-primary btn-lg ms-5">Kundeoversigt</a>
        </div>

        <div class="d-flex justify-content-center mt-5">
            <br>
            <a href="${pageContext.request.contextPath}/fc/seallproducts" type="button" class="btn btn-primary btn-lg ms-5">Se alle varer</a>
        </div>


    </jsp:body>
</t:genericpage>
