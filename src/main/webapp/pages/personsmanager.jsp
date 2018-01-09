<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>HR-manager: Persons list</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/pages/css/style.css" />" >
    <s:url value="/persons/all" var="pageurl" />
        <link rel="icon" type="image/x-icon"
            href="<s:url value="/favicon.ico"/>" />
  </head>
<body>
	<h4>Persons :</h4>
	<a href="<c:url value="/persons/new"/>"><s:message code="add"/></a>
     <a href="<c:url value="/"/>">
          <s:message code="back" />
     </a>
     <div>
         <c:set var="pageListHolder" value="${persons}" scope="session" />
             <table cellspacing="0">
                 <thead><tr>
                 <th>ID</th>
                 <th>Name</th>
                 <th>Birth day</th></tr>
                 </thead>
                 <tbody>
                 <c:forEach var="pers" items="${pageListHolder.pageList}">
                     <tr><td>${pers.id}</td>
                         <td>${pers.name}</td>
                         <td>${pers.birthDay}</td>
                     </tr>
                 </c:forEach>
                 </tbody>
             </table>
         </div>
      <c:choose>
                <c:when test="${pageListHolder.pageCount>0}">
                  <span style="float:left;">
                    <c:choose>
                      <c:when test="${pageListHolder.firstPage}">Prev</c:when>
                      <c:otherwise><a href="${pageurl}/prev">Prev</a></c:otherwise>
                    </c:choose>
                  </span>
                 </c:when>
              </c:choose>

              <c:choose>
                <c:when test="${pageListHolder.page==0}">
                  <span>
                    <c:forEach begin="0" end="2" varStatus="loop">
                    &nbsp;&nbsp;
                      <c:choose>
                        <c:when test="${loop.index == pageListHolder.page}">${loop.index+1}</c:when>
                        <c:otherwise><a href="${pageurl}/${loop.index}">${loop.index+1}</a></c:otherwise>
                      </c:choose>
                    &nbsp;&nbsp;
                    </c:forEach>
                  </span>
                </c:when>
                <c:otherwise>
                  <c:choose>
                    <c:when test="${pageListHolder.page==pageListHolder.pageCount-1}">
                      <c:forEach begin="${pageListHolder.pageCount-3}" end="${pageListHolder.pageCount-1}" varStatus="loop">
                      &nbsp;&nbsp;
                        <c:choose>
                          <c:when test="${loop.index == pageListHolder.page}">${loop.index+1}</c:when>
                          <c:otherwise><a href="${pageurl}/${loop.index}">${loop.index+1}</a></c:otherwise>
                        </c:choose>
                        &nbsp;&nbsp;
                     </c:forEach>
                    </c:when>
                    <c:otherwise>
                      <span>
                        <c:forEach begin="${pageListHolder.page-1}" end="${pageListHolder.page+1}" varStatus="loop">
                        &nbsp;&nbsp;
                          <c:choose>
                            <c:when test="${loop.index == pageListHolder.page}">${loop.index+1}</c:when>
                            <c:otherwise><a href="${pageurl}/${loop.index}">${loop.index+1}</a></c:otherwise>
                          </c:choose>
                        &nbsp;&nbsp;
                        </c:forEach>
                      </span>
                    </c:otherwise>
                  </c:choose>
                </c:otherwise>
              </c:choose>

              <c:choose>
                <c:when test="${pageListHolder.pageCount>0}">
                  <span>
                    <c:choose>
                      <c:when test="${pageListHolder.lastPage}">Next</c:when>
                      <c:otherwise><a href="${pageurl}/next">Next</a></c:otherwise>
                    </c:choose>
                  </span>
                </c:when>
              </c:choose>
</body>
</html>