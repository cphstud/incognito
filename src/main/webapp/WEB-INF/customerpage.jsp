<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Demo Page for Customer Roles
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <h1>Hej ${sessionScope.email}! </h1>
        Du er nu logget ind på din kundeprofil her på vores fantastiske hjemmeside.
        Role: ${sessionScope.role}


        <br><a href="${pageContext.request.contextPath}/fc/requestpage" class="btn btn-primary mt-5">Lav en forespørgelse</a>

        <br><a href="${pageContext.request.contextPath}/fc/customerviewrequestspage" class="btn btn-secondary mt-5">Se dine forespørgsler</a>

        <br><a href="${pageContext.request.contextPath}/fc/customervieworderspage" class="btn btn-secondary mt-5">Se dine ordrer</a>


    </jsp:body>

</t:genericpage>
