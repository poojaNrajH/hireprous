package adminpage1;

import java.io.IOException;



import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import configuration.config;
import configuration.objectlocators;
import exceldata.exceldata;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class adminstepdef {
	
       //private static final CharSequence CustomerName = null;
	static WebDriver driver;
       int row;
   	XSSFSheet sheet;
       
       
    @Given("User has to navigate to Hirepros login page")
	public void user_has_to_navigate_to_hirepros_login_page() {
		System.setProperty("webdriver.chrome.driver", config.driverPath);
		driver = new ChromeDriver();
		driver.get(config.url);
		driver.manage().window().maximize();
       }

	@When("User enter username and password for Hirepros")
	public void user_enter_username_and_password_for_hirepros() {
		System.out.println("inside Step - User enter username and password for Hirepros");
	    driver.findElement(By.name(objectlocators.userName)).sendKeys(config.username);
		driver.findElement(By.name(objectlocators.password)).sendKeys(config.password);
	}

	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {
		System.out.println("inside Step -User clicks on Login button");
	    driver.findElement(By.xpath(objectlocators.loginBtn)).click();
	}

	@Then("User will be logged in successfully")
	public void user_will_be_logged_in_successfully() throws InterruptedException {
		Thread.sleep(2000);
	}

	// ********************************Business unit****************************************\\
  @Given("User navigates to the Business Unit page of the Configuration")
  public void user_navigates_to_the_business_unit_page_of_the_configuration() throws InterruptedException {
	
   driver.findElement(By.xpath(objectlocators.configbtn)).click();
   driver.findElement(By.xpath(objectlocators.Bubtn)).click();
   Thread.sleep(2000);
  }

  @When("User clicks on New Business Unit button")
  public void user_clicks_on_new_business_unit_button() throws InterruptedException {
	Thread.sleep(2000);
    driver.findElement(By.xpath(objectlocators.newBUunit)).click();
}

  @And("User Enters data to Business Unit name and manager name")
  public void user_enters_data_to_business_unit_name_and_manager_name() throws InterruptedException {
	Thread.sleep(2000);
	driver.findElement(By.xpath(objectlocators.buName)).sendKeys(config.AddBuname);
    //WebElement ele = driver.findElement(By.name(objectlocators.Selectname));
    Select sel =new Select (driver.findElement(By.xpath(objectlocators.managername)));
    sel.selectByVisibleText(" Kamal p ");
    Thread.sleep(2000);
    }

  @And("User clicks on Save button and navigate to Business Unit list page")
  public void user_clicks_on_save_button_and_navigate_to_business_unit_list_page() throws InterruptedException {
    driver.findElement(By.xpath(objectlocators.savebtn)).click();
    Thread.sleep(2000);
}
//*************************************customer creation************************************//
  @Given("User navigates to the customer page of the Configuration")
  public void user_navigates_to_the_customer_page_of_the_configuration() throws InterruptedException {
	  
	  driver.findElement(By.xpath(objectlocators.configbtn)).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath(objectlocators.customerbtn)).click();
  }

  @When("User clicks on new customer unit button")
  public void user_clicks_on_new_customer_unit_button() throws InterruptedException {
      Thread.sleep(2000);
      driver.findElement(By.xpath(objectlocators.newcustomerbtn)).click();
  }

  @And("User Enters data to customer name,location,region field")
  public void user_enters_data_to_customer_name_location_region_field() throws InterruptedException, IOException {
	  Thread.sleep(3000);
		String CustomerName = exceldata.getExcelData(config.excelsheet, "Customers", "2", "0");
		driver.findElement(By.xpath(objectlocators.customername)).sendKeys(CustomerName); // enter customer field
		Thread.sleep(1000);
		String CustomerLocation = exceldata.getExcelData(config.excelsheet, "Customers", "2", "1");
		driver.findElement(By.xpath(objectlocators.location)).sendKeys(CustomerLocation);
		Thread.sleep(1000);
		String Region  = exceldata.getExcelData(config.excelsheet, "Customers", "3", "2");
		driver.findElement(By.xpath(objectlocators.region)).sendKeys(Region );
  }

  @And("User clicks on save button and navigate to customer list page")
  public void user_clicks_on_save_button_and_navigate_to_customer_list_page() {
     driver.findElement(By.xpath(objectlocators.customersavebtn)).click();
  }

