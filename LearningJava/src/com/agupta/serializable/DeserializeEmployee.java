package com.agupta.serializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeEmployee {
	public static void main(String args[]) {
		Employee e = null;
		try {
			FileInputStream fileInput = new FileInputStream("/tmp/Employee.ser");
			ObjectInputStream in = new ObjectInputStream(fileInput);
			e = (Employee) in.readObject();
			in.close();
			fileInput.close();
		} catch(IOException i) {
			i.printStackTrace();
		} catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
		e.printName();
	}
}