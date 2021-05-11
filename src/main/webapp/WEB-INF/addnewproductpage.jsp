<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<t:genericpage>
    <jsp:attribute name="header">
         Send forespørgelse
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>


        <form action="${pageContext.request.contextPath}/fc/" method="post">
        <div class="container mt-2">

            <label class="mt-2">ID</label>
            <input type="text" name="width" class="form-control mt-2">

            <label class="mt-2">Længde</label>
            <input type="text" name="length" class="form-control mt-2">

            <label class="mt-2">Bredde</label>
            <input type="text" name="roof_type" class="form-control mt-2">


            <label class="mt-2">Dybde</label>
            <input type="text" name="toolroom_width" class="form-control mt-2">

            <label class="mt-2">Navn</label>
            <input type="text" name="toolroom_length" class="form-control mt-2">

            <label class="mt-5">Beskrivelse</label>
            <input type="text" name="name" class="form-control mt-2">

            <label class="mt-2">Pris</label>
            <input type="text" name="address" class="form-control mt-2">

            <label class="mt-2">Enhed</label>
            <input type="text" name="postcode" class="form-control mt-2">




                <a href="adminpage" type="button" class="mt-3 btn btn-danger float-left">Go back</a>

                <button type="submit" class="mt-3 btn btn-success float-end">Tilføj</button>




        </div>

        </form>




    </jsp:body>

</t:genericpage>