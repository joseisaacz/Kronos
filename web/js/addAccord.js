/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//this fuction adds into an array the parameters of the url 
function getUrlVars() {
    var vars = {};
    var flag = false;
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function (m, key, value) {
        vars[key] = value;
        flag = true;
    });
    if (!flag)
        return null;

    return vars;
}

document.addEventListener("DOMContentLoaded", function () {
    console.log("HOLA");
    var number = getUrlVars();
    if (number !== null) {
        var accnumber = number.accnumber;
        if (accnumber !== 'undefined') {
            let _url = "api/accord/getaccord/" + accnumber;

            fetch(_url)
                    .then(res =>
                        res.json()
                    )
                    .then(accord => {
                        editAccord(accord);
                    })
                    .catch(error => {
                        console.log(error);
                    });

        }
    } else {
        console.log("ES NULL");
    }
});



//This function validates if a given date is weekend or holyday
function isValidDate(date) {
    console.log(deadline);
    console.log(date);
    date_aux = date.replace(/-/g, '\/');
    let fecha = new Date(date_aux);
    //if day is saturday or sunday
    if (fecha.getDay() === 0 || fecha.getDay() === 6) {
        return false;

    }

    //array with all the posible holidays of the year excluding easter
    let holiday = ['01-01', '04-11', '05-01', '07-25', '08-02', '08-15', '09-15', '10-12', '12-25'];

    for (let i = 0; i < holiday.length; i++) {
        let aux = '' + fecha.getFullYear + '-' + holiday[i];
        if (date === aux)
            return false;
    }

    if (fecha.getMonth() === 2 || fecha.getMonth() === 3) {
        let URL = "https://www.googleapis.com/calendar/v3/calendars/" +
                "es.cr%23holiday%40group.v.calendar.google.com/events?key=AIzaSyAJuTl"
                + "-gxVHcY80RvGL8T9fzY8sgfwU8Xw";
        var result = true;
        $.getJSON(URL).then(data => {
            data.items.forEach(item => {
                //if the day is eastern   
                if (item.summary === 'Jueves Santo' || item.summary === 'Viernes Santo') {
                    if (date === item.start.date) {
                        result = false;
                        return false;
                    }

                }
            })

            return result;
        });

    }
    return true;
}

/*
 * -------------------------------------------------------------------------------------
 * 
 **/
var states = null;
var types = null;


//this function initialize all functions of formulary
function init() {
    fullComboStay();


}
function initData1(newData) {
    stays = newData;

}

//this funtion upload the stay of accord on comboBox
function fullComboState()
{
    var comboState = document.getElementsByName("comboState");
    if (comboState) {
        comboState.options.length = 0;


        {
            var opc = document.createElement("OPTION");
            opc.setAttribute("value", "null");
            opc.setAttribute("selected", "selected");
            opc.appendChild(document.createTextNode("(Estado)"));
            refMenu.appendChild(opc);
        }

        for (var i = 0; i < states.length; i++) {
            var sta = comercios[i];

            var opc = document.createElement("OPTION");
            opc.setAttribute("value", sta.id + " " + sta.description);
            opc.appendChild(document.createTextNode(local.ciudad + " " + local.direccion));
            refMenu.appendChild(opc);

        }

    }
}

function changeComboType(combo) {
    let labelName = document.getElementById('labelName');
    let labelEmail = document.getElementById('labelEmail');
    let textName = document.getElementById('tempName');
    let textEmail = document.getElementById('tempEmail');
    if (combo !== 'A') {

        textName.value = '';
        textEmail.value = '';
        textName.type = 'text';
        textEmail.type = 'text';
        labelName.style.visibility = 'visible';
        labelEmail.style.visibility = 'visible';
    } else {
        textName.value = '';
        textEmail.value = '';
        textName.type = 'hidden';
        textEmail.type = 'hidden';
        labelName.style.visibility = 'hidden';
        labelEmail.style.visibility = 'hidden';
    }

}

function addAccord() {
    let deadline = document.getElementById('deadline');
    if (!isValidDate(deadline.value)) {
        alert ("La Fecha de Vencimiento no es válida");
        return;
    }

    let _url = '/Kronos/accord/addAccord';

    var form = document.getElementById('uploadForm');
    var data = new FormData(form);
    $.ajax({
        type: "POST",
        encType: "multipart/form-data",
        url: _url,
        cache: false,
        processData: false,
        contentType: false,
        data: data,
        success: function (msg) {
            var response = JSON.parse(msg);
            var status = response.status;
            if (status === 1) {
                alert("ACUERDO AGREGADO CORRECTAMENTE");
            } else {
                alert("OCURRIO UN ERROR");
            }
        },
        error: function (msg) {
            alert("OCURRIO UN ERROR");
        }
    });

}

function editAccord(accord){
       
                        document.getElementsByName("office")[0].value = accord.accNumber;
                        document.getElementsByName("incorporatedDate")[0].value = accord.incorporatedDate;
                        document.getElementsByName("deadline")[0].value = accord.deadline;
                        document.getElementsByName("observations")[0].value = accord.observations;

}

/*
 * 
 * get the pdf and display it in a new browser tab
 * 
 *             function prueba(){
               let path='/home/jonathan/uploads/docu.pdf';
                let _url='api/accord/getfile?filepath='+path;
                console.log(_url);
               fetch(_url)
    .then(response => response.blob())
   .then(data => window.open(URL.createObjectURL(data)));
       }
 * 
 * 
 */