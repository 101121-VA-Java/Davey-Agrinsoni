// Problem 1: Create a function "isWeekday" which takes a single argument and returns true if the argument is a day during the work week. It should return false if it is not.

function isWeekday(input) {
    if (input == 'Saturday' || input == 'Sunday'){
        return false;
    }
    return true;
    //Debatably need input validation to see if someone enters something else.
}

// Problem 2: Create a function "isEven" which takes a single argument and returns true if the argument is an even integer. It should return false if it is not

function isEven(input) {
    if(input % 2 == 0){
        return true;
    }
    return false;
}

// Problem 3: Write a JavaScript function which takes a single argument and returns the type

function findType(input) {

    return typeof input;
}

// Problem 4: Write a JavaScript function which takes a single argument and determines if it's prime. If it is, return true. If it's not return false.

function isPrime(input) {
    let i = input / 2;
    let b = true;
    if( input <= 1){
        return b = false;
    }
    for (let j = 2; j <= i; j++){
        if(input % j == 0){
            b = false;
        }
        else{
            b = true;
        }
    }
    return b;
}

// Problem 5: Write a JavaScript function which calculates the first number to the power of the second number. Do not do this recursively. Do not use the Math library.

function calculateExponent(base, exponent) {
    let result = base;
    if (exponent == 0){
        result = 1;
    } 
    for(let i = 1; i < exponent; i++){
        result *= base;
    }
    return result;
}
