class A{
	class B{}
}

public class C extends A.B{
	C(){
		new A().super();
	}
	C(A a){
		a.super();
	}
}
