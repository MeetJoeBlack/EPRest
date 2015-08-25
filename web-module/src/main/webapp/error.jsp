<%@ page session="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>

<h1>Error at path: ${url}</h1>


<c:if test="${not empty errMsg}">
    <h2>${errMsg}</h2>
</c:if>

</body>
</html>
