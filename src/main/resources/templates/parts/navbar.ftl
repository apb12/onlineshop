<#import "log.ftl" as l>
<#include "security.ftl">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/login">
        Логин
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">

            <#if known>

            <li class="nav-item">
                <a class="nav-link" href="/ur">Личный кабинет</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/shop">Магазин</a>
            </li>


    <#else>
    <li class="nav-item">
        <a class="nav-link" href="/registration">Регистрация</a>
    </li>


</#if>
</ul>
<div class="navbar-text mr-3" >${name}</div>
<@l.logout />
</div>
</nav>