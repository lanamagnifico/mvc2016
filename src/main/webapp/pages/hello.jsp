<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
    <title>HR-manager</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/pages/css/style.css" />" >
    <link rel="icon" type="image/x-icon"
        href="<s:url value="/favicon.ico"/>" />
  </head>
<body>
	<h2><s:message code="moduleTitle" /></h2>
	<div class="username">
	    <sec:authorize access="isAnonymous()">
          <a href="<c:url value="/login"/>">
    	    <s:message code="enter" />
          </a>  |
          <a href="<c:url value="/users/register"/>">
            <s:message code="registration" />
          </a>
	    </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            Welcome, <strong><sec:authentication property="principal.username"/></strong>
            |
                <form method="post" action="logout">
                   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                     <input name="submit" type="submit" value="<s:message code='logout'/>"/>
                </form>
        </sec:authorize>
    </div>
    <a href="<c:url value="/departments/all"/>">
    	   <s:message code="departments.manager.title" />
    	</a> |
    <a href="<c:url value="/legalentities/all"/>">
          <s:message code="legalentities.manager.title" />
          </a> |
	<a href="<c:url value="/persons/all"/>">
	   <s:message code="persons.manager.title" />
	</a> |
	<a href="<c:url value="/positions/all"/>">
         <s:message code="positions.manager.title" />
    </a>
</body>
</html>