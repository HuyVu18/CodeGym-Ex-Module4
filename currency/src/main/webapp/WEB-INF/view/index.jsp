<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Currency</title>
</head>
<body>
<h1>Currency conversion</h1>

<h4>USD --> VND</h4>
<form action="currency1" method="get">
    <input type="number" name="input1" placeholder="USD">
    <button type="submit">Conversion</button>
</form>
<p><c:out value="${result1.result}"/>VND</p>

<h4>VND --> USD</h4>
<form action="currency2" method="get">
    <input type="number" name="input2" placeholder="VND">
    <button type="submit">Conversion</button>
</form>
<p><c:out value="${result2.result}"/>USD</p>

</body>
</html>