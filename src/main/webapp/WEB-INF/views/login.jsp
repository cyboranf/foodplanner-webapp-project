<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<section class="dashboard-section">
    <div class="container pt-4 pb-4">
        <div class="border-dashed view-height">
            <div class="container w-25">
                <form class="padding-small text-center" method="post">
                    <h1 class="text-color-darker">Sign in</h1>
                    <div class="form-group">
                        <input type="text" class="form-control" id="email" name="email" placeholder="email">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" id="password" name="password" placeholder="password">
                    </div>
                    <button class="btn btn-color rounded-0" type="submit">Log in</button>
                </form>
            </div>
        </div>
    </div>
</section>

<%@include file="footer.jsp"%>