<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
.white-popup {
  position: relative;
  background: #FFF;
  padding: 20px;
  width: auto;
  max-width: 500px;
  margin: 20px auto;
}
</style>
<div id="test-popup" class="white-popup mfp-hide">
  <TABLE WIDTH=620 HEIGHT=40 BORDER=0 CELLSPACING=1 CELLPADDING=1 ALIGN=CENTER>
	<TR BGCOLOR=#A0A0A0>
		<TD ALIGN=CENTER><FONT SIZE=4><B>게시판 ( 게시글 입력 )</B></FONT></TD>
	</TR>
</TABLE>


<FORM NAME="BoardWrite" METHOD=POST ACTION="BoardWriteProc.jsp">

<TABLE WIDTH=620 BORDER=1 CELLSPACING=0 CELLPADDING=2 ALIGN=CENTER>

	<TR>
		<TD WIDTH=120 ALIGN=CENTER><B>제목</B></TD>
		<TD WIDTH=500>
			<INPUT TYPE=TEXT NAME="subject" SIZE=70>
		</TD>
	</TR>
	
	<TR>
		<TD WIDTH=120 ALIGN=CENTER><B>내용</B></TD>
		<TD WIDTH=500>
			<TEXTAREA NAME="content" COLS=70 ROWS=8></TEXTAREA>
		</TD>
	</TR>
	
</TABLE>

</FORM>

<TABLE WIDTH=620 HEIGHT=50 BORDER=0 CELLSPACING=1 CELLPADDING=1 ALIGN=CENTER>

	<TR ALIGN=CENTER>
		<TD WIDTH=110 ALIGN=LEFT>
			<IMG SRC="${img}/btn_list.gif" id="go_list" STYLE=CURSOR:HAND>
		</TD>
		<TD WIDTH=400 ALIGN=CENTER>		
			<IMG SRC="${img}/btn_save.gif" id="save" STYLE=CURSOR:HAND>&nbsp;&nbsp;
			<IMG SRC="${img}/btn_cancel.gif" STYLE=CURSOR:HAND>
		</TD>
		<TD WIDTH=110 ALIGN=LEFT>&nbsp;</TD>   
	</TR>
	
</TABLE>
</div>
<a href="#test-popup" class="open-popup-link">
Show inline popup
</a>
<a href="mobile-friendly-page.html" data-mfp-src="#test-popup" class="open-popup-link">
	Show inline popup
	</a>
<script type="text/javascript">
$(function() {
board.init('142','1');
	 $('.open-popup-link').magnificPopup({
	  type:'inline',
	  midClick: true // Allow opening popup on middle mouse click. Always set it to true if you don't provide alternative source in href.
	});
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