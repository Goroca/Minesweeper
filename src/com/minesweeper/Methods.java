package com.minesweeper;

import java.util.Random;

public class Methods {
	public static Mine[][] board;
	public static boolean[][] checked;

	private final static int CHAR_OFFSET = 65;
	private final static int CHAR_OFFSET_2 = 97;

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

				if (i > 0 && j > 0) {
					if (board[i - 1][j - 1].isActive())
						totalAround++;
				}
				if (i < (board.length - 1) && j > 0) {
					if (board[i + 1][j - 1].isActive())
						totalAround++;
				}
				if (i < (board.length - 1) && j < (board[i].length - 1)) {
					if (board[i + 1][j + 1].isActive())
						totalAround++;
				}
				if (i > 0 && j < (board[i].length - 1)) {
					if (board[i - 1][j + 1].isActive())
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
		for (int i = 0; i < board[0].length; i++) {
			column = column + (char) (CHAR_OFFSET + i) + ' ';
		}
		System.out.println(column);

	}

	public static boolean revelateBox(char row, char column) {
		int intRow = Integer.parseInt(String.valueOf(row)) - 1;
		try {
			int intColumn = (int) (column - CHAR_OFFSET);
			board[intRow][intColumn].setHidden(false);
			if (board[intRow][intColumn].isActive()) {
				showBoard();
				System.out.println("GAME OVER");
				return true;
			}
			if (board[intRow][intColumn].getAround() == 0) {
				checked = new boolean[board.length][board[0].length];
				checked[intRow][intColumn] = true;
				concadenateRevelateBox(intRow, intColumn);

			}
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			int intColumn = (int) (column - CHAR_OFFSET_2);
			board[intRow][intColumn].setHidden(false);
			if (board[intRow][intColumn].isActive()) {
				showBoard();
				System.out.println("GAME OVER");
				return true;
			}
			if (board[intRow][intColumn].getAround() == 0) {
				checked = new boolean[board.length][board[0].length];
				checked[intRow][intColumn] = true;
				concadenateRevelateBox(intRow, intColumn);

			}
		}
		return false;
	}

	private static void concadenateRevelateBox(int i, int j) {
		board[i][j].setHidden(false);
		if (board[i][j].getAround() == 0) {

			checked[i][j] = true;
			if (i > 0) {
				if (!checked[i - 1][j])
					concadenateRevelateBox(i - 1, j);
			}
			if (j > 0) {
				if (!checked[i][j - 1])
					concadenateRevelateBox(i, j - 1);
			}
			if (i < (board.length - 1)) {
				if (!checked[i + 1][j])
					concadenateRevelateBox(i + 1, j);
			}
			if (j < (board[i].length - 1)) {
				if (!checked[i][j + 1])
					concadenateRevelateBox(i, j + 1);
			}

			if (i > 0 && j > 0) {
				if (!checked[i - 1][j - 1])
					concadenateRevelateBox(i - 1, j - 1);
			}
			if (i < (board.length - 1) && j > 0) {
				if (!checked[i + 1][j - 1])
					concadenateRevelateBox(i + 1, j - 1);
			}
			if (i < (board.length - 1) && j < (board[i].length - 1)) {
				if (!checked[i + 1][j + 1])
					concadenateRevelateBox(i + 1, j + 1);
			}
			if (i > 0 && j < (board[i].length - 1)) {
				if (!checked[i - 1][j + 1])
					concadenateRevelateBox(i - 1, j + 1);
			}
		}
	}

	public static void targetBox(char row, char column) {
		int intRow = Integer.parseInt(String.valueOf(row)) - 1;
		try {
			int intColumn = (int) (column - CHAR_OFFSET);
			board[intRow][intColumn].setTargeted(true);

		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			int intColumn = (int) (column - CHAR_OFFSET_2);
			board[intRow][intColumn].setTargeted(true);

		}
	}

}