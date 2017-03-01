/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Creates 2 arrays with names: one for girls and one for boys
var boys = ["Peter", "lars", "Ole"];
var girls = ["Janne", "hanne", "Sanne"];

//print out the 2 arrays
console.log("Lægger de 2 arrays sammen:");
console.log(boys + girls + "\n");

/*console.log("\n" + "Tilføjer det ene array til det andet");
 console.log(boys.concat(girls));*/

//Create a new array called all
var all = boys.concat(girls);
console.log("Tilføjer det ene array til det andet:");
console.log(all + "\n");


console.log("Tilføjer to navne i enden af arrayet:");
console.log(all.push("Lone,Gitte"));
console.log(all + "\n");

console.log("Tilføjer to navne i starten af arrayet:");
console.log(all.unshift("Hans, Kurt"));
console.log(all + "\n");

//Create a comma seperated(,) string with all the names from above
var commaNames = all.join();
console.log("STRING - SEPEREATE NAMES BY COMMA:");
console.log(commaNames + "\n");

//Create a comma hyphen(-) string with all the names from above
var hyphenNames = all.join(" - ");
console.log("STRING - SEPEREATE NAMES BY HYPHEN:");
console.log(hyphenNames + "\n");





