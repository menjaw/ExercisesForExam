/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function Person(name) {
    this.name = name;
    var self = this;
    console.log("Name: " + this.name);

    setTimeout(function () {
        this.name = "Peter";
        console.log("Hi " + this.name);//explain
    }, 1500);

    setTimeout(function () {
        console.log("Hi " + self.name);//explain
    }, 1500);
}

var p = new Person("Kurt Hansen");//this calls the function
console.log("I'm gloab: " + p.name);//explain
