/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function stateToString(state) {
    let stateInt = parseInt(state, 10);
    switch (stateInt) {
        case 0:
            return 'Cumplido';
        case 1:
            return 'Incumplido';
        case 2:
            return 'Pendiente';

        case 3:
            return 'Recibido';

        case 4:
            return 'Desestimado';

        default:
            return '';
    }
}

// converts the value of the given char type to the string description
function typeToString(type) {
    switch (type) {
        case 'A':
            return 'Administración Municipal';
        case 'B':
            return 'Auditoria Interna';
        case 'C':

            return 'Lic';

        case 'D':
            return 'Obras';

        case 'E':
            return 'Plan Regulador';

        case 'F':
            return 'Hacienda';

        case 'G':
            return 'Juridicos';

        case 'H':
            return 'Sociales';

        case 'I':
            return 'Ambiente';

        case 'J':
            return 'Varios';

        default:
            return '';


    }
}


function searchAccordsByExpiredMonth(){
        let _url = "api/accord/getaccord/expiredtoday";
    fetch(_url)
            .then(res => res.json() )
            .then(accords => {
                 $('#tableAcc').DataTable().clear().destroy();
                console.log(accords);
                var parent = $("#accordList");
                parent.html("");
                accords.forEach(item => {
                    list(parent, item);
                });
                console.log(document.getElementById('accordList'));
            }).then(()=>{
                 console.log(document.getElementById('accordList'));
                    initTable();
            })
            .catch(error => {
                console.log(error);
            });    
}


document.addEventListener("DOMContentLoaded", function () {
    searchAccordsByExpiredMonth();
});


function initTable() {
    $('#tableAcc').DataTable({
        "language": {
            "lengthMenu": "Mostrar _MENU_ Acuerdos",
            "zeroRecords": "No se encontraron resultados",
            "info": "Mostrando Acuerdos del _START_ al _END_ de un total de _TOTAL_ registros",
            "infoEmpty": "Mostrando Acuerdos del 0 al 0 de un total de 0 registros",
            "infoFiltered": "(filtrado de un total de _MAX_ Acuerdos)",
            "sSearch": "Buscar:",
            "oPaginate": {
                "sFirst": "Primero",
                "sLast": "Último",
                "sNext": "Siguiente",
                "sPrevious": "Anterior"
            },
            "sProcessing": "Procesando..."
        },
        "lengthChange": false,
         "destroy": true
    });
}

function list(parent, accord) {
    var tr = $("<tr/>");
    tr.html(
            "<td>" + accord.accNumber + "</td>"
            + "<td>" + accord.incorporatedDate + "</td>"
            + "<td>" + accord.sessionDate + "</td>"
            + "<td>" + accord.deadline + "</td>"
            + "<td>" + typeToString(accord.type) + "</td>"
            + "<td>" + stateToString(accord.state) + "</td>"
            + "<td>" + "<button type=\"button\" style='text-align: center' class=\"bnt btn-primary\" onclick=\"location.href='addAccord.jsp?accnumber=" + accord.accNumber + "'\">"
            + "<i class=\"fas fa-edit\">" + "</i>" + "</button>" + "</td>"
            );
    parent.append(tr);
    
}
