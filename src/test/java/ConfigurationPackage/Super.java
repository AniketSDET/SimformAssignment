package ConfigurationPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Super extends Constants{
	

	
	public void launch() {
		
		Constants.chromeBrowser();
		driver.get("https://storicam.austinconversionoptimization.com/#/login");
		driver.manage().window().maximize();
		
	}
	

}
