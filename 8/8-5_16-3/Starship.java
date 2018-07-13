class AlertStatus{
	public void alert(){
		System.out.println("Normal Alert");
	}
}

class HotAlert extends AlertStatus{
	public void alert(){
		System.out.println("Alert - Hot!");
	}
}

class ColdAlert extends AlertStatus{
	public void alert(){
		System.out.println("Alert - Cold!");
	}
}

class CyberAlert extends AlertStatus{
	public void alert(){
		System.out.println("Alert - Cyber!");
	}
}

public class Starship{
	private AlertStatus alt = new AlertStatus();
	public void heatUp(){
		alt = new HotAlert();
		alt.alert();
	}
	public void freeze(){
		alt = new ColdAlert();
		alt.alert();
	}
	public void cyber(){
		alt = new CyberAlert();
		alt.alert();
	}
	
	public static void main(String[] args){
		Starship s = new Starship();
		s.heatUp();
		s.freeze();
		s.cyber();
	}
	
}


