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
        <h1>Du er logget ind som rolle: ${sessionScope.role} </h1>
        <h1>Admin ID: ${sessionScope.user.id} </h1>


        <div class="d-flex justify-content-center mt-5">
            <br>
            <a href="${pageContext.request.contextPath}/fc/seallproductpage" type="button" class="btn btn-primary btn-lg ms-5">Se alle varer</a>
        </div>

        <div class="d-flex justify-content-center mt-5">
            <br>
            <a href="${pageContext.request.contextPath}/fc/addnewproductpage" type="button" class="btn btn-primary btn-lg ms-5">Tilføj ny vare</a>
        </div>

        <div class="d-flex justify-content-center mt-5">
            <br>
            <a href="${pageContext.request.contextPath}/fc/seallsellerspage" type="button" class="btn btn-primary btn-lg ms-5">sælger oversigt</a>
        </div>

        <div class="d-flex justify-content-center mt-5">
            <br>
            <a href="${pageContext.request.contextPath}/fc/addnewsellerpage" type="button" class="btn btn-primary btn-lg ms-5">tilføj ny sælger</a>
        </div>


    </jsp:body>
</t:genericpage>
