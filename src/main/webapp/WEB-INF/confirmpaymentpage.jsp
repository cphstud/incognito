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
            <h4 class="alert-heading">Betal</h4>
            <hr>
            <p class="mb-0">Vi tjekker om du har penge nok på din konto, vent venligst</p>
        </div>

        <div class="contact mt-5">
            <h3>Kontakt Informationer:</h3>

        </div>

        <table class="table mt-5">
            <thead>
            <tr>
                <th scope="col">Bredde</th>
                <th scope="col">Længde</th>
                <th scope="col">Tag</th>
                <th scope="col">Navn</th>
                <th scope="col">Status</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="confirmpayment" items="${requestScope.confirmpayment}">
                <tr>
                    <td>${confirmpayment.width}</td>
                    <td>${confirmpayment.length}</td>
                    <td>${confirmpayment.roof_type}</td>
                    <td>${confirmpayment.name}</td>
                    <td>${confirmpayment.status}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <div class="d-flex justify-content-center mt-5">
            <br>
            <a href="employeepage" type="button" class="btn btn-primary btn-lg ms-5">Gå tilbage</a>
            <a href="orderconfirmationpage" type="button" class="btn btn-success btn-lg ms-5">Bekræft betaling <img src="${pageContext.request.contextPath}/images/arrow.png" width="30" class="ms-2"></a>
        </div>


    </jsp:body>
</t:genericpage>

