package Day02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Day02_Solution {
	public static void main(String[] args) {
		try{
			BufferedWriter bwriter = new BufferedWriter(new OutputStreamWriter(System.out));
			// Part 1
			bwriter.write("Dive part1: " + part1() + "\n");
			// Part 2
			bwriter.write("Dive part2: " + part2());
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
		int horizontal = 0, depth = 0;
		try{
			// Read input from file
			File file = new File("src/Day02/Day02_Input.txt");
			BufferedReader breader = new BufferedReader(new FileReader(file));
			String st = "";
			while((st = breader.readLine()) != null) {
				StringTokenizer token = new StringTokenizer(st);
				String command = token.nextToken();
				int measurement = Integer.parseInt(token.nextToken());
				switch (command) {
					case "forward" :
						horizontal += measurement;
						break;
					case "down" :
						depth += measurement;
						break;
					case "up" :
						depth -= measurement;
						break;
				}
			}
		} catch (
				FileNotFoundException e) {
			e.printStackTrace();
		} catch (
				IOException e) {
			e.printStackTrace();
		}
		return horizontal * depth;
	}

	private static long part2() {
		int horizontal = 0, depth = 0, aim = 0;
		try{
			File file = new File("src/Day02/Day02_Input.txt");
			BufferedReader breader = new BufferedReader(new FileReader(file));
			String st = "";
			while((st = breader.readLine()) != null) {
				StringTokenizer token = new StringTokenizer(st);
				String command = token.nextToken();
				int measurement = Integer.parseInt(token.nextToken());
				switch (command) {
					case "forward" :
						horizontal += measurement;
						depth += aim*measurement;
						break;
					case "down" :
						aim += measurement;
						break;
					case "up" :
						aim -= measurement;
						break;
				}
			}
		} catch (
				FileNotFoundException e) {
			e.printStackTrace();
		} catch (
				IOException e) {
			e.printStackTrace();
		}
		return horizontal * depth;
	}
}
