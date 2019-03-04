
const equality=readline().split(/[+=]/);


for(let i =2;i<37;i++){
    let X = converter(equality[0], i);
    let Y = converter(equality[1], i);
    let Z = converter(equality[2], i);
    if (X !== null && Y !== null && Z !== null && X+Y===Z) {
        print(i);
        break;
    }
}

function converter(strArr,base){
    let Dic ="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    let res=0;
    for(let i=0;i<strArr.length;i++){
        let digitVal=Dic.indexOf(strArr[i]);
        if(digitVal>=base){
            return null;
        }
        res+=(digitVal)*Math.pow(base,strArr.length-(i+1));
    }
    return res;
}