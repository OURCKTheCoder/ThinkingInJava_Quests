package ourck.mainconsole;

import java.io.IOException;
import java.util.*;
import net.mindview.util.BinaryFile; // As utility instead of instance

public class BinaryFIleByteCounter {
	private byte[] data;
	private Map<Byte, Integer> table = new HashMap<>();
	
	public BinaryFIleByteCounter(String path) throws IOException {
		data = BinaryFile.read(path);
		for(byte b : data) {
			if(!table.containsKey(b)) table.put(b, 1);
			else {
				int newval = (Integer)table.get(b);
				table.put(b, ++newval);
			}
		}
	}
	
	public String toString() {
		return table.toString();
	}
	
	public static void main(String[] args) throws IOException {
		BinaryFIleByteCounter bfct = new BinaryFIleByteCounter(
				"/home/ourck/文档/Local/Project TIJ4/ThinkingInJava_Quests/6/6-1-4_3-2/MainConsole.class");
		System.out.println(bfct);
	}

}

