import java.math.BigInteger;
import java.util.*;

public class Main {
	
	public static void main(String [] args){
		
		BigInteger s = new BigInteger("118265094039565815049531127364467631364610459894615953952979710610700899375945248175926844977229339151565710308913382741188217043128243497980628317489");//500, new Random());
		BigInteger p = new BigInteger("814046464234006127431370570346341561503605608267701837058685727915984416348127511652932424382792914577319918977831359168793250418356668890032722529223");//500, new Random());
		BigInteger g = new BigInteger("387024528638770622731590519860279898675143715032733692364706925338600770063388954556787557775053491158773419726400771301182244314513382487643522832164");
		BigInteger t = new BigInteger("1998286638065473057944506344030256054916203227381748916180906390214373930105605405985818224246280726328877245115163209963634633681313092395058312190549");
		
		System.out.println("P value: " + p.toString(10));
		System.out.println("S value: " + s.toString(10));
		
		BigInteger resultOne = g.modPow(s, p);
		System.out.println("For sure correct: " + resultOne.toString(10));
		
		BigInteger result = modExpo(g, s, p);
		System.out.println("My attempt: " + result.toString(10));
		if(resultOne.toString(10).equals(result.toString(10))){
			System.out.println("They are equal!");
		}
		
		
	}
	
	
	public static BigInteger modExpo(BigInteger g, BigInteger s, BigInteger p){
		
		BigInteger temp = new BigInteger("1");
					
		System.out.println("Exponent in binary: " + s.toString(2));
		
		
		for(int x=0; x<s.toString(2).length(); x++){
			if(s.toString(2).charAt(s.toString(2).length()-1-x)=='1'){
				if(x==0){
					temp = temp.multiply(g);
				}
				else{
					BigInteger e = twoExpModP(g, x, p);
					temp = temp.multiply(e);
				}
			}
		}
		
		
		temp = temp.mod(p);
		return temp;
		
	}
	
	public static BigInteger twoExpModP(BigInteger g, int n, BigInteger p){
	
	
		BigInteger temp = new BigInteger(g.toString(10));
		temp = temp.pow(2);
		
		for(int x = 0; x<n-1; x++){
			temp = temp.pow(2);
			temp = temp.mod(p);
		}
		return temp;
	}
}

