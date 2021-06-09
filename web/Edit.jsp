<%-- 
    Document   : Edit
    Created on : 2021-6-9, 20:45:54
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>
            <s:if test="book == null">
                Add Book
            </s:if>
            <s:else>
                Edit Book
            </s:else>
        </h2>
        <s:form action="Store">
        <tr>
            <td>
                <s:textfield name="book.isbn" label="ISBN"/>
            </td>
            <td>
                <s:fielderror><s:param>Isbn</s:param></s:fielderror>
            </td>
        </tr>
        <tr>
            <td>
                <s:textfield name="book.title" label="TITLE"/>
                 <td>
                <s:fielderror><s:param>Title</s:param></s:fielderror>
            </td>
            </td>

        </tr>
        <tr>
            <td>
                <s:textfield name="book.price" label="PRICE"/>
                 <td>
                <s:fielderror><s:param>Price</s:param></s:fielderror>
            </td>
            </td>

        </tr>
        <s:submit/>
    </s:form>
</body>
</html>
