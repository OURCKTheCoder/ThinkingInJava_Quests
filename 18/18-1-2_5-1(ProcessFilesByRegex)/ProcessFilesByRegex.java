package ourck.mainconsole;

import java.io.*;
import java.util.regex.*;
import net.mindview.util.*;

public class ProcessFilesByRegex {
  public interface Strategy {
    void process(File file);
  }
  private Strategy strategy;
  private String regex;
  private Pattern p;
  public ProcessFilesByRegex(Strategy strategy, String regex) {
    this.strategy = strategy;
    this.regex = regex;
  }
  public void start(String[] args) {
    try {
      if(args.length == 0)
        processDirectoryTree(new File("/home/ourck/文档/Local/Project TIJ4/ThinkingInJava_Quests/6/6-1-4_3-2"));
      else
        for(String arg : args) {
          File fileArg = new File(arg);
          if(fileArg.isDirectory())
            processDirectoryTree(fileArg);
          else {
            // Allow user to leave off extension:
				if(p.matcher(arg).matches());
            strategy.process(
              new File(arg).getCanonicalFile());
          }
        }
    } catch(IOException e) {
      throw new RuntimeException(e);
    }
  }
  public void
  processDirectoryTree(File root) throws IOException {
    for(File file : Directory.walk(root.getAbsolutePath(), regex))
      strategy.process(file.getCanonicalFile());
  }
  // Demonstration of how to use it:
  public static void main(String[] args) {
    new ProcessFilesByRegex(new ProcessFilesByRegex.Strategy() {
      public void process(File file) {
        System.out.println(file);
      }
    }, "MainConsole.java").start(args);
  }
} /* (Execute to see output) *///:~
