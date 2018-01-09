<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>HR-manager: Person Form</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/pages/css/style.css" />" >
    <s:url value="/persons/all" var="pageurl" />
        <link rel="icon" type="image/x-icon"
            href="<s:url value="/favicon.ico"/>" />
  </head>
<body>
	<h4>Person:</h4>
	<sf:form method="POST" commandName="person">
          <sf:errors path="*" element="div" cssClass="errors" />

          <sf:label path="name"
                cssErrorClass="error">
                   <s:message code="name.title" />
           </sf:label>
          <sf:input path="name"/><br/>

          <sf:label path="gender"
                cssErrorClass="error">
                    <s:message code="gender.title" />
          </sf:label>
          <sf:input path="gender" /> <br/>
          <input type="submit" value="Save" />
    </sf:form>
  <a href="${pageurl}">
  <s:message code="back" />
  </a>
</body>
</html>