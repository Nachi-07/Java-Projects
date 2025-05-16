package com.MultiThread.www;

public class SeatReserve implements Runnable {
	private int wantedseats=1;
	private int availableseat;
	SeatReserve(int availableseat ){
		
		this.availableseat=availableseat;
	}
	
	public synchronized void run () {
		String name = Thread.currentThread().getName();
		if(availableseat>=wantedseats) {
			
		System.out.println("Chintu Your going home njoy pandogoo..."+ name);
		availableseat--;
		
	}
		else {
		System.out.println(name+" Emm undile nka panduko.....");
	}
		
	}
	
	public static void main(String[] args) {
		SeatReserve s = new SeatReserve(1);
		Thread t1 = new Thread(s,"Raju");
		Thread t2 = new Thread(s,"Sai");
		t1.start();
		t2.start();
		
	}

}
