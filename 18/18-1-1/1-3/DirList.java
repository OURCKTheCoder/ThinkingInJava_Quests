
package ourck.mainconsole;
//: io/DirList.java
// Display a directory listing using regular expressions.
// {Args: "D.*\.java"}
import java.util.regex.*;
import java.io.*;
import java.util.*;
import net.mindview.util.TextFile;

public class DirList {
  public static void main(String[] args) {
    File path = new File("/home/ourck/文档");
    String[] list;
    if(args.length == 0)
      list = path.list();
    else
      list = path.list(new FileTxtFilter(args[0]));
    Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
    for(String dirItem : list)
      System.out.println(dirItem);
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
