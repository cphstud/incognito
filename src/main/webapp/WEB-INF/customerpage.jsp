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
<<<<<<< Updated upstream


        <h1>Hello ${sessionScope.email} </h1>
        You are now logged in as a Customer of our wonderful site.
        Role: ${sessionScope.role}


        <br><a href="${pageContext.request.contextPath}/fc/requestpage" class="btn btn-primary mt-3">Lav en forespørgelse</a>


=======
        <h1>Hej ${sessionScope.email}! </h1>
        Du er nu logget ind på din kundeprofil her på vores fantastiske hjemmeside.
        Role: ${sessionScope.role}

        <button href="" type="button" class="mt-3 btn btn-secondary float-end">Lav ny forespørgsel</button>

        <button href="" type="button" class="mt-3 btn btn-secondary float-end">Se dine forespørgsler</button>

        <button href="" type="button" class="mt-3 btn btn-secondary float-end">Se dine bekræftede ordrer</button>
>>>>>>> Stashed changes
    </jsp:body>

</t:genericpage>

