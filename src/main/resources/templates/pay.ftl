<#import "parts/common.ftl" as c>
<@c.page>
<#if error??>
<div>
    <h1><span class="badge badge-danger">${error}</span></h1>
</div>
<div>
    <a href="/shop">вернуться к покупкам</a>
</div>
</#if>
<#if success??>
<div>
    <h1><span class="badge badge-success">${success}</span></h1>
</div>
<div>
    <a href="/shop">вернуться к покупкам</a>
</div>
</#if>
<#if comp??>

<div>
    <h1><span class="badge badge-warning">Вы покупаете ${comp.name}</span></h1>
</div>

<form action="/shop" method="post">

    <div class="input-group mb-2">

        <input class="form-control form-control-lg mb-2" type="number" step=1 min=1 pattern=[0-9]{3} name="amount" placeholder="Введите количество" required/>
        <input type="hidden" name="id" value=${comp.id?c}>
    </div>

<input type="hidden" name="_csrf" value="${_csrf.token}"/>
<input class="btn btn-outline-primary btn-lg" type="submit" value="Купить"/>
</form>
</#if>
</@c.page>