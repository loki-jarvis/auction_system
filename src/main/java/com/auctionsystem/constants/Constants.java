package com.auctionsystem.constants;

public class Constants {
	
	
	public static class UserConstants{
		
		static int ADMIN = 0;
		static int REPRESENTATIVE = 1;
		static int SELLER = 2;
		static int BUYER = 3;
		public int getADMIN() {
			return ADMIN;
		}

		public static int getREPRESENTATIVE() {
			return REPRESENTATIVE;
		}

		public static int getSELLER() {
			return SELLER;
		}

		public static int getBUYER() {
			return BUYER;
		}
		
	}

}
