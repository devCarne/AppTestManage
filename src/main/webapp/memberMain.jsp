<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("id", session.getAttribute("memberId"));
    pageContext.setAttribute("name", session.getAttribute("memberName"));
    pageContext.setAttribute("regDate", session.getAttribute("memberRegDate"));
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
${name}님 안녕하세요. 아이디 : ${id}, 가입일 : ${regDate}
</body>
</html>
