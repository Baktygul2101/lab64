'use strict';
window.addEventListener('load', function () {

    const saveButton = document.getElementById("save-task");
    saveButton.addEventListener("click", function() {
        const taskForm = document.getElementById("form");
        let data = new FormData(taskForm);

        fetch("http://localhost:4040/task", {
            method: 'POST',
            body: data
        }).then(r => r.json()).then(data => {window.location.href = "http://localhost:4040/"});
    });

});

//
var taskList = document.getElementsByTagName("LI");
var i;
for (i = 0; i < taskList.length; i++) {
    var span = document.createElement("SPAN");
    var txt = document.createTextNode("\u00D7");
    span.className = "close";
    span.appendChild(txt);
    taskList[i].appendChild(span);
}

// кнопка закрытия
var close = document.getElementsByClassName("close");
var i;
for (i = 0; i < close.length; i++) {
    close[i].ondbclick = function () {
        var div = this.parentElement;
        div.style.display = "none";
    }
}
//чтобы бы подчеркнуть
const doubleClick = document.querySelector('ul');
doubleClick.addEventListener('click', function (ev) {
    if (ev.target.tagName === 'LI') {
        ev.target.classList.toggle('checked');
    }
}, false);
