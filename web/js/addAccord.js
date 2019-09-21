/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
                        console.log(accord);
                        document.getElementsByName("office")[0].value = accord.accNumber;
                        document.getElementsByName("incorporatedDate")[0].value = accord.incorporatedDate;
                        document.getElementsByName("deadline")[0].value = accord.deadline;
                        document.getElementsByName("observations")[0].value = accord.observations;
                        
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


    let URL = "https://www.googleapis.com/calendar/v3/calendars/es.cr%23holiday%40group.v.calendar.google.com/events?key=AIzaSyAJuTl-gxVHcY80RvGL8T9fzY8sgfwU8Xw";
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

