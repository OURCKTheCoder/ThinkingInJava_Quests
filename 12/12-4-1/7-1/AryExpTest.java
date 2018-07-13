import java.util.logging.*;

public class AryExpTest {
	public static void main(String[] args){
		Integer[] ary = { 1,2,3,4 };
		try{
			System.out.println(ary[4]);			
		} catch(ArrayIndexOutOfBoundsException e) {
			Logger logger = Logger.getLogger("OUT OF BoUNd!");
			logger.severe("Out of bound!");
		}
	}
}


