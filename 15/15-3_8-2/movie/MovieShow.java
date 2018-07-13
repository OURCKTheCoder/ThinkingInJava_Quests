package movie;

import storycharacters.*;
import java.util.*;

public class MovieShow{
	private static final ArrayList<String> NAMES = new ArrayList<String>();
	static {
		Collections.addAll(NAMES, "Stark", "Robin", "Jack", "Captain", "Kirito", "JARVIS");
	}

	private class CharacterGenerator implements Iterable<StoryCharacters> {
		private Random rand = new Random(47);
		private String randName() { return NAMES.get(rand.nextInt(NAMES.size())); }
		private int iterateTimes;
		public CharacterGenerator(int num) { iterateTimes = num; }
		public StoryCharacters next() { // Can use for single test.
			int flag = rand.nextInt(2);
			if(flag == 0) return new GoodGuy(randName());
			if(flag == 1) return new BadGuy(randName());
			else return new GoodGuy(randName()); //There're always goodguys in the world!
		}
		public Iterator<StoryCharacters> iterator(){
			return new Iterator<StoryCharacters>(){
				public boolean hasNext() { return iterateTimes > 0;}
				public StoryCharacters next() { iterateTimes--; return CharacterGenerator.this.next(); }
			};
		}
	}
	
	public static void main(String[] args) {
		MovieShow myMovie = new MovieShow();
		MovieShow.CharacterGenerator characters = myMovie.new CharacterGenerator(25);
		
		for(StoryCharacters c : characters){
			c.doIt();
		}
	}
	
}

