package com.orangehrmlive.resources.testdata;

import org.testng.annotations.DataProvider;

/**
 * Created by Jay
 */
public class TestData {
    @DataProvider(name = "userDetails")
    public Object[][] getData() {
        Object[][] data = new Object[][]{
                {"Admin", "Admin", "Paul Brown CollingsBrenna", "Enable"},
                {"Cassidy.Hope", "ESS", "Cassidy Hope", "Enable"},
                {"Nina.Patel", "ESS", "Nina Patel", "Enable"},
                {"Odis.Adalwin", "ESS", "Odis Adalwin", "Enable"}
        };
        return data;
    }

}
