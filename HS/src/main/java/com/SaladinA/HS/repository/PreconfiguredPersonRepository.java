package com.SaladinA.HS.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import com.SaladinA.HS.model.Person;

/**
 * This class repository allows us to create a preconfigured list of Person
 * objects in a list The list is created from data from a csv.
 * 
 * @author Amber Saladin
 *
 */
@Repository
public class PreconfiguredPersonRepository implements PersonRepository {

	private static AtomicInteger counter = new AtomicInteger(0);
	List personStorage = new ArrayList();

	/**
	 * This method checks whether or not a given string is a number
	 * 
	 * @param strNum the string to check
	 * @return boolean true or false
	 */
	public static boolean isNumeric(String strNum) {
		try {
			double d = Double.parseDouble(strNum);
		} catch (NumberFormatException | NullPointerException nfe) {
			return false;
		}
		return true;
	}

	/**
	 * An override method that saves a Person to the personStorage List
	 */
	@Override
	public Person save(Person person) {
		person.setId(counter.incrementAndGet());
		personStorage.add(person);
		return person;
	}

	/**
	 * An override method that finds all persons in a csv, Iterates through the list
	 * returned, prints each person object data to the console, and returns the
	 * personStorage list.
	 */
	@Override
	public List findAll() throws IOException {
		personStorage = readPeopleCSV();
		for (Object p : personStorage) {
			System.out.println(p);
		}
		personStorage.remove(0);
		return personStorage;
	}

	/**
	 * This method reads people data from a csv, goes through each line of data,
	 * splits the line of data into variables, rejoins variables with extra commas,
	 * eliminates bad characters, and adds the variables to create a person object.
	 * Each person object is added to the people list
	 * 
	 * @return people List
	 * @throws IOException
	 */
	public List readPeopleCSV() throws IOException {
		List people = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader("importPeople.csv"));
		String line = "";
		while ((line = br.readLine()) != null && !line.isEmpty()) {
			List<String> newPersonDataList = new ArrayList<String>();
			String combine = "";
			String[] personData = line.split(",");
			boolean goodString = true;
			boolean first = true;
			String newString = "";
			for (String s : personData) {
				char[] dataArray = s.toCharArray();
				int length = dataArray.length - 1;
				if ((s.charAt(0) == '"' && s.charAt(length) != '"')
						|| (s.charAt(0) != '"' && s.charAt(length) == '"')) {
					// if(dataArray[0] == '"' && dataArray[length] != '"') {
					if (s.charAt(0) == '"' && s.charAt(length) != '"') {
						newString = s.substring(2, length + 1);
						first = true;
					} else {
						newString = s.substring(0, length - 1);
						first = false;
					}
					goodString = false;
				} else {
					if (!isNumeric(s)) {
						newString = s.substring(1);
						newString = newString.substring(0, length - 1);
					} else {
						newString = s;
					}
					goodString = true;
				}
				if (goodString) {
					newPersonDataList.add(newString);
				} else if (!goodString && first) {
					combine = newString;
				} else {
					combine = combine + "," + newString;
					newPersonDataList.add(combine);
				}
			}
			int id = counter.incrementAndGet();
			String patientName = newPersonDataList.get(0);
			String ssn = newPersonDataList.get(1);
			String age = newPersonDataList.get(2);
			String phoneNumber = newPersonDataList.get(3);
			String status = newPersonDataList.get(4);
			Person p = new Person(id, patientName, ssn, age, phoneNumber, status);
			people.add(p);

		}
		br.close();
		return people;

	}

}
