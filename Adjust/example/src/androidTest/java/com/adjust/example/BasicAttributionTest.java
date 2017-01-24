package com.adjust.example;

import android.content.*;
import android.support.test.*;
import android.support.test.filters.LargeTest;
import android.support.test.rule.*;
import android.support.test.runner.*;

import com.adjust.sdk.*;

import org.junit.*;
import org.junit.runner.*;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertEquals;

/**
 * Created by ab on 01/12/2016.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
/**
 * - Start
 * - SDK would send first `Session` package to backend
 * - Backend would send back response with an `ask_in` parameter
 * - SDK would send an `Attribution` package to backend.
 * - End
 */
public class BasicAttributionTest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.adjust.example", appContext.getPackageName());
    }

    @Test
    public void foo() {
        AdjustAnalyzer.reportState("callsite A");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
