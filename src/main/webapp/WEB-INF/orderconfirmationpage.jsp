<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Customer View Request
    </jsp:attribute>

    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>

        <h3>Du er logget ind som rolle: ${sessionScope.role}</h3>
        <h3>Sælger ID: ${sessionScope.id}</h3>


        <div class="alert alert-success mt-5" role="alert">
            <h4 class="alert-heading">Ordre bekræftet!</h4>
            <hr>
            <p class="mb-0">Der er sendt en bekræftelse til din email</p>
        </div>


        <h3>Ordre detaljer</h3>

        <c:forEach var="orderconfirmation" items="${requestScope.ordercofirmation}">
            <p>Købsdato: ${orderconfirmation.date}</p>
            <p>Betalt beløb: ${orderconfirmation.price}</p>
            <p>Forsendelsesinfo:</p>
            <p>${orderconfirmation.address}</p>
            <hr>
            <p>Varetype: ${orderconfirmation.roof_type}</p>
            <hr>
            <p>Bredde (CM): ${orderconfirmation.width}</p>
            <hr>
            <p>Længde (CM): ${orderconfirmation.length}</p>
            <hr>
        </c:forEach>




    </jsp:body>
</t:genericpage>

