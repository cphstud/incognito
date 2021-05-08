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


        <a href="" class="btn btn-primary">Se alle kunders forespørgelser</a>
        <a href="" class="btn btn-primary">Bekræftede order</a>
        <a href="" class="btn btn-primary">Kundeoversigt</a>
        <a href="" class="btn btn-primary">Se alle varer</a>

    </jsp:body>
</t:genericpage>

