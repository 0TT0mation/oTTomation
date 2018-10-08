package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class testBase {
    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setupTest (@Optional String browser) throws MalformedURLException{


    }
    @AfterMethod
    public void tearDown() throws Exception{

    }
}
