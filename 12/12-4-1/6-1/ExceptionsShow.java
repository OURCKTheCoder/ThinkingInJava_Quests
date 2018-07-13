import java.util.logging.*;

public class ExceptionsShow {
	public static void main(String[] args){
		try{
			throw new TooFat();
		} catch(TooFat e) {
			System.out.println("——BTW, I'm not a cat. I'm the logger.");
		}


		System.out.println();		

		try{
			throw new TooThin();
		} catch(TooThin e) {
			System.out.println("——BTW, I'm not a cat. I'm the logger.");
		}

		
	}
}

class TooFat extends Exception {
	private Logger logger = Logger.getLogger("CatLogger_Meow");
	public TooFat(){
		logger.info("For a cat, the fatter is he better!");
	}
}

class TooThin extends Exception {
	private Logger logger = Logger.getLogger("CatLogger_Meow");
	public TooThin(){
		logger.severe("A cat must be FAT!!!!");
	}
}
