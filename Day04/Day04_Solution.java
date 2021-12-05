package Day04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Day04_Solution {
	public static void main(String[] args) {
		try{
			BufferedWriter bwriter = new BufferedWriter(new OutputStreamWriter(System.out));
			File file = new File("src/Day04/Day04_Input.txt");
			BufferedReader breader = new BufferedReader(new FileReader(file));
			String st = breader.readLine();

			int[] numlist = Arrays.stream(st.split(",",-1)).mapToInt(Integer::parseInt).toArray();

			int leastNum = Integer.MAX_VALUE, maxNum = Integer.MIN_VALUE, winBoardResult = 0, loseBoardResult = 0;

			while((st = breader.readLine()) != null) {
				int boardSum = 0;
				HashMap<Integer, ArrayList<Integer>> board = new HashMap<>();
				for (int i = 0; i < 5; i++) {
					st = breader.readLine();
					StringTokenizer tokenizer = new StringTokenizer(st);
					for (int j = 0; j < 5; j++) {
						int num = Integer.parseInt(tokenizer.nextToken());
						boardSum += num;
						ArrayList<Integer> al = new ArrayList<>();
						al.add(i);
						al.add(j);
						board.put(num, al);
					}
				}

				int[] res = findWinNumberOfBoard(board, numlist, boardSum);

				if(res[0] != -1) {
					if(leastNum > res[0]) {
						leastNum = res[0];
						winBoardResult = res[1];
					}
					if(maxNum < res[0]) {
						maxNum = res[0];
						loseBoardResult = res[1];
					}
				}
			}

			// Part 1
			bwriter.write("Gaint Squid Winning Board Result: " + winBoardResult + "\n");

			// Part 2
			bwriter.write("Gaint Squid Losing Board Result: " + loseBoardResult);
			bwriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static int[] findWinNumberOfBoard(HashMap<Integer, ArrayList<Integer>> board, int[] numlist, int boardSum) {
		int rows[] = new int[]{0,0,0,0,0}; int cols[] = new int[]{0,0,0,0,0};

		for(int num = 0; num < numlist.length; num++) {
			int numberDrawn = numlist[num];
			if(board.containsKey(numberDrawn)) {
				boardSum -= numberDrawn;
				ArrayList<Integer> al = board.get(numberDrawn);
				rows[al.get(0)]++; cols[al.get(1)]++;

				if(rows[al.get(0)] == 5 || cols[al.get(1)] == 5)
					return new int[]{num, numberDrawn * boardSum};
			}
		}
		return new int[]{-1,-1};
	}
}
