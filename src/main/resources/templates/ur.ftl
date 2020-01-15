<#import "parts/common.ftl" as c>
<@c.page>
<#if error??>
<div align="center">
    <h1><span class="badge badge-danger">${error}</span></h1>
    <a href="/shop">вернуться к покупкам</a>
</div>
</#if>
<#if purchase??>

<table class="table">
    <thead>
    <tr>
        <th scope="col">Дата</th>
        <th scope="col">Товар</th>
        <th scope="col">Количество</th>
        <th scope="col">Цена</th>
        <th scope="col">Редактировать</th>
        <th scope="col">Удалить</th>
    </tr>
    </thead>
    <tbody>
    <#list purchase as p>
    <tr>
        <th scope="row">${p.dtime}</th>
        <td>${p.item.name}</td>
        <td>${p.count}</td>
        <td>${p.amount}</td>
        <td><a href="/edit/${p.id?c}">Редактировать</a> </td>
        <td><a href="/delete/${p.id?c}">Удалить</a> </td>
    </tr>
    </#list>
    </tbody>
</table>
<div align="center">
    <a href="/shop">вернуться к покупкам</a>
</div>
</#if>
</@c.page>