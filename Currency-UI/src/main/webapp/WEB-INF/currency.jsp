<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<fieldset>
<legend><h2>CurrencyConvertion</h2></legend>

<form:form action="currencyValue" modelAttribute="currencyReqModel">

CurrencyValue:<form:input path="currencyValue"/><br><br>
CurrencyFrom<form:input path="currencyFrom"/><br><br>
CurrencyTo<form:input path="currencyTo"/><br><br>


<input type="submit" value="submit"/>
</form:form>
<br><br>
<c:if test="${!empty value}">

<h2>Convertion Value is:${value}</h2>
</c:if>
</fieldset>
</div>
</body>
</html>