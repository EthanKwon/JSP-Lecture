<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>회원 수정</title>
	<style>
		label {
			display : block; /* 새 라인에서 시작 */
			padding : 5px;
		}
		label span {
			display : inline-block;
			width : 90px;
			text-align : right;
			padding : 10px;
		}
	</style>
</head>
<body>
<%
	//request.setCharacterEncoding("UTF-8");
	MemberDTO member = (MemberDTO) request.getAttribute("member");
%>
	<h3>회원 수정</h3>
	<hr>
	<!-- <form name="updateForm" action="/jspbook/member/updateMemberServlet" method=post> -->
	<form name="updateForm" action="/jspbook/member/memberProcServlet?action=execute" method=post>
		<input type="hidden" id="id" name="id" value="<%=member.getId()%>">
		<label><span>아이디:</span>
			<%=member.getId()%></label>
		<label><span>이름:</span>
			<input type="text" name="name" value="<%=member.getName()%>" size="10"></label>
		<label><span>생일:</span>
			<input type="text" name="birthday" value="<%=member.getBirthday()%>" size="10"></label>
		<label><span>주소:</span>
			<input type="text" name="address" value="<%=member.getAddress()%>" size="40"></label>	
			<br>
		<label><span></span><input type="submit" value="회원 수정" name="B1">&nbsp;&nbsp;
			<input type="reset" value="재작성" name="B2"></label>
	</form>
</body>
</html>