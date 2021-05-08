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
        <h1>Du er logget ind som rolle: ${sessionScope.email} </h1>
        <h1>Admin ID: ${sessionScope.user.id}</h1><br>

        <h3 class="mt-3">Oversigt over alle sælger:</h3>
        <table class="table table-striped">
            <thead>
            <th>Bredde</th>
            <th>Længde</th>
            <th>Tag</th>
            <th>Navn</th>
            <th>Status</th>
            </thead>
            <c:forEach var="order" items="${applicationScope.order}">

            </c:forEach>
        </table>
        <div class="d-flex justify-content-center mt-5">
            <br>
            <a href="adminpage" type="button" class="btn btn-danger btn-lg ms-5">Go back</a>
        </div>

    </jsp:body>
</t:genericpage>
