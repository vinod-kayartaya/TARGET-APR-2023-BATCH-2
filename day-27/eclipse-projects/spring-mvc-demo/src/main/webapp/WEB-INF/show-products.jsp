<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product list</title>
</head>
<body>

	<h1>Product list</h1>

	<table border="1">
		<thead>
			<tr>
				<th>Name</th>
				<th>Price</th>
				<th>Unit description</th>
				<th>Discontinued?</th>
				<th>Units in stock</th>
				<th>Units on order</th>
				<th>Reorder level</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${products}" var="p">
				<tr>
					<td>${p.productName}</td>
					<td>${p.unitPrice}</td>
					<td>${p.quantityPerUnit}</td>
					<td>${p.discontinued==1?"Yes": "No"}</td>
					<td>${p.unitsInStock}</td>
					<td>${p.unitsOnOrder}</td>
					<td>${p.reorderLevel}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>