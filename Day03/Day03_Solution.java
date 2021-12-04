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

public class Day03_Solution {
	static int[] frequencyBits;
	static List<String> inputs = new ArrayList<>();
	static int numberOfBits;
	public static void main(String[] args) {
		try{
			BufferedWriter bwriter = new BufferedWriter(new OutputStreamWriter(System.out));
			// Part 1
			bwriter.write("Binary Diagnostic part1: " + part1() + "\n");
			// Part 2
			bwriter.write("Binary Diagnostic part2: " + part2());
			bwriter.flush();
		} catch (IOException e) {
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
			numberOfBits = st.length();
			frequencyBits = new int[numberOfBits];
			Arrays.fill(frequencyBits, 0);
			do {
				inputs.add(st);
				for(int i = 0; i < st.length(); i++) {
					if(st.charAt(i) == '1') {
						frequencyBits[i]++;
					}
				}
			} while((st = breader.readLine()) != null);

			for(int i = 0; i < frequencyBits.length; i++) {
				if(frequencyBits[i] > inputs.size()-frequencyBits[i]) {
					gammarate += Math.pow(2,(frequencyBits.length - i - 1));
				} else {
					epsilonrate += Math.pow(2,(frequencyBits.length - i - 1));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return gammarate * epsilonrate;
	}

	private static long part2() {
		List<String> o2 = new ArrayList<String>(inputs);
		List<String> co2 = new ArrayList<String>(inputs);
		char prevFreqBit = 'a';
		for(int m = 0; m < numberOfBits && o2.size() > 1; m++) {
			int onesCount = 0;
			for(int n = 0; n < o2.size() && o2.size() > 1; n++) {
				if(m != 0) {
					char prevBit = o2.get(n).charAt(m - 1);
					if (prevFreqBit != prevBit) {
						o2.remove(n);
						n--;
						continue;
					}
				}
				char currBit = o2.get(n).charAt(m);
				if(currBit == '1')
					onesCount++;
			}

			if(onesCount >= o2.size()-onesCount)
				prevFreqBit = '1';
			else
				prevFreqBit = '0';
		}

		for(int n = 0; n < o2.size() && o2.size() > 1; n++) {
			char prevBit = o2.get(n).charAt(numberOfBits-1);
				if (prevFreqBit != prevBit) {
					o2.remove(n);
					n--;
					continue;
				}
			}
		// CO2
		for(int m = 0; m < numberOfBits && co2.size() > 1; m++) {
			int onesCount = 0;
			for(int n = 0; n < co2.size() && co2.size() > 1; n++) {
				if(m != 0) {
					char prevBit = co2.get(n).charAt(m - 1);
					if (prevFreqBit != prevBit) {
						co2.remove(n);
						n--;
						continue;
					}
				}
				char currBit = co2.get(n).charAt(m);
				if(currBit == '1')
					onesCount++;
			}

			if(onesCount >= co2.size()-onesCount)
				prevFreqBit = '0';
			else
				prevFreqBit = '1';
		}

		for(int n = 0; n < co2.size() && co2.size() > 1; n++) {
			char prevBit = co2.get(n).charAt(numberOfBits-1);
			if (prevFreqBit != prevBit) {
				co2.remove(n);
				n--;
				continue;
			}
		}

		int o2GeneratorRating = 0, co2ScruberRating = 0;
		String o2Final = o2.get(0);
		for(int i = 0; i < o2Final.length(); i++) {
			int currBit = Integer.parseInt(String.valueOf(o2.get(0).charAt(i)));
			o2GeneratorRating += currBit * Math.pow(2, numberOfBits - i - 1);
		}
		String co2Final = co2.get(0);
		for(int i = 0; i < co2Final.length(); i++) {
			int currBit = Integer.parseInt(String.valueOf(co2Final.charAt(i)));
			co2ScruberRating += currBit * Math.pow(2, numberOfBits - i - 1);
		}

		return o2GeneratorRating * co2ScruberRating;
	}
}
