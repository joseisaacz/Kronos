/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



// It changes the value of date field, text field and the combo box of the states
// depending of the option selected in the select
function changeSelect(value) {
    let field = document.getElementById('searchText');
    let button = document.getElementById('seacrhButton');
    let combo = document.getElementById('selectType');
    console.log(field);
    if (value === 'sessionDate' || value === 'incorDate') {
        field.type = 'date';
        field.value = "";
        button.style.visibility = 'visible';
        combo.value = 'A';
        combo.style.visibility = 'hidden';
        combo.value = 'A';

    } else
    if (value === 'accNumber') {
        field.value = "";
        field.type = 'text';
        button.style.visibility = 'visible';
        combo.value = 'A';
        combo.style.visibility = 'hidden';
    } else if (value === 'sessionType') {
        field.value = "";
        field.type = 'hidden';
        button.style.visibility = 'visible';
        combo.value = 'A';
        combo.style.visibility = 'visible';
    } else if (value === 'allAccords') {
        field.value = "";
        field.type = 'hidden';
        button.style.visibility = 'visible';
        combo.value = 'A';
        combo.style.visibility = 'hidden';
    } else if (value === 'expiredAccords') {
        field.value = "";
        field.type = 'hidden';
        button.style.visibility = 'visible';
        combo.value = 'A';
        combo.style.visibility = 'hidden';
    } else {
        field.value = "";
        combo.value = 'A';
        field.type = 'hidden';
        button.style.visibility = 'hidden';
        combo.style.visibility = 'hidden';
    }



}

document.addEventListener("DOMContentLoaded", function () {
    setTypeOptions();
    initTable();
});


function setTypeOptions() {
    let select = document.getElementById('selectType');
    let url = "api/type/getall";
    fetch(url)
            .then(response => response.json())
            .then(data => {
                data.forEach(item => {
                    var opt = document.createElement('option');
                    opt.value = item.id;
                    opt.innerHTML = item.description;
                    select.appendChild(opt);
                });
                select.value = 'A';
                console.log(select.value);
                console.log(select);
            }).catch(error => console.log(error));

}


//document.addEventListener("DOMContentLoaded", function () {
//    document.getElementById('seacrhButton').style.visibility = 'hidden';
//});

// list the values of the accord and append it to the table body.
var accCounter = 0;
function list(parent, accord) {
    let now = new Date();
    console.log(now);
    let date = new Date(accord.deadline);

    var tr = $("<tr/>");
    tr.html(
            "<td>" + accord.accNumber + "</td>"
            + "<td>" + accord.incorporatedDate + "</td>"
            + "<td>" + accord.sessionDate + "</td>"
            + "<td>" + accord.deadline + "</td>"
            + "<td>" + typeToString(accord.type) + "</td>"
            + "<td id=\"stateTD" + accCounter + "\">" + stateToString(accord.state) + "</td>"
            + "<td>" + "<button type=\"button\" style='text-align: center' class=\"bnt btn-primary\" onclick=\"location.href='addAccord.jsp?accnumber=" + accord.accNumber + "'\">"
            + "<i class=\"fas fa-edit\">" + "</i>" + "</button>" + "</td>"
            );
    parent.append(tr);
    let state = 'stateTD' + accCounter;
    if (now > date)
        tr.css('backgroundColor', 'rgb(242, 110, 110)');
    else
    if (parseInt(accord.state, 10) === 0)
        document.getElementById(state).style.backgroundColor = '#00D781';

    else
    if (parseInt(accord.state, 10) === 1)
        document.getElementById(state).style.color = 'red';

    else if (parseInt(accord.state, 10) === 2)
        document.getElementById(state).style.backgroundColor = '#FFE57A';




    accCounter++;

}

// it converts the int value of the state to the string description 
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
            return 'Administracion Municipal';
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
// api call to get accords by session Date
function SearchBySessionDate() {
    let sessiondate = document.getElementById('searchText').value;
    let _url = "api/accord/getaccord/sessiondate/" + sessiondate;

    fetch(_url)
            .then(res =>
                res.json()
            )
            .then(accords => {
                $('#tableAcc').DataTable().clear().destroy();
                var parent = $("#accordList");
                parent.html("");
                accords.forEach(item => {
                    list(parent, item);
                });

            })
            .then(() => {
                initTable();
            })
            .catch(error => {
                console.log(error);
            });
}

