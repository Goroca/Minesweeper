package com.minesweeper;

import java.util.Random;

public class Methods {
	public static Mine[][] board;
	private final static int CHAR_OFFSET = 65;

	/**
	 * @param dim
	 * @param totalMines
	 */
	public static void startBoard(int dim, int totalMines) {
		board = new Mine[dim][dim];
		int totalBoxes = dim * dim;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				Mine aux = new Mine();
				board[i][j] = aux;
			}
		}
		setMines(dim, totalMines);
		setAround();
	}

	public static void setMines(int dim, int totalMines) {
		int setMines = 0;

		while (setMines <= totalMines) {
			int random1 = new Random().nextInt(dim);
			int random2 = new Random().nextInt(dim);
			board[random1][random2].setActive(true);
			setMines++;
		}
	}

	public static void setAround() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				int totalAround = 0;
				if (i > 0) {
					if (board[i - 1][j].isActive())
						totalAround++;
				}
				if (j > 0) {
					if (board[i][j - 1].isActive())
						totalAround++;
				}
				if (i < (board.length - 1)) {
					if (board[i + 1][j].isActive())
						totalAround++;
				}
				if (j < (board[i].length - 1)) {
					if (board[i][j + 1].isActive())
						totalAround++;
				}
				board[i][j].setAround(totalAround);
			}
		}

	}

	public static void showBoard() {
		for (int i = 0; i < board.length; i++) {
			int row = i + 1;
			if (row < 10)
				System.out.print(' ');
			System.out.print(row + " [ ");
			for (Mine mine : board[i]) {
				System.out.print(mine.showMine() + ' ');
			}
			System.out.println(']');
		}
		String column = "     ";
		for (int i = 0; i < board.length; i++) {
			column = column + (char) (CHAR_OFFSET + i) + ' ';
		}
		System.out.println(column);

	}

	public static void revelateBox(int row, char column) {
		int intColumn = (int) column - CHAR_OFFSET;
		board[row - 1][intColumn].setHidden(false);
	}

}