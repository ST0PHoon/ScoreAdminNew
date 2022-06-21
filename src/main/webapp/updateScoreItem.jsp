<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>

<h1> 성적 조회후 정정 / 삭제 </h1>

		<form method='post' name='updel' >
			<table cellspacing=1 width=400 border = 1>
				<tr>
					<td width=100><p align=center>이름</p></td>
					<td width=300><p align=center>
						<input type="text" name="name" minlength="1" maxlength="8" id = 'namee' required='required' pattern='^[가-힣a-zA-Z]*' title = '문자형식으로 입력하세요' value='<%=name%>' ></p>
					</td>
				</tr>
				<tr>
					<td width=100><p align=center>학번</p></td>
					<td width=300><p align=center>
						<input type='text' name='studentid' value='<%=studentid%>' readonly></p>
					</td>
				</tr>
				<tr>
					<td width=100><p align=center>국어</p></td>
					<td width=300><p align=center>
						<input type='number' min='0' max='100' name='korean' id = 'korr' required='required'  value='<%=kor%>' ></p>
					</td>
				</tr>
				<tr>
					<td width=100><p align=center>영어</p></td>
					<td width=300><p align=center>
						<input type='number' min='0' max='100' name='english' id = 'engg' required='required' value='<%=eng%>' ></p>
					</td>
				</tr>
				<tr>
					<td width=100><p align=center>수학</p></td>
					<td width=300><p align=center>
						<input type='number' min='0' max='100' name='mathmatic' id = 'matt' required='required' value='<%=mat%>' ></p>
					</td>
				</tr>		
			</table>
			<table cellspacing=1 width=400 border = 0>
				<tr>
					<td width=200></td>
					<td width=100><p align=center><input type=submit value="수정" onClick=""></p></td>
					<td width=100><p align=center><input type=submit value="삭제" onClick=""></p></td>
				</tr>
			</table>

</body>
</html>