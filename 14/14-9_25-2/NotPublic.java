class NotPublic {
	private void foo() { System.out.println("FOO! You got it!");}
	protected void bar() { System.out.println("BAR! You got it!");}
	void fun() { System.out.println("FUN! You got it!");}
	
	public Class<?> retInstance() { return NotPublic.class; }
}
