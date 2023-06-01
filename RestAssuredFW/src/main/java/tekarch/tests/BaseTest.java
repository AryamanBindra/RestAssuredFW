package tekarch.tests;

import org.testng.annotations.BeforeClass;

import tekarch.reusables.LoginUtils;

public class BaseTest {
	LoginUtils lu = null;

	@BeforeClass
	public void SetUp() {
		lu = new LoginUtils();
	}

}
