<%-- 
    Document   : List
    Created on : 2021-6-9, 20:17:57
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
        <s:form>
        <tr>
            <th>ISBN</th>
            <th>Title</th>
            <th>Price</th>
            <th>Operation</th>
        </tr>

        <s:iterator value="books">
            <tr>
                <td><s:property value="isbn"/> </td>
                <td><s:property value="title"/> </td>
                <td><s:property value="price"/> </td>
                <td>  
                    <a href="<s:url action="Remove"><s:param name="isbn" value="isbn"/></s:url>">
                    Delete
                    </a>
                    &nbsp;
                    <a href="<s:url action="Load"><s:param name="isbn" value="isbn"/></s:url>">
                    Edit
                    </a>
                        
                </td>
            </tr>
        </s:iterator>
            
    </s:form>
            <a href="Edit.jsp">
                Add Book
            </a>
</body>
</html>
