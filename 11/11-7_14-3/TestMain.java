
import java.util.*;

public class TestMain {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		Collections.addAll(list, 10,11,12);
		for(int i = 0; i < 10; i++) {
			ListIterator<Integer> it = list.listIterator(list.size()/2);//Cannot upcast.
			it.add(i);
			System.out.println(list);
		}
	}

}

