package Sir.com.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ScreenShot {
	
	public void takeScreeenShot() throws IOException
	{
		EventFiringWebDriver efw = new EventFiringWebDriver(BaseClass.driver);
		 File f1 = efw.getScreenshotAs(OutputType.FILE);
		 String date = new SimpleDateFormat("dd-mm-yyyy hh-MM-ss").format(new Date());
		 File f2 = new File(System.getProperty("user.dir")+"//Screenshot//"+date+".png");
		 FileUtils.copyFile(f1, f2);
	}

}
