/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var divs = document.getElementsByTagName("div");
for (var i = 0; i < divs.length; i++) {
    divs[i].style.backgroundColor = "blue";
}

var btn = document.getElementById("btn");
btn.addEventListener("click", clickHandler);

function clickHandler(evt) {
    var divs = document.getElementsByTagName("div");
    divs[0].style.backgroundColor = "red";
    divs[1].style.backgroundColor = "yellow";
    divs[2].style.backgroundColor = "green";
}
