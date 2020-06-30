package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.RegistrationPage;
import support.*;


public class RegistrationTest extends RegistrationPage implements Domain {
    RandomUsers randomUsers = new RandomUsers();

    @Test
    public void RegistrationTest_Positive() throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(REGISTRATION);
            waitEmailInput(testSettings.chromeWaiter);

            setUserLogin(testSettings.chromeDriver, randomUsers.setRandomFirstName());
            setUserEmail(testSettings.chromeDriver, randomUsers.setRandomEmail());
            String randomPass = randomUsers.setRandomPhoneNum();
            setUserPassword(testSettings.chromeDriver, randomPass);
            setRepeatUserPassword(testSettings.chromeDriver, randomPass);
            getCheckbox(testSettings.chromeDriver).click();
            setWallet(testSettings.chromeDriver, randomUsers.setRandomWallet());
            getConfirmButton(testSettings.chromeDriver).click();
            waitSuccessPage(testSettings.chromeWaiter);

            if(getSuccessPage(testSettings.chromeDriver)) {
                System.out.println("Positive test passed!");
                testSettings.chromeDriver.close();
            }

        } catch (Exception e) {
            testSettings.screenshotBuilder.createScreenshot("RegistrationTest_Positive", testSettings.chromeDriver);
            testSettings.chromeDriver.close();
            System.out.println(e);
        }
    }
    @Test
    public void RegistrationTest_WrongLogin ()throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(REGISTRATION);
            waitEmailInput(testSettings.chromeWaiter);

            setUserLogin(testSettings.chromeDriver, "fF");
            setUserEmail(testSettings.chromeDriver, randomUsers.setRandomEmail());
            String randomPass = randomUsers.setRandomPhoneNum();
            setUserPassword(testSettings.chromeDriver, randomPass);
            setRepeatUserPassword(testSettings.chromeDriver, randomPass);
            getCheckbox(testSettings.chromeDriver).click();
            setWallet(testSettings.chromeDriver, randomUsers.setRandomWallet());
            getConfirmButton(testSettings.chromeDriver).click();

            if (getLoginWarning(testSettings.chromeDriver)) {
                System.out.println("Wrong login passed!");
                testSettings.chromeDriver.close();
            }

        }catch (Exception e) {
            testSettings.screenshotBuilder.createScreenshot("RegistrationTest_WrongLogin", testSettings.chromeDriver);
            System.out.println(e);
            testSettings.chromeDriver.close();
        }
    }

    @Test// more then 10 symbols
    public void RegistrationTest_HugeLogin ()throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(REGISTRATION);
            waitEmailInput(testSettings.chromeWaiter);

            setUserLogin(testSettings.chromeDriver, randomUsers.setRandomFirstName() + "wrfsawdsd" );
            setUserEmail(testSettings.chromeDriver, randomUsers.setRandomEmail());
            String randomPass = randomUsers.setRandomPhoneNum();
            setUserPassword(testSettings.chromeDriver, randomPass);
            setRepeatUserPassword(testSettings.chromeDriver, randomPass);
            getCheckbox(testSettings.chromeDriver).click();
            setWallet(testSettings.chromeDriver, randomUsers.setRandomWallet());
            getConfirmButton(testSettings.chromeDriver).click();

            if (getLoginWarning(testSettings.chromeDriver)) {
                System.out.println("Huge login passed!");
                testSettings.chromeDriver.close();
            }

        }catch (Exception e) {
            testSettings.screenshotBuilder.createScreenshot("RegistrationTest_HugeLogin", testSettings.chromeDriver);
            System.out.println(e);
            testSettings.chromeDriver.close();
        }
    }

    @Test
    public void RegistrationTest_ExistingEmail ()throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(REGISTRATION);
            waitEmailInput(testSettings.chromeWaiter);

            setUserLogin(testSettings.chromeDriver, randomUsers.setRandomFirstName());
            setUserEmail(testSettings.chromeDriver, "evgqa1220@yopmail.com");
            String randomPass = randomUsers.setRandomPhoneNum();
            setUserPassword(testSettings.chromeDriver, randomPass);
            setRepeatUserPassword(testSettings.chromeDriver, randomPass);
            getCheckbox(testSettings.chromeDriver).click();
            setWallet(testSettings.chromeDriver, randomUsers.setRandomWallet());
            getConfirmButton(testSettings.chromeDriver).click();
            waitExistingEmailWarning(testSettings.chromeWaiter);

            if (getExistingEmailWarning(testSettings.chromeDriver)) {
                System.out.println("Existing email passed!");
                testSettings.chromeDriver.close();
            }

        }catch (Exception e) {
            testSettings.screenshotBuilder.createScreenshot("RegistrationTest_ExistingEmail", testSettings.chromeDriver);
            System.out.println(e);
            testSettings.chromeDriver.close();
        }
    }

    @Test
    public void RegistrationTest_WrongEmail () throws Exception{
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(REGISTRATION);
            waitEmailInput(testSettings.chromeWaiter);

            setUserLogin(testSettings.chromeDriver, randomUsers.setRandomFirstName());
            setUserEmail(testSettings.chromeDriver, "evgqa1220daw");
            String randomPass = randomUsers.setRandomPhoneNum();
            setUserPassword(testSettings.chromeDriver, randomPass);
            setRepeatUserPassword(testSettings.chromeDriver, randomPass);
            getCheckbox(testSettings.chromeDriver).click();
            setWallet(testSettings.chromeDriver, randomUsers.setRandomWallet());
            getConfirmButton(testSettings.chromeDriver).click();
            waitExistingEmailWarning(testSettings.chromeWaiter);

            if (getExistingEmailWarning(testSettings.chromeDriver)) {
                System.out.println("Wrong Email passed!");
                testSettings.chromeDriver.close();
            }

        }catch (Exception e) {
            testSettings.screenshotBuilder.createScreenshot("RegistrationTest_WrongEmail", testSettings.chromeDriver);
            testSettings.chromeDriver.close();
        }
    }

    @Test
    public void RegistrationTest_EmptyEmail ()throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(REGISTRATION);
            waitEmailInput(testSettings.chromeWaiter);

            setUserLogin(testSettings.chromeDriver, randomUsers.setRandomFirstName());
            setUserEmail(testSettings.chromeDriver, "");
            String randomPass = randomUsers.setRandomPhoneNum();
            setUserPassword(testSettings.chromeDriver, randomPass);
            setRepeatUserPassword(testSettings.chromeDriver, randomPass);
            getCheckbox(testSettings.chromeDriver).click();
            setWallet(testSettings.chromeDriver, randomUsers.setRandomWallet());
            getConfirmButton(testSettings.chromeDriver).click();
            waitExistingEmailWarning(testSettings.chromeWaiter);

            if (getExistingEmailWarning(testSettings.chromeDriver)) {
                System.out.println("Empty Email passed!");
                testSettings.chromeDriver.close();
            }

        }catch (Exception e) {
            testSettings.screenshotBuilder.createScreenshot("RegistrationTest_EmptyEmail", testSettings.chromeDriver);
            testSettings.chromeDriver.close();
        }
    }

    @Test //contains less then 8 symbols
    public void RegistrationTest_WrongPass ()throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(REGISTRATION);
            waitEmailInput(testSettings.chromeWaiter);

            setUserLogin(testSettings.chromeDriver, randomUsers.setRandomFirstName());
            setUserEmail(testSettings.chromeDriver, randomUsers.setRandomEmail());
            String randomPass = randomUsers.setRandomPhoneNum();
            setUserPassword(testSettings.chromeDriver, "123456");
            setRepeatUserPassword(testSettings.chromeDriver, randomPass);
            getCheckbox(testSettings.chromeDriver).click();
            setWallet(testSettings.chromeDriver, randomUsers.setRandomWallet());
            getConfirmButton(testSettings.chromeDriver).click();

            if(getPasswordWarning(testSettings.chromeDriver)) {
                System.out.println("Wrong pass passed!");
                testSettings.chromeDriver.close();
            }

        }catch (Exception e) {
            testSettings.screenshotBuilder.createScreenshot("RegistrationTest_WrongPass", testSettings.chromeDriver);
            testSettings.chromeDriver.close();
        }
    }

    @Test
    public void RegistrationTest_EmptyPass ()throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(REGISTRATION);
            waitEmailInput(testSettings.chromeWaiter);

            setUserLogin(testSettings.chromeDriver, randomUsers.setRandomFirstName());
            setUserEmail(testSettings.chromeDriver, randomUsers.setRandomEmail());
            String randomPass = randomUsers.setRandomPhoneNum();
            setUserPassword(testSettings.chromeDriver, "");
            setRepeatUserPassword(testSettings.chromeDriver, randomPass);
            getCheckbox(testSettings.chromeDriver).click();
            setWallet(testSettings.chromeDriver, randomUsers.setRandomWallet());
            getConfirmButton(testSettings.chromeDriver).click();

            if(getPasswordWarning(testSettings.chromeDriver)) {
                System.out.println("Empty pass passed!");
                testSettings.chromeDriver.close();
            }

        }catch (Exception e) {
            testSettings.screenshotBuilder.createScreenshot("RegistrationTest_EmptyPass", testSettings.chromeDriver);
            testSettings.chromeDriver.close();
        }
    }

    @Test
    public void RegistrationTest_WrongRepeatPass ()throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(REGISTRATION);
            waitEmailInput(testSettings.chromeWaiter);

            setUserLogin(testSettings.chromeDriver, randomUsers.setRandomFirstName());
            setUserEmail(testSettings.chromeDriver, randomUsers.setRandomEmail());
            String randomPass = randomUsers.setRandomPhoneNum();
            setUserPassword(testSettings.chromeDriver, randomPass);
            setRepeatUserPassword(testSettings.chromeDriver, "12312365464");
            getCheckbox(testSettings.chromeDriver).click();
            setWallet(testSettings.chromeDriver, randomUsers.setRandomWallet());
            getConfirmButton(testSettings.chromeDriver).click();

            if(getRepeatPasswordWarning(testSettings.chromeDriver)) {
                System.out.println("Wrong repeat pass passed!");
                testSettings.chromeDriver.close();
            }

        }catch (Exception e) {
            testSettings.screenshotBuilder.createScreenshot("RegistrationTest_WrongRepeatPass", testSettings.chromeDriver);
            testSettings.chromeDriver.close();
        }
    }

    @Test
    public void RegistrationTest_EmptyRepeatPass ()throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(REGISTRATION);
            waitEmailInput(testSettings.chromeWaiter);

            setUserLogin(testSettings.chromeDriver, randomUsers.setRandomFirstName());
            setUserEmail(testSettings.chromeDriver, randomUsers.setRandomEmail());
            String randomPass = randomUsers.setRandomPhoneNum();
            setUserPassword(testSettings.chromeDriver, randomPass);
            setRepeatUserPassword(testSettings.chromeDriver, "");
            getCheckbox(testSettings.chromeDriver).click();
            setWallet(testSettings.chromeDriver, randomUsers.setRandomWallet());
            getConfirmButton(testSettings.chromeDriver).click();
            waitRepeatPasswordWarning(testSettings.chromeWaiter);

            if(getRepeatPasswordWarning(testSettings.chromeDriver)) {
                System.out.println("Empty repeat pass passed!");
                testSettings.chromeDriver.close();
            }

        }catch (Exception e) {
            testSettings.screenshotBuilder.createScreenshot("RegistrationTest_EmptyRepeatPass", testSettings.chromeDriver);
            testSettings.chromeDriver.close();
        }
    }

