/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Declares an empty Array
var boyNames = ["Thor", "Hans", "Tim", "Sofus", "Torben"];
var girlNames = ["Therese", "Hanne", "Trine", "Sofie", "Tove"];


/*TO FORSKELLIGE MÅDER AT PRINTE ARRAYS*/
//Måde 1
for (var i = 0; i < boyNames.length; i++) {
    console.log(boyNames[i]);
}

//Måde 2 - tager en funktion og kalder 
girlNames.forEach(function (name) {
    console.log(name);
});

//printer bare
console.log("Hi");

//Bestem hvor længe der skal gå før denne printes ud
setTimeout(function () {
    console.log("Hallo");
}, 2000);


//Denne metode printer et array med navnenes længde
//boyNames = boyNames.map(function(boyNames){
//    return boyNames.length;
//});
//console.log(boyNames);

//Denne metode printer en liste med navnene
boyNames = boyNames.map(function (boyNames) {
    return "<li>" + boyNames + "</li>";
});
console.log(boyNames);

var lis = girlNames.join(" ");
console.log(lis);

//Filter
var filtered = boyNames.filter(function(boyNames){
    return boyNames[0] === "T";
});
console.log(filtered);