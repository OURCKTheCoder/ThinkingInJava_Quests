public class MainConsole {
	
	public static void main(String[] args) {	
		SList<String> list = new SList<String>();
		SList<String>.SListIterator it = list.iterator();
		it.add(new Link<String>("A"));
		it.add(new Link<String>("B"));
		it.add(new Link<String>("C"));
		it.add(new Link<String>("D"));
		it.add(new Link<String>("E"));
		while(it.hasNext()) {
			try {
				System.out.println(it.next());
			} catch (OutOfBoundException e) {
				throw new RuntimeException(e);
			}
		}
	}
}

class Link<T> { // Or "Node"
	Link() { strData = null; }
	Link(String str) { strData = str; }
	public String strData;
	public Link<T> next = null;
	public String toString() { return strData; }
}

class SList<T> {
	
	private Link<T> head = new Link<T>();
	{
		head.strData = "*HEAD*"; // ...This should be "null".
	}
	
	public class SListIterator {
		private Link<T> ptr = head;
		public boolean hasNext() { return ptr.next != null; }
		public Link<T> next() throws OutOfBoundException {
			if(hasNext()) { 
				ptr = ptr.next;
				return ptr;
			}
			else throw new OutOfBoundException();
		}
		public void add(Link<T> obj) {
			obj.next = ptr.next;
			ptr.next = obj;
		}
		public void delete() {
			Link<T> tmp = ptr.next;
			ptr.next = tmp.next;
			tmp.next = null;
		}
	}

	public String toString() {
		SListIterator it = new SListIterator();
		StringBuilder stb = new StringBuilder();
		while(it.hasNext()) {
			try {
				stb.append(it.next().toString() + "|");
			} catch (OutOfBoundException e) {
				throw new RuntimeException(e);
			}
		}
		return stb.toString();
	}
	
	public SListIterator iterator() { return new SListIterator(); }
}

class OutOfBoundException extends Exception {}

