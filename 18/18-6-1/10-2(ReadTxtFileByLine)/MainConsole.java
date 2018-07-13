import java.io.*;
import java.util.*;

public class MainConsole {
	
	public static void main(String[] args) throws IOException{
		if(args.length != 2) return;
		
		FileReader file = new FileReader(args[0]);
		BufferedReader fromFile= new BufferedReader(file);
		
		List<String> txtList = new LinkedList<String>();
		
		String str;
		while((str = fromFile.readLine()) != null) {
			txtList.add(str.toUpperCase());
		}
		
		// Now search.
		String pattern = args[1];
		List<Integer> linenums = new ArrayList<>();
		Iterator<String> it = txtList.iterator();
		while(it.hasNext()) {
			String l = it.next();
			if(l.contains(pattern)) linenums.add(txtList.indexOf(l));
		}

		Collections.reverse(txtList);
		System.out.println(txtList);
		System.out.println("--------------------------");
		System.out.println(linenums);
		
		fromFile.close(); //!!!!!!
	}

}


