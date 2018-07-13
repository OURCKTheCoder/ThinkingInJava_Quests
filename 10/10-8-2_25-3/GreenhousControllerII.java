package innerclasses;

import innerclasses.controller.*;

public class GreenhousControllerII {

	public static void main(String[] args) {
		GHExControls ec = new GHExControls();
		Event[] eventList = {
			ec.new TurnOn(1000000000),
			ec.new TurnOff(2000000000)
		};
		ec.addEvent(ec.new Restart(1000000, eventList));
		ec.run();
	}

}
