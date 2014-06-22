package com.example.philiptictactoe;

public class Player {
	
	String name;
	private int stats;
	
	public Player(String string) {
		this.name = string;
		this.stats = 0;
	}
	
	public void setStats(int statistics) {
		this.stats = statistics;
	}
	
	public int getStats() {
		return this.stats;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
