package wcCommand;

public class WordCountResult {
	private int words;
	private int lines;
	private int characters;
	
	public WordCountResult(int words, int lines, int characters) {
		setWords(words);
		setLines(lines);
		setCharacters(characters);
	}

	public int getWords() {
		return words;
	}

	public int getLines() {
		return lines;
	}

	public int getCharacters() {
		return characters;
	}

	public void setWords(int words) {
		this.words = words;
	}

	public void setLines(int lines) {
		this.lines = lines;
	}

	public void setCharacters(int characters) {
		this.characters = characters;
	}

}
