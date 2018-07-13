package pk3;

import pk2.*;
import pk1.*;

public class Child extends SampleClass{
	public Model show() { return this.new SampleModel(); }//Or "new" for short.
}
