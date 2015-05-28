package countOccurences;

import hashMapToString.HashMapToString;

import java.util.HashMap;
import java.util.Map;

public class Occurences {
	public static Map<String, Integer> countOccurneces(String text){ 
		String[] textToWords = text.split(" ");
		Map<String, Integer> countOccur = new HashMap<String, Integer>();
		for (String word : textToWords) { 
			if (!countOccur.containsKey(word)) {
				countOccur.put(word, 1);
			}
			else {
				countOccur.replace(word, countOccur.get(word), countOccur.get(word) + 1);
			}
				
		}
		return countOccur;
	}
	
	public static void main(String[] args) {
		
		Map<String, Integer> result = Occurences.countOccurneces("Ninjas are all over the place! We are all going to die!");
		System.out.println(HashMapToString.printHashMap(result));
	}
}
