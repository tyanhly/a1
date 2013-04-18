package com.example.a1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(AnotherActivity.class);
            }
        });
        
    }
    
    private void startActivity(Class<? extends Activity> activityClass) {
        Intent intent = new Intent();
        intent.setClassName(getPackageName(), activityClass.getName());
        startActivity(intent);
    }
}
