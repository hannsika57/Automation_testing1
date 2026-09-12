
package webdrivercommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BrowserCommands {

    @Test(priority = 1)
    public void ChromeBrowserTest() {
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.manage().window().maximize();

        String title = driver.getTitle();
        System.out.println(title);

        if (title.equals("Test Login | Practice Test Automation")) {
            System.out.println("Title verified");
        }
        String url = driver.getCurrentUrl();
        System.out.println(url);
        driver.quit();
    }

    @Test(priority = 2)
    public void FirefoxBrowserTest() {
        FirefoxDriver driver = new FirefoxDriver();

        driver.get("https://www.hollandandbarrett.com/");
        driver.manage().window().maximize();

        String title = driver.getTitle();
        System.out.println(title);

        if (title.equals("Health & Wellness | Vitamins, Supplements & More | Holland & Barrett")) {
            System.out.println("Title verified");
        }
        String url = driver.getCurrentUrl();
        System.out.println(url);
        driver.quit();
    }

    @Test(priority = 3)
    public void EdgeBrowserTest9() {
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://mvnrepository.com/");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        System.out.println(title);
        if (title.equals("Maven Repository: Search/Browse/Explore")) {
            System.out.println("Title verified");
        }
        String url = driver.getCurrentUrl();
        System.out.println(url);
        driver.quit();
    }

    @Test(priority = 4)
    public void EdgeBrowserTest1() {
    	
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://www.vskills.in/practice/manual-testing-mock-test");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        System.out.println(title);
        if (title.equals("Manual Testing Mock Test - Vskills Practice Tests")) {
            System.out.println("Title verified");
        }
        String url = driver.getCurrentUrl();
        System.out.println(url);
        driver.quit();
    }

    @Test(priority = 5)
    public void EdgeBrowserTest2() {
    	
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        System.out.println(title);
        if (title.equals("Google")) {
            System.out.println("Title verified");
        }
        String url = driver.getCurrentUrl();
        System.out.println(url);
        driver.quit();
    }

    @Test(priority = 6)
    public void EdgeBrowserTest3() {
        EdgeDriver driver = new EdgeDriver();

        driver.get("https://www.automationexercise.com/");
        driver.manage().window().maximize();

        String title = driver.getTitle();
        System.out.println(title);

        if (title.equals("Automation Exercise")) {
            System.out.println("Title verified");
        }

        String url = driver.getCurrentUrl();
        System.out.println(url);

        driver.quit();
    }

    @Test(priority = 7)
    public void EdgeBrowserTest4() {
        EdgeDriver driver = new EdgeDriver();

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        String title = driver.getTitle();
        System.out.println(title);

        if (title.equals("Automation Testing Practice")) {
            System.out.println("Title verified");
        }

        String url = driver.getCurrentUrl();
        System.out.println(url);

        driver.quit();
    }

    @Test(priority = 8)
    public void EdgeBrowserTest() {
        EdgeDriver driver = new EdgeDriver();

        driver.get("https://practice.expandtesting.com/");
        driver.manage().window().maximize();

        String title = driver.getTitle();
        System.out.println(title);

        if (title.equals("Practice Test Automation | Expand Testing")) {
            System.out.println("Title verified");
        }

        String url = driver.getCurrentUrl();
        System.out.println(url);

        driver.quit();
    }

    @Test(priority = 9)
    public void EdgeBrowserTest5() {
        EdgeDriver driver = new EdgeDriver();

        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        String title = driver.getTitle();
        System.out.println(title);

        if (title.equals("DEMOQA")) {
            System.out.println("Title verified");
        }

        String url = driver.getCurrentUrl();
        System.out.println(url);

        driver.quit();
    }

    @Test(priority = 10)
    public void EdgeBrowserTest6() {
        EdgeDriver driver = new EdgeDriver();

        driver.get("https://testpages.eviltester.com/reference/other-sites/");
        driver.manage().window().maximize();

        String title = driver.getTitle();
        System.out.println(title);

        if (title.equals("Other Sites - Test Pages")) {
            System.out.println("Title verified");
        }

        String url = driver.getCurrentUrl();
        System.out.println(url);

        driver.quit();
    }
}

