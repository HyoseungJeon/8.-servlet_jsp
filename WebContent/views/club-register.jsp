<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<%@ include file="../header/header.jspf" %>

<!-- Main -->
<main id="main" class="index-main">
    <div class="container">

        <h2 class="page-title text-center">클럽 등록</h2>

		<form class="form-horizontal" action="${ctx}/register.do" method="post">
        <div class="content">
            <div class="panel panel-bordered">
                <div class="panel-body">
                    <div class="content">
                        
                            <div class="form-group">
                                <label for="clubName" class="col-sm-2 control-label">클럽 이름</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="clubName" name="clubName" placeholder="클럽 이름">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="clubIntro" class="col-sm-2 control-label">소개</label>
                                <div class="col-sm-10">
                                    <textarea class="form-control" id="clubIntro" name="clubIntro" rows="15" cols="110"></textarea>
                                </div>
                            </div>
                        
                    </div>
                </div>
            </div>

            <div class="row btn-action">
                <div class="col-sm-12">
                    <div class="fl-right">
                        <button type="submit" class="btn btn-primary btn-bordered">
                            <i class="fas fa-check"></i> 등록
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



