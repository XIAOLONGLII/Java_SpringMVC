/*
###########
input.txt

Suresh 56
Mahesh 89
Shyam 81
Vikas 92
Shloka 84
Nalini 62
Abhi 71
Bhavani 68

input2.txt

51
ASuresh
BMahesh
CAbhi
80
DVikas
EBhavani
FNalini
62


###########

output3.txt

51
56
62
62
80
81
ASuresh
Abhi
BMahesh
Bhavani
CAbhi
DVikas
EBhavani
FNalini
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
		BufferedReader reader2 = null;
		BufferedWriter writer = null;
		ArrayList<String> lines = new ArrayList<>();

		try {
			reader = new BufferedReader(new FileReader("input.txt"));
			String currentLine = reader.readLine();
			while(currentLine != null) {
				lines.add(currentLine);
				currentLine = reader.readLine();
			}


			reader2 = new BufferedReader(new FileReader("input2.txt"));
			String currentLine2 = reader2.readLine();
			while(currentLine2 != null) {
				lines.add(currentLine2);
				currentLine2 = reader2.readLine();
			}	


			Collections.sort(lines);
			writer = new BufferedWriter(new FileWriter("output3.txt"));
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
