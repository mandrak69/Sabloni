package razno;

import javax.print.attribute.standard.RequestingUserName;

interface Checker{
	boolean validate (String input);
}

//interface IntChecker{
//	boolean validate (int input);
//}

interface TypeChecker<T>{
	boolean validate (T input);
	default TypeChecker<T> and (TypeChecker<T> other){
		
		
		return (t)->validate(t) && other.validate(t);
	}
}


public class TypeCheckExmpl {
	public static void main(String[] args) {
		//proverite da li je string null
		Checker checkerIsNull = (s)->s==null;

		//da li je prazan sring
		Checker checkerIsEmpty = (s)->s.isEmpty();
		
		//nije prazan i sadrzi slovo A

		
		//nije prazan, sadrzi slobo B i znak #
		
		
		//da li je broj paran
		TypeChecker<Integer> isOdd =(num)->num%2==0;
		System.out.println("2 paran: "+isOdd.validate(2));
		//da li je broj deljiv sa 3
		TypeChecker<Integer> isOdd3 =(num)->num%3==0;
		System.out.println("8 deljiv sa 3: "+isOdd3.validate(8));
		TypeChecker<String> hasA=(s)->s.contains("a");
		TypeChecker<String> hasb=(s)->s.contains("b");
		TypeChecker<String> hasc=(s)->s.contains("c");

		boolean r = hasA.validate("dragan");
		boolean rr = hasA.and(hasb.and(hasc)).validate("dragan");

		System.out.println("Paran i deljiv sa 3 (12): "+isOdd.and(isOdd3 ).validate(12));
		System.out.println("Paran i deljiv sa 3 (10): "+isOdd.and(isOdd3 ).validate(10));
		
	}
}