//*********************************************project creation************************************************//
  @Given("User navigates to the Project page in the Configuration")
  public void user_navigates_to_the_project_page_in_the_configuration() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(objectlocators.configbtn)).click();
	  Thread.sleep(2000);
      driver.findElement(By.xpath(objectlocators.projectbtn)).click();
  }

  @When("User clicks on New Project button")
  public void user_clicks_on_new_project_button() throws InterruptedException {
	  Thread.sleep(2000);
      driver.findElement(By.xpath(objectlocators.newprojectbtn)).click();
  }

  @And("User Enters data to Project name and business unit and customer from dropdown for project creation")
  public void user_enters_data_to_project_name_and_business_unit_and_customer_from_dropdown_for_project_creation() throws InterruptedException, IOException {
	  Thread.sleep(3000);
	  String ProjectName = exceldata.getExcelData(config.excelsheet, "project creation", "1", "0");
      driver.findElement(By.xpath(objectlocators.projectname)).sendKeys(ProjectName);
	 
      Select businessUnit = new Select( driver.findElement(By.xpath(objectlocators.businessunitname)));
      businessUnit.selectByVisibleText("   abc   ");
      Thread.sleep(2000);
      Select customerId =new Select (driver.findElement(By.xpath(objectlocators.customerselect)));
      customerId.selectByVisibleText( "  Applied Materials  " );
      Thread.sleep(2000);
  }

  @And("User clicks on Save button and navigate to view Project list page")
  public void user_clicks_on_save_button_and_navigate_to_view_project_list_page() throws InterruptedException {
	  Thread.sleep(2000);
      driver.findElement(By.xpath(objectlocators.projectcreationsavebtn)).click();
  }

  @Then("User redirects to the configuration page")
  public void user_redirects_to_the_configuration_page() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(objectlocators.configbtn)).click();
  }
  //****************************************recruitment role************************************//
  @Given("User navigates to the Recruitment Role menu in the Configuration")
  public void user_navigates_to_the_recruitment_role_menu_in_the_configuration() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(objectlocators.configbtn)).click();
	  Thread.sleep(2000);
      driver.findElement(By.xpath(objectlocators.recruitmentrole)).click();
      }

  @When("User clicks on New Recruitment Role button")
  public void user_clicks_on_new_recruitment_role_button() throws InterruptedException {
	  Thread.sleep(2000);
      driver.findElement(By.xpath(objectlocators.newrecruitmentbtn)).click();
  }

  @And("User Enters data to Recruitment Role name field and verifies")
  public void user_enters_data_to_recruitment_role_name_field_and_verifies() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(objectlocators.recruitmentrolename)).sendKeys(config.recname);
  }

  @And("User clicks on Save button and navigate to view Recruitment Role list page")
  public void user_clicks_on_save_button_and_navigate_to_view_recruitment_role_list_page() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(objectlocators.recsavebtn)).click();
  }

  @Then("User can search Recruitment name in search text-box")
  public void user_can_search_recruitment_name_in_search_text_box() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(objectlocators.recsearchtextboxbtn)).click();
	  driver.findElement(By.xpath(objectlocators.recsearchtextboxbtn)).sendKeys(config.recname);
	  driver.findElement(By.xpath(objectlocators.recsearchbtn)).click();
	  Thread.sleep(2000);
  }

