package com.minesweeper;

public class Methods {
	public static Mine[][] board;
	
	public static void startBoard(int dim) {
		board = new Mine[dim][dim];
		
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
