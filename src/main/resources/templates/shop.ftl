<#import "parts/common.ftl" as c>
<@c.page>

<#if items??>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Название</th>
        <th scope="col">RAM</th>
        <th scope="col">HDD</th>
        <th scope="col">Процессор</th>
        <th scope="col">Цена</th>
        <th scope="col">Купить</th>
    </tr>
    </thead>
    <tbody>
    <#list items as l>
    <tr>
        <th scope="row">${l.name}</th>
        <td>${l.ram}</td>
        <td>${l.hdd}</td>
        <td>${l.proc}</td>
        <td>${l.price}</td>
        <td><a href="/shop/${l.id}">купить</a> </td>
    </tr>
    </#list>
    </tbody>
</table>
</#if>
</@c.page>