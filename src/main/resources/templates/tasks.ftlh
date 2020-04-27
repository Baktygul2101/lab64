<!DOCTYPE html>
<html lang="en">

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>

<div id="myDIV" class="header">
    <h2 style="margin:5px">Список дел</h2>
    <form id="form" name="form" enctype="multipart/form-data" action="/task" method="post" onsubmit="if (this.title.value == 'Писать тут!') { alert('Ничего не введено'); return false; }">
        <input type="text" placeholder="введите задание" name="title" id="name" required autofocus value="Писать тут!" onblur="if(this.value=='');" onfocus="if(this.value=='Писать тут!') this.value='';">
        <button type="button" id="save-task" class="addBtn">Save</button>
    </form>
</div>



<ul id="myUL">
    <#list tasks as task>
     <li> <p>${task.title}</p>
         <input name="candidateId" type="hidden" value="${task.id}"></li>
    </#list>
</ul>

</body>
<script src="/js/script.js"></script>
</html>