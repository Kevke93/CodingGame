import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
	static MajaNumber majaDic[]= new MajaNumber[20];
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();
        System.err.println(L+ " "+ H);
        String numeral[]=new String[H];
        
        for (int i = 0; i < H; i++) {
            numeral[i] = in.next();
            System.err.println(numeral[i]);
        }
        String majaNumbers[][]= new String[20][H];
        for(int i=0;i<H;i++) {
        	for(int j=0;j<numeral[i].length()/L;j++) {
        		StringBuilder sb = new StringBuilder(numeral[i]);
        		majaNumbers[j][i]=sb.substring(j*L, j*L+L);
        	}
        }
        int numb=0;
        for(String s[]:majaNumbers) {
        	MajaNumber temp= new MajaNumber(s);
        	temp.setValue(numb);
        	majaDic[numb]=temp;
        	numb++;
        }
        int S1 = in.nextInt();
        System.err.println(S1);
        
        String[] numbMajaStart1=new String[S1];
        for (int i = 0; i < S1; i++) {
            numbMajaStart1[i]= in.next();
            System.err.println( numbMajaStart1[i]);
        }
        
        int S2 = in.nextInt();
        System.err.println(S2);
        String[] numbMajaStart2=new String[S2];
        for (int i = 0; i < S2; i++) {
        	numbMajaStart2[i]= in.next();       
        	System.err.println(numbMajaStart2[i]);
        }
        MajaNumber majaNumber1[]= transformIntoMajaNumbers(numbMajaStart1,H);
        MajaNumber majaNumber2[]= transformIntoMajaNumbers(numbMajaStart2,H);
        
        String operation = in.next();
        System.err.println(operation);
        
        long majaNumb1Long=transformMajaNumberToLong(majaNumber1);
        long majaNumb2Long=transformMajaNumberToLong(majaNumber2);
        long result=0;
        if(operation.equals("+"))
        	result=majaNumb1Long+majaNumb2Long;
        else if(operation.equals("-"))
        	result=majaNumb1Long-majaNumb2Long;
        else if(operation.equals("*"))
        	result=majaNumb1Long*majaNumb2Long;
        else if(operation.equals("/"))
        	result=majaNumb1Long/majaNumb2Long;
        
        ArrayList<MajaNumber> resultList = transformNumberToMaja(result);

        for(MajaNumber maja:resultList) {
        	String majaResult[]=maja.getMajaSign();
        	for(String s :majaResult)
        	{System.out.println(s);}
        	
        }
        

    }
public static ArrayList<MajaNumber>transformNumberToMaja(long result){
	ArrayList<MajaNumber> resultList= new ArrayList<>();
	int amountOfNumbersNeeded=0;
	long test=result;
	if (result ==0) {resultList.add(majaDic[0]); return resultList;}
	while(test>0) {
		test=test/20;
		amountOfNumbersNeeded++;
	}
	
	for(int i =amountOfNumbersNeeded-1;i>=0;i--) {
		int fac=(int)(result/(long)Math.pow(20, i));
		result=result%(long)Math.pow(20, i);
		
		resultList.add(majaDic[fac]);

	}
	
	
	
	return resultList;
}
	public static long transformMajaNumberToLong(MajaNumber[] majaNumber) {
		long result = 0;

		for (int i = 0; i < majaNumber.length; i++) {
			MajaNumber maja=majaNumber[i];

			for (MajaNumber majaD : majaDic) {
				if (majaD.equalsMajaSign(maja.getMajaSign())) {
					result = result + majaD.getValue() * (long) Math.pow(20,majaNumber.length - i - 1 );
					break;
				}

			}

		}

		return result;
	}

    public static MajaNumber[] transformIntoMajaNumbers(String [] majaString,int Height) {
    	int amounfOfMajaNumbers=majaString.length/Height;
    	MajaNumber majaNunb[]= new MajaNumber[amounfOfMajaNumbers];

    	
    	for(int j =0;j<amounfOfMajaNumbers;j++) {
    		String temp[]= new String [Height];
    	for(int i=0;i<Height;i++) {
    		temp[i]=majaString[j*Height+i];	
    	}
    	MajaNumber majaNeu= new MajaNumber(temp);
		majaNunb[j]=majaNeu;
		
    	}

    	return majaNunb;
    }
}
class MajaNumber{
	protected String[] MajaSign;
	protected int valNumb;
	
	
	MajaNumber(String s[]){
		this.MajaSign=s;
	}
	protected void setValue(int val) {this.valNumb=val;}
	protected int getValue() {return valNumb;}
	protected String[] getMajaSign() {return MajaSign;}
	protected boolean equalsMajaSign(String[] MajaSignToCheck) {
		
		int row=0;
		for(String s:MajaSignToCheck) {
			if(!s.equals(MajaSign[row])) {return false;}
			row++;
		}
		return true;
	}
	
}