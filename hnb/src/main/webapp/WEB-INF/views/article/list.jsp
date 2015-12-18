<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<LINK REL='stylesheet' type='text/css' href='${css}/board.css'/>	





	
<script type="text/javascript">
	$(function() {
		board.init('142','1');
	});
	var board = {
			init : function(themeNo,pageNo) {
				$.getJSON(context+'/article/list/'+themeNo+'/'+pageNo, function(data) {
					var command = {
							pageNo: '1',
							themeNo : '142' //자유게시판
					};
					var table = '<div id="boardList"><h1 align=center style="color:white;margin-bottom:30px">자유게시판</h1>'
								+'<table id="tab_test"><tr><td style="text-align:right">게시글 수 : '+data.count+'</td></tr></table>'
								+'<TABLE id="tab_borderList"><TR ALIGN=CENTER><TD WIDTH=8%><B>번호</B></TD>'
								+'<TD WIDTH=30%><B>제목</B></TD>'
								+'<TD WIDTH=60%><B>내용</B></TD>'
								+'</TR>';
						$.each(data, function(index, value) {
						table += '<TR><TD WIDTH=8% ALIGN=CENTER>'+(index+1)+'</TD>'
							+'<TD WIDTH=30% ALIGN=CENTER><A HREF="BoardContent.jsp">'+this.usrSubject+'</A></TD>'
							+'<TD WIDTH=60% ALIGN=LEFT>'+this.usrContent+'</TD></TR>';
						});
							
						table +='</TABLE></div>'
								+'<div style="width:100px; margin:auto"><a href="'+context+'/article/write">글쓰기</a></div>';
					$('.mainView').html(table);
				});
			}
	
		};
</script>