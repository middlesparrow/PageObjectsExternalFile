package PageObjectsExternalFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait

public abstract class Base {

    public void OpenFile() {

        JSONParser parser = new JSONParser();
        String currentDirectory = Paths.get(".").toAbsolutePath().normalize().toString();

        File locatorsFileExists = new File(currentDirectory + "/locators.json");
        if (propertiesFileExists.exists()) {
            locatorsStr = currentDirectory + "/locators.json";
            locatorsFile = parser.parse(new FileReader(locatorsStr));

        } else {
            System.out.println("File " + currentDirectory + "/locators.json" + " is missing.");
            exit = 1;
        }
    }
}