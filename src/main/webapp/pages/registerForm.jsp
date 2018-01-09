<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>HR-manager: Registration Form</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/pages/css/style.css" />" >
    <link rel="icon" type="image/x-icon"
            href="<s:url value="/favicon.ico"/>" />
     <meta name="_csrf" content="${_csrf.token}"/>
     <meta name="_csrf_header" content="${_csrf.headerName}"/>
  </head>
  <body>
    <h1>Register</h1>
    <sf:form method="POST" commandName="user"
         enctype="multipart/form-data">
      <sf:errors path="*" element="div" cssClass="errors" />

      <sf:label path="name"
            cssErrorClass="error">
                <s:message code="name.title" />
            </sf:label>
            <sf:input path="name"/><br/>
      <sf:label path="password"
                  cssErrorClass="error">
                      <s:message code="password.title" />
                  </sf:label>
                  <sf:password path="password"/><br/>
          <label for="passwordConfirm"><s:message code="password.confirm.title" /></label>
          <input type="password" id="passwordConfirm" name="passwordConfirm"/> <br/>
      <sf:label path="email"
            cssErrorClass="error">
             <s:message code="email.title" />
              </sf:label>
            <sf:input path="email" /><br/>
      <label for="image">
             <s:message code="image.title" />
              </label>
            <input name="image" type="file"
              accept="image/jpeg,image/png,image/gif"/><br/>
      <input type="submit" value="Register" />
    </sf:form>
    <a href="<c:url value="/"/>">
      <s:message code="back" />
      </a>
  </body>
</html>