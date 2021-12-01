import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Day01_Solution {
    public static void main(String[] args) {
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			bw.write("Sonar Sweep : " + sonarSweep());
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	private static int sonarSweep() {
		File file = new File("src/Day01/Day01_Input.txt");
		BufferedReader br = null;
		int counter = 0;
		try {
			br = new BufferedReader(new FileReader(file));
			String token = br.readLine();
			int prev = Integer.parseInt(token);
			while((token = br.readLine()) != null) {
				int curr = Integer.parseInt(token);
				if(prev < curr)
					counter++;
				prev = curr;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return counter;
	}
}
