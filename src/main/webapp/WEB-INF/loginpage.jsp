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
        <div style="margin-top: 5em;" class="container">
            <form name="login" action="${pageContext.request.contextPath}/fc/logincommand"  method="POST">

                <label class="col-form-label">Email</label>
                    <input class="form-control" type="text" name="email">

                    <label class="col-form-label mt-3">Password</label>
                    <input class="form-control" type="password" name="password">


                <c:if test="${requestScope.error != null }">
                    <p style="color:red">
                            ${requestScope.error}
                    </p>
                </c:if>

                <c:if test="${not empty param.msg}">
                    <p style="font-size: large">${param.msg}</p>
                </c:if>
                <button class="btn btn-success float-end mt-3" type="submit" value="Login">Login</button>
            </form>


        </div>
    </jsp:body>
</t:genericpage>