//***************************************services[resource management]*******************************************************//
  @Given("User clicks on Services")
  public void user_clicks_on_services() throws InterruptedException {
     driver.findElement(By.xpath(objectlocators.servicesbtn)).click(); 
     Thread.sleep(2000);
     }

  @When("User clicks on Resource Management button")
  public void user_clicks_on_resource_management_button() throws InterruptedException {
      driver.findElement(By.xpath(objectlocators.resourcemngmntbtn)).click();
      Thread.sleep(2000);
  }

  @And("User clicks on New Resource Management button")
  public void user_clicks_on_new_resource_management_button() throws InterruptedException {
      driver.findElement(By.xpath(objectlocators.newresourcebtn)).click();
      Thread.sleep(2000);
  }

  @Then("User Enters data to EmployeeId, EmployeeId By HR, WorkOrderNumber, Employment Type, FirstName, LastName, ContactNo, Email, Gender, Project Allocation,CustomerName, Project Name, Business Unit, Designation,Year Of Experience, Skillset field and verifies")
  public void user_enters_data_to_employee_id_employee_id_by_hr_work_order_number_employment_type_first_name_last_name_contact_no_email_gender_project_allocation_customer_name_project_name_business_unit_designation_year_of_experience_skillset_field_and_verifies() throws IOException, InterruptedException {
	  String EmployeeID = exceldata.getExcelData(config.excelsheet, "resourcemanagement", "1", "0");
		driver.findElement(By.xpath(objectlocators.employeeid)).sendKeys(EmployeeID);
		Thread.sleep(1000);
		String EmployeeIDByHR = exceldata.getExcelData(config.excelsheet, "resourcemanagement", "1", "1");
		driver.findElement(By.xpath(objectlocators.employeeidbyHR)).sendKeys(EmployeeIDByHR);
		Thread.sleep(1000);
		String WorkOrderNumber = exceldata.getExcelData(config.excelsheet, "resourcemanagement", "1", "2");
		driver.findElement(By.xpath(objectlocators.workordernumber)).sendKeys(WorkOrderNumber);
		Thread.sleep(1000);
		Select EmploymentType  = new Select( driver.findElement(By.xpath(objectlocators.employmenttype)));
		EmploymentType .selectByVisibleText("   Full Time   ");
	    Thread.sleep(2000);
	    String FirstName = exceldata.getExcelData(config.excelsheet, "resourcemanagement", "1", "3");
		driver.findElement(By.xpath(objectlocators.firstname)).sendKeys(FirstName);
		Thread.sleep(1000);
		String LastName = exceldata.getExcelData(config.excelsheet, "resourcemanagement", "1", "4");
		driver.findElement(By.xpath(objectlocators.lastname)).sendKeys(LastName);
		Thread.sleep(1000);
		String ContactNumber = exceldata.getExcelData(config.excelsheet, "resourcemanagement", "1", "5");
		driver.findElement(By.xpath(objectlocators.contactnumber)).sendKeys(ContactNumber);
		Thread.sleep(1000);
		String Email  = exceldata.getExcelData(config.excelsheet, "resourcemanagement", "1", "6");
		driver.findElement(By.xpath(objectlocators.RSMemail)).sendKeys(Email );
		Thread.sleep(1000);
		WebElement radio = driver.findElement(By.xpath(objectlocators.gender));
		radio.click();
		Thread.sleep(1000);
		Select ProjectAllocation  = new Select( driver.findElement(By.xpath(objectlocators.projectallocation)));
		ProjectAllocation .selectByVisibleText("   Yes  ");
	    Thread.sleep(2000);
	    Select CustomerName  = new Select( driver.findElement(By.xpath(objectlocators.RSMcustomername)));
	    CustomerName .selectByVisibleText("    Alchemy / HCL   ");
	    Thread.sleep(2000);
	    Select ProjectName  = new Select( driver.findElement(By.xpath(objectlocators.RSMprojectname)));
	    ProjectName .selectByVisibleText("  Select Project  ");
	    Thread.sleep(2000);
	    Select BusinessUnit  = new Select( driver.findElement(By.xpath(objectlocators.RSMbu)));
	    BusinessUnit .selectByVisibleText("  Select Project  ");
	    Thread.sleep(2000);
	    String Designation = exceldata.getExcelData(config.excelsheet, "resourcemanagement", "1", "7");
		driver.findElement(By.xpath(objectlocators.RSMdesignation)).sendKeys(Designation);
		Thread.sleep(1000);
		String YearOfExperience = exceldata.getExcelData(config.excelsheet, "resourcemanagement", "1", "8");
		driver.findElement(By.xpath(objectlocators.yearofexperience)).sendKeys(YearOfExperience);
		Thread.sleep(1000);
		String SkillSet = exceldata.getExcelData(config.excelsheet, "resourcemanagement", "1", "9");
		driver.findElement(By.xpath(objectlocators.skillset)).sendKeys(SkillSet);
		Thread.sleep(1000);
		}

  @And("User clicks on Save button and navigate to view Resources list page")
  public void user_clicks_on_save_button_and_navigate_to_view_resources_list_page() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(objectlocators.RSMsavebtn)).click();
  }

  @And("User verify the added Resource by searching")
  public void user_verify_the_added_resource_by_searching() throws InterruptedException {
	  Thread.sleep(2000);
      driver.findElement(By.xpath(objectlocators.searchbyfullname)).sendKeys(config.searchbyname);
      driver.findElement(By.xpath(objectlocators.RSMsearchbtn)).click();
  }
  //*************************************vendor management***********************************//