// api call to ge accords by session type
function searchBySessionType() {
    let type = document.getElementById('selectType').value;
    let _url = "api/accord/getaccord/type/" + type;

    fetch(_url)
            .then(res =>
                res.json()
            )
            .then(accords => {
                $('#tableAcc').DataTable().clear().destroy();
                var parent = $("#accordList");
                parent.html("");
                accords.forEach(item => {
                    list(parent, item);
                });

            })
            .then(() => {
                initTable();
            })
            .catch(error => {
                console.log(error);
            });
}
// api call to get accords by incorporated date
function searchByIncorDate() {

    let incordate = document.getElementById('searchText').value;
    let _url = "api/accord/getaccord/incordate/" + incordate;

    fetch(_url)
            .then(res =>
                res.json()
            )
            .then(accords => {
                $('#tableAcc').DataTable().clear().destroy();
                var parent = $("#accordList");
                parent.html("");
                accords.forEach(item => {
                    list(parent, item);
                });

            }).then(() => {
        initTable();
    })
            .catch(error => {
                console.log(error);
            });
}

// api call to get accords by accordNumber
function searchByAccNumber() {
    let accnumber = document.getElementById('searchText').value;
    let _url = "api/accord/search/getaccord/" + accnumber;
 

    fetch(_url)
            .then(res =>
                res.json()
            )
            .then(accords => {
                console.log(accords);
                $('#tableAcc').DataTable().clear().destroy();
                var parent = $("#accordList");
                parent.html("");
                accords.forEach(item => {
                    list(parent, item);
                });

            }).then(() => {
        initTable();
    })
            .catch(error => {
                console.log(error);
            });
}
// api call to get all accords
function searchAllAccords() {
    let _url = "api/accord/getaccord/all";
    fetch(_url)
            .then(res => {
                console.log(res);
                return res.json();
            })
            .then(accords => {
                $('#tableAcc').DataTable().clear().destroy();
                var parent = $("#accordList");
                parent.html("");
                accords.forEach(item => {
                    list(parent, item);
                });
            }).then(() => {

        initTable();
    })

            .catch(error => {
                console.log(error);
            });
}

function searchExpiredAccords() {

    let _url = 'api/accord/getaccord/allExpired';
    fetch(_url)
            .then(res => {
                console.log(res);
                return res.json();
            })
            .then(accords => {
                $('#tableAcc').DataTable().clear().destroy();
                var parent = $("#accordList");
                parent.html("");
                accords.forEach(item => {
                    list(parent, item);
                });
            }).then(() => {

        initTable();
    })

            .catch(error => {
                console.log(error);
            });
}
// button function depending of the option selected in the main combo box
function searchAccord() {
    let parameter = document.getElementById('serchType').value;
    if (parameter !== 'notSelected') {
        switch (parameter) {
            case 'sessionDate':
                SearchBySessionDate();
                break;

            case 'incorDate':
                searchByIncorDate();
                break;


            case 'sessionType':
                searchBySessionType();
                break;

            case 'accNumber':
                searchByAccNumber();
                break;

            case 'allAccords':
                searchAllAccords();
                break;

            case 'expiredAccords':
                searchExpiredAccords();
                break;
        }
    }
}



function initTable() {
    $('#tableAcc').DataTable({
        "language": {
            "lengthMenu": "Mostrar _MENU_ Acuerdos",
            "zeroRecords": "No se encontraron resultados",
            "info": "Mostrando Acuerdos del _START_ al _END_ de un total de _TOTAL_ registros",
            "infoEmpty": "Mostrando Acuerdos del 0 al 0 de un total de 0 registros",
            "infoFiltered": "(filtrado de un total de _MAX_ Acuerdos)",
            "sSearch": "Filtrar:",
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

function searchAccordsByExpiredMonth() {
    let _url = "api/accord/getaccord/expiredtoday";
    fetch(_url)
            .then(res =>
                res.json()
            )
            .then(accords => {
                var parent = $("#accordList");
                parent.html("");
                accords.forEach(item => {
                    list(parent, item);
                });

            }).then(() => {
        $("#tableAcc").destroy();
        $("#tableAccNotify").DataTable().destroy();
        initTable();
    })
            .catch(error => {
                console.log(error);
            });
}

