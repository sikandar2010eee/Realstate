package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_039_POM_AddNewPost {
	private WebDriver driver;

	public RETC_039_POM_AddNewPost(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='user_login']")
	private WebElement userName;

	@FindBy(xpath = "//input[@id='user_pass']")
	private WebElement password;

	@FindBy(xpath = "//input[@value='Sign In']")
	private WebElement SignIn;

	@FindBy(xpath = "//div[contains(text(),'Posts')]")
	private WebElement Posts;

	@FindBy(xpath = "//li[@class='wp-first-item current']/parent::*/child::li[4]/a")
	private WebElement Categories;

	@FindBy(xpath = "//input[@id='tag-name']")
	private WebElement NameTextbox;

	@FindBy(xpath = "//input[@id='tag-slug']")
	private WebElement slugTextbox;

	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement DescriptionTextBox;

	@FindBy(xpath = "//input[@id='submit']")
	private WebElement AddNewCategory;

	@FindBy(xpath = "//div[contains(text(),'Posts')]")
	private WebElement posts;

	@FindBy(xpath = "//a[@class='page-title-action']")
	private WebElement AddNewPost;

	@FindBy(xpath = "//input[@id='title']")
	private WebElement EnterTitleHere;

	@FindBy(xpath = "//textarea[@id='content']")
	private WebElement BodyText;

	@FindBy(xpath = "//input[@id='in-category-1']")
	private WebElement CategoryCheckBox;

	@FindBy(xpath = "//input[@id='publish']")
	private WebElement Publish;

	public void sendUserName(String text) {
		this.userName.clear();
		this.userName.sendKeys(text);
	}

	public void sendPassword(String text) {
		this.password.clear();
		this.password.sendKeys(text);
	}

	public void ClickOnSignIn() {

		this.SignIn.click();

	}

	public void ClickOnPost() {
		
		//Actions action= new Actions(driver);
		//action.moveToElement(Posts).build().perform();
		//action.moveToElement(Posts).click();
		
		this.Posts.click();
	}

	public void ClickOnCategories() {

		this.Categories.click();
	}

	public void sendNameText(String text) {
		this.NameTextbox.clear();
		this.NameTextbox.sendKeys(text);
	}

	public void sendslugText(String text) {
		this.slugTextbox.clear();
		this.slugTextbox.sendKeys(text);
	}

	public void sendDescriptionText(String text) {
		this.DescriptionTextBox.clear();
		this.DescriptionTextBox.sendKeys(text);
	}

	public void clickonAddNewCategory() {
		this.AddNewCategory.click();
	}

	public void clickonposts() {
		this.posts.click();
	}

	public void clickonAddNewPost() {
		this.AddNewPost.click();
	}

	public void sendTitle(String text) {
		this.EnterTitleHere.clear();
		this.EnterTitleHere.sendKeys(text);
	}

	public void sendBodyText(String text) { // you know in all methods i have give the same input arguments as text
		this.BodyText.clear();
		this.BodyText.sendKeys(text);
	}

	public void clickonCategoryCheckBox() {
		this.CategoryCheckBox.click();
	}

	public void clickonPublish() {
		this.Publish.click();
	}
}
