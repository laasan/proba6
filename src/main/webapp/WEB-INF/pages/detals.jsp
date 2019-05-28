<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Books Page</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<a href="index.jsp">Back to main menu</a>

<br/>
<br/>

<h1>Detals List</h1>

<c:if test="${!empty listDetals}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Type</th>
            <th width="120">Name</th>
            <th width="120">Need</th>
            <th width="120">Amount</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listDetals}" var="detal">
            <tr>
                <td>${detal.id}</td>
                <td>${detal.type}</td>
                <td>${detal.name}</td>
                <td>${detal.need}</td>
                <td>${detal.amount}</td>
                <td><a href="<c:url value='/edit/${detal.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${detal.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>


        <table>
            <tr>
                <td><a href="<c:url value='/previous'/>">Previous</a></td>
                <td width="60"></td>
                <td><a href="<c:url value='/next'/>">Next</a></td>
            </tr>
        </table>


    <br/>

    <table class="tg">
        <tr>
            <td width="200">Computers could be built: </td>
            <td width="30">${compAmount}</td>
        </tr>
    </table>

</c:if>
<br/>

<table>
    <tr>
        <td><a href="<c:url value='/detals/selectNeed'/>">Necessary</a></td>
        <td><a href="<c:url value='/detals/selectNoNeed'/>">Optional</a></td>
        <td><a href="<c:url value='/detals/selectAll'/>">All</a></td>
    </tr>
</table>

<h1>Add a Detal</h1>

<c:url var="addAction" value="/detals/add"/>

<form:form action="${addAction}" modelAttribute="detal">
    <table>
        <c:if test="${!empty detal.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="type">
                    <spring:message text="Type"/>
                </form:label>
            </td>
            <td>
                <form:input path="type"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="need">
                    <spring:message text="Need"/>
                </form:label>
            </td>
            <td>
                <form:input path="need"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="amount">
                    <spring:message text="Amount"/>
                </form:label>
            </td>
            <td>
                <form:input path="amount"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty detal.name}">
                    <input type="submit"
                           value="<spring:message text="Edit Detal"/>"/>
                </c:if>
                <c:if test="${empty detal.name}">
                    <input type="submit"
                           value="<spring:message text="Add Detal"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>

<h1>Search</h1>
<c:url var="searchAction" value="/detals/search"/>

<form:form action="${searchAction}" modelAttribute="detal">
    <table>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>

        </tr>
        <tr>
            <td colspan="2">

                <input type="submit" value="<spring:message text="Search"/>"/>

            </td>
        </tr>

    </table>
</form:form>
</body>
</html>
