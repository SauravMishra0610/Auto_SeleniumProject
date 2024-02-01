package utils;

import com.base.BasePage;
import org.testng.Assert;

import java.util.Random;

public class SeleniumHelper extends BasePage {

    public String randomAlphabeticValues(int length){
        // create a string of all characters
        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // create random string builder
        StringBuilder sb = new StringBuilder();
        // create an object of Random class
        Random random = new Random();
        // specify length of random string
        for(int i = 0; i < length; i++) {
            // generate random index number
            int index = random.nextInt(alphabets.length());
            // get character specified by index
            // from the string
            char randomChar = alphabets.charAt(index);
            // append the character to string builder
            sb.append(randomChar);
        }
        String randomString = sb.toString();
        System.out.println("Random String is: " + randomString);
        return randomString;
    }

    public String randomAlphaNumericValues(int length){
        // create a string of uppercase and lowercase characters and numbers
        String upperAlphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabets = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        // combine all strings
        String alphaNumeric = upperAlphabets + lowerAlphabets + numbers;
        // create random string builder
        StringBuilder sb = new StringBuilder();
        // create an object of Random class
        Random random = new Random();
        // specify length of random string
        for(int i = 0; i < length; i++) {
            // generate random index number
            int index = random.nextInt(alphaNumeric.length());
            // get character specified by index
            // from the string
            char randomChar = alphaNumeric.charAt(index);
            // append the character to string builder
            sb.append(randomChar);
        }
        String randomString = sb.toString();
        System.out.println("Random String is: " + randomString);
        return randomString;
    }

    public void assertCurrentText(String currentText, String getLocatorText) {
        Assert.assertEquals(currentText, getLocatorText);
    }
}


