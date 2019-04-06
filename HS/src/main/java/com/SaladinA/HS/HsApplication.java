package com.SaladinA.HS;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.SaladinA.HS.model.Person;


@SpringBootApplication(scanBasePackages="com.SaladinA")
public class HsApplication {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		SpringApplication.run(HsApplication.class, args);
//		List people = readPeopleCSV();
//		for(Object p : people) {
//			System.out.println(p);
//		}
		
        
        
		
	}
//	public static List readPeopleCSV() throws IOException {
//		List people = new ArrayList<>();
//		BufferedReader br = new BufferedReader(new FileReader("importPeople.csv"));
//		String line = "";
//		while((line =  br.readLine()) != null && !line.isEmpty()) {
//			List<String> newPersonDataList = new ArrayList<String>();
//			String combine = "";
//			String[] personData = line.split(",");
//			boolean goodString = true;
//			boolean first = true;
//			String newString = "";
//			for(String s : personData) {
//				System.out.println(s);
//				char [] dataArray = s.toCharArray();
//				System.out.println(dataArray[0]);
//				int length = dataArray.length - 1;
//				System.out.println(dataArray[length]);
//				if((s.charAt(0) == '"' && s.charAt(length) != '"') || (s.charAt(0) != '"' && s.charAt(length) == '"')) {
//					//if(dataArray[0] == '"' && dataArray[length] != '"') {
//					if(s.charAt(0) == '"' && s.charAt(length) != '"') {
//						newString = s.substring(2, length + 1);
//						System.out.println("First part String");
//						first = true;
//					}else {
//						System.out.println("Second part String");
//						newString = s.substring(0, length - 1);
//						first = false;
//					}
//					goodString = false;
//				}else {
//					System.out.println("Whole String");
//					
//					if(!isNumeric(s)) {
//						System.out.println("Not Numeric");
//					newString = s.substring(1);
//					System.out.println(newString);
//					newString = newString.substring(0, length - 1);
//					System.out.println(newString);
//					}else {
//						System.out.println("Numeric");
//						newString = s;
//					}
//					goodString = true;
//				}
//				if(goodString) {					
//					newPersonDataList.add(newString);
//				}else if(!goodString && first){
//					combine = newString;
//				}else {
//					combine = combine + "," + newString;
//					newPersonDataList.add(combine);
//				}
//			}
//			
//				String patientName = newPersonDataList.get(0);
//				String ssn = newPersonDataList.get(1);
//				String age = newPersonDataList.get(2);
//				String phoneNumber = newPersonDataList.get(3);
//				String status = newPersonDataList.get(4);
//				Person p = new Person(patientName, ssn, age, phoneNumber, status);
//				people.add(p);
//			
//			
//		}
//		br.close();
//		return people;
//		
//	}
//	public static boolean isNumeric(String strNum) {
//	    try {
//	        double d = Double.parseDouble(strNum);
//	    } catch (NumberFormatException | NullPointerException nfe) {
//	        return false;
//	    }
//	    return true;
//	}

}
