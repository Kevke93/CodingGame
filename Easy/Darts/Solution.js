
const SIZE = parseInt( readline() );
const N = parseInt( readline() );
let playerArr=[ N ];

for (let i = 0 ; i < N ; i++) {
    playerArr[i] = new Player( readline() , i );
}

const T = parseInt( readline() );
for (let i = 0; i < T; i++) {
    const [name , x ,y ] = readline().split(" ");

    for ( let j = 0; j < N; j++ ) {
        if ( playerArr[j].name === name ) {
            playerArr[ j ].addScore( Math.abs( x ) ,Math.abs( y ) );
            break;
        }
    }
    playerArr.sort( function ( p1, p2 ) {
        if( p1.score < p2.score ){
            return 1;}
        else if(p1.score > p2.score){
            return 0;
        }

        if( p1.prio > p2.prio ) return 1;
        else return 0;
    });
}

for ( let i = 0; i < N; i++ )  {
    print ( playerArr[i].name + " "+ playerArr[i].score );
}

/*-------------------------------------------------------------------------------------------------*/
function Player( name,i ){
    this.name=name;
    this.score = 0;
    this.prio = i;

    this.addScore = function ( x, y ){

        if(insideDiamont ( x , y )){
            this.score += 15;
        }
        else if( insideCycle( x , y ) ){
            this.score += 10;
        }
        else if( insideSquare( x, y ) ){
            this.score +=5;
        }
    };
}
function insideDiamont(x , y){
    return ( SIZE/2  - x >= y );
}
function insideCycle( x , y ) {
    return (Math.pow( x**2 + y**2 , 0.5 )<= SIZE/2 );
}
function insideSquare(x , y) {
    return ( x <= SIZE/2 && y <= SIZE/2 );
}