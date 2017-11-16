package bst;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BinaryStuff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<StudentGPA> arr = new ArrayList<StudentGPA>();
		
		File students = new File("students.in");
		try {
			Scanner scan = new Scanner(students);
			while(scan.hasNext()) {
				String s1 = scan.nextLine();
				String[] result = s1.split("\\s");
				if(result.length == 3) {
					arr.add(new StudentGPA(Integer.parseInt(result[0]),result[1],Double.parseDouble(result[2])));
				} else {
					arr.add(new GraduateStudentGPA(Integer.parseInt(result[0]),result[1], Double.parseDouble(result[2]), result[3]));
				}
			}
		
			BinarySearchTree<StudentGPA> tree = new BinarySearchTree<StudentGPA>();
			for(int i = 0; i < arr.size(); i++) {
				System.out.println(arr.get(i));
				tree.insert(arr.get(i));
			}
			TreeIterator<StudentGPA> iter = new TreeIterator<StudentGPA>(tree);
			iter.setInorder();
			while(iter.hasNext()) {
				StudentGPA temp = iter.next();
				System.out.println("-_-_-_-_-_-_-_-_-_-_-");
				System.out.println("GPA: " + temp.GPA);
				System.out.println("Name: " + temp.name);
				System.out.println("ID: " + temp.id);
			}
			scan.close();
			
		
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
