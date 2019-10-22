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
//document.addEventListener("DOMContentLoaded", function () {
//    var number = getUrlVars();
//    if (number !== null) {
//        var accnumber = number.accnumber;
//        if (accnumber !== 'undefined') {
//            let _url = "api/accord/getaccord/" + accnumber;
//
//            fetch(_url)
//                    .then(res =>
//                        res.json()
//                    )
//                    .then(accord => {
//                        editAccord(accord);
//                    })
//                    .catch(error => {
//                        console.log(error);
//                    });
//
//        }
//    } 
////    setTypeOptions();
//});