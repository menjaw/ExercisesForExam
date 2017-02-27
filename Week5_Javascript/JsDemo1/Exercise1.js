/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*Function Declaration*/
//Observe: No return type, no type on parameters
function add(n1, n2) {
    return n1 + n2;
}

var sub = function (n1, n2) {
    return n1 - n2;
};

var cb = function (n1, n2, callback) {
    if (!(typeof n1 === "number" && typeof n2 === "number" && typeof callback === "function")) {
        //return null;

        //error er et indbygget objekt
        throw Error("Illegal arguments in call to function");
    }
    return "Result: " + n1 + "+" + n2 + "=" + callback(n1, n2);
};


try {
    console.log(cb(3, 3, add));
    console.log(cb(3, 3, sub));
//anonym funktion
    console.log(cb(5, 5, function (n1, n2) {
        return n1 * n2;
    }));
    //Fanger fejlen som kan opstå
} catch (err) {
    console.log("Error: " + err.message);
}
