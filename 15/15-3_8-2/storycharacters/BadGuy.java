package storycharacters;

public class BadGuy implements StoryCharacters {
	private String name;
	public BadGuy(String name) { this.name = name; }
	public void doIt() { System.out.println(name + ": DESTROY the world!!!!");}
}
