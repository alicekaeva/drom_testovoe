package pages.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.base.BasePage;

import java.util.*;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private final By FAVOURITE_BUTTON = By.className("css-1rozdag");
    private final By FAVOURITE_NOTIFICATION = By.cssSelector(".css-tf6zid.er4tud40 > div");
    private final By CROSSED_TEXT = By.className("css-r91w5p");
    private final By MILEAGE = By.xpath("//div[@class=\"css-1fe6w6s e162wx9x0\"]/span[contains(text(), \"тыс. км\")]");
    private final By YEAR = By.cssSelector("div.css-17lk78h.e3f4v4l2 > span");
    private final By SECOND_PAGE = By.xpath("//a[@class=\"css-1jjais5 ena3a8q0\" and contains(text(), \"2\")]");
    private final By SELECT = By.xpath("(//div[@class=\"css-1lw8b0j e26h77w0\"]/select)[1]");

    public void addFavourite() {
        driver.findElement(FAVOURITE_BUTTON).click();
        driver.findElement(FAVOURITE_NOTIFICATION);
    }

    public void checkCrossedText() {
        List<WebElement> elements = driver.findElements(CROSSED_TEXT);
        Assert.assertEquals(elements.size(), 0, "contains crossed text");
    }

    public void checkMileage() {
        List<WebElement> elements = driver.findElements(MILEAGE);
        Assert.assertEquals(elements.size(), 20, "no mileage");
    }

    public void checkYear() {
        List<WebElement> elements = driver.findElements(YEAR);
        String buffer;
        int year;
        for (WebElement element : elements) {
            buffer = element.getText();
            String[] words = buffer.split(", ");
            year = Integer.parseInt(words[1]);
            Assert.assertTrue(year >= 2007, "year less than 2007");
        }
    }

    public MainPage goToSecondPage() {
        driver.findElement(SECOND_PAGE).click();
        return this;
    }

    public void gatherBrands(){
        WebElement element = driver.findElement(SELECT);
        List<WebElement> elements = element.findElements(By.cssSelector("*"));
        HashMap<String, Integer> brands = new HashMap<>();
        String buffer;
        int amount;
        String brand;
        for (int i = 8; i < elements.size(); i++) {
            buffer = elements.get(i).getText();
            if (buffer.contains(" ")){
                amount = Integer.parseInt(buffer.substring(buffer.indexOf("(") + 1, buffer.indexOf(")")));
                brand = buffer.substring(0, buffer.indexOf("("));
                brands.put(brand, amount);
            } else {
                ;
            }
        }
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : brands.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list);
        for (int num : list) {
            for (Map.Entry<String, Integer> entry : brands.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedMap.put(entry.getKey(), num);
                }
            }
        }
        System.out.print("| Фирма | Количество объявлений |\n");
        Set<String> keys = sortedMap.keySet();
        Object[] namesArray = keys.toArray();
        for (int i = keys.size() - 1; i > keys.size() - 20; i--) {
            System.out.println("| "+ namesArray[i] + " | "
                    + sortedMap.get(namesArray[i]) + " |");
        }
    }
}
