<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Login page
    </jsp:attribute>

    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>

        <h3>Du er logget ind som rolle: ${sessionScope.role}</h3>
        <h3>Sælger ID: ${sessionScope.id}</h3>

        <table class="table mt-5">
            <thead>
            <tr>
                <th scope="col">Kunde ID</th>
                <th scope="col">Navn</th>
                <th scope="col">Addresse</th>
                <th scope="col">Postnr.</th>
                <th scope="col">E-mail</th>
                <th scope="col">Telefon</th>
                <th scope="col">Rolle</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="users" items="${requestScope.users}">
                <tr>
                    <td>${users.id}</td>
                    <td>${users.name}</td>
                    <td>${users.address}</td>
                    <td>${users.postcode}</td>
                    <td>${users.email}</td>
                    <td>${users.phone}</td>
                    <td>${users.role}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <div class="d-flex justify-content-center mt-5">
            <br>
            <a href="employeepage" type="button" class="btn btn-danger btn-lg ms-5">Go back</a>
        </div>


    </jsp:body>
</t:genericpage>

