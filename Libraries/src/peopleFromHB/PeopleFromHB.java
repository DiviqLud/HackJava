package peopleFromHB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class PeopleFromHB {
	private static PeopleFromHB instance = new PeopleFromHB();

	private PeopleFromHB() {

	}

	public static PeopleFromHB getInstance() {
		return instance;
	}

	public String getHtmlFromUrl(String url) throws IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(url);
		HttpResponse response = httpClient.execute(request);
		HttpEntity entity = response.getEntity();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				entity.getContent()));

		StringBuilder html = new StringBuilder();
		String line;

		while ((line = br.readLine()) != null) {
			html.append(line);
		}

		return html.toString();
	}

	public void getPeopleByCourses(String url) throws IOException,
			JSONException {
		String html = getHtmlFromUrl(url);

		JSONArray jsonArray = new JSONArray(html);

		int size = jsonArray.length(); // get totalCount of all jsonObjects
		for (int i = 0; i < size; i++) { // iterate through jsonArray
			JSONObject jsonObject = jsonArray.getJSONObject(i); // get
																// jsonObject @
																// i position
			JSONArray courses = (JSONArray) jsonObject.get("courses");
			if (courses.length() > 1) {
				System.out.println(jsonObject.get("name"));
			}
		}
	}

	public Map<String, Integer> getPeopleByCheckins(String url) throws IOException,
			JSONException {
		String html = getHtmlFromUrl(url);

		Map<String, Integer> people = new HashMap<String, Integer>();

		JSONArray jsonArray = new JSONArray(html.toString());

		int size = jsonArray.length();
		for (int i = 0; i < size; i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			String name = jsonObject.getString("student_name");
			if (!people.containsKey(name)) {
				people.put(name, 1);
			} else {
				people.replace(name, people.get(name), people.get(name) + 1);
			}
		}
		return people;
	}
	
	public void printPeopleByCheckins(String url) throws IOException, JSONException {
		Map<String, Integer> people = getPeopleByCheckins(url);
		Map<String, Integer> sortedPeople = ValueComparator.sortByValue(people);
		for (String key : sortedPeople.keySet()) {
			System.out.println("Name: " + key + " Times seen: " + sortedPeople.get(key));
		}
	}

}
