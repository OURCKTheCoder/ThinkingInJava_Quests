package ourck;

import interfaces.interfaceprocessor.*;

public class MainConsole {
	
	public static void main(String[] args) {
//		StrProcessor s = new StrProcessor();
//		String string = s.process("test text.");
//		System.out.println(string);
		
		StrAdapter obj = new StrAdapter(new StrProcessor());
		Apply.process(obj, "test text.");
	}

}

class StrProcessor{
	
	public String process(String arg) {
		char[] str = arg.toCharArray();
		for(int i = 0; i < str.length; i+=2) {
			char tmpC = ' ';
			tmpC = str[i]; 
			str[i] = str[i+1];
			str[i+1] = tmpC;
		}
		return new String(str);
	}
	
}

class StrAdapter implements Processor{
	private StrProcessor s;
	StrAdapter(StrProcessor s){
		this.s = s;
	}
	public String name() {
		return s.getClass().getSimpleName();
	}
	public String process(Object input) {
		return s.process((String)input);
	}
}
