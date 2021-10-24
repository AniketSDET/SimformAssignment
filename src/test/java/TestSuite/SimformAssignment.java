package TestSuite;


import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


import ConfigurationPackage.Super;
import Tests.StoriCam_Operations;



public class SimformAssignment extends Super{

	
	@Test
	public void Execution() throws InterruptedException{
		
		launch();
		StoriCam_Operations SO = new StoriCam_Operations(driver);
		SO.TestCase1();
		SO.TestCase2();
		
		
		
		
	}
	
	/*@AfterTest
	public void teardown(){
		driver.quit();
	}*/
	
	
	
	
	
	
	
	
	
	
}
