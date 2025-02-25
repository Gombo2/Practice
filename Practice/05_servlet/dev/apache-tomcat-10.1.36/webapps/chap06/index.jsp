<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Exceptioin Handler</h1>

<!--
    Exception 핸들링 해보기
    1. web.xml을 통해 여러 상태 코드 발생 시 서블릿으로 요청할 지 url 경로 설정해 보기
    2. 모든 에러에 대해 페이지를 동적으로 처리할 수 있게 페이지를 만들어 응답해 보기
        (request의 attribute에 담긴 값을 활용할 예정)
   -->
<%--<ul>(li>a)*2--%>
<ul>
    <li><a href="show404error">404에러 확인</a></li>
    <li><a href="show500Error">500에러 확인</a></li>
</ul>
</body>
</html>