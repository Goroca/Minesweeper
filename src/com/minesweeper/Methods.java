package com.minesweeper;

import java.util.Random;

public class Methods {
	public static Mine[][] board;

	/**
	 * @param dim
	 * @param totalMines
	 */
	public static void startBoard(int dim, int totalMines) {
		board = new Mine[dim][dim];
		int setMines = 0;
		int totalBoxes = dim * dim;
		double probablity = ((double) totalMines) / ((double) totalBoxes);

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {

				Mine aux = new Mine();
				board[i][j] = aux;
			}
		}
	}

	public static void showBoard() {
		for (Mine[] mines : board) {
			System.out.print("[ ");
			for (Mine mine : mines) {
				System.out.print(mine.showMine() + ' ');
			}
			System.out.println(']');
		}
	}

}