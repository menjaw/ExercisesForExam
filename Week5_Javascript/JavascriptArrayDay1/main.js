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
console.log(all.push("Lone", "Gitte"));
console.log(all + "\n");

console.log("Tilføjer to navne i starten af arrayet:");
console.log(all.unshift("Hans", "Kurt"));
console.log(all + "\n");

//Create a comma seperated(,) string with all the names from above
var commaNames = all.join();
console.log("STRING - SEPEREATE NAMES BY COMMA:");
console.log(commaNames + "\n");

//Create a comma hyphen(-) string with all the names from above
var hyphenNames = all.join(" - ");
console.log("STRING - SEPEREATE NAMES BY HYPHEN:");
console.log(hyphenNames + "\n");


//Remove the first name in the array
var removeFirstElement = all.shift();
console.log("Removes the first element in array");
console.log("Removed: " + removeFirstElement);
console.log(all + "\n");

//Remove the last name from the array
var removeLastElement = all.pop();
console.log("Removes the last element in array");
console.log("Removed: " + removeLastElement);
console.log(all + "\n");

//Remove existing elements
var removeElement = all.splice(3, 2);
console.log("Removes an element in array");
console.log("Removed: " + removeElement);
console.log(all + "\n");

//Reverse the elements in array
var reverseElements = all.reverse();
console.log("Reverse the elements in array");
console.log(reverseElements + "\n");

//Sort the array
var sortArray = all.sort(function (name1, name2) {
    return name1.toUpperCase().localeCompare(name2.toUpperCase());
});
console.log("Sort the elements in the array");
console.log(sortArray + "\n");

//Convert all the names to UpperCase
var upperCaseArray = all.map(function (arr) {
    return arr.toUpperCase();
});
console.log("Convert elements to uppercase in array");
console.log(upperCaseArray + "\n");

//Create new array containing names starting with I eller L
var filterCallbackArray = all.filter(function (arr) {
    if (arr === "I" || arr === "L") {
        return ;
    }
});
console.log("Create new array containing names starting with I eller L");
console.log(filterCallbackArray + "\n");


