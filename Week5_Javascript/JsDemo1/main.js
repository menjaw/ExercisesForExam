/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//var f = function () {
//    console.log("Tester om installationen virker");
//};
//f();

//variabel
var name = {firstname: "Hans", lastname: "Hansen"};
//print
console.log(name.firstname, name.lastname);


//function
function nameFactory(){
    return {firstname: "Thor", lastname: "Nielsen"}
}
//variable
var n = nameFactory();
n.phone = "4379287384";
//print
console.log(n.firstname, n.lastname, n.phone);

//another demo NOT WORKING CORRECTLY
var names = ["Therese", "Hanne", "Trine", "Sofie", "Tove"];
names.company = "SIT";
console.log(names);

//Delete the firstname
var n = nameFactory();
delete n.firstname;
console.log(n);
