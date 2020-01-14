/*

###########
input1.txt

Suresh 56
Mahesh 89
Shyam 81
Vikas 92
Shloka 84
Nalini 62
Abhi 71
Bhavani 68


###########
output1.txt

student name student marks
Vikas 92
Mahesh 89
Shloka 84
Shyam 81
Abhi 71
Bhavani 68
Nalini 62
Suresh 56



*/


import java.io.*;
import java.util.*;
class Student {
	String name;
	int marks;
	public Student(String name, int marks){
		this.name = name;
		this.marks = marks;
	}
}
class nameCompare implements Comparator<Student> {
	@Override
	public int compare (Student s1, Student s2) {
		return s1.name.compareTo(s2.name);
	}
}
class marksCompare implements Comparator<Student> {
	@Override
	public int compare (Student s1, Student s2) {
		return s2.marks - s1.marks;
	}
}
public class SortMultiColumns {

	public static void main(String[] args) {
		try {


			BufferedReader reader = new BufferedReader(new FileReader("input1.txt"));
			ArrayList<Student> studentRecords = new ArrayList<>();
			String currentLine = reader.readLine();
			while(currentLine != null) {
				String[] studentDetails = currentLine.split(" ");
				String name = studentDetails[0];
				int marks = Integer.valueOf(studentDetails[1]);
				studentRecords.add(new Student(name, marks));
				currentLine = reader.readLine();
			}
			Collections.sort(studentRecords, new marksCompare());
			BufferedWriter writer = new BufferedWriter(new FileWriter("output2.txt"));
			writer.write("student name");
			writer.write(" student marks");
			writer.newLine();
			for(Student student: studentRecords) {
				writer.write(student.name);
				writer.write(" "+student.marks);
				writer.newLine();
			}
			reader.close();
			writer.close();
		}
		 catch(IOException e) {
			e.printStackTrace();
		}
	}
}




