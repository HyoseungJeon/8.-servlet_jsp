<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">

<%@ include file="../header/header.jspf"%>

<!-- Main -->
<main id="main" class="index-main">
    <div class="container">

        <h2 class="page-title text-center">나의 클럽</h2>

        <div class="content">
            <div class="search-form">
                <form action="${ctx}/list.do" method="post">
                    <div class="form-group">
                        <div class="input-group">
                            <input type="text" name="clubName" class="form-control" placeholder="검색어를 입력하세요.">
                            <div class="input-group-btn">
                                <button type="submit" class="btn btn-primary"><span
                                        class="glyphicon glyphicon-search"></span>
                                </button>
                            </div><!-- /btn-group -->
                        </div><!-- /input-group -->
                    </div>
                </form>
            </div>

			
            <div class="row btn-action">
                <div class="col-sm-12">
                    <div class="fl-right">
                        <a href="${ctx}/register.do" class="btn btn-default">
                            <i class="fas fa-plus"></i>
                            등록
                        </a>
                    </div>
                </div>
            </div>

            <div class="table-wrap">
                <table class="table text-center">
                    <thead>
                    <tr>
                        <th class="text-center">No</th>
                        <th class="text-center">클럽명</th>
                        <th class="text-center">창설일</th>
                        <!-- <th class="text-center">회원수</th> -->
                        <th class="text-center">관리</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${clubList }" var="club" varStatus="sts">
                    <tr>
                        <th scope="row" class="text-center">${sts.count }</th>
                        <td><a href="${ctx }/detail.do?name=${club.name}">${club.name }</a></td>
                        <jsp:useBean id="dateValue" class="java.util.Date"></jsp:useBean>
                        <jsp:setProperty property="time" name="dateValue" value="${club.foundationTime }"/>
                        <!-- long type으로 받은 값을 dataValue라는 이름의 Date type 변수로 생성 -->
                        
                        <td><fmt:formatDate pattern="yyyy-MM-dd" value="${dateValue }"/></td>
                        
                        <!-- <td>3</td> -->
                        <td>
                            <button class="btn btn-default btn-sm">
                                수정
                            </button>
                            <button class="btn btn-default btn-sm">
                                삭제
                            </button>
                        </td>
                    </tr>
                    </c:forEach>
                    
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</main>
<!-- // Main -->

<%@ include file="../footer/footer.jspf" %>


</html>



