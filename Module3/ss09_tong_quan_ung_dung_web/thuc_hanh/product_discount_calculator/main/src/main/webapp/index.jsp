<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Discount Calculator</title>
</head>
<body>
<h2>Discount Calculator</h2>
<form method="post" action="/discount">
    <label>Product Description: </label><br/>
    <input type="text" name="description" placeholder="Product Description" value=""/><br/>
    <label>List Price: </label><br/>
    <input type="text" name="price" placeholder="List Price" value="0"/><br/>
    <label>Discount Percent: </label><br/>
    <input type="text" name="percent" placeholder="Discount Percent" value="0"/><br/>
    <input type = "submit" id = "submit" value = "Calculate Discount"/>

    <p>Discount Amount: ${discount}</p>
    <p>Discount Price: ${price}</p>
</form>
</body>
</html>