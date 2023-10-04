package utilities;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class Listeners extends CommonOps implements ITestListener {

    public void onStart(ITestContext execution) {

        System.out.println("------------ Starting Execution ------------");
    }

    public void onFinish(ITestContext execution) {

        System.out.println("------------ Execution Ended ------------");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0)
    {
        // TODO Auto-generated method stub
    }

    public void onTestSkipped(ITestResult test) {
        System.out.println
                ("------------ Skipping Test: " + test.getName() + " ------------");
    }

    // Method Name : onTestStart
    // Method Description: This method is executed when a test starts.
    // Method Parameters : ITestResult test - Information about the test that is starting.
    // Print a message indicating the start of the test
    public void onTestStart(ITestResult test) {
        System.out.println
                ("------------ Starting Test: " + test.getName() + " ------------");
    }

    // Method Name : onTestSuccess
    // Method Description: This method is executed when a test method passes. if platform is not api it delete the video file of the run
    // Method Parameters : ITestResult test - Information about the passed test.
    public void onTestSuccess(ITestResult test) {
        if (!platform.equalsIgnoreCase("api")){
            System.out.println
                    ("------------ Test: " + test.getName() + " Passed ------------");

            // Stop Monte Test recording

            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            // Delete video file
            File file = new File("./test-recordings/" + test.getName() + ".avi");
            if(file.delete())
                System.out.println("Video file Deleted Successfully");
            else
                System.out.println("Failed to delete video file");
        }
    }

    // Method Name : onTestFailure
    // Method Description: This method is executed when a test method fails.
    // taking a screenshot and stop video record if platform is not api
    // Method Parameters : ITestResult test - Information about the failed test.
    public void onTestFailure(ITestResult test) {
        if (!platform.equalsIgnoreCase("api")){
            Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
            System.out.println("------------ Test: " + test.getName() + " Failed ------------");

            // Stop Monte Test recording

            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("Taking Screenshot...");

            // Take Screenshot
            saveScreenshot();
        }
    }

    @Attachment(value = "Page Screen-Shot", type = "image/png")
    public byte[] saveScreenshot() {
        if (!platform.equalsIgnoreCase("mobile"))
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        else
            return ((TakesScreenshot) mobileDriver).getScreenshotAs(OutputType.BYTES);

    }
}
