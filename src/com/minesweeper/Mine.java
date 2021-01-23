package com.minesweeper;

public class Mine {
	public enum Status {
		TARGETED, HIDDEN, UNHIDDEN;
	}

	private boolean active;
	private int around;
	private Status status;

	public Mine() {
		// TODO Auto-generated constructor stub
		active = false;
		around = 0;
		status = Status.HIDDEN;
	}

	public String showMine() {
		String s = "";
		if (Status.TARGETED.equals(status))
			s = "T";
		else if (Status.HIDDEN.equals(status)) {
			s = "X";
		} else if (active) {
			s = "B";
		} else {
			s = Integer.toString(around);
			if (around == 0)
				s = " ";
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
