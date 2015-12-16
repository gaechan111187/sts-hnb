<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
	<div>
	<div id="frm_toggle">
	<c:if test="${empty sessionScope.user}">
	   	<!-- 로그인 안한 상태 -->
		<div id="frm_login" class="form-2">
			<p class="float">
				<label for="login"><i class="icon-user">ID</i></label> <input type="text" name="login" placeholder="UserID">
			</p>
			<p class="float">
				<label for="password"><i class="icon-user">PW</i></label> <input type="password" name="password" placeholder="Password" class="showpassword">
			</p>
			<p class="clearfix">
				<a id="join_btn" class="log-twitter">회원 가입</a> 
				<a id="login_btn" class="log-twitter" style="margin-left:10px;">로그인</a> 
			</p>
		</div>
		</c:if>
		<c:if test="${not empty sessionScope.user}">
			<div id="frm_logined" class="form-2">
				<p style="color:white;">${user.name}님 반갑습니다.</p><p class="clearfix"></p>
					<input id="logout_btn" type="submit" name="submit" value="로그아웃">
					<input id="mypage_btn" type="submit" name="submit" value="마이 페이지" style="width: 85px;">
			</div>
		</c:if>
		</div>

		<div id="home" class="brand" style="padding-left: 390px; padding-right: 390px;">MTB BOX</div>

		<div class="address-bar" style="padding-left: 400px; padding-right: 400px;">
		세상을 바꾸는 힘, Culture MTB(Movie Theater BOX)</div>
	</div>

	<!-- Navigation -->
    <nav class="navbar navbar-default" role="navigation" >
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
                <a class="navbar-brand" href="index.html">Business Casual</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style=" margin-left:33%;" >
                <ul class="nav navbar-nav">
                    <li>
                        <button id="movie_btn">영화</button> <!-- 네비바 해당 링크 존재 -->
                    </li>
                    <li>
                        <button id="ticket_btn">예매</button>
                    </li>
                    <li>
                        <button id="theater_btn">극장</button>
                    </li>
                    <li>
                        <button id="event_btn">이벤트&컬쳐</button>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
    </nav>

<script type="text/javascript">
	$(function() {
		var $home = $('#home');
		var $event = $('#event_btn');
		var $movie = $('#movie_btn');
		var $mainView = $('.mainView');
		var $ticket = $('#ticket_btn');
		var $login = $('#login_btn');
		var $logout = $('#logout_btn');
		var $join = $('#join_btn');
		var $mypage = $('#mypage_btn');
		var $adminHome = $('#admin_home');
		var $adminMember = $('#admin_member');
		var $adminMovie = $('#admin_movie');
		global.load($home,$mainView,context+"/");
		global.load($ticket,$mainView,context+"/ticket/Ticket.do");
		global.load($mypage,$mainView,context+"/member/mypage");
		global.move($event, context+"/event/boardList");
		$movie.click(function() {Movie.home(context);});
		$join.click(function() {Member.join(context);});
		$login.click(function() {Member.login(context);});
		$logout.click(function() {Member.logout(context);});
		$adminHome.click(function() {Admin.home(context);});
		$adminMember.click(function() {Admin.member(context);});
		$adminMovie.click(function() {Admin.movie(context);});
	});
	
	
</script>
