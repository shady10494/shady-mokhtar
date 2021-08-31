package MainPackage;

public class Variables {

	// These are the variables used in the project
	public String FacebookUrl = "https://www.facebook.com";
	public String ExcelPath = "data\\Test Data.xlsx";
	public String SheetRegister = "Register";
	public String SheetLogin = "Login";
	public String EnglishTitle = "Facebook – log in or sign up";

	// These are the variables for Homepage
	public String EnglishButtonXpath = "//a[@title = \"English (UK)\"]";
	public String NewAccountXpath = "//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']";

	// These are the variables used in the registreation form
	public String FirstNameXpath = "//input[@name= 'firstname']";
	public String SurNameXpath = "//input[@name= 'lastname']";
	public String EmailOrPhoneXpath = "//input[@name= 'reg_email__']";
	public String ConfirmEmailXpath = "//input[@name=\"reg_email_confirmation__\"]";
	public String PasswordRegXpath = "//input[@name= 'reg_passwd__']";
	public String BirthDayXpath = "//select[@name= 'birthday_day']";
	public String BirthMonthXpath = "//select[@name= 'birthday_month']";
	public String BirthYearXpath = "//select[@name= 'birthday_year']";
	public String GenderXpathPart1 = "//label[contains(text(),'";
	public String GenderXpathPart2 = "')]";
	public String pronounXpath = "//select[@name='preferred_pronoun']";
	public String SignUpXpath = "//button[@name = 'websubmit']";

	// These are the variables used in the Login page
	public String EmailXpath = "//input[@name='email']";
	public String passwordXpath = "//input[@name='pass']";
	public String loginBtnXpath = "//button[@name='login']";
}
