package com.infosys.xmldiexample.beans;

public class Batches {
	
	int batchId;
	String batchName;
	int batchSize;
	public Batches(int batchId, String batchName, int batchSize) {
		
		this.batchId = batchId;
		this.batchName = batchName;
		this.batchSize = batchSize;
	}
	
	public void showBatchDetails()
	{
		System.out.println("Batch id "+batchId);
		System.out.println("Batch Name "+batchName);
		System.out.println("Batch Size "+batchSize*2);
		
	}
	
	

}
