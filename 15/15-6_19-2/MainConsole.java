package ourck.mainconsole;

import java.util.ArrayList;
import java.util.Random;
import net.mindview.util.*;;

public class MainConsole {
	
	public static void main(String[] args) {
		Ferry ferry = new Ferry();
		for(Repository r : ferry) {
			System.out.println("" + r);
			for(Container c : r) {
				System.out.println("\t" + c);
				for(Goods  g : c)
					System.out.println("\t\t" + g);
			}
		}
	}
	
}

class Goods {
	private static long count = 0;
	private long id = count++;
	private Goods() {}
	public String toString() { return "Goods" + "[" + id + "]"; }
	public static Generator<Goods> generator = new Generator<Goods>() {
		@Override
		public Goods next() {
			return new Goods();
		}
	};
}

class Container extends ArrayList<Goods>{
	private static long count = 0;
	private long id = count++;
	private Container() {
		Random rand = new Random(47);
		for(int i = 0; i < rand.nextInt(10); i++) {
			add(Goods.generator.next());
		}
	}
	public String toString() { return "Container" + "[" + id + "]"; }
	public static Generator<Container> generator = new Generator<Container>() {
		@Override
		public Container next() {
			return new Container();
		}
	};	
}

class Repository extends ArrayList<Container> {
	private static long count = 0;
	private long id = count++;
	private Repository() {
		Random rand = new Random(47);
		for(int i = 0; i < rand.nextInt(10); i++) {
			add(Container.generator.next());
		}
	}
	public String toString() { return "Repository" + "[" + id + "]"; }
	public static Generator<Repository> generator = new Generator<Repository>() {
		@Override
		public Repository next() {
			return new Repository();
		}
	};	
}

class Ferry extends ArrayList<Repository> {
	private static long count = 0;
	private long id = count++;
	public Ferry() {
		Random rand = new Random(47);
		for(int i = 0; i < rand.nextInt(10); i++) {
			add(Repository.generator.next());
		}
	}
}