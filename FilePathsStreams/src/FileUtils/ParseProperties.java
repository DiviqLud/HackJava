package FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseProperties {

	private static ParseProperties instance = null;

	public static ParseProperties getInstance() {
		if (instance == null) {
			instance = new ParseProperties();
		}
		return instance;
	}

	public static void trimWhitespaces(List<Character> list) {
		List<Character> trimmedList = new ArrayList<Character>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) != ' ') {
				trimmedList.add(list.get(i));
			}
		}
		list.clear();
		list.addAll(trimmedList);
	}

	public String getKey(List<Character> list) {
		StringBuilder key = new StringBuilder();
		if (list.get(0) != '#') {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) != '=') {
					key.append(list.get(i));
				}
				else {
					return key.toString();
				}
			}
		}
		return null;
	}

	public String getValue(List<Character> list) {
		int valueStartIndex = list.indexOf('=');
		StringBuilder value = new StringBuilder();
		for (int i = valueStartIndex + 1; i < list.size(); i++) {
			value.append(list.get(i));
		}
		return value.toString();
	}

	public Map<String, String> parseProperties(File file) throws IOException {
		Map<String, String> resultMap = new HashMap<String, String>();
		List<Character> result = new ArrayList<Character>();
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		int c = 0;
		while ((c = br.read()) != -1) {
			char token = (char) c;
			if (token != '\n') {
				result.add(token);
			} else {
				if (!result.isEmpty()){	
					trimWhitespaces(result);
					if (getKey(result) != null) {
						resultMap.put(getKey(result), getValue(result));
					}
					result.clear();
				}
			}

		}
		br.close();
		return resultMap;
	}

}