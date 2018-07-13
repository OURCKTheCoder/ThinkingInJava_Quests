public interface StaticImpInt{
	void show();
	
	public static class Nested{
		public static void callShow(StaticImpInt i){
			i.show();
		}
		public static void main(String[] args){
			Imp i = new Imp();
			callShow(i);
		} 
	}
}

class Imp implements StaticImpInt{
	public void show(){
		System.out.println("test text");
	}
}
