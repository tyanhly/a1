package com.example.a1;

import static org.robolectric.Robolectric.shadowOf;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.Intent;
import android.widget.Button;

import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
    MainActivity mainActivity;

    @Before
    public void setup(){
        mainActivity = new MainActivity();
    }

    @Test
    public void testButtonClickShouldStartAnotherActivity() throws Exception{
        mainActivity.onCreate(null);
        Button btn = (Button) mainActivity.findViewById(R.id.btn);
        btn.performClick();
        
        ShadowActivity shadowActivity = shadowOf(mainActivity);
        Intent intent = shadowActivity.getNextStartedActivity();
        ShadowIntent shadowIntent = shadowOf(intent);
        assertEquals(shadowIntent.getComponent().getClassName(), AnotherActivity.class.getName());

    }

}