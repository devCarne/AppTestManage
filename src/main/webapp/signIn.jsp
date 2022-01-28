<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <table>
        <tr>
            <th colspan="2">로그인</th>
            <th rowspan="3"><input type="submit" value="로그인" onclick="return inputCheck()" formaction="signIn.do"></th>
        </tr>
        <tr>
            <td>아이디</td><td><input type="text" name="id" id="id"></td>
        </tr>
        <tr>
            <td>비밀번호</td><td><input type="password" name="pw" id="pw"></td>
        </tr>
    </table>
</form>
<script>
    function inputCheck() {
        if (document.getElementById("id").value.length === 0) {
            alert("아이디를 입력하세요");
            document.getElementById("id").focus();
            return false;
        } else if (document.getElementById("pw").value.length === 0) {
            alert("비밀번호를 입력하세요");
            document.getElementById("pw").focus();
            return false;
        }
    }
</script>
</body>
</html>
