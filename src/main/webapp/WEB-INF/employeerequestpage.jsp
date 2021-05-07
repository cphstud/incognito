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
        <h1>Sælger ID: ${sessionScope.user.id}</h1>

        <h3 class="mt-3">Se alle kunders forespørgelse:</h3>
        <table class="table table-striped">
            <thead>
            <th>order_id</th>
            <th>user_id</th>
            <th>length</th>
            <th>width</th>
            <th>date</th>
            <th>subtotal</th>
            <th>status</th>
            </thead>
            <c:forEach var="order" items="${applicationScope.order}">

            </c:forEach>
        </table>
        <div class="d-flex justify-content-center mt-5">
            <br>
            <a href="employeepage" type="button" class="btn btn-danger btn-lg ms-5">back</a>
        </div>

    </jsp:body>
</t:genericpage>
