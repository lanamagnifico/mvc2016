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
                 <th>Name</th>
                 <th>INN</th></tr>
                 </thead>
                 <tbody>
          <c:forEach var="le" items="${legalentities}">
              <tr><td>${le.id}</td>
              <td>${le.name}</td>
              <td>${le.inn}</td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
</body>
</html>
