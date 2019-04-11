# Page Objects - Import locators from json file

This project is inspired by https://github.com/shchukax/search-with work. In fact, most of the code is from this user, but I changed the way the json file is accessed.

Page objects model have a limitation, we can only use locators to get to the page elements. For instance:

@FindBy(how = How.XPATH, using = "//div/div/div/div/div/div[1]/section/div/div/div/form/div[1]/input")
private WebElement formElement;
