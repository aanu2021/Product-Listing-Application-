<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mb-3">Update Product Details</h1>
				<form action="${pageContext.request.contextPath}/update-product" method="post">
					<input type="number" hidden="true" name="id" value="${product.id}" />
					<div class="form-group">
						<label for="name">Product Name</label> 
						   <input
							type="text" class="form-control" id="name"
							name="name" value="${product.name}" placeholder="Enter the product name here">
					</div>
					<div class="form-group">
						<label for="description">Product Description</label> 
						 <textarea
							class="form-control" id="description" rows="5"
							placeholder="Enter the product description here" name="description">${product.description}</textarea>
					</div>
					<div class="form-group">
						<label for="price">Product Price</label> 
						   <input
							type="number" class="form-control" id="price"
							name="price" value="${product.price}" placeholder="Enter the product price here">
					</div>
					<div class="container text-center">
					   <a href="${pageContext.request.contextPath}/home" class="btn btn-lg btn-outline-danger">Back</a>
					   <button type="submit" class="btn btn-lg btn-warning">Update</button>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>