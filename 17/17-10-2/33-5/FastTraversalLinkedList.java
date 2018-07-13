package ourck.mainconsole;

import java.util.*;
import net.mindview.util.*;

public class FastTraversalLinkedList<T> implements List<T>  {
	private ArrayList<T> arylst = new ArrayList<T>(); // The main character;
	private LinkedList<T> lklst = new LinkedList<T>();// Only handles special actions
														//(like insert & remove)
	
	@Override
	public boolean add(T e) {
		try {
			arylst.add(e);
			lklst.add(e);
			return true;
		} catch(Exception exp) {
			throw new RuntimeException(exp);
		}
	}

	@Override
	public void add(int index, T element) {
		lklst.add(index,element);
//		arylst = new ArrayList<>(lklst);
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		try {
			arylst.addAll(c);
			lklst.addAll(c);
			return true;
		} catch(Exception exp) {
			throw new RuntimeException(exp);
		}
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		try {
			lklst.addAll(index, c); //Insert
			arylst = new ArrayList<>(lklst);
			return true;
		} catch(Exception exp) {
			throw new RuntimeException(exp);
		}
	}

	@Override
	public void clear() {
		arylst = new ArrayList<T>();
		lklst = new LinkedList<T>();		
	}

	@Override
	public boolean contains(Object o) {
		return arylst.contains(o) || lklst.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return arylst.containsAll(c) || lklst.containsAll(c);
	}

	@Override
	public T get(int index) {
		return arylst.get(index);
	}

	@Override
	public int indexOf(Object o) {
		return arylst.indexOf(o);
	}

	@Override
	public boolean isEmpty() {
		return arylst.isEmpty();
	}

	@Override
	public Iterator<T> iterator() {
		return arylst.iterator();
	}

	@Override
	public int lastIndexOf(Object o) {
		return arylst.lastIndexOf(o);
	}

	@Override
	public ListIterator<T> listIterator() {
		return arylst.listIterator();
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		return arylst.listIterator(index);
	}

	@Override
	public boolean remove(Object o) {
		boolean flag = lklst.remove(o); //Remove
		arylst = new ArrayList<>(lklst);
		return flag;
	}

	@Override
	public T remove(int index) {
		T obj = lklst.remove(index);
//		arylst = new ArrayList<>(lklst);
		return obj;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean flag = lklst.removeAll(c); //Remove
		arylst = new ArrayList<>(lklst);
		return flag;
	}

	@Override
	public boolean retainAll(Collection<?> c) { // TODO Which is the best?
		return lklst.retainAll(c);
	}

	@Override
	public T set(int index, T element) {
		return arylst.set(index, element);
	}

	@Override
	public int size() {
		return arylst.size();
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		return arylst.subList(fromIndex, toIndex);
	}

	@Override
	public Object[] toArray() {
		return arylst.toArray();
	}

	@Override
	public <E> E[] toArray(E[] a) { // E != T
		return arylst.toArray(a);
	}
	
	@Override
	public String toString() {
		StringBuilder stb = new StringBuilder();
		stb.append("[");
		Iterator<T> it = arylst.listIterator();
		while(it.hasNext()) {
			stb.append(it.next() + ", ");
		}
		stb.append("]");
		
		return stb.toString();
	}
	
	public static void main(String[] args) {
		FastTraversalLinkedList<String> lst = new FastTraversalLinkedList<>();
		Collections.addAll(lst, Generated.array(new String[7], new Generator<String>() {
			private Random rand = new Random(47);
			private static final int STR_SIZE = 7;
			@Override
			public String next() {
				StringBuilder stb = new StringBuilder();
				for(int i = 0; i < STR_SIZE; i++) {
					stb.append(new Character((char)(rand.nextInt(26) + 'A')));
				}
				return stb.toString();
			}
		}));
		System.out.println(lst);
		
		ListPerformance.main(new String[0]);
	}

}
