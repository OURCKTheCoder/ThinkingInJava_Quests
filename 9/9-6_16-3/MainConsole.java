
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

class CharAry{
	private static final int RAND_SEED=47;
	private static Random rand = new Random(RAND_SEED);//记得static修饰符！！！！！
	private Character[] cs;
	private Integer length;
//	public CharAry(Character... args) {
//		cs = args;
//		length = args.length;
//	}
	public CharAry(int l) {
		length = l;
		cs = new Character[length];
		for(int i = 0; i < length; i++) {
			double index = 65 + (90 - 65) * rand.nextInt(100) / 100 ;
			cs[i] = new Character((char)index);
		}
	}
	public Character[] value(){
		return cs;
		/*
		 * 注意：这个cs并不是单例设计模式，
		 * （单例设计模应返回一个类的所有对象共同维护的static成员）
		 * 只是一种在实现上类似代理的方式，仅仅只是将其封装在内而已。
		 */
	}
//	public static void main(String[] args) {
//		CharAry charAry = new CharAry(7);
//		for(Character c : charAry.value()) {
//			System.out.print(c);
//		}
//	}
}

class AdaptedCharAry implements Readable{
	private static final int LENGTH = 20;
	private int count;//计数：这一串char中的字母数 / 字符串数
//	public AdaptedCharAry() {
//		count = chars.value().length;
//	}
//	public int read(CharBuffer cb){
//		if(count-- == 0) return -1;//Scan完所有的字母后结束
//		cb.append(chars.value()[count]);
//		return cb.length();
//	}//单字符串Ver
	
	public AdaptedCharAry(int aryNum) {
		count = aryNum;
	}
	
	public int read(CharBuffer cb) {
		if(count-- == 0)
			return -1;
		CharAry chars = new CharAry(LENGTH);
		for(char c : chars.value())
			cb.append(c);
		cb.append('\n');
		return cb.length();
	}
}


public class MainConsole{
	private static final int ARY_NUM = 5;
	public static void main(String[] args) {
		Scanner s = new Scanner(new AdaptedCharAry(ARY_NUM));//考虑把main的args作为参数。
		while(s.hasNext()) {
			System.out.println(s.next());
		}
		s.close();
	}
}

/*
 * 设计类时应明确对象，
 */
