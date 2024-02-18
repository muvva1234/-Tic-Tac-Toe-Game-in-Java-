package com.tic_tac_toe;

import java.util.HashSet;
import java.util.Scanner;

public class Tic_Tac_Toe_Game {
	// HashSet to track user and CPU moves
	static HashSet<Integer> userSet = new HashSet<>();
	static HashSet<Integer> CPUSet = new HashSet<>();

	public static void main(String[] args) {
		// Initial Tic_Tac_Toe game board
		String[][] game_board = { { " ", " ", "|", " ", " ", " |", " ", " " },
				{ "-", " ", "|", " ", " ", " |", " ", "-" }, { " ", " ", "|", " ", " ", " |", " ", " " },
				{ "-", " ", "|", " ", " ", " |", " ", "-" }, { " ", " ", "|", " ", " ", " |", " ", " " } };

		// tic_tac_toe_Board(game_board);
		System.out.println("Welcome to play the Tic Tac Toe game! Let's have some fun and may the best player win!!");
		System.out.println("Here the Board");
		tic_tac_toe_Board(game_board);
		System.out.println("Let start the game");

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter the section number from 1 to 9:");
			int userOption = sc.nextInt();
			sc.nextLine();
			// Validate user input for valid section
			while (userSet.contains(userOption) || CPUSet.contains(userOption)) {
				System.out.println("your have choosed wrong Section,Choose the right section");
				System.out.println("Enter the section number from 1 to 9:");
				userOption = sc.nextInt();
			}
			// Place user move on the board

			placeHolder(game_board, userOption, "you");
			String result = winningConditions();
			if (result.length() > 0) {
				System.out.println(result);
				break;
			}
			System.out.println();
			// CPU makes a move
			int CPUOption = CPU_decision();
			while (userSet.contains(CPUOption) || CPUSet.contains(CPUOption)) {
				CPUOption = CPU_decision();
			}
			// Place CPU move on the board
			placeHolder(game_board, CPUOption, "CPU");
			result = winningConditions();
			if (result.length() > 0) {
				System.out.println(result);
				break;
			}

		}
	}

	// Method to generate a random CPU move
	public static int CPU_decision() {
		// max-range 1 to 9
		int max = 9;
		int min = 1;
		return (int) (Math.random() * max) + min;
	}
	// Method to check winning conditions

	public static String winningConditions() {
		// similarly define hash sets for other rows, columns, and diagonals
		HashSet<Integer> r1 = new HashSet<>();
		r1.add(1);
		r1.add(2);
		r1.add(3);
		HashSet<Integer> r2 = new HashSet<>();
		r2.add(4);
		r2.add(5);
		r2.add(6);
		HashSet<Integer> r3 = new HashSet<>();
		r3.add(7);
		r3.add(8);
		r3.add(9);
		HashSet<Integer> c1 = new HashSet<>();
		c1.add(1);
		c1.add(4);
		c1.add(7);
		HashSet<Integer> c2 = new HashSet<>();
		c2.add(2);
		c2.add(5);
		c2.add(8);
		HashSet<Integer> c3 = new HashSet<>();
		c3.add(3);
		c3.add(6);
		c3.add(9);
		HashSet<Integer> d1 = new HashSet<>();
		d1.add(1);
		d1.add(5);
		d1.add(9);
		HashSet<Integer> d2 = new HashSet<>();
		d2.add(3);
		d2.add(5);
		d2.add(7);

		HashSet<HashSet> allSets = new HashSet<>();
		allSets.add(r1);
		allSets.add(r2);
		allSets.add(r3);
		allSets.add(c1);
		allSets.add(c2);
		allSets.add(c3);
		allSets.add(d1);
		allSets.add(d2);
		// Check if a winning condition is met
		for (HashSet hs : allSets) {
			if (userSet.containsAll(hs)) {
				return "Congratulations,You Won";
			} else if (CPUSet.containsAll(hs)) {
				return "You Lost,Try Again";
			}
		}
		// Check for a draw
		if (userSet.size() + CPUSet.size() == 9) {
			return "Draw Match";
		}
		return "";

	}

	// Method to display the Tic_Tac_Toe board
	public static void tic_tac_toe_Board(String[][] game_board) {
		for (int i = 0; i < game_board.length; i++) {
			for (int j = 0; j < game_board[0].length; j++) {
				System.out.print(game_board[i][j]);
			}
			System.out.println();
		}
	}

	// Method to place a move on the board
	public static void placeHolder(String[][] game_board, int postions, String user) {

		String symbol = "X";
		if (user.equalsIgnoreCase("you")) {
			symbol = "X";
			userSet.add(postions);
		} else if (user.equalsIgnoreCase("CPU")) {
			symbol = "O";
			CPUSet.add(postions);
		}
		// Update the game board with the move
		switch (postions) {
		case 1:
			game_board[0][0] = symbol;
			break;
		case 2:
			game_board[0][4] = symbol;
			break;
		case 3:
			game_board[0][6] = symbol;
			break;
		case 4:
			game_board[2][0] = symbol;
			break;
		case 5:
			game_board[2][4] = symbol;
			break;
		case 6:
			game_board[2][6] = symbol;
			break;

		case 7:
			game_board[4][0] = symbol;
			break;
		case 8:
			game_board[4][4] = symbol;
			break;

		case 9:
			game_board[4][6] = symbol;
			break;

		default:
			System.out.println("invalid postion ,select the right one");

		}
		// Display the updated board
		tic_tac_toe_Board(game_board);

	}


}
