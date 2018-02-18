package rz.ciklum.domain;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.Random;
import org.junit.*;

import rz.ciklum.generator.DateGenerator;
import rz.ciklum.generator.UserCredentialsGenerator;
import rz.ciklum.generator.NumberGenerator;


/**
 * Test to register 5 users in the web http://demoqa.com/registration/
 */
public class RegistrationPageTest {

    WebDriver driver = new ChromeDriver();
    RegistrationPage registrationPage = new RegistrationPage(driver);
    Random rad = new Random();
    UserCredentialsGenerator UserCredentials = new UserCredentialsGenerator();
    NumberGenerator numberGenerator = new NumberGenerator();
    DateGenerator dateGenerator = new DateGenerator();
    int usersToRegister = 5;
    int registeredUsers = 0;
    
    //Users provided in the email
    public static final UsersCiklum user0 = new UsersCiklum("Jan","Dam");
    public static final UsersCiklum user1 = new UsersCiklum("Chack","Norris");
    public static final UsersCiklum user2 = new UsersCiklum("Klark","Kent");
    public static final UsersCiklum user3 = new UsersCiklum("John","Daw");
    public static final UsersCiklum user4 = new UsersCiklum("Bat","Man");
    public static final UsersCiklum user5 = new UsersCiklum("Tim","Los");
    public static final UsersCiklum user6 = new UsersCiklum("Dave","Core");
    public static final UsersCiklum user7 = new UsersCiklum("Pay","Pal");
    public static final UsersCiklum user8 = new UsersCiklum("Lazy","Cat");
    public static final UsersCiklum user9 = new UsersCiklum("Jack","Johnes");
    
    ArrayList<UsersCiklum> usersDataList = new ArrayList<UsersCiklum>();
    ArrayList<UsersCiklum> usersRegisteredList = new ArrayList<UsersCiklum>();


    @Before
    public void setUp() {
    	String driverPath = ".\\libs\\";
    	System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
    }

    @Test
    public void registerNewUser() {
    	
		usersDataList.add(user0);
		usersDataList.add(user1);
		usersDataList.add(user2);
		usersDataList.add(user3);
		usersDataList.add(user4);
		usersDataList.add(user5);
		usersDataList.add(user6);
		usersDataList.add(user7);
		usersDataList.add(user8);
		usersDataList.add(user9);
		
    	for(int i=0; i<usersToRegister; i++) {
    		int userRandomPosition = rad.nextInt(usersDataList.size()-1);
    		UsersCiklum currentUser = usersDataList.get(userRandomPosition);
    		
    	    String firstName = currentUser.getFirstname();
    	    String lastName = currentUser.getLastName();
    	    
    	    String password = UserCredentials.createPassword(15);
    	    
    	    String rootPicture = "C:\\demoqa-ciklum\\Profile_Pictures\\pic"+i+".png";

    	    String year = dateGenerator.generateYear();
    	    String month = dateGenerator.generateMonth();
    	    String day = dateGenerator.generateDay(month, year);
    	    String phone = RandomStringUtils.randomNumeric(10);
    	    String username = UserCredentials.createUsername(firstName, lastName, 14);
    	    String email = firstName+lastName+RandomStringUtils.randomNumeric(5)+"@gmail.com";
    	    String description = "This is the registration test for "+firstName+" "+lastName;
    	    
    	    
    		registrationPage.openPage();
    		
	        registrationPage.setFirstNameField(firstName);
	        registrationPage.setLastNameField(lastName);
	        registrationPage.selectMaritalStatus(numberGenerator.randomNumberfrom0(3));
	        registrationPage.selectHobby(numberGenerator.randomNumberfrom0(3));
	        registrationPage.selectCountryField();
	        registrationPage.selectMonthField(month);
	        registrationPage.selectDayField(day);
	        registrationPage.selectYearField(year);
	        registrationPage.setPhoneField(phone);
	        registrationPage.setUsernameField(username);
	        registrationPage.setEmailField(email);
	        registrationPage.setRootPicture(rootPicture);
	        registrationPage.setDescriptionField(description);
	        registrationPage.setPasswordField(password);
	        registrationPage.setConfirmPasswordField(password);
	        registrationPage.submit();
	        
	        if(registrationPage.notificationForRegistration()) {
	        	registeredUsers++;
	        	usersRegisteredList.add(usersDataList.get(userRandomPosition));
	        	usersDataList.remove(userRandomPosition);
	        }
    	}
    	
        if(registeredUsers == usersToRegister) {
        	Assert.assertTrue(true);
        	
        	System.out.println("List of user NOT registered: "+usersDataList.size()+" in total\n");
            for(UsersCiklum elem : usersDataList){
                System.out.println(elem.getFirstname()+" "+elem.getLastName()+"\n");
            }

        }else {
        	Assert.assertTrue(false);
        	
        	System.out.println("List of user registered: "+usersRegisteredList.size()+" in total\n");
            for(UsersCiklum elem : usersRegisteredList){
                System.out.println(elem.getFirstname()+" "+elem.getLastName()+"\n");
            }
        }
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
