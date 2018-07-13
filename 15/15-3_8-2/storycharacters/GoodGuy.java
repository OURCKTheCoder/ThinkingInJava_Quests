package storycharacters;

public class GoodGuy implements StoryCharacters {
	private String name;
	public GoodGuy(String name) { this.name = name; }
	public void doIt() { System.out.println(name + ": Save the world!");}
}
