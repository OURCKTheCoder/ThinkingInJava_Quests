public class CharactersParty{
	public static void main(String[] args){
		A[] As = { new A(), new A() };
		B b = new B();
		for(A a : As){
			b.addU(a.a());
		}	
	}
}

interface U{
	void u();
}

class A{
	U a() {
		return new U(){
			public void u() { System.out.println("u!"); }
		};//';'!!!!!!!!!
	}
}

class B{
	private U[] Us = {
		new U() { public void u() { System.out.println("u!"); } },
		new U() { public void u() { System.out.println("u!"); } }
	};
	
	void addU(U obj) {
		//TODO - Add an U in ary.
	}
	
	void setNull(){
		//TODO - Set all Us to null.
	}
	
	void showUs(){
		for(U u : Us) u.u();
	}
}
