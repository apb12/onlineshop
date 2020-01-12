<#import "parts/common.ftl" as c>
<#import "parts/log.ftl" as l>
<@c.page>
<script src="http://code.jquery.com/jquery-2.2.4.js"
        type="text/javascript"></script>


<div align="center">

    <#if message??> <b>${message}</b></#if>

</div>
<@l.login "/registration" />
</@c.page>