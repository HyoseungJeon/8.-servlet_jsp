<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<%@ include file="../header/header.jspf"%>

<!-- Main -->
<main id="main" class="index-main">
    <div class="container">

        <h2 class="page-title text-center">${foundClub.name }</h2>

        <div class="panel panel-bordered">
            <div class="panel-body">
                <div class="content">
                    <ul class="list-inline">
                    	<jsp:useBean id="dateValue" class="java.util.Date"></jsp:useBean>
                        <jsp:setProperty property="time" name="dateValue" value="${foundClub.foundationTime }"/>
                        <li><span class="title">창설일</span><fmt:formatDate pattern="yyyy-MM-dd" value="${dateValue }"/></li>
                        <!-- <li><span class="title">회원수</span> 3
                            <button class="btn btn-basic"><span class="glyphicon glyphicon-search"></span></button>
                        </li> -->
                    </ul>
                </div>

                <div class="content">
                    <div class="title">소개</div>

                    <div class="content-inner">
                        <p>
                            ${foundClub.intro }
                        </p>
                    </div>
                </div>
            </div>
        </div>
        <div class="content">
            <div class="row btn-action">
                <div class="col-sm-12">
                    <a href="${ctx }" class="btn btn-default">
                        <i class="fas fa-list"></i> 목록
                    </a>
                    <div class="fl-right">
                        <a href="${ctx }/modify.do?name=${foundClub.name}" class="btn btn-default btn-bordered">
                            <i class="fas fa-edit"></i> 수정
                        </a>
                        <a href="${ctx }/delete.do?name=${foundClub.name}" class="btn btn-danger btn-bordered">
                            <i class="fas fa-trash-alt"></i> 삭제
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<!-- // Main -->

<%@ include file="../footer/footer.jspf" %>
</body>

</html>



