package razno;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayOn4Way {
	static List<Integer> createList1(){
		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(13);
		list.add(5);
		list.add(1);
		list.add(8);
		return list;
	}
	
	static List<Integer> createList2(){
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
		
		return list;
	}
	
	static List<Integer> createList3(){
		List<Integer> list=new ArrayList<Integer>(){
			{
				add(10);
				add(20);
				add(60);
				add(30);
				add(10);
				add(0);
				add(60);
			}
		};
		return list;
	}
	
	static List<Integer> createList4(){
		List<Integer> list=new ArrayList<Integer>(Collections.nCopies(10, 100));
		return list;
	}

	
	
	public static void main(String[] args) {
		 List<Integer> l1 = ArrayOn4Way.createList1();
		 System.out.println("l1: "+ l1);
		 
		 List<Integer> l2 = ArrayOn4Way.createList2();
		 System.out.println("l2: "+ l2);
		 l2.add(11);
		 System.out.println("l2: "+ l2);
		 
		 List<Integer> l3 = ArrayOn4Way.createList3();
		 System.out.println("l3: "+ l3);
		 l3.add(13);
		 System.out.println("l3: "+ l3);
		 
		 List<Integer> l4 = ArrayOn4Way.createList4();
		 System.out.println("l4: "+ l4);
		 
		 
		//sorirtiraj listu opadajucem redosledu
		 Collections.sort(l3);
		 Collections.reverse(l3);
		 System.out.println("sorted l3: "+ l3);	
		 
		 Collections.sort(l1,Collections.reverseOrder());
		 System.out.println("sorted l1: "+ l1);	
		 
		 //izbacite neki zadati element
		 
		 
		 //izbaciti zadati element, ako ih ima vise izbaciti sve
		 Iterator<Integer>  iterator = l3.iterator();
		 while(iterator.hasNext()){
			 Integer el = iterator.next();
			 if (el.equals(10)) iterator.remove();
		 }
		 
		 System.out.println("l3: "+ l3);	
		 
	}

}
