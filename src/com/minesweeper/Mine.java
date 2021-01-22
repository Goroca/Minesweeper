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
		} else if (active) {
			s = "B";
		} else {
			s = Integer.toString(around);
		}
		return s;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getAround() {
		return around;
	}

	public void setAround(int around) {
		this.around = around;
	}

	public boolean isTargeted() {
		return targeted;
	}

	public void setTargeted(boolean targeted) {
		this.targeted = targeted;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

}
