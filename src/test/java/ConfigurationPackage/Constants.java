package ConfigurationPackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Constants {

		public static WebDriver driver;
		
		public static String rootpath = System.getProperty("user.dir");
		
		public static void chromeBrowser() {
			
			System.setProperty("webdriver.chrome.driver" , "D:\\WORK\\Drivers\\ChromeDriverv2.37\\chromedriver.exe");
			 driver = new ChromeDriver();
			
		}
		
		public static void firefoxBrowser(){
			
			System.setProperty("webdriver.gecko.driver" , "D:\\WORK\\Drivers\\GeckoDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		@SuppressWarnings("deprecation")
		public static void IEBrowser(){
			/*
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);*/
			
			System.setProperty("webdriver.ie.driver", "D:\\WORK\\Drivers\\IEDriver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			//driver = new InternetExplorerDriver(capabilities);
		}
		

	

}
