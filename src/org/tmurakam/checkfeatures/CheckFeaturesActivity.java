package org.tmurakam.checkfeatures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.app.Activity;
import android.content.pm.FeatureInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class CheckFeaturesActivity extends Activity {
    private final static String TAG = "CheckFeatures";
    private TextView mTextView;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mTextView = (TextView)findViewById(R.id.textView);
        
        FeatureInfo[] features = getPackageManager().getSystemAvailableFeatures();
        List<String> names = new ArrayList<String>();
        
        if (features != null) {
            for (FeatureInfo fi : features) {
                if (fi.name != null) {
                    names.add(fi.name);
                }
            }
        }
        Collections.sort(names);
        
        StringBuilder sb = new StringBuilder();
        for (String name : names) {
            Log.d(TAG, name);
            sb.append(name);
            sb.append("\n");
        }
        
        mTextView.setText(sb.toString());
    }
}