package Day05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day05_Solution {
	public static void main(String[] args) {

		// Read input
		ArrayList<Integer> x1 = new ArrayList<>(); ArrayList<Integer> x2 = new ArrayList<>();
		ArrayList<Integer> y1 = new ArrayList<>(); ArrayList<Integer> y2 = new ArrayList<>();
		readInput(x1, x2, y1, y2);
		try {
			BufferedWriter bwriter = new BufferedWriter(new OutputStreamWriter(System.out));
			int[][] graph = new int[1000][1000];
			int part1Result = part1(graph, x1, x2, y1, y2);
			bwriter.write("Hydrothermal Venture part1: " + part1Result + "\n");
			int part2Result = part2(graph, x1, x2, y1, y2);
			bwriter.write("Hydrothermal Venture part2: " + (part1Result + part2Result));
			bwriter.flush();
		} catch (IOException e ) {
			e.printStackTrace();
		}
	}

	private static int part1(int[][] graph, ArrayList<Integer> x1, ArrayList<Integer> x2, ArrayList<Integer> y1, ArrayList<Integer> y2) {
		int counter = 0;
		for(int i = 0 ; i < x1.size(); i++) {
			int m1 = x1.get(i), n1 = x2.get(i), m2 = y1.get(i), n2 = y2.get(i);
			if( m1 == m2 && n1 != n2) {
				int smaller = n1 < n2 ? n1 : n2;
				int larger = n1 > n2 ? n1 : n2;
				for(int p = smaller; p <= larger; p++) {
					graph[m1][p]++;
					if(graph[m1][p] == 2)
						counter++;
				}
			} else if (n1 == n2 && m1 != m2) {
				int smaller = m1 < m2 ? m1 : m2;
				int larger = m1 > m2 ? m1 : m2;
				for(int p = smaller; p <= larger; p++) {
					graph[p][n1]++;
					if(graph[p][n1] == 2)
						counter++;
				}
			}
		}
		return counter;
	}
	// Incomplete -- Part2 Expected answer = 20121, but I'm getting - 20099
	private static int part2(int[][] graph, ArrayList<Integer> x1, ArrayList<Integer> x2, ArrayList<Integer> y1, ArrayList<Integer> y2) {
		int counter = 0;
		for(int i = 0 ; i < x1.size(); i++) {
			int m1 = x1.get(i), n1 = x2.get(i), m2 = y1.get(i), n2 = y2.get(i);

			if (m1 != m2 && n1 != n2) {
				boolean incx = false, incy = false;
				if(m1 < m2)
					incx = true;
				if(n1 < n2)
					incy = true;

				while(m1 != m2 && n1 != n2) {
					graph[m1][n1]++;
					if(graph[m1][n1] == 2)
						counter++;
					if(incx)
						m1++;
					else
						m1--;
					if(incy)
						n1++;
					else
						n1--;
				}
			}
		}
		return counter;
	}
	private static void readInput(ArrayList<Integer> x1, ArrayList<Integer> x2, ArrayList<Integer> y1, ArrayList<Integer> y2) {
		try {
			File file = new File("src/Day05/Day05_Input.txt");
			BufferedReader breader = new BufferedReader(new FileReader(file));
			String st;
			while((st = breader.readLine()) != null) {
				StringTokenizer token = new StringTokenizer(st);
				String fromStr = token.nextToken();
				String[] from = fromStr.split(",");
				x1.add(Integer.parseInt(from[0]));
				x2.add(Integer.parseInt(from[1]));
				String toStr = token.nextToken(); // skip arrow
				toStr = token.nextToken();
				String[] to = toStr.split(",");
				y1.add(Integer.parseInt(to[0]));
				y2.add(Integer.parseInt(to[1]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
