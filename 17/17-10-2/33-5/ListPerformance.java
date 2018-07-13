package ourck.mainconsole;
//: containers/ListPerformance.java
// Demonstrates performance differences in Lists.
// {Args: 100 500} Small to keep build testing short
import java.util.*;
import net.mindview.util.*;

public class ListPerformance {
  private static final String TESTSTR = "testStr";
  static Random rand = new Random();
  static int reps = 1000;
  static List<Test<List<String>>> tests =
    new ArrayList<Test<List<String>>>();
  static List<Test<LinkedList<String>>> qTests =
    new ArrayList<Test<LinkedList<String>>>();
  static {
	  tests.add(new Test<List<String>>("sort") {
			int test(List<String> list, TestParam tp) {
				int loops = tp.loops;
				for(int i = 0; i < loops; i++) {
					list.sort(String.CASE_INSENSITIVE_ORDER);
				}
				return loops;
			}
		});
    tests.add(new Test<List<String>>("add") {
      int test(List<String> list, TestParam tp) {
        int loops = tp.loops;
        int listSize = tp.size;
        for(int i = 0; i < loops; i++) {
          list.clear();
          for(int j = 0; j < listSize; j++)
            list.add(TESTSTR);
        }
        return loops * listSize;
      }
    });
    tests.add(new Test<List<String>>("get") {
      int test(List<String> list, TestParam tp) {
        int loops = tp.loops * reps;
        int listSize = list.size();
        for(int i = 0; i < loops; i++)
          list.get(rand.nextInt(listSize));
        return loops;
      }
    });
    tests.add(new Test<List<String>>("set") {
      int test(List<String> list, TestParam tp) {
        int loops = tp.loops * reps;
        int listSize = list.size();
        for(int i = 0; i < loops; i++)
          list.set(rand.nextInt(listSize), TESTSTR);
        return loops;
      }
    });
    tests.add(new Test<List<String>>("iteradd") {
      int test(List<String> list, TestParam tp) {
        final int LOOPS = 1000000;
        int half = list.size() / 2;
        ListIterator<String> it = list.listIterator(half);
        for(int i = 0; i < LOOPS; i++)
          it.add(TESTSTR);
        return LOOPS;
      }
    });
    tests.add(new Test<List<String>>("insert") {
      int test(List<String> list, TestParam tp) {
        int loops = tp.loops;
        for(int i = 0; i < loops; i++)
          list.add(5, TESTSTR); // Minimize random-access cost
        return loops;
      }
    });
    tests.add(new Test<List<String>>("remove") {
      int test(List<String> list, TestParam tp) {
        int loops = tp.loops;
        int size = tp.size;
        for(int i = 0; i < loops; i++) {
          list.clear();
          
          for(int j = 0; j < size; j++) list.add(TESTSTR);// TODO This may RUIN THE TEST!!!!!
          
          while(list.size() > 5)
            list.remove(5); // Minimize random-access cost
        }
        return loops * size;
      }
    });
    // Tests for queue behavior:
    
    qTests.add(new Test<LinkedList<String>>("sort") {
		int test(LinkedList<String> list, TestParam tp) {
			int loops = tp.loops;
			for(int i = 0; i < loops; i++) {
				list.sort(String.CASE_INSENSITIVE_ORDER);
			}
			return loops;
		}
	});
    
    qTests.add(new Test<LinkedList<String>>("addFirst") {
      int test(LinkedList<String> list, TestParam tp) {
        int loops = tp.loops;
        int size = tp.size;
        for(int i = 0; i < loops; i++) {
          list.clear();
          for(int j = 0; j < size; j++)
            list.addFirst(TESTSTR);
        }
        return loops * size;
      }
    });
    qTests.add(new Test<LinkedList<String>>("addLast") {
      int test(LinkedList<String> list, TestParam tp) {
        int loops = tp.loops;
        int size = tp.size;
        for(int i = 0; i < loops; i++) {
          list.clear();
          for(int j = 0; j < size; j++)
            list.addLast(TESTSTR);
        }
        return loops * size;
      }
    });
    qTests.add(
      new Test<LinkedList<String>>("rmFirst") {
        int test(LinkedList<String> list, TestParam tp) {
          int loops = tp.loops;
          int size = tp.size;
          for(int i = 0; i < loops; i++) {
            list.clear();

            for(int j = 0; j < size; j++) list.add(TESTSTR);// TODO This may RUIN THE TEST!!!!!

            
            while(list.size() > 0)
              list.removeFirst();
          }
          return loops * size;
        }
      });
    qTests.add(new Test<LinkedList<String>>("rmLast") {
      int test(LinkedList<String> list, TestParam tp) {
        int loops = tp.loops;
        int size = tp.size;
        for(int i = 0; i < loops; i++) {
          list.clear();

          for(int j = 0; j < size; j++) list.add(TESTSTR);// TODO This may RUIN THE TEST!!!!!

          while(list.size() > 0)
            list.removeLast();
        }
        return loops * size;
      }
    });
  }
  static class ListTester extends Tester<List<String>> {
    public ListTester(List<String> container,
        List<Test<List<String>>> tests) {
      super(container, tests);
    }
    // Fill to the appropriate size before each test:
    @Override protected List<String> initialize(int size){
      container.clear();

      for(int j = 0; j < size; j++) container.add(TESTSTR);// TODO This may RUIN THE TEST!!!!!
      
      return container;
    }
    // Convenience method:
    public static void run(List<String> list,
        List<Test<List<String>>> tests) {
      new ListTester(list, tests).timedTest();
    }
  }
  public static void main(String[] args) {
    if(args.length > 0)
      Tester.defaultParams = TestParam.array(args);
    // Can only do these two tests on an array:
    Tester<List<String>> arrayTest =
      new Tester<List<String>>(null, tests.subList(1, 3)){
        // This will be called before each test. It
        // produces a non-resizeable array-backed list:
        @Override protected
        List<String> initialize(int size) {
          String[] sa = Generated.array(String.class,
            new CountingGenerator.String(), size);
          return Arrays.asList(sa);
        }
      };
    arrayTest.setHeadline("Array as List");
//    arrayTest.timedTest();
    Tester.defaultParams= TestParam.array(
      10, 5000, 100, 5000, 1000, 1000, 10000, 200);
    if(args.length > 0)
      Tester.defaultParams = TestParam.array(args);
    ListTester.run(new FastTraversalLinkedList<String>(), tests);
    ListTester.run(new ArrayList<String>(), tests);
    ListTester.run(new LinkedList<String>(), tests);
//    ListTester.run(new Vector<String>(), tests);
    Tester.fieldWidth = 12;
    Tester<LinkedList<String>> qTest =
      new Tester<LinkedList<String>>(
        new LinkedList<String>(), qTests);
    qTest.setHeadline("Queue tests");
    qTest.timedTest();
  }
} /* Output: (Sample)
--- Array as List ---
 size     get     set
   10     130     183
  100     130     164
 1000     129     165
10000     129     165
--------------------- ArrayList ---------------------
 size     add     get     set iteradd  insert  remove
   10     121     139     191     435    3952     446
  100      72     141     191     247    3934     296
 1000      98     141     194     839    2202     923
10000     122     144     190    6880   14042    7333
--------------------- LinkedList ---------------------
 size     add     get     set iteradd  insert  remove
   10     182     164     198     658     366     262
  100     106     202     230     457     108     201
 1000     133    1289    1353     430     136     239
10000     172   13648   13187     435     255     239
----------------------- Vector -----------------------
 size     add     get     set iteradd  insert  remove
   10     129     145     187     290    3635     253
  100      72     144     190     263    3691     292
 1000      99     145     193     846    2162     927
10000     108     145     186    6871   14730    7135
-------------------- Queue tests --------------------
 size    addFirst     addLast     rmFirst      rmLast
   10         199         163         251         253
  100          98          92         180         179
 1000          99          93         216         212
10000         111         109         262         384
*///:~
