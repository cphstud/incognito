<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Home
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div>

            <h2>Velkommen til Fog's skræddersyning af carporte!</h2>

            <div style="margin-top: 3em;margin-bottom: 3em;">
                Her kan du vælge mellem, at logge ind eller forsætte til skræddersyning af carporte.
            </div>

            <br><a href="${pageContext.request.contextPath}/fc/requestpage" class="btn btn-primary mt-3">Lav en forespørgelse</a>

            <c:if test="${sessionScope.role == 'employee' }">
                <p style="font-size: larger">Her er hvad du kan gøre, fordi du er logget ind, som sælger./Du er logget ind som: 'Sælger'.
                Du har følgende valgmuligheder:</p>
                 <p><a href="fc/employeepage">Employee Page</a>
             </c:if>

             <c:if test="${sessionScope.role == 'customer' }">
                <p style="font-size: larger">Her er hvad du kan gøre, fordi du er logget ind, som kunde./Du er logget ind som: 'Kunde'.
            Du har følgende valgmuligheder:</p>
                <p><a href="fc/customerpage">Customer Page</a>
            </c:if>

        </div>

        <a href="${pageContext.request.contextPath}/fc/seeallproductspage">Se Alle Varer</a>

    </jsp:body>
</t:genericpage>