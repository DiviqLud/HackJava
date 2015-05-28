package Exceptions;

import java.util.ArrayList;
import java.util.List;

public class DBConnection {
	List<User> l = new ArrayList<User>();
	
	public void add(User a) throws DatabaseCorruptedException {
		if (a.getUsername() == "" || a.getUsername() == null){
			throw new DatabaseCorruptedException("Invalid username");
		}
		l.add(a);
		
	}
	
	public static void main(String[] args) {
		User a = new User("");
		DBConnection abv = new DBConnection();
		try {
			abv.add(a);
		}
		catch (DatabaseCorruptedException db) {
			System.out.println("WTF");
		}
	}
}
