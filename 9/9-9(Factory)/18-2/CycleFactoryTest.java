interface Cycle{
	void run();
}

class Unicycle implements Cycle{
	public void run() {}
}

class Bicycle implements Cycle{
	public void run() {}
}

class Tricycle implements Cycle{
	public void run() {}
}

interface Factory{
	Cycle getASample();
}

class UnicycleFactory implements Factory{
	public Cycle getASample() {return new Unicycle();}
}

class BicycleFactory implements Factory{
	public Cycle getASample() {return new Bicycle();}
}

class TricycleFactory implements Factory{
	public Cycle getASample() {return new Tricycle();}
}

public class CycleFactoryTest{
	public static void main(String[] args){
		
	}
}

