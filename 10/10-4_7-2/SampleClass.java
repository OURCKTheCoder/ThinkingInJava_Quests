public class SampleClass{

	private int luckyNum = 7;
	
	private int getLuckyNum() { return luckyNum; }

	class InnerClass{
		void modify(int val) {
			luckyNum = val;
			System.out.println(getLuckyNum());
		}
	}
		
	public InnerClass testInnerObj(){
		InnerClass obj = this.new InnerClass();
		obj.modify(47);
		return obj;
	}
	
	public static void main(String[] args){
		SampleClass s = new SampleClass();
		s.testInnerObj();//无论是否通过内部类实现“修改luckyNum”，这样调用总能隐藏实现细节。
	}
}
