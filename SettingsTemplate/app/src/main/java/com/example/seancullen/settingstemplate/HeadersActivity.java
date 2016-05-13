package com.example.seancullen.settingstemplate;

import android.preference.PreferenceActivity;

import java.util.List;

/**
 * Created by Sean Cullen on 5/12/2016.
 */
public class HeadersActivity extends PreferenceActivity {
    @Override
    public void onBuildHeaders(List<Header> target) {
        loadHeadersFromResource(R.xml.preference_headers, target);
    }
}
