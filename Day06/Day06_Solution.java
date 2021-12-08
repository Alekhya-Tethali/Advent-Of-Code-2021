package Day06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


// Incorrect solution working on it
public class Day06_Solution {
	public static void main(String[] args) {
		ArrayList<Integer> fish = readInput();
		System.out.println(fish);
		BufferedWriter bwriter = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			bwriter.write("Lanternfish part1: " + countLanternFish(fish, 18));
//			bwriter.write("Lanternfish part2: " + countLanternFish(fish, 256));
			bwriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static int countLanternFish(ArrayList<Integer> fish, int days) {
		int d = 0;
		while(d++ < days) {
			int N = fish.size();
			for(int f = 0; f < N; f++) {
				int currFish = fish.get(f);
				if(currFish == 0) {
					fish.set(f, 6);
					fish.add(8);
				} else {
					fish.set(f, currFish - 1);
				}
			}
		}
		return fish.size();
	}

	private static ArrayList<Integer> readInput() {
		ArrayList<Integer> fish = new ArrayList<>();
		try {
			File file = new File("src/Day06/Day06_Sample_Input.txt");
			BufferedReader breader = new BufferedReader(new FileReader(file));
			String input = breader.readLine();
			String[] inputs = input.split(",");
			for(String i : inputs) {
				fish.add(Integer.parseInt(i));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fish;
	}
}
