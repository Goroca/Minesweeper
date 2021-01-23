package com.minesweeper;

import java.io.*;

public class Main extends Methods {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// STANDAR : 8 x 8 casillas y 10 minas.
		startBoard(8, 10);
		showBoard();

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Select ROW and COLOMN");
		String text = in.readLine();
		while(!revelateBox(text.charAt(0), text.charAt(1))) {
			showBoard();
			text = in.readLine();
			while (text.length()>2 && (text.charAt(0) == 'T' || text.charAt(0) == 't')) {
				targetBox(text.charAt(1), text.charAt(2));
				showBoard();
				text = in.readLine();
			}
		}

	}



}
