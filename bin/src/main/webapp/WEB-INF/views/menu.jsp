<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
    <c:when test="${sessionScope.userId eq null}">
        <div><a href="${pageContext.request.contextPath}/user/login.do">로그인</a>
            <a href="${pageContext.request.contextPath}/user/regist_form.do">회원가입</a></div>
    </c:when>
    <c:otherwise>
        <div> ${userName}님 로그인 인증!! <a href="${pageContext.request.contextPath}/user/logout.do">로그아웃</a></div>
    </c:otherwise>
</c:choose>
<a href="${pageContext.request.contextPath}/index.jsp">홈으로 이동</a>