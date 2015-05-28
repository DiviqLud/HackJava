package FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SingletonMain {
	public static void main(String[] args) throws IOException {
		ParseProperties parse = ParseProperties.getInstance();
		Map<String, String> result = new HashMap<String, String>();
		result = parse.parseProperties(new File("qwerty.properties"));
		
		for (String name: result.keySet()){

            String key =name.toString();
            String value = result.get(name).toString();  
            System.out.println(key + " " + value);  
		} 
	}
}
