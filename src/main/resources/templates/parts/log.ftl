<#macro login path>
<#include "security.ftl">
<div>
    <form action="${path}" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Логин :</label>
            <div class="col-sm-6">
                <input type="text" id="username" name="username"  class="form-control
             ${(usernameError??)?string('is-invalid','')}"
                       placeholder="Введите логин"/>
                <#if usernameError??>
                <div class="invalid-feedback">
                    ${usernameError}
                </div>
            </#if>
        </div>
</div>
<div class="form-group row">
    <label  class="col-sm-2 col-form-label"> Пароль : </label>
    <div class="col-sm-6">
        <input type="password" name="password" class="form-control
             ${(passwordError??)?string('is-invalid','')}"
               placeholder="Введите пароль"/>
        <#if passwordError??>
        <div class="invalid-feedback">
            ${passwordError}
        </div>
    </#if>
</div>
</div>
<#if path=="/registration">
<div class="form-group row">
    <label  class="col-sm-2 col-form-label"> Повторите пароль : </label>
    <div class="col-sm-6">
        <input type="password" name="password2" class="form-control
             ${(password2Error??)?string('is-invalid','')}"
               placeholder="Повторите пароль"/>
        <#if password2Error??>
        <div class="invalid-feedback">
            ${password2Error}
        </div>
    </#if>
</div>
</div>



</#if>



<input type="hidden" name="_csrf" value="${_csrf.token}"/>

<#if path=="/registration">

<div>
    <button class="btn btn-outline-primary btn-lg mb-2" type="submit">Регистрация</button>
</div>
<#else>
<div><button class="btn btn-outline-primary btn-lg mb-2" type="submit">Вход</button></div>

</#if>

</form>
</div>
</#macro>
<#macro logout>
<div>
    <form action="/logout" method="post">
        <button class="btn btn-outline-primary" type="submit">Выход</button>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    </form>
</div>
</#macro>