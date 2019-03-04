import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        String Dictionary[]=new String[N];
        for (int i = 0; i < N; i++) {
            Dictionary[i] = in.nextLine();
        }
        char Points1 []={'e','a','i','o','n','r','t','l','s','u'};
        char Points2[]={'d','g'};
        char Points3[]={'b','c','m','p'};
        char Points4[]={'f','h','v','w','y'};
        char Points5 []={'k'};
        char Points8[]={'j','x'};
        char Points10[]={'q','z'};
        
        char[] LETTERS = in.nextLine().toCharArray();
        System.err.println(new String(LETTERS));
        int MaxScore=0;
        String BestWord="";
        for (String check :Dictionary){
            
            char[]checkCH = check.toCharArray();
            char[]AvailabeLetters=new char[LETTERS.length];
            for(int i=0;i<LETTERS.length;i++){
                AvailabeLetters[i]=LETTERS[i];
            }
            
            boolean Available=false;
            for (char b:checkCH){
                Available=false;
                for(int i=0;i<AvailabeLetters.length;i++){
                    if (b==AvailabeLetters[i]){
                        Available=true; 
                        AvailabeLetters[i]=' ';
                        break;}
                    }
                    if (Available==false){break;
                        }
                    }
            int tempScore=0;
            
            if (Available==true){
                for (char b:checkCH){
                    for(char c:Points1){
                        if(b==c){tempScore++;break;}                                    
                    }
                     for(char c:Points2){
                        if(b==c){tempScore=tempScore+2;break;}                                    
                    }
                    for(char c:Points3){
                        if(b==c){tempScore=tempScore+3;break;}                                    
                    }
                    for(char c:Points4){
                        if(b==c){tempScore=tempScore+4;break;}                                    
                    }
                    for(char c:Points5){
                        if(b==c){tempScore=tempScore+5;break;}                                    
                    }
                    for(char c:Points8){
                        if(b==c){tempScore=tempScore+8;break;}                                    
                    }
                    for(char c:Points10){
                        if(b==c){tempScore=tempScore+10;break;}                                    
                    }
                }
                
                if (tempScore>MaxScore){MaxScore=tempScore;BestWord=check;}   
                }
                
                System.err.println(check+" "+Available+" "+tempScore+ " ");
                Available=false;
                
                
            }
            System.out.print(BestWord);
            
    }
}