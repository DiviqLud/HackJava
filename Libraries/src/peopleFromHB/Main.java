package peopleFromHB;

import java.io.IOException;

import org.codehaus.jettison.json.JSONException;

public class Main {
	public static void main(String[] args) throws IOException, JSONException {
		PeopleFromHB instance = PeopleFromHB.getInstance();
		//instance.getPeopleByCourses("https://hackbulgaria.com/api/students/");
		//instance.printPeopleByCheckins("https://hackbulgaria.com/api/checkins/");
	}
}
