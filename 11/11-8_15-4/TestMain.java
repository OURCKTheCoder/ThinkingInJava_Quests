
import net.mindview.util.*;

public class TestMain {
	
	public static void main(String[] args) {
		String testTxt = new String("+U+n+c---+e+r+t---+a-+i-+n+t+y---+-+r+u--+l+e+s---");
		Stack<Character> s = new Stack<Character>();
		
		char[] cs = testTxt.toCharArray();
		
		for(int i = 0; i < cs.length; i++) {
			if(cs[i] == '+') s.push(cs[++i]);
			if(cs[i] == '-') s.pop();//[!]Is stack empty?
			System.out.println(s);
		}
		
	
	}

}

