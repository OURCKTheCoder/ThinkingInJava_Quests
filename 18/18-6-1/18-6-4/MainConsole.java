import java.io.*;
import java.util.*;

public class MainConsole {
	
	public static void main(String[] args) throws IOException{
		if(args.length != 1) return;
		FileReader file = new FileReader(args[0]);
		BufferedReader fromFile= new BufferedReader(file);
		
		List<String> txtList = new LinkedList<String>();
		
//		StringBuilder sb = new StringBuilder();
		String str;
		int lineNum = 0;
		while((str = fromFile.readLine()) != null) {
			StringBuilder stb = new StringBuilder();
			stb.append(++lineNum + ": " + str); //sb.append(stb.toString() + '\n');
			txtList.add(stb.toString().toUpperCase());
		}

		Collections.reverse(txtList);
		
		fromFile.close(); //!!!!!!
//		System.out.println(sb.toString());
	}

}

