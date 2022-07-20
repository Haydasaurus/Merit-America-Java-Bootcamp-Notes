package com.techelevator.search;

public class WordLocation {

	private int fileID;
	private int location;
	
	public WordLocation(int fileID, int location) {
		this.fileID = fileID;
		this.location = location;
	}
	
	public int getFileID() {
		return this.fileID;
	}
	
	public int getLocation() {
		return this.location;
	}

	public int distanceFrom(WordLocation wl) {
		return wl.getLocation() - this.location;
	}
	
	@Override
	public String toString() {
		return "" + fileID + "-" + location;
	}
	
}
