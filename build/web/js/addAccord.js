/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//This function validates if a given date is weekend or holyday
function isValidDate(date){
    date_aux=date.replace(/-/g, '\/'); 

function isValidDate(date){
    date_aux=date.replace(/-/g, '\/'); //change every '-' to '/'. This is because the Date
    //object of javascript has a non UTC default time-zone. Ex. 2019-25-25 => 2019/25/25
    let fecha=new Date(date_aux);
    //if day is saturday or sunday
    if(fecha.getDay()===0 || fecha.getDay()===6){
        return false;
        
    }

    //array with all the posible holidays of the year excluding easter
    let holiday =['01-01','04-11','05-01','07-25','08-02','08-15','09-15','10-12','12-25'];

    for(let i=0; i<holiday.length; i++){

        let aux=''+fecha.getFullYear+'-'+holiday[i]; 
        let aux=''+fecha.getFullYear+'-'+holiday[i]; //append the year of the parameter to the posible holiday day and month. Ej 
        if(date===aux)
          return false;
    }

  
    /*
     If neither the day is on a weekend or the day is a possible holiday 
     It has to check if the date is on easter or not
    */

let URL="https://www.googleapis.com/calendar/v3/calendars/es.cr%23holiday%40group.v.calendar.google.com/events?key=AIzaSyAJuTl-gxVHcY80RvGL8T9fzY8sgfwU8Xw";
var result=true;
$.getJSON(URL).then(data=>{
  data.items.forEach(item=>{

   //if the day is eastern   
 if(item.summary==='Jueves Santo' || item.summary==='Viernes Santo' ){
     if(date===item.start.date){
      result=false;
     return false;
     }
     
 }
})

  return result;
});


}

