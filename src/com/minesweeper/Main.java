package com.minesweeper;

import java.io.*;

public class Main extends Methods {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// STANDAR : 8 x 8 casillas y 10 minas.
		startBoard(20, 10);
		showBoard();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Select ROW and COLOMN");
		String text = in.readLine();
		revelateBox(text.charAt(0), text.charAt(1));
		showBoard();

	}

}
