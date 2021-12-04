package Day03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day03_Solution {
	static int[] frequencyBits;
	static List<String> inputs = new ArrayList<>();
	static int readings = 0;
	public static void main(String[] args) {
		try{
			BufferedWriter bwriter = new BufferedWriter(new OutputStreamWriter(System.out));
			// Part 1
			bwriter.write("Dive part1: " + part1() + "\n");

			bwriter.flush();
		} catch (
				FileNotFoundException e) {
			e.printStackTrace();
		} catch (
				IOException e) {
			e.printStackTrace();
		}
	}

	private static long part1() {
		int gammarate = 0, epsilonrate = 0;
		try{
			// Read input from file
			File file = new File("src/Day03/Day03_Input.txt");
			BufferedReader breader = new BufferedReader(new FileReader(file));
			String st = breader.readLine();
			inputs.add(st);
			frequencyBits = new int[st.length()];
			Arrays.fill(frequencyBits, 0);
			do {
				readings++;
				inputs.add(st);
				for(int i = 0; i < st.length(); i++) {
					if(st.charAt(i) == '1') {
						frequencyBits[i]++;
					}
				}
			} while((st = breader.readLine()) != null);

			for(int i = 0; i < frequencyBits.length; i++) {
				if(frequencyBits[i] > readings-frequencyBits[i]) {
					gammarate += Math.pow(2,(frequencyBits.length - i - 1));
				} else {
					epsilonrate += Math.pow(2,(frequencyBits.length - i - 1));
				}
			}
		} catch (
				FileNotFoundException e) {
			e.printStackTrace();
		} catch (
				IOException e) {
			e.printStackTrace();
		}
		return gammarate * epsilonrate;
	}
}