//    @Test
//    public void RegistrationTest_CheckboxMissed () throws Exception{
//        TestSettings testSettings = new TestSettings();
//        testSettings.runMaximizeWindow();
//        try {
//            testSettings.chromeDriver.get(REGISTRATION);
//            waitEmailInput(testSettings.chromeWaiter);
//
//            setUserLogin(testSettings.chromeDriver, randomUsers.setRandomFirstName());
//            setUserEmail(testSettings.chromeDriver, randomUsers.setRandomEmail());
//            String randomPass = randomUsers.setRandomPhoneNum();
//            setUserPassword(testSettings.chromeDriver, randomPass);
//            setRepeatUserPassword(testSettings.chromeDriver, randomPass);
//            getCheckbox(testSettings.chromeDriver).click();
//            setWallet(testSettings.chromeDriver, randomUsers.setRandomWallet());
//            getConfirmButton(testSettings.chromeDriver).click();
//            waitSuccessPage(testSettings.chromeWaiter);
//
//        }catch (Exception e) {
//            testSettings.screenshotBuilder.createScreenshot("RegistrationTest_CheckboxMissed", testSettings.chromeDriver);
//            testSettings.chromeDriver.close();
//        }
//    }

    @Test
    public void RegistrationTest_WalletMissed ()throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        String undefined = "undefined";
        try {
            testSettings.chromeDriver.get(REGISTRATION);
            waitEmailInput(testSettings.chromeWaiter);

            setUserLogin(testSettings.chromeDriver, randomUsers.setRandomFirstName());
            setUserEmail(testSettings.chromeDriver, randomUsers.setRandomEmail());
            String randomPass = randomUsers.setRandomPhoneNum();
            setUserPassword(testSettings.chromeDriver, randomPass);
            setRepeatUserPassword(testSettings.chromeDriver, randomPass);
            getCheckbox(testSettings.chromeDriver).click();
            getConfirmButton(testSettings.chromeDriver).click();
            String some = testSettings.chromeDriver.findElement(By.id("selectId")).getCssValue(undefined);
            System.out.println(some);

            if (some != null) {
                testSettings.chromeDriver.close();
                System.out.println("RegistrationTest_WalletMissed passed!");
            }

        }catch (Exception e) {
            testSettings.screenshotBuilder.createScreenshot("RegistrationTest_WalletMissed", testSettings.chromeDriver);
            testSettings.chromeDriver.close();
        }
    }

    @Test//when checkbox selected
    public void RegistrationTest_AllFieldsMissed ()throws Exception {
        TestSettings testSettings = new TestSettings();
        testSettings.runMaximizeWindow();
        try {
            testSettings.chromeDriver.get(REGISTRATION);
            waitEmailInput(testSettings.chromeWaiter);
            getCheckbox(testSettings.chromeDriver).click();
            if (       getExistingEmailWarning(testSettings.chromeDriver)
                    && getPasswordWarning(testSettings.chromeDriver)
                    && getRepeatPasswordWarning(testSettings.chromeDriver))
            {
                testSettings.chromeDriver.close();
                System.out.println("RegistrationTest_AllFieldsMissed passed!");
            }

        }catch (Exception e) {
            testSettings.screenshotBuilder.createScreenshot("RegistrationTest_AllFieldsMissed", testSettings.chromeDriver);
            testSettings.chromeDriver.close();
        }
    }
}