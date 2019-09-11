<%@page import="com.java.web.HomeBean"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="/resources/css/noticeboard.css">
	<link href="https://fonts.googleapis.com/css?family=Poor+Story&display=swap&subset=korean" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
			$("tbody tr").on("click", function(){
			/* 	var a = $(this).index();
				console.log(a); */
				
				var no = $(this).children().eq(0).text();
				console.log(no);
				var title = $(this).children().eq(1).text();
				var text = $(this).children().eq(2).text();
				
 				$("#title").val(title);
 				$("#text").val(text);
 				$("#no").val(no);
 				
			})
		});
	</script>
</head>
<body>
	<div class="container">
		<h1>게시판</h1>
		<div>
			<form action="">
				<div>
					<input type="hidden" name="no" id="no">
					<label for="title">제목 : </label> 
					<input type="text" name="title" id="title" placeholder="제목" required="required">
					<label for="text">내용 : </label>
					<input type="text" name="text" id="text" placeholder="내용">
					<button type="submit" formaction="/insert" class="blue">입력</button>
					<button type="submit" formaction="/update" class="yellow">수정</button>
					<button type="submit" formaction="/delete" class="pink">삭제</button>
				</div>
			</form>			
		</div>
		<div>
			<table>
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>내용</th>
					</tr>
				</thead>
				<tbody>
<%
	List<HomeBean> list = (List<HomeBean>) request.getAttribute("list");
	if(list == null || list.size() == 0) {
		System.out.println("리스트에 내용이 없습니다");
%>
					<tr>
						<td colspan="3">조회 데이터가 없습니다.</td>
					</tr>
<% 
	} else {	
		for(int i = 0; i < list.size(); i++){
%>
					<tr>
						<td><%=list.get(i).getNo() %></td>
						<td><%=list.get(i).getTitle() %></td>
						<td><%=list.get(i).getText() %></td>
					</tr>
<% 
		}
	}	
%>	
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
