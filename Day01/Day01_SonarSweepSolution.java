package Day01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Day01_SonarSweepSolution {
    public static void main(String[] args) {
		try {
			// Read input from file
			File file = new File("src/Day01/Day01_Input.txt");
			BufferedReader breader = null;
			int[] inputs = new int[2000];
			String token; int index = 0;
			breader = new BufferedReader(new FileReader(file));
			while((token = breader.readLine()) != null) {
				inputs[index++] = Integer.parseInt(token);
			}

			BufferedWriter bwriter = new BufferedWriter(new OutputStreamWriter(System.out));

			// Part 1
			bwriter.write("Sonar Sweep Part1: " + part1(inputs) + "\n");

			// Part 2
			bwriter.write("Sonar Sweep Part2: " + part2(inputs));
			bwriter.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	private static int part1(int[] inputs) {
		int increasedDepthMeasurements = 0;
		for(int index = 1; index < inputs.length; index++)
			if(inputs[index-1] < inputs[index])
				increasedDepthMeasurements++;
		return increasedDepthMeasurements;
	}

	private static int part2(int[] inputs) {
		int increased3SlidingDepthMeasurements = 0;
		for(int index = 1; index < inputs.length - 2; index++) {
			int prevSlidingWindow = inputs[index - 1] + inputs[index] + inputs[index + 1];
			int currSlidingWindow = inputs[index] + inputs[index + 1] + inputs[index + 2];
			if (prevSlidingWindow < currSlidingWindow)
				increased3SlidingDepthMeasurements++;
		}
		return increased3SlidingDepthMeasurements;
	}
}
