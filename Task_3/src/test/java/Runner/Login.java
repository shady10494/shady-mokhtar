package Runner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ahmed.excelizer.ExcelReader;

import MainPackage.BaseClass;

public class Login extends BaseClass {

	@DataProvider (name = "DataProviderForUsers")
	public Object[][] userRegister(){
		return ExcelReader.loadTestData(ExcelPath, SheetLogin);
	}
	@Test(dataProvider="DataProviderForUsers")
	public void registerAccountWithEmail(String Email, String Password) throws InterruptedException {
		String title = driver.getTitle();
		if (title != EnglishTitle) {
			findXpath_Click(EnglishButtonXpath);
		}		
		findXpath_SendKeys(EmailXpath, Email);
		findXpath_SendKeys(passwordXpath, Password);
		findXpath_Click(loginBtnXpath);
		Thread.sleep(3000);
		//driver.quit();
	}
	}

