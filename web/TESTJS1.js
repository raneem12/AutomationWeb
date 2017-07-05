
var y = -1;

$(document).ready(function () {
    hide();
    insRow();
});

function raneem(obj) {
    var x = $(obj).val();
    switch (x) {
        case 'getText':
            $('#'+obj.dataset.id).hide();
            break;
    }
}

function hide(){
    $('.hide').hide();
}

function insRow() {
    y++;
    var x = document.getElementById('tab_logic');

    var new_row = x.rows[0].cloneNode(true);

    new_row.classList.remove("hide");
    new_row.style.display = "table-row";

    //var inp1 = new_row.cells[0].getElementsByTagName('input')[0];

    var inp3 = new_row.cells[0].getElementsByTagName('select')[0];
    inp3.dataset.id = "value"+y;

    inp3.name = 'action' + y;

    var inp2 = new_row.cells[1].getElementsByTagName('input')[0];
    new_row.cells[1].id = 'value' + y;
    inp2.name = 'value' + y;

    var inp4 = new_row.cells[2].getElementsByTagName('input')[0];
    inp4.name = 'id' + y;
    var inp5 = new_row.cells[3].getElementsByTagName('select')[0];
    inp5.name = 'type' + y;


    var inp6 = new_row.cells[4].getElementsByTagName('input')[0];
    inp6.name = 'name' + y;

    inp2.value = "";
    inp3.value = "";
    inp4.value = "";
    inp5.value = "";
    inp6.value = "";
    x.appendChild(new_row);
}


function insRow1() {
    var xy = 0;
    console.log('hi');

    var x = document.getElementById('tab_logic');

    var new_row = x.rows[0].cloneNode(true);

    var inp2 = new_row.cells[1].getElementsByTagName('input')[0];
    inp2.name = 'value' + xy;

    var inp4 = new_row.cells[2].getElementsByTagName('input')[0];
    inp4.name = 'id' + xy;
    var inp5 = new_row.cells[3].getElementsByTagName('input')[0];
    inp5.name = 'idd' + xy;


    var inp6 = new_row.cells[4].getElementsByTagName('input')[0];
    inp6.name = 'idd' + xy;

    xy++;
    x.appendChild(new_row);
}
