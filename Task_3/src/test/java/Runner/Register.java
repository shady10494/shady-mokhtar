package Runner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.ahmed.excelizer.ExcelReader;

import MainPackage.BaseClass;

public class Register extends BaseClass {

	@DataProvider(name = "DataProviderForUsers")
	public Object[][] userRegister() {
		return ExcelReader.loadTestData(ExcelPath, SheetRegister);
	}

	@Test(dataProvider="DataProviderForUsers")
	public void registerAccountWithEmail(
	String FirstName , String SurName, String Mobile,String ConfirmEmail, String Password,
	String Day , String Month, String Year, String Gender , String Pronoun) throws InterruptedException{

		String title = driver.getTitle();
		if (title != EnglishTitle) {
			findXpath_Click(EnglishButtonXpath);
		}		
		System.out.println("changed english");
		findXpath_Click(NewAccountXpath);
		WaitXpath(10, FirstNameXpath);

		findXpath_SendKeys(FirstNameXpath, FirstName);
		findXpath_SendKeys(SurNameXpath, SurName);

		findXpath_SendKeys(EmailOrPhoneXpath, Mobile);
		if (Mobile.startsWith("t")) {
			findXpath_SendKeys(ConfirmEmailXpath, ConfirmEmail);
		}
		findXpath_SendKeys(PasswordRegXpath, Password);
		if (Day != "") {
			selectDropdownMenu(BirthDayXpath, Day);
		}
		if (Month != "") {
			selectDropdownMenu(BirthMonthXpath, Month);
		}
		if(Year != "") {
			selectDropdownMenu(BirthYearXpath, Year);
		}
		findXpath_Click(GenderXpathPart1 + Gender + GenderXpathPart2);
		if (Gender == "Custom") {
			selectDropdownMenu(pronounXpath, Pronoun);
		}

		Thread.sleep(2000);
		driver.quit();

	}
}



