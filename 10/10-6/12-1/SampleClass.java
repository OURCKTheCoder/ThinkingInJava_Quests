public class SampleClass{

	private int luckyNum = 7;
	
	private int getLuckyNum() { return luckyNum; }

	private class InnerClass{
		public void modify(int val) {}
	}

	public InnerClass testInnerObj(){
		return new InnerClass(){
			public void modify(int val) {
				luckyNum = val;
				System.out.println(getLuckyNum());
			}
		};
	}
	
	public static void main(String[] args){
		SampleClass s = new SampleClass();
		s.testInnerObj().modify(47);
	}
}
