import java.io.*;
import java.util.*;

public class MainConsole {
	
	public static void main(String[] args) throws IOException{
		if(args.length != 1) return;
		FileReader file = new FileReader(args[0]);
		BufferedReader fromFile= new BufferedReader(file);
		
		List<String> txtList = new LinkedList<String>();
		
		String str;
		while((str = fromFile.readLine()) != null) {
			txtList.add(str.toUpperCase());
		}

		System.out.println(txtList);
		Collections.reverse(txtList);
		System.out.println(txtList);
		
		fromFile.close(); //!!!!!!
	}

}

