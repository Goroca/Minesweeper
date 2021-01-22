package com.minesweeper;

public class Mine {
	private boolean active;
	private int around;
	private boolean targeted;
	private boolean hidden;

	
	public Mine() {
		// TODO Auto-generated constructor stub
		active = true;
		around = 0;
		targeted = false;
		hidden = true;
	}
	
	public String showMine() {
		String s = "";
		if (targeted)
				s = "T";
		else if (hidden) {
			s = "X";
		}
		else if (active) {
			s = "B";
		}
		else {
			s = Integer.toString(around);
		}
		return s;
	}

}
