<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<%@ include file="./common.jsp"%>
</head>
<body>

	<div class="container mt-3">
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-center mb-3">Welcome to Product App</h1>
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">S.No.</th>
							<th scope="col">Name</th>
							<th scope="col">Description</th>
							<th scope="col">Price</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="product" items='${products}'>
							<tr>
								<th scope="row" class="font-weight-bold">PROD${product.id}</th>
								<td>${product.name}</td>
								<td>${product.description}</td>
								<td class="font-weight-bold">&#x20B9; ${product.price}</td>
								<td>
								   <a href="update/${product.id}"><i class="fa-solid fa-pen-to-square fa-2x mx-3"></i></a>
								   <a href="delete/${product.id}"><i class="fa-solid fa-trash text-danger fa-2x"></i></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="container text-center">
					<a href="add-product" class="btn btn-lg btn-outline-success">Add
						Product</a>
				</div>
			</div>
		</div>
	</div>

</body>
</html>