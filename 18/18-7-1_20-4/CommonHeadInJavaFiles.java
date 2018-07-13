package ourck.mainconsole;

import java.io.File;
import java.io.IOException;

import net.mindview.util.*;
import net.mindview.util.Directory.TreeInfo;

public class CommonHeadInJavaFiles {

	public static void main(String[] args) throws IOException {
		TreeInfo fileTree = Directory.walk(
				"/home/ourck/文档/Local"
				+ "/Project TIJ4/ThinkingInJava_Quests"
				+ "/"); // How to use regex?
		
		for(File file : fileTree.files) {
			byte[] bytesOfFile;
			bytesOfFile = BinaryFile.read(file);
			System.out.println(file.getName() + ": ");
			for(int i = 0; i < 4; i++) { // And modify "i<4" to "i<8", the result is the same. 
				Byte b = new Byte(bytesOfFile[i]);
				System.out.print(b + " ");
			}
			System.out.println();System.out.println();
		}
	}

}
