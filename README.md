# Page Objects - Import locators from json file

This project is inspired by https://github.com/shchukax/search-with work. In fact, most of the code is from this user, but I changed the way the json file is accessed.

Page objects model have a limitation, we can only use locators to get to the page elements. For instance:

```sh
@FindBy(how = How.XPATH, using = "//div/div/div/div/div/div[1]/section/div/div/div/form/div[1]/input")
private WebElement formElement;
```

I didin't like this, because the code had to be all over the files.
So, there was the need to access a centralized file.

shchukax implemented two different ways to get to a json file, and loaded the json with a different structured of the one I'm loading here, but I already was loading a json file, so I wanted to keep loading the same way this new file; And to be honest, I couldn't get it to work, for some reason I just wasn't reaching the locators.json file...

Let me just say that if you don't have the background of using an abstract class to load selenium and implementing the Page Object Model, this Page Object code will be very hard to implement. You need to take baby steps before fully understanding all this :)

So, to use the page object we use like this:

```sh
@SearchWith(page="login", name="formElement")
private WebElement formElement;
```
