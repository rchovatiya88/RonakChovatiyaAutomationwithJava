import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Ronak on 4/22/16. Webdriver Instance to navigate to ebay, search for a term and extract search results into a text file. 
 
 */
public class extractSearchTerm {

File f = new File("/Users/Ronak/Desktop/Work/Study/SearchResult.txt");

    @Test

    public void SearchTerm(){
//go to ebay and search for "elephand handicraft"
        WebDriver driver=new FirefoxDriver();
        driver.get("http://www.ebay.com");
        WebElement searchTxtBox = driver.findElement(By.xpath(".//*[@id='gh-ac']"));
        searchTxtBox.sendKeys("elephant handicraft");
        driver.findElement(By.xpath(".//*[@id='gh-btn']")).click();

//find the results and extract it into SearchResult.txt file 

    List <WebElement> totalLinks=driver.findElements(By.xpath(".//*[@id='Results']"));
        FileWriter w = null;
        try {
            w = new FileWriter("/Users/Ronak/Desktop/Work/Study/SearchResult.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    for (int i=0; i<totalLinks.size(); i++) {
        String text = totalLinks.get(i).getText();
        System.out.println(text);

        BufferedWriter out;
        out = new BufferedWriter(w);
        //w.append(text);
        try {
            out.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Closes the current webdriver browser window
        driver.close();
        //Closes all the webdriver browser instances
        driver.quit();

    } }}






