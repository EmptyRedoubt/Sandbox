package com.SaladinA.HS.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import com.SaladinA.HS.model.Person;
@Repository
public class PreconfiguredPersonRepository implements PersonRepository{
	private static AtomicInteger counter = new AtomicInteger(0);
	List personStorage = new ArrayList();
	
	public static boolean isNumeric(String strNum) {
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException | NullPointerException nfe) {
	        return false;
	    }
	    return true;
	}
	
	@Override
	public Person save(Person person) {
		person.setId(counter.incrementAndGet());
		personStorage.add(person);
		return person;
	}

	@Override
	public List findAll() throws IOException {
		personStorage = readPeopleCSV();
		for(Object p : personStorage) {
			System.out.println(p);
		}
		personStorage.remove(0);
		return personStorage;
	}
	public List readPeopleCSV() throws IOException {
		List people = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader("importPeople.csv"));
		String line = "";
		while((line =  br.readLine()) != null && !line.isEmpty()) {
			List<String> newPersonDataList = new ArrayList<String>();
			String combine = "";
			String[] personData = line.split(",");
			boolean goodString = true;
			boolean first = true;
			String newString = "";
			for(String s : personData) {
				char [] dataArray = s.toCharArray();
				int length = dataArray.length - 1;
				if((s.charAt(0) == '"' && s.charAt(length) != '"') || (s.charAt(0) != '"' && s.charAt(length) == '"')) {
					//if(dataArray[0] == '"' && dataArray[length] != '"') {
					if(s.charAt(0) == '"' && s.charAt(length) != '"') {
						newString = s.substring(2, length + 1);
						first = true;
					}else {
						newString = s.substring(0, length - 1);
						first = false;
					}
					goodString = false;
				}else {					
					if(!isNumeric(s)) {
					newString = s.substring(1);
					newString = newString.substring(0, length - 1);
					}else {
						newString = s;
					}
					goodString = true;
				}
				if(goodString) {					
					newPersonDataList.add(newString);
				}else if(!goodString && first){
					combine = newString;
				}else {
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
