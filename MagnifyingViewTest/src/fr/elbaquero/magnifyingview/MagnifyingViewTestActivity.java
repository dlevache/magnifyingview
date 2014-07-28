/*
 * Copyright 2014 elbaquero
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package fr.elbaquero.magnifyingview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

/**
 * {@link MagnifyingView} test activity.
 */
public class MagnifyingViewTestActivity extends Activity
{
    /** Magnifying view. */
    private MagnifyingView mMagnifyingView;

    @Override
    public void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ImageView magnifiedView = (ImageView) findViewById(R.id.test_image);
        Intent intent = getIntent();

        if (Intent.ACTION_VIEW.equals(intent.getAction()))
        {
            magnifiedView.setImageURI(intent.getData());
        }
        else
        {
            magnifiedView.setImageResource(R.drawable.candies);
        }

        mMagnifyingView = new MagnifyingView(this);
        mMagnifyingView.attach(magnifiedView);

        View settingsView = findViewById(R.id.fab_settings);
        settingsView.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(final View v)
            {
                Intent settingsIntent = new Intent(MagnifyingViewTestActivity.this,
                        MagnifyingViewSettingsActivity.class);
                startActivity(settingsIntent);
            }
        });
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        PreferencesManager preferencesManager = PreferencesManager.getInstance(this);
        mMagnifyingView.enableMagnifying(preferencesManager.readBoolean(Constants.PREFERENCES_KEY_ACTIVATION,
                Constants.PREFERENCES_DEFAULT_ACTIVATION));
        mMagnifyingView.setScale(preferencesManager.readFloat(Constants.PREFERENCES_KEY_SCALE,
                Constants.PREFERENCES_DEFAULT_SCALE));
        mMagnifyingView.setCircleRadius(preferencesManager.readInteger(Constants.PREFERENCES_KEY_RADIUS,
                Constants.PREFERENCES_DEFAULT_RADIUS));
        mMagnifyingView.setBorderWidth(preferencesManager.readInteger(Constants.PREFERENCES_KEY_BORDER_WIDTH,
                Constants.PREFERENCES_DEFAULT_BORDER_WIDTH));
        mMagnifyingView.setBorderColor(preferencesManager.readInteger(Constants.PREFERENCES_KEY_BORDER_COLOR,
                Constants.PREFERENCES_DEFAULT_BORDER_COLOR));
        mMagnifyingView.setOffset(preferencesManager.readInteger(Constants.PREFERENCES_KEY_OFFSET_X,
                Constants.PREFERENCES_DEFAULT_OFFSET_X), preferencesManager.readInteger(
                Constants.PREFERENCES_KEY_OFFSET_Y, Constants.PREFERENCES_DEFAULT_OFFSET_Y));
    }
}
