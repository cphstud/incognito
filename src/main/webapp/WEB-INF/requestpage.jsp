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


        <form action="${pageContext.request.contextPath}/fc/thankyoupage" method="post">
        <div class="container mt-2">
            <label class="mt-2">Carport bredde</label>
            <input type="text" name="width" class="form-control mt-2">

            <label class="mt-2">Carport længde</label>
            <input type="text" name="length" class="form-control mt-2">

            <select class="form-select mt-4" name="roof_type">
                <option>Vælg tag type</option>
                <option value="flat">Flat</option>
                <option value="rejsning">Rejsning</option>
            </select>

            <hr class="mt-5">

<!----
            <label class="mt-5">Navn</label>
            <input type="text" name="name" class="form-control mt-2">

            <label class="mt-2">Addresse</label>
            <input type="text" name="address" class="form-control mt-2">

            <label class="mt-2">Postnummer og by</label>
            <input type="text" name="postcode" class="form-control mt-2">

            <label class="mt-2">Telefon</label>
            <input type="text" name="phone" class="form-control mt-2">
---->

            <button type="submit" class="mt-3 btn btn-success float-end">Send forespørgelse</button>

        </div>

        </form>




    </jsp:body>

</t:genericpage>