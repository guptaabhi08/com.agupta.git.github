package com.agupta.serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializableEmployee {
	public static void main(String args[]) {
		Employee employee = new Employee();
		employee.setAge(24);
		employee.setName("Abhishek");
		employee.setEmailId("agupta@amazon.com");
		try {
			FileOutputStream fileOut = new FileOutputStream("/tmp/employee.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(employee);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in /tmp/employee.ser");
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
}