@Given("User navigates to the Vendor Management page of the service")
  public void user_navigates_to_the_vendor_management_page_of_the_service() throws InterruptedException {
	//Thread.sleep(1000);
  driver.findElement(By.xpath(objectlocators.servicesbtn)).click();
	Thread.sleep(1000);
  }
  @When("User clicks on Vendor Management button")
public void user_clicks_on_vendor_management_button() throws InterruptedException {
  Thread.sleep(2000);
  driver.findElement(By.xpath(objectlocators.vendorbtn)).click();
}

@And("User clicks on New Vendor Management button")
public void user_clicks_on_new_vendor_management_button() throws InterruptedException {
  Thread.sleep(2000);
  driver.findElement(By.xpath(objectlocators.newvendor)).click();
}

@Then("User Enters data to VendorName, ContactNo, Email,Location,and CCEmailIDs field and verifies")
public void user_enters_data_to_vendor_name_contact_no_email_location_and_cc_email_i_ds_field_and_verifies() throws IOException, InterruptedException {
  String VendorName = exceldata.getExcelData(config.excelsheet, "vendormanagement", "1", "0");
	driver.findElement(By.xpath(objectlocators.vendorname)).sendKeys(VendorName);
	Thread.sleep(1000);
	String ContactNumber = exceldata.getExcelData(config.excelsheet, "vendormanagement", "1", "1");
	driver.findElement(By.xpath(objectlocators.vencontactnum)).sendKeys(ContactNumber);
	Thread.sleep(1000);
	String Email  = exceldata.getExcelData(config.excelsheet, "vendormanagement", "1", "2");
	driver.findElement(By.xpath(objectlocators.vendoremail)).sendKeys(Email );
	Thread.sleep(1000);
	String Location  = exceldata.getExcelData(config.excelsheet, "vendormanagement", "1", "3");
	driver.findElement(By.xpath(objectlocators.venlocation)).sendKeys(Location );
	Thread.sleep(1000);
	
	Select VendorPriority  = new Select( driver.findElement(By.xpath(objectlocators.vendorpriority)));
	VendorPriority .selectByVisibleText("   Primary   ");
    Thread.sleep(2000);
    
    String CCEmailIDs   = exceldata.getExcelData(config.excelsheet, "vendormanagement", "1", "4");
	driver.findElement(By.xpath(objectlocators.ccmail)).sendKeys(CCEmailIDs  );
	Thread.sleep(1000);
	
}

@And("User clicks on Save button and navigate to view Vendor list page")
public void user_clicks_on_save_button_and_navigate_to_view_vendor_list_page() throws InterruptedException {
  Thread.sleep(1000);
	driver.findElement(By.xpath(objectlocators.vendorsavebtn)).click();

}

@And("User verify the added Vendor by searching")
public void user_verify_the_added_vendor_by_searching() throws InterruptedException {
  Thread.sleep(2000);
  driver.findElement(By.xpath(objectlocators.vendorsearchtextboxbtn)).click();
  driver.findElement(By.xpath(objectlocators.vendorsearchtextboxbtn)).sendKeys(config.vendorsearchbyname);
  driver.findElement(By.xpath(objectlocators.vendorsearchbtn)).click();
  Thread.sleep(2000);
}
}

