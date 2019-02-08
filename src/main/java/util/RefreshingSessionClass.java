package util;

import mbeans.ViagemList;

public class RefreshingSessionClass {

	private static ViagemList viagemList;

	public static ViagemList getViagemList() {
		return viagemList;
	}

	public static void setViagemList(ViagemList viagemList) {
		RefreshingSessionClass.viagemList = viagemList;
	}

	public static void refreshAll() {
		if (viagemList != null) {
			viagemList.findAll();
		}
	}

}
