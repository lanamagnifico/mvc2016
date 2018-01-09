<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>HR-manager</title>
    <link rel="stylesheet" type="text/css"
              href="<c:url value="/pages/css/style.css" />" >
  </head>

  <body onload='document.f.username.focus();'>
     <form action="login" method="POST" name="f">
           <label for="username">
              <s:message code="name.title" />
           </label>
           <input type='text' name="username" value=''/><br/>

           <label path="password">
              <s:message code="password.title" />
           </label>
           <input type='password' name="password"/><br/>
           <input name="submit" type="submit" value="Login"/>
           <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
         </form>
       </body>
</html>