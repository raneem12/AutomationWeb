/**
 * Created by rzzayed on 7/2/17.
 */


// $(document).ready(function(){
//     var i=1;
//     $("#add_row").click(function(){
//         $('#addr'+i).html("<td>"+ (i+1) +"</td><td><input name='name"+i+"' type='text' placeholder='Name' class='form-control input-md'  /> </td><td><input  name='mail"+i+"' type='text' placeholder='Mail'  class='form-control input-md'></td><td><input  name='mobile"+i+"' type='text' placeholder='Mobile'  class='form-control input-md'></td>");
//
//         $('#tab_logic').append('<tr id="addr'+(i+1)+'"></tr>');
//         i++;
//     });
//     $("#delete_row").click(function(){
//         if(i>1){
//             $("#addr"+(i-1)).html('');
//             i--;
//         }
//     });
//
// });

var xy  = 0;


function insRow()
{
    console.log( 'hi');
    var x=document.getElementById('tab_logic');

    var new_row = x.rows[0].cloneNode(true);


    //var inp1 = new_row.cells[0].getElementsByTagName('input')[0];

    var inp3 = new_row.cells[0].getElementsByTagName('select')[0];

    inp3.name = 'action' + xy;

    var inp2 = new_row.cells[1].getElementsByTagName('input')[0];
    inp2.name = 'value' +xy;

    var inp4 = new_row.cells[2].getElementsByTagName('input')[0];
    inp4.name = 'id' +xy;
    var inp5 = new_row.cells[3].getElementsByTagName('input')[0];
    inp5.name = 'idd' +xy;


    var inp6 = new_row.cells[4].getElementsByTagName('input')[0];
    inp6.name = 'idd' +xy;

xy++;
    x.appendChild( new_row );
}