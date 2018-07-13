package pk2;

import pk1.*;

public class SampleClass{

	protected class SampleModel implements Model{
		public SampleModel() {}//！！！必须注明构造器是public的。
		//否则构造器将跟随这个内部类的可访问性，也是protected.（？）
		public void foo() {}
		public void bar() {}
	}
	
}
