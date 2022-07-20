package com.techelevator.search;

public class WordDistance {

	private int fileID;
	private int distance;
	
	public WordDistance(int fileID, int distance) {
		this.fileID = fileID;
		this.distance = distance;
	}
	
	public int getFileID() {
		return this.fileID;
	}
	
	public int getDistance() {
		return this.distance;
	}
}
