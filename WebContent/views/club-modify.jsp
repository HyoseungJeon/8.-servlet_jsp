<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<%@ include file="../header/header.jspf" %>

<!-- Main -->
<main id="main" class="index-main">
    <div class="container">

        <h2 class="page-title text-center">${club.name}</h2>

		<form class="form-inline" action="${ctx}/modify.do" method="post">
		<input type="hidden" name="clubName" value="${club.name }"/>
        <div class="panel panel-bordered">
            <div class="panel-body">
                <div class="content">
                    
                        <div class="row">
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <label for="exampleInputName2" class="title">창설일</label>
                                    <jsp:useBean id="dateValue" class="java.util.Date"></jsp:useBean>
                        			<jsp:setProperty property="time" name="dateValue" value="${club.foundationTime }"/>
                        			<%-- <fmt:formatDate pattern="yyyy-MM-dd" value="${dateValue }"/> --%>
                                    <input name="clubFoundationTime" type="text" class="form-control" id="exampleInputName2" placeholder="" 
                                    value=<fmt:formatDate pattern="yyyy-MM-dd" value="${dateValue }"/>>
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <!-- <label for="exampleInputName2" class="title">회원수</label>
                                    <p>3</p> -->
                                </div>
                            </div>
                        </div>
                    
                </div>

                <div class="content">
                    <div class="title">소개</div>

                    <div class="content-inner">
                        <textarea name="clubIntro" class="form-control" rows="15" cols="145">${club.intro }</textarea>
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
                        <button type="submit" class="btn btn-primary btn-bordered">
                            <i class="fas fa-check"></i> 수정 완료
                        </button>
                    </div>
                </div>
            </div>
        </div>
        </form>
    </div>
</main>
<!-- // Main -->

<%@ include file="../footer/footer.jspf" %>
</body>

</html>



