
var y = 0;

$(document).ready(function () {
/*
    $('#mid' + y).on("change", function (e) {
        debugger;
        var val = $(this).val()
        switch (val) {
            case 'getText':
                $('#value0').hide();
            case 'navigate' :
                $('#value0').show();
        }
    });*/
});

function raneem() {
    var x = document.getElementById('mid'+y);
    switch (x.value) {
        case 'getText':
            $('#id' +y).show();
            $('#value' +y).hide();
            $('#name' +y).show();
            $('#type' +y).hide();
            break;
        case 'navigate' :
            $('#value' +y).show();
            $('#name' +y).hide();
            $('#type' +y).hide();
            $('#id' +y).hide();

            break;

    }
}
function insTestCase() {
    var x = document.getElementById('hidden_div');
    var new_row = x.rows[0].cloneNode(true);
    x.appendChild(new_row);

}



function insRow() {
    y++;
    console.log('hi');
    var x = document.getElementById('tab_logic');

    var new_row = x.rows[0].cloneNode(true);


    var inp3 = new_row.cells[0].getElementsByTagName('select')[0];
    inp3.id= 'mid' + y
    inp3.name = 'action' + y;

    var inp2 = new_row.cells[1].getElementsByTagName('input')[0];
    inp2.name = 'value' + y;
    inp2.id = 'value' + y;


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


