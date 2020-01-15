<#import "parts/common.ftl" as c>
<@c.page>
<div align="center">
    <h1><span class="badge badge-warning">Редактирование заказаов</span></h1>
</div>
<#if success??>
<div align="center">
    <h3><span class="badge badge-success">${success}</span></h3>
</div>
</#if>
<#if error??>
<div align="center">
    <h3><span class="badge badge-danger">${error}</span></h3>
</div>
</#if>

<#if delete??>
<form action="/delete" method="post">
    <div align="center">
        <h3><span class="badge badge-danger">Вы точно хотите удалить этот заказ?</span></h3>
    </div>

    <div class="input-group mb-2">
        <input type="hidden" name="id" value=${delete.id?c}>
    </div>

    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <input class="btn btn-outline-primary btn-lg" type="submit" value="Удалить"/>
</form>
<form action="/ur" method="get">
    <input class="btn btn-outline-primary btn-lg" type="submit" value="Нет"/>
</form>
</#if>

<#if edit??>
<form action="/edit" method="post">
    <div align="center">
        <h3><span class="badge badge-danger">Редактировать заказ?</span></h3>
    </div>

    <div class="input-group mb-2">
        <input class="form-control form-control-lg mb-2" type="number" step=1 min=1 pattern=[0-9]{3} name="count" placeholder="Введите количество" required/>
        <input type="hidden" name="id" value=${edit.id?c}>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <input class="btn btn-outline-primary btn-lg" type="submit" value="Редактировать"/>
</form>
<form action="/ur" method="get">
    <input class="btn btn-outline-primary btn-lg" type="submit" value="Нет"/>
</form>
</#if>
<div align="center">
    <a href="/ur">в личный кабинет</a>
    <a href="/shop">вернуться к покупкам</a>
</div>
</@c.page>