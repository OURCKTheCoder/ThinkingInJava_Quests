package ourck.mainconsole;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import net.mindview.util.*;

public class MainConsole {
	
	public static void main(String[] args) {
		ProcessFiles processor = new ProcessFiles(new ProcessFiles.Strategy() {
			@Override
			public void process(File arg0) {
				
				DateFormat df = DateFormat.getDateInstance(
						DateFormat.SHORT, Locale.US);
						
				long t = 0;
				try {
					t = df.parse("1/04/2018").getTime();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				if(arg0.lastModified() > t)
					System.out.println(arg0);
			}
		}, "java");
		
		String[] str = {"/home/ourck/文档/Local/Project TIJ4/ThinkingInJava_Quests/6/6-1-4_3-2"};
		processor.start(str);
		
	}

}

