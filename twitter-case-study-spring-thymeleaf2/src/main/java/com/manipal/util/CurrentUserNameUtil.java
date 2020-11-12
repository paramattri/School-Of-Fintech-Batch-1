package com.manipal.util;

public class CurrentUserNameUtil {
	
	private static String currentUserName;

	public static String getCurrentUserName() {
		return currentUserName;
	}

	public static void setCurrentUserName(String currentUserName) {
		CurrentUserNameUtil.currentUserName = currentUserName;
	}
	
}
