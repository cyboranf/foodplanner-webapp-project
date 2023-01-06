<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="appheader.jsp"%>

<div class="m-4 p-3 width-medium ">
    <c:if test="${msg=='success'}"><p style="font-size: x-large; color: blue">Posiłek usunięty prawidłowo!</p></c:if>
    <c:if test="${msg=='failed'}"><p style="font-size: x-large; color: red">Coś poszło nie tak podczas usuwania posiłku!</p></c:if>
    <div class="dashboard-content border-dashed p-3 m-4">
        <div class="row border-bottom border-3 p-1 m-1">
            <div class="col noPadding">
                <h3 class="color-header text-uppercase">SZCZEGÓŁY PLANU</h3>
            </div>
            <div class="col d-flex justify-content-end mb-2 noPadding">
                <a href="/app/plan/list" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">Powrót</a>
            </div>
        </div>

        <div class="schedules-content">
            <div class="schedules-content-header">
                <div class="form-group row">
                                <span class="col-sm-2 label-size col-form-label">
                                    Nazwa planu
                                </span>
                    <div class="col-sm-10">
                        <p class="schedules-text">${plan.name}</p>
                    </div>
                </div>
                <div class="form-group row">
                                <span class="col-sm-2 label-size col-form-label">
                                    Opis planu
                                </span>
                    <div class="col-sm-10">
                        <p class="schedules-text">
                            ${plan.description}
                        </p>
                    </div>
                </div>
            </div>

            </tbody>

            <table class="table">
                <thead>
                <tr class="d-flex">
                    <th class="col-2"></th>
                    <th class="col-8"></th>
                    <th class="col-2"></th>
                </tr>
                </thead>
                <tbody>

                <tr class="d-flex">
                    <td class="col-2"></td>
                    <td class="col-7"></td>
                    <td class="col-1 center">

                    </td>
                    <td class="col-2 center">
                    </td>

            </table>

        </div>
    </div>
</div>
</div>
</section>

<script>
    function myFunction(number, name, dayName, id) {
        if (confirm("Czy na pewno chcesz usunąć posiłek \"" + name + "\" z "+dayName+"?") == true) {
            window.location.href = "/app/deleterecipefromplan?id="+number+"&plan="+id;
        } else {
            window.location.href = "/app/plan/details?id="+id;
        }
    }
    function link(link){
        window.location.href = link;
    }
</script>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>