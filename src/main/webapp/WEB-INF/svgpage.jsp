<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         vis svg tegning
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div>

            <h2>Tegning</h2>

            <p>Her indsættes en tegning</p>
                ${requestScope.drawing}




             <c:if test="${sessionScope.role == 'customer' }">
                <p style="font-size: larger">Her er hvad du kan gøre, fordi du er logget ind, som kunde./Du er logget ind som: 'Kunde'.
            Du har følgende valgmuligheder:</p>
                <p><a href="fc/customerpage">Customer Page</a>
            </c:if>

        </div>

    </jsp:body>
</t:genericpage>