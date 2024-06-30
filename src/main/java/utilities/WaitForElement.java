package utilities;

import java.time.Duration;

import base.BaseTest;

public class WaitForElement extends BaseTest {

	public static void inTime(boolean b, int timeoutInSecs) throws InterruptedException {

		for (int i = 1; i < timeoutInSecs*2; i++) {
			if (b) {
				break;
			} else {
				Thread.sleep(Duration.ofMillis(500));
				continue;
			}
		}
	}

}
