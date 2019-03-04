/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

/*-----------------------------------------------------------------------
Idea optimazied Brute Force Algorithmen
But there should be a better solution
 */
let N = parseInt(readline());

let digits=N.toString().split("");
let digitsum=digitSum(digits);
let solutionFound=false;

if ( hasToAddNumber ( digits )&& digits.length>1 ){
    // set everything 0 exprext of the first number
    for( let i =1 ; i<digits.length ; i++ ){
        digits[i] = 0;
    }
    do{
        if(digits[0] == 9){

            digits[0] = 0;
            digits.unshift(1);
        }
        else {
            digits[0]++;
        }
    }
    while( digitSum(digits)> digitsum )

    digits=checkIfDigitSumisStillBigger(digits,digitsum);
    N=+digits.join("");

    if( digitsum - digitSum(digits) == 0 ){
        solutionFound=true;
    }
}




while( true && !solutionFound ){
    
    N++;
    let digits=N.toString().split("");

    let currentDigits = 0;
    for( let i=0 ;i<digits.length ; i++ ){
        currentDigits +=+ digits[i];
    }
    if( currentDigits == digitsum ) {
        break;
    }
}

print(N);

/*---------------------------------------------------------------------------------------*/

function hasToAddNumber( digits ){
    for( let i = 0; i < digits.length-1 ; i++ ){
        if( digits[i] < digits[i+1] ){
            return false;
        }
    }
    return true;
}
function digitSum( digits ){
    let digitsum = 0 ;
    for(let i=0 ; i<digits.length ; i++){
        digitsum +=+ digits[i];
    }
    return digitsum;
}
function checkIfDigitSumisStillBigger( digits , digitsum ) {

    let insertPlace = digits.length-1;

    for ( let i = 9 ; i > 2 ; i-- ) {

        while ( digitsum - digitSum( digits ) >= i ) {
            digits[insertPlace] = i;
            insertPlace--;
        }
    }
    return digits;
}