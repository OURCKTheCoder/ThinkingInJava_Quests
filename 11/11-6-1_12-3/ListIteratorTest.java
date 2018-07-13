	import java.util.*;

public class ListIteratorTest{
	public static void main(String[] args){
		List<Integer> list1 = Arrays.asList(1,2,3,4,5);
		List<Integer> list2 = Arrays.asList(1,2,3,4,5);

//		Iterator<Integer> it1 = list1.listIterator();//Cannot upcast???????
		ListIterator<Integer> it1 = list1.listIterator();
		ListIterator<Integer> it2 = list2.<Integer>listIterator();//可以添加显示类型说明

		while(it1.hasNext()) { it1.next(); }
		while(it2.hasNext()) {//!
			it2.next();
			it2.set(it1.previous());
		}
		
		System.out.println(list2);
	}
}

	
