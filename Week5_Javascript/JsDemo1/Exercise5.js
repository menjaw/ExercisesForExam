/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var greeter = function () {
    console.log(this.message);
};

var comp1 = {message: "Hello World"};
var comp2 = {message: "FU the World"};

var g1 = greeter.bind(comp1);
var g2 = greeter.bind(comp2);

g1();
g2();