/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

const n = parseInt(readline());
let matrix = new Array(n);
let square=true;
for (let i = 0; i < n; i++) {
    matrix[i] = new Array(n);
}

for (let i = 0; i < n; i++) {
    var inputs = readline().split(' ');
    if(inputs.length!=n)
    {square=false;
        }
    for (let j = 0; j < n; j++) {
        matrix[i][j] = parseInt(inputs[j]);

    }
}
let magicNumber=calcPosMagicNumber();



if(noDublicates() && checkSum() && square){
    print("MAGIC");
}
else print("MUGGLE");



function noDublicates() {
    let listOfNumbers=[];

    for( let i = 0 ; i < n ; i++ ){
        for( let j = 0; j < n ; j++ ){
            let num = matrix[i][j];
        
            if(listOfNumbers.includes(num) || num<=0){
              
                return false;
            }
            listOfNumbers.push(num);
        }
    }
    for(let i =1;i<=n**2;i++){

        if(!listOfNumbers.includes(i)){
            
            return false;
        }
    }
    return true;
}

function checkSum() {
    for( let i = 0 ; i < n ; i++){
        let rowSum=0;
        for( let j = 0 ; j < n ; j++){
            rowSum+=matrix[i][j];
        }
        if(rowSum!=magicNumber){
            return false;
        }
    }

    for( let i = 0 ; i < n ; i++){
        let collumnSum=0;
        for( let j = 0 ; j < n ; j++){
            collumnSum+=matrix[j][i];
        }
        if(collumnSum!=magicNumber){
            return false;
        }
    }



    /* Diagonal Left*/
    let diagonalSum=0;
    for (let i = 0 ; i < n ; i++ ){
        diagonalSum += matrix [i][i];
    }

    if(diagonalSum!=magicNumber){
        return false;
    }

    /* Diagonal Right*/
    diagonalSum=0;
    for (let i = 0 ; i < n ; i++ ){
        diagonalSum += matrix [i][n-1-i];
    }

    if(diagonalSum!=magicNumber){
        return false;
    }

    return true;
}
function calcPosMagicNumber () {
    let numb=0;

    for (let i = 0 ; i < n ; i++ ){
        numb+=matrix[0][i];
    }
    return numb;

}