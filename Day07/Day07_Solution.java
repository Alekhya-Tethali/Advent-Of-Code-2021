package Day07;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Day07_Solution {
	public static void main(String[] args) {
		int[] inputs = readInput();
		int max = inputs[inputs.length - 2], min = inputs[inputs.length - 1];
		System.out.println("The Treachery of Whales part1: " + part1(inputs));
		System.out.println("The Treachery of Whales part2: " + part2(inputs));
	}

	private static int part1(int[] inputs) {
		int minFuel = Integer.MAX_VALUE;
		int max = inputs[inputs.length - 2], min = inputs[inputs.length - 1];
		for(int i = min; i < max; i++) {
			int fuel = 0;
			for(int j = 0; j < inputs.length-2; j++) {
					fuel += Math.abs(i - inputs[j]);
			}
			if(minFuel > fuel)
				minFuel = fuel;
		}
		return minFuel;
	}

	private static int part2(int[] inputs) {
		int minFuel = Integer.MAX_VALUE;
		int max = inputs[inputs.length - 2], min = inputs[inputs.length - 1];
		for(int i = min; i < max; i++) {
			int fuel = 0;
			for(int j = 0; j < inputs.length-2; j++) {
				int diff = Math.abs(i - inputs[j]);
				fuel += (diff * (diff+1))/2;
			}
			if(minFuel > fuel)
				minFuel = fuel;
		}
		return minFuel;
	}

	private static int[] readInput() {
		try {
			File file = new File("src/Day07/Day07_Input.txt");
			BufferedReader breader = new BufferedReader(new FileReader(file));
			String st = breader.readLine();
			String[] input = st.split(",");
			int[] inputs = new int[input.length + 2];
			int i = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
			for(String s : input) {
				int ip = Integer.parseInt(s);
				inputs[i++] = ip;
				if(ip > max) {
					max = ip;
				}
				if(ip < min) {
					min = ip;
				}
			}
			inputs[i++] = max; inputs[i++] = min;
			return inputs;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new int[]{-1};
	}
}