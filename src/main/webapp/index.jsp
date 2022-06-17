<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="kr.ac.kopo.ctc.kopo37.dao.ScoreItemDao" %>
<%@ page import="kr.ac.kopo.ctc.kopo37.dao.ScoreItemDaoImpl" %>
<%@ page import="kr.ac.kopo.ctc.kopo37.service.ScoreItemService" %>
<%@ page import="kr.ac.kopo.ctc.kopo37.service.ScoreItemServiceImpl" %>
<%@ page import="kr.ac.kopo.ctc.kopo37.domain.ScoreItem" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
ScoreItemDao scoreItemDao = new ScoreItemDaoImpl();
ScoreItemService scoreItemService = new ScoreItemServiceImpl();
scoreItemService.setScoreItemDao(scoreItemDao);
List<ScoreItem> scoreItems = scoreItemService.selectAll(1, 2);
//out.println(n);
%>
afdsfdsafdsa


</body>
</html>