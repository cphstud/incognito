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


        <div class="alert alert-success mt-5" role="alert">
            <h4 class="alert-heading">Forespørgsel sendt!</h4>
            <hr>
            <p class="mb-0">Der er sendt en bekræftelse til din email</p>
        </div>

        <c:forEach var="orders" items="${requestScope.orders}">
                <h1>Carport bredde:</h1>
                <p>${orders.width}</p>
                <h1>Carport længde:</h1>
                <p>${orders.length}</p>
                <h1>Tag:</h1>
                <p>${orders.roof_type}</p>
        </c:forEach>




    </jsp:body>
</t:genericpage>

