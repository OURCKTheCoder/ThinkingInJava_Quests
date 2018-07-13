import java.io.*;
import innerclasses.controller.*;
import innerclasses.GreenhouseControls.*;

public class GreenhouseController {
  public static Event eventFromFile(String path) throws IOException { // ...Or reflect?
	  FileReader file = new FileReader(path);
	  BufferedReader txtFromFile = new BufferedReader(file);
	  
	  String strByLine; 
	  /* Suppose this file has 2 lines: the first is the type of Event,
	  		the second is the "delay time" argument.*/
	  		
	  GreenhouseControls gc = new GreenhouseControls(); 
	  // 						^Used for creating child class instance.
	  LightOn event = null;
	  while((strByLine = txtFromFile.readLine()) != null) {
		  switch (strByLine) {
			case "LightOn":
				Integer intarg = Integer.parseInt(txtFromFile.readLine());
				event = gc.new LightOn(intarg);
				break;
			// case others here.
			default: break;
		}
	  }
	  txtFromFile.close();
	  return event;
  }
	
	
  public static void main(String[] args) throws IOException {
    GreenhouseControls gc = new GreenhouseControls();
    // Instead of hard-wiring, you could parse
    // configuration information from a text file here:
    gc.addEvent(gc.new Bell(900));
    Event[] eventList = {
		eventFromFile("test");
    };	
    gc.addEvent(gc.new Restart(2000, eventList));
    if(args.length == 1)
      gc.addEvent(
        new GreenhouseControls.Terminate(
          new Integer(args[0])
        )
      );
    gc.run();
  }
} /* Output:
Bing!
Thermostat on night setting
Light is on
Light is off
Greenhouse water is on
Greenhouse water is off
Thermostat on day setting
Restarting system
Terminating
*///:~
