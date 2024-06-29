package utilities;

import base.BaseTest;

public class WaitForElement extends BaseTest {

	public static void inTime(boolean b, int timeoutInSecs) {

		for (int i = 1; i < timeoutInSecs; i++) {
			if (b) {
				break;
			} else {
				continue;
			}
		}
	}

}
