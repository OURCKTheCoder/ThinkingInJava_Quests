package pk1;
import pk2.*;

class SampleClass{
	
	public PublicInterface returnObj() { return new Inner(); }

	private class Inner implements PublicInterface{
		public Inner() {}
		public void doSomeThing() { System.out.println("Test text"); }
	}
		
}

public class TestMain{
	public static void main(String[] args){
		SampleClass mainobj = new SampleClass();
		
		PublicInterface obj2 = (SampleClass.Inner)mainobj.returnObj();
		//																	^ Can't create private obj
		obj2.doSomeThing();
	}
}
