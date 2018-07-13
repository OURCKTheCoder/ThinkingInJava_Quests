import java.util.*;

class FixedSizeStack<T> {
	private int index = 0;
	private ArrayList<Object> storage; //  ArrayList<Object> or  ArrayList<T>? The former.
													//	The target is: vave as Object & return as T.
	public FixedSizeStack() {
		storage = new ArrayList<Object>();
	}
	int getIndex() { return index; } 
	public void push(T item) { storage.add(item); index++; }
	@SuppressWarnings("unchecked")
	public T pop() { return (T)storage.get(--index); }
	
}

public class GenericCast32 {
	public static final int SIZE = 10;
	public static void main(String[] args) {
		FixedSizeStack<String> strings = 
			new FixedSizeStack<String>();
		for(String s : "A B C D E F G H I J".split(" "))
			strings.push(s);
		// Runtime ArrayIndexOutOfBoundsException:
		// strings.push("oops"); // Bounds-checking required:
		if(strings.getIndex() < SIZE) strings.push("oops");
		for(int i = 0; i < SIZE; i++) {
			String s = strings.pop();
			System.out.print(s + " ");
		}					
	}		
		
}
