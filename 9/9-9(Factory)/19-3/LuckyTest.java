import java.util.Random;

interface LukTestMethod{
	int lukTest();
}

class Dice implements LukTestMethod{
	private static Random rand = new Random(47);
	public int lukTest(){
		return rand.nextInt(5) + 1;
	}
}

class Coin implements LukTestMethod{
	private static Random rand = new Random(47);
	public int lukTest(){
		return rand.nextInt(1);
	}
}

interface Factory{
	LukTestMethod getAMethod();
}

class DiceFactory implements Factory{
	public 	LukTestMethod getAMethod() { return new Dice(); }
}

class CoinFactory implements Factory{
	public 	LukTestMethod getAMethod() { return new Coin(); }
} 

public class LuckyTest{
	public static void main(String[] args){
	
	}
}
