# Page Objects - Search locators in json file

This project is inspired by https://github.com/shchukax/search-with work. In fact, most of the code is from this user, but I changed the way the json file is accessed.

Page objects model have a limitation, we can only use annotations with locators to get to the page elements. For instance:

```sh
@FindBy(how = How.XPATH, using = "//div/div/div/div/div/div[1]/section/div/div/div/form/div[1]/input")
private WebElement formElement;
```

I didin't like this, because the code had to be spread over the files, it would be hard to maintain.
So, there was the need to access a centralized json file.

shchukax implemented two different ways to get to a json file, and loaded the json with a different structure of the one I'm loading here, but I already was loading a json file, so I wanted to keep loading the same way this new file; And to be honest, I couldn't get shchukax to work, for some reason I just wasn't reaching the locators.json file... But I guess I was doing something wrong.

Let me just say that if you don't have the background of using an abstract class to load selenium driver and implementing the Page Object Model, and cucumber, and some other stuff, this Page Object project won't do that much for you. You need to take baby steps before fully understanding all this :)

So, to use the page object, we use like this:

```sh
@SearchWith(page="login", name="formElement")
private WebElement formElement;
```

As I've said, I cripled the shchukax work, but changed it in a way to satisfy what I needed.

The code in here is not a functional project, are just the required files, but I plan on updating sometime soon.

```sh
{
  "login":{
    "formElement":
    {
      "type":"xpath",
      "value":"//div/div/div/div/div/div[1]/section/div/div/div/form/div[1]/input"
    }
  }
}
```
