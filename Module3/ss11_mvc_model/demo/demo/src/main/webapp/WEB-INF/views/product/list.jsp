<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Văn Bảo
  Date: 7/5/2023
  Time: 6:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <style>
        /* styles.css */
        table {
            margin: 20px 0;
            border-collapse: collapse;
            width: 100%;
        }

        th {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
            background-color: #007bff;
            color: #fff;
        }

        td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
            background-color: #f5f5f5;
        }

        tr:nth-child(even) td {
            background-color: #ddd;
        }

        tr:hover {
            background-color: #f0f0f0;
        }

        h1 {
            color: #333;
        }

        a {
            font-size: 16px;
            text-decoration: none;
            color: black;
        }

        a:hover {
            color: blue;
        }

        #link {
            color: #007bff;
            padding: 10px 20px;
            background-color: #ddd;
        }

        #link:hover {
            color: #ddd;
            background-color: darkgreen;
        }

        td a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<h1>List product</h1>
<a id="link" href="/product?action=create">Add new product</a>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Date release</th>
        <th>Category</th>
        <th colspan="2">Function</th>
    </tr>
    <c:forEach items="${products}" var="p">
        <tr>
            <td class="id">${p.id}</td>
            <td class="name"><a href="/product?action=detail&id=${p.id}">${p.name}</a></td>
            <td class="quantity">${p.quantity}</td>
            <td class="price">${p.price}</td>
            <td class="dateRelease">
                <fmt:formatDate value="${p.dateRelease}" pattern="dd/MM/yyyy"/>
            </td>
            <td class="categoryName">${p.category.name}</td>
            <td>
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal"
                        data-bs-whatever="${p.id}">Edit
                </button>
            </td>
            <td><a href="/product?action=delete&id=${p.id}">Delete</a></td>
        </tr>
    </c:forEach>
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Edit</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="mb-3">
                            <label for="id" class="col-form-label">ID:</label>
                            <input type="text" class="form-control" id="id">
                        </div>
                        <div class="mb-3">
                            <label for="name" class="col-form-label">Name:</label>
                            <input type="text" class="form-control" id="name">
                        </div>
                        <div class="mb-3">
                            <label for="quantity" class="col-form-label">Quantity:</label>
                            <input type="text" class="form-control" id="quantity">
                        </div>
                        <div class="mb-3">
                            <label for="price" class="col-form-label">Price:</label>
                            <input type="text" class="form-control" id="price">
                        </div>
                        <div class="mb-3">
                            <label for="dateRelease" class="col-form-label">Date Release:</label>
                            <input type="text" class="form-control" id="dateRelease">
                        </div>
                        <div class="mb-3">
                            <label for="categoryName" class="col-form-label">Category:</label>
                            <select name="" id="categoryName">
                                <c:forEach items="${categories}" var="e">
                                    <option value="${e.id}">${e.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save change</button>
                </div>
            </div>
        </div>
    </div>
</table>
<script>
    var exampleModal = document.getElementById('exampleModal');
    var idList = document.getElementsByClassName("id");
    var nameList = document.getElementsByClassName("name");
    var quantityList = document.getElementsByClassName("quantity");
    var priceList = document.getElementsByClassName("price");
    var dateReleaseList = document.getElementsByClassName("dateRelease");
    var categoryNameList = document.getElementsByClassName("categoryName");
    console.log(idList,nameList,quantityList,priceList,dateReleaseList,categoryNameList)
    exampleModal.addEventListener('show.bs.modal', function (event) {
        // Button that triggered the modal
        var button = event.relatedTarget
        // Extract info from data-bs-* attributes
        var id = parseInt(button.getAttribute('data-bs-whatever'))
        // If necessary, you could initiate an AJAX request here
        // and then do the updating in a callback.
        //
        // Update the modal's content.
        exampleModal.querySelector('#id').value = idList[id-1].value
        exampleModal.querySelector('#name').value = nameList[id-1].value
        exampleModal.querySelector('#quantity').value = quantityList[id-1].value
        exampleModal.querySelector('#price').value = priceList[id-1].value
        exampleModal.querySelector('#dateRelease').value = dateReleaseList[id-1].value
    })
</script>
</body>
</html>
