import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SalesForceLoginUsingDatabaseTesting {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String host="localhost";
		String port="3306";
		
		Connection con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/Credentials", "root", "vairaj");
		
		Statement s=con.createStatement();
		
		ResultSet rs=s.executeQuery("select * from UserInfo where uesrname='vaishalibakale@gmail.com';");
		
		while(rs.next())
		{
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\LatestChromeDriverExe\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get("https://login.salesforce.com/?locale=in");
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			
			driver.findElement(By.xpath("//*[@id='username']")).sendKeys(rs.getString("uesrname"));
			
			driver.findElement(By.name("pw")).sendKeys(rs.getString("password"));
			
			driver.findElement(By.xpath("//*[@id='Login']")).click();
			
			System.out.println(rs.getString("uesrname"));
			
			System.out.println(rs.getString("password"));
		}
		
		
	}

}
