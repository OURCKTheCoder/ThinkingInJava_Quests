package innerclasses;

import innerclasses.controller.Event;

public class GHExControls extends GreenhouseControls{
	private boolean machine = false;
	public class TurnOn extends Event{
		public TurnOn(long delayTime) {
			super(delayTime);
		}
		public void action() {
			machine = true;
		}
		public String toString() { return "On"; }
	}
	public class TurnOff extends Event{
		public TurnOff(long delayTime) {
			super(delayTime);
		}
		public void action() {
			machine = false;
		}
		public String toString() { return "Off"; }
	}
	
	public class Restart extends Event{
		private Event[] newEventList;
		public Restart(long delayTime, Event[] newEventList){
			super(delayTime);
			this.newEventList = newEventList;
		}
		public void action() {
			for(Event e : newEventList) {
				addEvent(e);
			}
			start();
		}
		public String toString() { return "Restart!"; }
	}
}