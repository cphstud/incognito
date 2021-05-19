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

        <table class="table mt-5">
            <thead>
            <tr>
                <th scope="col">Order ID</th>
                <th scope="col">Bredde</th>
                <th scope="col">Længde</th>
                <th scope="col">Tag</th>
                <th scope="col">Navn</th>
                <th scope="col">Status</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="requests" items="${requestScope.requests}">
                <tr>
                    <td>${requests.order_id}</td>
                    <td>${requests.width}</td>
                    <td>${requests.length}</td>
                    <td>${requests.roof_type}</td>
                    <td>${requests.name}</td>
                    <td>${requests.status}</td>
                    <td>
                        <form action="${pageContext.request.contextPath}/fc/confirmpaymentpage" method="POST">
                            <!----<input type="hidden" name="order_id" value="${requests.order_id}"/>
                            <button class="btn btn-primary btn-sm" type="submit">Betal</button>
                            ----->
                            <a href="${requests.order_id}}">Betal</a>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <div class="d-flex justify-content-center mt-5">
            <br>
            <a href="employeepage" type="button" class="btn btn-primary btn-lg ms-5">Gå tilbage</a>
        </div>


    </jsp:body>
</t:genericpage>

