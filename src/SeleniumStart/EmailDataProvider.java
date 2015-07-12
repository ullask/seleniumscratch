package SeleniumStart;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EmailDataProvider
{

	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][3];
		data[0][0] = "xyz@gmail.com";
		data[0][1] = 123;
		data[0][2] ="how are u";
		
		data[1][0] = "bcd@gmail.com";
		data[1][1] = 456;
		data[1][2] = "im good";
		return data;
		
	}
	
	@Test(dataProvider="getData")
	public void testMailSending(String to,Integer sub, String msg)
	{
		System.out.println(to+"----"+sub+"---"+msg);
	}
}
