/*-------------------------------------
 *	OURCK - 文件大小计数器
 *-------------------------------------

/* 
 * 通过File.length可获得该文件大小（单位byte）
 */
import java.util.regex.*;
import java.io.*;
import java.util.*;
import net.mindview.util.TextFile;

public class DirList {
  public static void main(String[] args) {
    File path = new File("/home/ourck/文档/Local/Project TIJ4/ThinkingInJava_Quests");
    String[] list;
    if(args.length == 0)
      list = path.list();
    else
      list = path.list(new FileTxtFilter(args[0]));
    Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
    
    long sum = 0;
    for(String dirItem : list) {
    	long size = new File(path, dirItem).length();
    	sum += size;
    	System.out.println(dirItem + ", " + size + " byte(s)");
    }
    System.out.println("------------- Total: " + sum + " byte(s) -------------");
  }
}

class DirFilter implements FilenameFilter {
  private Pattern pattern;
  public DirFilter(String regex) {
    pattern = Pattern.compile(regex);
  }
  public boolean accept(File dir, String name) {
    return pattern.matcher(name).matches();
  }
}

class FileTxtFilter implements FilenameFilter {
  private String pattern;
  private TextFile f;
  public FileTxtFilter(String keyword) {
    pattern = new String(keyword);
  }

  public boolean accept(File dir, String name) {
    String path = dir.getPath() + "/" + name;
    if(new File(path).isDirectory())return false;
    List<String> lst = Arrays.asList(new TextFile(path).toString().split(" "));
    return lst.contains(pattern);
  }

} /* Output:
DirectoryDemo.java
DirList.java
DirList2.java
DirList3.java
*///:~
