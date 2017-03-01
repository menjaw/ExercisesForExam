/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function Car(make, model, year){
    this.make = make;
    this.model = model;
    this.year = year;
}

var car1 = Car("Volvo", "V65", 1998);
var car2 = Car("Volvo", "S54", 2003);

//console.log(car1.year);
//console.log(car2.year);
//console.log(car2);
console.log(make + year + model);


