import java.io.File;
import java.util.*;
import java.util.regex.*;

public class SortedDirList {
	private File path;
	private List<String> paths;
	public SortedDirList(String path) {
		try {
			this.path = new File(path);
			paths = Arrays.asList(this.path.list());		
			Collections.sort(paths,String.CASE_INSENSITIVE_ORDER);
		} catch(NullPointerException e) {
			System.err.println(" Plz give a valid path!");
			throw e;
		}
	}
	
	public List<String> list() {
		return paths;
	}
	
	public List<String> list(String regex) {
		Pattern pattern = Pattern.compile(regex);
		String[] strs = paths.toArray(new String[paths.size()]);
		
		StringBuilder stb = new StringBuilder();
		for(String s : strs) {
			if(pattern.matcher(s).matches()) {
				stb.append(s + ",");
			}
		}
		
		List<String> matched = Arrays.asList(stb.toString().split(","));
		return matched;
	}
	
	public static void main(String[] args) {
		SortedDirList s = new SortedDirList("/home/ourck/文档"); // Terminal "~" refers to "/home", but doesn't work in Java.
		System.out.println(s.list());
		System.out.println(s.list("JAVA_API"));
	}
}
