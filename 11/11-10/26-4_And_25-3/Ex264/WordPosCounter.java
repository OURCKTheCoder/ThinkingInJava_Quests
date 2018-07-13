package Ex264;
import net.mindview.util.*;
import java.util.*;

public class WordPosCounter{
	private String path;
	private ArrayList<String> words = new ArrayList<String>();
	public WordPosCounter(String path){//包间调用构造函数必须显式声明为public
		this.path = path;
		words = new TextFile(this.path, "\\W+");
	}
	public HashMap<String,ArrayList<Integer>> calculate(){
		HashMap<String,ArrayList<Integer>> wTable = new HashMap<String,ArrayList<Integer>>();
		
		//将words加入Set以去重
		HashSet<String> _words = new HashSet<String>(words);
		//既然Set可以接受Collection对象作为构造函数的参数，就不用大费周章：
//		HashSet<String> _words = new HashSet<String>();
//		String[] res = (String[])words.toArray(new String[words.size()]);
//		Collections.addAll(_words, res);
		
		ArrayList<Integer> _localPos = new ArrayList<Integer>();
		for(String word : _words) {
			ListIterator<String> ptr = words.listIterator();
			//每趟开始前新建临时表
			//若为外部变量不行：这个Map仅仅只将String引用和AryList引用建立关系，而非对象本身
			while(ptr.hasNext()) {
				if(ptr.next().equals(word)) {
					_localPos.add(ptr.nextIndex());//[!]
				}
			}
			System.out.println(_localPos);
			wTable.put(word, _localPos);
			System.out.println(wTable);
		}
		return wTable;
	}
	
	public static void main(String[] args) {
		HashMap<String,ArrayList<Integer>> rst = new WordPosCounter("123.java").calculate();
		System.out.println(rst);
	}
	
}
