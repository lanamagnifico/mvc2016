<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>HR-manager: Persons list</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/pages/css/style.css" />" >
        <link rel="icon" type="image/x-icon"
            href="<s:url value="/favicon.ico"/>" />
  </head>
<body>
      <table cellspacing="0">
                 <thead><tr>
                 <th>ID</th>
                 <th>Name</th></tr>
                 </thead>
                 <tbody>
          <c:forEach var="dep" items="${departments}">
              <tr><td>${dep.id}</td>
              <td>${dep.name}</td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
</body>
</html>