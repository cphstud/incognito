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

        <h3 class="mt-3">Oversigt over alle sælger:</h3>

        <table class="table mt-5">
            <thead>
            <tr>
                <th scope="col">Bredde</th>
                <th scope="col">Længde</th>
                <th scope="col">Tag</th>
                <th scope="col">Navn</th>
                <th>Status</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="confirmedOrders" items="${requestScope.confirmedOrders}">
                <tr>
                    <td>${confirmedOrders.width}</td>
                    <td>${confirmedOrders.length}</td>
                    <td>${confirmedOrders.roof_type}</td>
                    <td>${confirmedOrders.name}</td>
                    <td>${confirmedOrders.status}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>




    </jsp:body>
</t:genericpage>

