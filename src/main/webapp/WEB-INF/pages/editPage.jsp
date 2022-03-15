<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty car.manufacturer}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty car.manufacturer}">
        <title>Edit</title>
    </c:if>
</head>
<body>
<c:if test="${empty car.manufacturer}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty car.manufacturer}">
    <c:url value="/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty car.manufacturer}">
        <input type="hidden" name="id" value="${car.id}">
    </c:if>
    <label for="manufacturer">Manufacturer</label>
    <input type="text" name="manufacturer" id="manufacturer">
    <label for="model">Model</label>
    <input type="text" name="model" id="model">
    <label for="year">Year</label>
    <input type="text" name="year" id="year">
    <c:if test="${empty car.manufacturer}">
        <input type="submit" value="Add new car">
    </c:if>
    <c:if test="${!empty car.manufacturer}">
        <input type="submit" value="Edit car">
    </c:if>
</form>
</body>
</html>