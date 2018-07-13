import java.util.*;

interface Processor<T,E extends Exception,X extends Exception> {
  void process(List<T> resultCollector) throws E, X;
}

class ProcessRunner<T,E extends Exception,X extends Exception>
extends ArrayList<Processor<T,E,X>> {

  List<T> processAll() throws E, X {
    List<T> resultCollector = new ArrayList<T>();
    for(Processor<T,E,X> processor : this)
      processor.process(resultCollector); // Throw from here.
    return resultCollector;
  }
  
}	

class Failure1 extends Exception {}

class Processor1 implements Processor<String,Failure1,Failure2> {
  static int count = 3;
  public void
  process(List<String> resultCollector) throws Failure1, Failure2 {
    if(count-- > 1)
      resultCollector.add("Hep!");
    else{
      resultCollector.add("Ho!");
      throw new Failure2();
    }
    if(count < 0)
       throw new Failure1();
  }
}	

class Failure2 extends Exception {}

class Processor2 implements Processor<Integer,Failure1,Failure2> {
  static int count = 2;
  public void
  process(List<Integer> resultCollector) throws Failure1, Failure2 {
    if(count-- == 0)
      resultCollector.add(47);
    else {
      resultCollector.add(11);
      throw new Failure2();
    }
    if(count < 0)
       throw new Failure1();
  }
}	

public class ThrowGenericException {
  public static void main(String[] args) {
    ProcessRunner<String,Failure1,Failure2> runner =
      new ProcessRunner<String,Failure1,Failure2>();
    for(int i = 0; i < 3; i++)
      runner.add(new Processor1());
    try {
      System.out.println(runner.processAll());
    } catch(Failure1 e) {
      System.out.println(e);
    } catch(Failure2 e) {
    	System.out.println(e);
    }

    ProcessRunner<Integer,Failure1,Failure2> runner2 =
      new ProcessRunner<Integer,Failure1,Failure2>();
    for(int i = 0; i < 3; i++)
      runner2.add(new Processor2());
    try {
      System.out.println(runner2.processAll());
    } catch(Failure1 e) {
      System.out.println(e);
    } catch(Failure2 e) {
    	System.out.println(e);
    }
  }
} ///:~
