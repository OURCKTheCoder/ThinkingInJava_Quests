
import java.util.*;

public class MainConsole {
	
	public static void main(String[] args) {
		Integer[] ary = {1,3,4,5,6,9,7,6,86,23,4,763,9,62,32,316,6 };
		Arrays.sort(ary, Collections.reverseOrder());
		System.out.println(Arrays.toString(ary));
	}
	
}
