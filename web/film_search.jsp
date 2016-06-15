<%-- 
    Document   : film_search
    Created on : Jun 15, 2016, 10:48:33 AM
    Author     : cmlee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Query Result</h1>
        
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Value</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Title</td>
                    <td>${film.title}</td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td>${film.description}</td>
                </tr>
                <tr>
                    <td>Rating</td>
                    <td>${film.rating}</td>
                </tr>
                <tr>
                    <td>Length</td>
                    <td>${film.length}</td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
