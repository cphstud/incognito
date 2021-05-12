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

        <h5>Carport bredde:</h5>
        <p>
                ${requestScope.newOrder.width} cm
        </p>

        <h5>Carport længde:</h5>
        <p>
                ${requestScope.newOrder.length} cm
        </p>

        <h5>Carport tag:</h5>
        <p>
                ${requestScope.newOrder.roof_type}
        </p>

        <div class="d-flex justify-content-center mt-5">
            <br>
            <a href="customerpage" type="button" class="btn btn-danger btn-lg ms-5">Gå til din kundeprofil</a>
        </div>




    </jsp:body>
</t:genericpage>

