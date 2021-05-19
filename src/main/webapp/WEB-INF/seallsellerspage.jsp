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
            <th>User ID</th>
            <th>Navn</th>
            <th>Addresse</th>
            <th>Telefon</th>
            <th>Email</th>
            <th>Password</th>
            <th>Rolle</th>
            <th>Postnummer</th>
            <th>Kredit</th>
            <th>By</th>
            </thead>
            <c:forEach var="seeAllSellers" items="${requestScope.seeAllSellers}">
                <td>${seeAllSellers.user_id}</td>
                <td>${seeAllSellers.name}</td>
                <td>${seeAllSellers.address}</td>
                <td>${seeAllSellers.phone}</td>
                <td>${seeAllSellers.email}</td>
                <td>${seeAllSellers.password}</td>
                <td>${seeAllSellers.role}</td>
                <td>${seeAllSellers.postcode}</td>
                <td>${seeAllSellers.credit}</td>
                <td>${seeAllSellers.city}</td>
            </c:forEach>
        </table>
        <div class="d-flex justify-content-center mt-5">
            <br>
            <a href="adminpage" type="button" class="btn btn-danger btn-lg ms-5">Go back</a>
        </div>



    </jsp:body>
</t:genericpage>
