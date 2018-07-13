package ourck.mainconsole;

public class TestMain {

	public static void main(String[] args) {
		DangerousMonster barney = new DragonZilla();
		HorrorShow.u(barney);
		HorrorShow.v(barney);
		Vampire vlad = new VeryBadVampire();
		HorrorShow.u(vlad);
		HorrorShow.v(vlad);
		HorrorShow.w(vlad);
	}

}
//: interfaces/HorrorShow.java
//Extending an interface with inheritance.

interface Monster {
	void menace();
}

interface DangerousMonster extends Monster {
	void destroy();
}

interface Lethal {
	void kill();
}

class DragonZilla implements DangerousMonster {
	public void menace() {}
	public void destroy() {}
}	

interface Vampire extends DangerousMonster, Lethal {
	void drinkBlood();
}

class VeryBadVampire implements Vampire {
	public void menace() {}
	public void drinkBlood() {}
	public void destroy() {}
	public void kill() {}
}	

class HorrorShow {
	static void u(Monster b) { b.menace(); }
	static void v(DangerousMonster d) {
		d.menace();
		d.destroy();
	}
	static void w(Lethal l) { l.kill(); }
	static DangerousMonster monsterMaker() {
		return new DangerousMonster() {
			
			@Override
			public void menace() {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void destroy() {
				// TODO 自动生成的方法存根
				
			}
		};
	}
	static Vampire vampireMaker() {
		return new Vampire() {
			
			@Override
			public void kill() {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void menace() {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void destroy() {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void drinkBlood() {
				// TODO 自动生成的方法存根
				
			}
		};
	}
	
	
}
