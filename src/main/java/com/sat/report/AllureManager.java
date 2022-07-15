package com.sat.report;

import com.github.automatedowl.tools.AllureEnvironmentWriter;
import com.google.common.collect.ImmutableMap;
import com.sat.config.Constants;
import com.sat.driver.DriverManager;
import com.sat.utils.BaseTest;

import io.qameta.allure.Attachment;
import org.openqa.selenium.TakesScreenshot;
import java.text.SimpleDateFormat;
import java.lang.Process;
import java.lang.Runtime;
import java.util.Date;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.net.URL;

import static org.openqa.selenium.OutputType.BYTES;

public class AllureManager {

    private AllureManager() {
    }

    public static void setAllureEnvironmentInformation() {
        AllureEnvironmentWriter.allureEnvironmentWriter(
                ImmutableMap.<String, String>builder().
                        put("Target execution", "Local").
                        put("Global timeout", "10").
                        put("Faker locale", "us").
                        build(), System.getProperty("user.dir")
                        + "/target/allure-results/");
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] takeScreenshotToAttachOnAllureReport() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(BYTES);
    }

}
