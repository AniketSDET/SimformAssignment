package Tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import ConfigurationPackage.Super;

public class StoriCam_Operations extends Super {

	public StoriCam_Operations (WebDriver driver){
		
		this.driver = driver ; 
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy (xpath = "//input[@name = 'txtSecurityCode']") WebElement SecurityCodeTextBox ;
	@FindBy (xpath = "//button[contains(text(),'Validate')]") WebElement Validate;
	@FindBy (id = "login-email") WebElement Email_or_ChannelName ; 
	@FindBy (id = "login-pwd") WebElement Password ;
	@FindBy (xpath = "//i[@ng-class = 'vm.eyeclass']") WebElement Eye ;
	@FindBy (xpath = "//button[contains(text(),'Login')]") WebElement Login ;
	@FindBy (xpath = "//div[@id = 'toast-container']//div[@ng-class = 'toaster.type']//div[@class = 'toast-message']//div[@class='ng-binding ng-scope']") WebElement alert; ;
	
	
	
	
	
	
	public void TestCase1() throws InterruptedException{
		
		String url = driver. getCurrentUrl();
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(url, "https://storicam.austinconversionoptimization.com/#/login");
		
		SecurityCodeTextBox.sendKeys("1234567");
		Validate.click();
		
		/*WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.alertIsPresent());*/
		try{
			Thread.sleep(1000);
			String alertText = alert.getText();
			Assert.assertEquals(alertText, "Invalid security code");
			
		}catch(NoSuchElementException n){
			System.out.println("Trying Again");
			Validate.click();
			String alertText = alert.getText();
			Assert.assertEquals(alertText, "Invalid security code");
		}
		
		
		SecurityCodeTextBox.clear();
		SecurityCodeTextBox.sendKeys("123456");
		Validate.click();
		Email_or_ChannelName.sendKeys("Chintan");
		Password.sendKeys("Simform@123");
		Eye.click();
		Login.click();
		
	}
	
	@FindBy(xpath = "//a[@class = 'dropdown-toggle dropdown-icon']") WebElement Setting ;
	@FindBy(xpath = "//a[contains(text(),'Edit Profile')]") WebElement EditProfile ;
	@FindBy(css = "ul.profile-follow-count>li:nth-of-type(1)>a>div>p") WebElement Stories ; 
	@FindBy(css = "ul.profile-follow-count>li:nth-of-type(2)>a>div>p") WebElement Posts ; 
	@FindBy(css = "ul.profile-follow-count>li:nth-of-type(3)>a>div>p") WebElement VIP ;
	@FindBy(css = "ul.profile-follow-count>li:nth-of-type(4)>a>div>p") WebElement Followers ;
	@FindBy(css = "ul.profile-follow-count>li:nth-of-type(5)>a>div>p") WebElement Following ;
	@FindBy(css = "ul.profile-follow-count>li:nth-of-type(6)>a>div>p") WebElement Favourites ;
	@FindBy(css = "ul.profile-follow-count>li:nth-of-type(7)>a>div>p") WebElement Outtakes ;
	@FindBy(css = "ul.profile-follow-count>li:nth-of-type(8)>a>div>p") WebElement Selfemojis ;
	@FindBy(css = "ul.profile-follow-count>li:nth-of-type(9)>a>div>p") WebElement Comments ;
	
	@FindBy(xpath = "//span[@class='menu-text' and contains(text(),'Dashboard')]") WebElement Dashboard;
	@FindBy(xpath = "//div[@class='input-group feed-post']//input")WebElement Post ; 
	@FindBy(xpath = "//span[contains(text(),'Photo')]//following-sibling::input[@id='myimg']")WebElement Photo ; 
	@FindBy(xpath = "//a[contains(text(),'Post')]")WebElement PostButton ;
	@FindBy(xpath = "//a[@ng-click = 'vm.toggleCommentSection($index,post._id)']")WebElement Comment ;
	@FindBy(xpath = "//textarea[@class = 'ng-pristine ng-untouched ng-valid']")WebElement CommentText ;
	
	
	
	//div[@class='status-tag']//form//span[contains(text(),'Photo')]//input[@id='myimg']
	
	public void TestCase2() throws InterruptedException{
		
		Thread.sleep(5000);
		Setting.click();
		EditProfile.click();
		
		System.out.println("No. of Stories: " + Stories.getText());
		System.out.println("No. of Posts: " +Posts.getText());
		System.out.println("No. of VIP: " + VIP.getText());
		System.out.println("No. of Followers: " +Followers.getText());
		System.out.println("No. of Following: " + Following.getText());
		System.out.println("No. of Favourites: " +Favourites.getText());
		System.out.println("No. of Outtakes: " + Outtakes.getText());
		System.out.println("No. of Selfemojis: " +Selfemojis.getText());
		System.out.println("No. of Comments: " + Comments.getText());
		
		Dashboard.click();
		Post.click();
		Photo.sendKeys("C:\\Users\\abhon\\OneDrive\\Pictures\\tEblUI.jpg");
		PostButton.click();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(Comment));
		Comment.click();
		CommentText.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='TestComment'", CommentText);
		
		CommentText.sendKeys(Keys.ENTER);
	
		
	}
	
}
