/*
#todo:
Sort single column in a file, then output it to a text file. 

######################
intput.txt 

56
Suresh
Mahesh
Abhi
81
Vikas
Bhavani
Nalini
62

######################
output.txt

56
62
81
Abhi
Bhavani
Mahesh
Nalini
Suresh
Vikas


*/



import java.io.*;
import java.util.*;
class SingleColumn {
	public static void main(String[] args) {
		BufferedReader reader = null;
		BufferedWriter writer = null;
		ArrayList<String> lines = new ArrayList<>();

		try {
			reader = new BufferedReader(new FileReader("input.txt"));
			String currentLine = reader.readLine();
			while(currentLine != null) {
				lines.add(currentLine);
				currentLine = reader.readLine();
			}
			Collections.sort(lines);
			writer = new BufferedWriter(new FileWriter("output.txt"));
			for(String line: lines) {
				writer.write(line);
				writer.newLine();
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(reader != null) reader.close();
				if(writer != null) writer.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
