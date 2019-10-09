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
    } 
    setTypeOptions();
});



//This function validates if a given date is weekend or holiday
function isValidDate(date) {
    let fecha = date;

    //array with all the posible holidays of the year excluding easter
    let holiday = [
        '01-01', // New year 
        '04-11', // Rivas battle
        '05-01', // Labor day
        '07-25', // Annexation of Guanacaste
        '08-02', // Our Lady of Los Ángeles
        '08-15', // Mother's day
        '09-15', // Independance's day
        '10-12', // Day of the Cultures
        '12-25'  // Christmas Day
    ];

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
    let textName = document.getElementById('username');
    let textEmail = document.getElementById('email');
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
        alert("La Fecha de Vencimiento no es válida");
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

function editAccord(accord) {

    document.getElementsByName("office")[0].value = accord.accNumber;
    document.getElementsByName("incorporatedDate")[0].value = accord.incorporatedDate;
    document.getElementsByName("deadline")[0].value = accord.deadline;
    document.getElementsByName("observations")[0].value = accord.observations;

}


//-----------DRAG AND DROP---------
+function ($) {
    'use strict';

    // UPLOAD CLASS DEFINITION
    // ======================

    var dropZone = document.getElementById('drop-zone');
    var uploadForm = document.getElementById('js-upload-form');

    var startUpload = function (files) {
        console.log(files)
    }

    uploadForm.addEventListener('submit', function (e) {
        var uploadFiles = document.getElementById('js-upload-files').files;
        e.preventDefault()

        startUpload(uploadFiles)
    })

    dropZone.ondrop = function (e) {
        e.preventDefault();
        this.className = 'upload-drop-zone';

        startUpload(e.dataTransfer.files)
    }

    dropZone.ondragover = function () {
        this.className = 'upload-drop-zone drop';
        return false;
    }

    dropZone.ondragleave = function () {
        this.className = 'upload-drop-zone';
        return false;
    }

}(jQuery);

function editAccord(accord) {

    document.getElementsByName("office")[0].value = accord.accNumber;
    document.getElementsByName("incorporatedDate")[0].value = accord.incorporatedDate;
    document.getElementsByName("deadline")[0].value = accord.deadline;
    document.getElementsByName("observations")[0].value = accord.observations;

}



//it adds an amount of days the the date
//even if it has to change the month or the year
function addDays (days, date) {

  var result = new Date(date);
  result.setDate(result.getDate() + days);
  return result;
}


//this function gets the deadline date counting the weekends and the holidays
function getDeadline_NaturalDays() {

    let incorporatedDate = document.getElementById('incorporatedDate').value;
    let date_aux = incorporatedDate.replace(/-/g, '\/');
    let days = parseInt(document.getElementById('days').value,10);
    let toDate= new Date(date_aux);
    
    //adding the days to the date
    let date = addDays(days, toDate);

    //if the resulting date is a weekend
    if (date.getDay() === 6 || date.getDay() === 0) {
        date = fixWeekend(date);
    }
    
    // if the resulting date is not a holiday
    //then return it
    //else just add one day to the resulting date 
    //until isnt a holiday or a weekend
    if (isValidDate(date)) {
        return date;
    } else {

        for (; ; ) {
            date = addDays(1, date);
            if (date.getDay() === 6 || date.getDay() === 0) {
                date = fixWeekend(date);
            }
            if (isValidDate(date))
                return date;
        }

    }

}

//this function gets the deadline without counting the weekends
// or the holidays
function getDeadline_BussinessDays(){
     let incorporatedDate = document.getElementById('incorporatedDate').value;
    let date_aux = incorporatedDate.replace(/-/g, '\/');
    let days = parseInt(document.getElementById('days').value,10);
    let date= new Date(date_aux);
    //counting the current day
    let aux=1;
    
    for(; ;){
        // if the counting is equal to the amount of days selected
        if(aux===days){
            //if isnt a holiday or a weekend return the current date
            if(date.getDay() !== 0 && date.getDay() !== 6 && isValidaDate(date)){
                return date;
            }
            else{
                
                //if the resulting date is a weekend, fix it
                if(date.getDay()===0 || date.getDay()===6){
                    date=fixWeekend(date); 
                }
                   
                else{
                    //add one day to the resulting date to avoid the holiday
                    date=addDays(1,date);
                }
                for(;;){
                    //return the resulting date if isnt a weekend or a holiday
                    if(date.getDay() !== 0 && date.getDay() !== 6 && isValidaDate(date))
                        return date;
                    else
                        date=addDays(1,date);
                    //else just keep adding one day to the resulting date until isnt a 
                    //holiday or a weekend
                }
            }
        }
            
        // it only counts when isnt weekend or holiday
        if(date.getDay() !== 0 && date.getDay() !== 6 && isValidaDate(date))
             aux++;
        
        //adds one day to the date
        date=addDays(1,date);
    }
    
    
}


//this function adds 1 day to the date if the day is sunday 
//and 2 days if the day is saturday 
function fixWeekend(date) {
    if (date.getDay() === 6)
        return addDays(2,date);
    else
        return addDays(1,date);


}

function setTypeOptions(){
    let select= document.getElementById('comboTypes');
    let url="api/type/getall";
     fetch(url)
     .then(response => response.json() )
     .then(data=>{
     data.forEach(item=>{
       var opt = document.createElement('option'); 
         opt.value = item.id;
         opt.innerHTML = item.description;
         select.appendChild(opt);
     });
 }).catch(error => console.log(error));
    
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