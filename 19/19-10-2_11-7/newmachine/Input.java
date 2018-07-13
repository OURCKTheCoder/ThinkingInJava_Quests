package ourck.newmachine;

import java.util.*;

class ExInput { // Extended input.
	private Input input;
	private Item selectedItem;
	public ExInput(Input input, Item item) {
		this.input = input; this.selectedItem = item;
	}
	public ExInput(Input input) {
		this.input = input;
	}
	public Input getInput() { return input; }
	public Item getSelectedItem() { return selectedItem; }
	public boolean isAItemSelection() { return selectedItem == null; }
	public int amount() { return input.value; }
	public String toString() { return selectedItem.toString(); }
}

enum Input {
  NICKEL(5), DIME(10), QUARTER(25), DOLLAR(100),
  ITEM, // TOOTHPASTE(200), CHIPS(75), SODA(100), SOAP(50),
  ABORT_TRANSACTION {
    public int amount() { // Disallow
      throw new RuntimeException("ABORT.amount()");
    }
  },
  STOP { // This must be the last instance.
    public int amount() { // Disallow
      throw new RuntimeException("SHUT_DOWN.amount()");
    }
  };

  int value; // In cents
  Input(int value) { this.value = value; }
  Input() {}
  int amount() { return value; }; // In cents
  static Random rand = new Random(47);
  public static Input randomSelection() {
    // Don't include STOP:
    return values()[rand.nextInt(values().length - 1)];
  }
}

class Item {
	private static final List<Item> itemList = 
			new ArrayList<Item>();
	static {
		Collections.addAll(itemList, 
				new Item("TOOTHPASTE", 200),
				new Item("CHIPS", 75),
				new Item("SODA", 100),
				new Item("SOAP", 50));
	}
	private String name;
	private int index;
	public Item(String name, int index) {
		this.name = name; this.index = index;
	}
	public String toString() { return name + index; }
	public void add(Item i) { itemList.add(i); }
	public static Item randomGenerate() { return new Item("DarkMatter", 666); }
}
