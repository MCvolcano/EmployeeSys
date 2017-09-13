<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>所有员工信息</title>
		<style type="text/css">
			table td {
				text-align: center;
			}
			/*合并表格的边框*/
			
			table {
				width: 700px;
				border-collapse: collapse;
			}
			
			h3 {
				text-align: center;
			}
			
			div {
				margin: 0 auto;
				width: 700px;
			}
		</style>
	</head>

	<body>
	
		<c:set var="totalUsers" value="${requestScope.totalUsers}"/>
	    <c:set var="usersPerPage" value="${requestScope.usersPerPage}"/>
	    <c:set var="totalPages" value="${requestScope.totalPages}"/>
	    <c:set var="beginIndex" value="${requestScope.beginIndex}"/>
	    <c:set var="endIndex" value="${requestScope.endIndex}"/>
	    <c:set var="page" value="${requestScope.page}"/>
	    <c:set var="currentPageUsers" value="${requestScope.list.subList(beginIndex,endIndex)}"/>
	    <p>用户总数:${totalUsers}</p>
	    <p>每页用户数:${usersPerPage}</p>
	    <p>总页数:${totalPages}</p>
	    <p>当前页:${page}</p>
	    
		<div>
			<h3>所有员工信息</h3>
			<a href="add.jsp">添加员工信息</a><br/>
			<table border="1">

				<tr>
					<th>序号</th>
					<th>id</th>
					<th>姓名</th>
					<th>性别</th>
					<th>年龄</th>
					<th>手机</th>
					<th>邮箱</th>
					<th>QQ</th>
					<th>操作</th>
				</tr>
				
				
				
				<c:forEach var="e" items="${currentPageUsers }" varStatus="vs">
				<tr>
					<td>${vs.count }</td>
					<td>${e.id }</td>
					<td>${e.name }</td>
					<td>${e.sex }</td>
					<td>${e.age }</td>
					<td>${e.phone }</td>
					<td>${e.email }</td>
					<td>${e.qq }</td>
					<td>
						<a href="QueryServlet?id=${e.id }">修改</a>&nbsp;
						<a href="DeleteServlet?id=${e.id }">删除</a>
					</td>
				</tr>
				</c:forEach> 
				
				<tr>
					<td colspan="9">
						<a href="<c:url value="/ListServlet?page=1"/>">首页</a>
						<a href="<c:url value="/ListServlet?page=${page-1>1?page-1:1}"/>">上一页</a>
						<a href="<c:url value="/ListServlet?page=${page+1<totalPages?page+1:totalPages}"/>">下一页</a>
						<a href="<c:url value="/ListServlet?page=${totalPages}"/>">尾页</a>
					</td>
				</tr>
			</table>
		</div>
		
	</body>

</html>