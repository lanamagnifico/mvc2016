<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>HR-manager: Profile</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/pages/css/style.css" />" >
    <link rel="icon" type="image/x-icon"
                  href="<s:url value="/favicon.ico"/>" />
  </head>
<body>
<c:if test="${not empty firstEntry}">
   <span class="mes">
    <s:message code="congratulations" />
   </span>
</c:if>
<h1><c:out value="${user.name}"/></h1>
<image class="avatar" src="data:image/jpeg;base64,${image}" alt="picture"/><br/>
<c:out value="${user.email}"/><br/>
</body>
</html>
