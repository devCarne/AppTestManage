<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <table>
        <tr>
            <th colspan="2">관리자 등록</th>
            <th rowspan="4"><input type="submit" value="등록" onclick="return inputCheck()" formaction="managerSignUp.do"></th>
        </tr>
        <tr>
            <td>아이디</td><td><input type="text" id="id" name="id"></td>
            <td><input type="button" onclick="idCheck()" value="중복체크"><div id="message"></div></td>
        </tr>
        <tr>
            <td>비밀번호</td><td><input type="password" id="pw" name="pw"></td>
        </tr>
        <tr>
            <td>이름</td><td><input type="text" id="name" name="name"></td>
        </tr>
    </table>
</form>
<script>
    function idCheck() {
        let xhr = new XMLHttpRequest();
        xhr.onreadystatechange = () => {
            if (xhr.readyState === 4 && xhr.status === 200) {
                document.getElementById("message").innerText = xhr.responseText;
            }
        };
        let id = document.getElementById("id").value;
        xhr.open("GET", "idCheck.do?id=" + id);
        xhr.send();
    }

    function inputCheck() {
        if (document.getElementById("message").textContent === "가입이 가능합니다.") {
            if (document.getElementById("id").value.length === 0) {
                alert("아이디를 입력하세요");
                document.getElementById("id").focus();
                return false;
            } else if (document.getElementById("pw").value.length === 0) {
                alert("비밀번호를 입력하세요");
                document.getElementById("pw").focus();
                return false;
            } else if (document.getElementById("name").value.length === 0) {
                alert("이름을 입력하세요");
                document.getElementById("name").focus();
                return false;
            }
        } else {
            alert("중복검사를 해주세요");
            return false;
        }
    }
</script>
</body>
</html>