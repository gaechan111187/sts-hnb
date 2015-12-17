<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<LINK REL='stylesheet' type='text/css' href='${css}/board.css'/>	





	
<script type="text/javascript">
	$(function() {
		board.load(context+'/event/boardList/1');
	});
	var board = {
			load : function(url) {
				$.getJSON(url, function(data) {
					var table = '<div id="boardList"><h1 align=center style="color:white;margin-bottom:30px">자유게시판</h1>'
								+'<table id="tab_test"><tr><td style="text-align:right">게시글 수 : '+data.count+'</td></tr></table>'
								+'<TABLE id="tab_borderList"><TR ALIGN=CENTER><TD WIDTH=10%><B>번호</B></TD>'
								+'<TD WIDTH=40%><B>제목</B></TD>'
								+'<TD WIDTH=20%><B>작성자</B></TD>'
								+'<TD WIDTH=20%><B>작성일</B></TD>'
								+'<TD WIDTH=18%><B>참조</B></TD></TR>'
								/* +'<c:forEach var="member" items="${memberList}" varStatus="status">'
								+'<TR><TD WIDTH=10% ALIGN=CENTER>${status.index+1}</TD>'
								+'<TD WIDTH=20% ALIGN=CENTER>'+data.id+'</TD>'
								+'<TD WIDTH=20% ALIGN=CENTER><A HREF="BoardContent.jsp">'+data.name+'</A></TD>'
								+'<TD WIDTH=30% ALIGN=LEFT>'+data.email+'</TD>'
								+'<TD WIDTH=18% ALIGN=CENTER>'+data.regdate+'</TD></TR></c:forEach>' */
								+'</TABLE></div>';
					$('.mainView').html(table);
				});
			}
	};
</script>