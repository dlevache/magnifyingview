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
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

/**
 * {@link MagnifyingView} settings activity.
 */
public class MagnifyingViewSettingsActivity extends Activity
{
    /** Activation check box. */
    private CheckBox mActivateSettingValueView;

    /** Radius edit text. */
    private EditText mRadiusSettingValueView;

    /** Border width value. */
    private EditText mBorderWidthValue;

    /** Border color value. */
    private View mBorderColorValue;

    /** Border color red value. */
    private SeekBar mBorderColorRedValue;

    /** Border color green value. */
    private SeekBar mBorderColorGreenValue;

    /** Border color blue value. */
    private SeekBar mBorderColorBlueValue;

    /** Border color alpha value. */
    private SeekBar mBorderColorAlphaValue;

    /** Border color edit layout. */
    private LinearLayout mBorderColorEditLayout;

    /** Offset X edit text. */
    private EditText mOffsetXSettingValueView;

    /** Offset Y edit text. */
    private EditText mOffsetYSettingValueView;

    @Override
    public void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        View settingsView = findViewById(R.id.fab_settings);
        settingsView.setVisibility(View.GONE);

        View activateSettingView = findViewById(R.id.settings_activate);
        View radiusSettingView = findViewById(R.id.settings_radius);
        View borderWidthSettingView = findViewById(R.id.settings_border_width);
        View borderColorSettingView = findViewById(R.id.settings_border_color);
        View offsetXSettingView = findViewById(R.id.settings_offset_x);
        View offsetYSettingView = findViewById(R.id.settings_offset_y);

        mActivateSettingValueView = (CheckBox) findViewById(R.id.settings_activate_value);
        mRadiusSettingValueView = (EditText) findViewById(R.id.settings_radius_value);
        mBorderWidthValue = (EditText) findViewById(R.id.settings_border_width_value);
        mBorderColorValue = findViewById(R.id.settings_border_color_value);
        mBorderColorEditLayout = (LinearLayout) findViewById(R.id.settings_border_color_edit);
        mBorderColorRedValue = (SeekBar) findViewById(R.id.settings_border_color_red);
        mBorderColorGreenValue = (SeekBar) findViewById(R.id.settings_border_color_green);
        mBorderColorBlueValue = (SeekBar) findViewById(R.id.settings_border_color_blue);
        mBorderColorAlphaValue = (SeekBar) findViewById(R.id.settings_border_color_alpha);
        mOffsetXSettingValueView = (EditText) findViewById(R.id.settings_offset_x_value);
        mOffsetYSettingValueView = (EditText) findViewById(R.id.settings_offset_y_value);

        OnClickListener onClickListener = new OnClickListener()
        {
            @Override
            public void onClick(final View v)
            {
                switch (v.getId())
                {
                    case R.id.settings_activate:
                        mActivateSettingValueView.setChecked(!mActivateSettingValueView.isChecked());
                        break;

                    case R.id.settings_border_color:
                        if (mBorderColorEditLayout.getVisibility() == View.GONE)
                        {
                            mBorderColorEditLayout.setVisibility(View.VISIBLE);
                        }
                        else
                        {
                            mBorderColorEditLayout.setVisibility(View.GONE);
                        }
                        break;

                    default:
                        break;
                }
            }
        };

        activateSettingView.setOnClickListener(onClickListener);
        radiusSettingView.setOnClickListener(onClickListener);
        borderWidthSettingView.setOnClickListener(onClickListener);
        borderColorSettingView.setOnClickListener(onClickListener);
        offsetXSettingView.setOnClickListener(onClickListener);
        offsetYSettingView.setOnClickListener(onClickListener);

        OnSeekBarChangeListener onSeekBarChangeListener = new OnSeekBarChangeListener()
        {
            @Override
            public void onStopTrackingTouch(final SeekBar seekBar)
            {
            }

            @Override
            public void onStartTrackingTouch(final SeekBar seekBar)
            {
            }

            @Override
            public void onProgressChanged(final SeekBar seekBar, final int progress, final boolean fromUser)
            {
                int borderColor = buildBorderColor();
                mBorderColorValue.setBackgroundColor(borderColor);
            }
        };

        mBorderColorRedValue.setOnSeekBarChangeListener(onSeekBarChangeListener);
        mBorderColorGreenValue.setOnSeekBarChangeListener(onSeekBarChangeListener);
        mBorderColorBlueValue.setOnSeekBarChangeListener(onSeekBarChangeListener);
        mBorderColorAlphaValue.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        PreferencesManager preferencesManager = PreferencesManager.getInstance(this);
        mActivateSettingValueView.setChecked(preferencesManager.readBoolean(Constants.PREFERENCES_KEY_ACTIVATION,
                Constants.PREFERENCES_DEFAULT_ACTIVATION));
        mRadiusSettingValueView.setText(String.valueOf(preferencesManager.readInteger(Constants.PREFERENCES_KEY_RADIUS,
                Constants.PREFERENCES_DEFAULT_RADIUS)));
        mBorderWidthValue.setText(String.valueOf(preferencesManager.readInteger(Constants.PREFERENCES_KEY_BORDER_WIDTH,
                Constants.PREFERENCES_DEFAULT_BORDER_WIDTH)));

        int color = preferencesManager.readInteger(Constants.PREFERENCES_KEY_BORDER_COLOR,
                Constants.PREFERENCES_DEFAULT_BORDER_COLOR);
        mBorderColorValue.setBackgroundColor(color);

        int red = (color >> 16) & 0xFF;
        int green = (color >> 8) & 0xFF;
        int blue = color & 0xFF;
        int alpha = (color >> 24) & 0xFF;
        mBorderColorRedValue.setProgress(red);
        mBorderColorGreenValue.setProgress(green);
        mBorderColorBlueValue.setProgress(blue);
        mBorderColorAlphaValue.setProgress(alpha);

        mOffsetXSettingValueView.setText(String.valueOf(preferencesManager.readInteger(
                Constants.PREFERENCES_KEY_OFFSET_X, Constants.PREFERENCES_DEFAULT_OFFSET_X)));
        mOffsetYSettingValueView.setText(String.valueOf(preferencesManager.readInteger(
                Constants.PREFERENCES_KEY_OFFSET_Y, Constants.PREFERENCES_DEFAULT_OFFSET_Y)));

        mBorderColorEditLayout.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed()
    {
        PreferencesManager preferencesManager = PreferencesManager.getInstance(this);

        preferencesManager.saveBoolean(Constants.PREFERENCES_KEY_ACTIVATION, mActivateSettingValueView.isChecked());
        preferencesManager.saveInteger(Constants.PREFERENCES_KEY_RADIUS,
                Integer.parseInt(mRadiusSettingValueView.getText().toString()));
        preferencesManager.saveInteger(Constants.PREFERENCES_KEY_BORDER_WIDTH,
                Integer.parseInt(mBorderWidthValue.getText().toString()));

        int color = buildBorderColor();
        preferencesManager.saveInteger(Constants.PREFERENCES_KEY_BORDER_COLOR, color);
        preferencesManager.saveInteger(Constants.PREFERENCES_KEY_OFFSET_X,
                Integer.parseInt(mOffsetXSettingValueView.getText().toString()));
        preferencesManager.saveInteger(Constants.PREFERENCES_KEY_OFFSET_Y,
                Integer.parseInt(mOffsetYSettingValueView.getText().toString()));
        super.onBackPressed();
    }

    /**
     * Build the border color using the seek bars progress values.
     * 
     * @return the border color.
     */
    private int buildBorderColor()
    {
        int red = mBorderColorRedValue.getProgress();
        int green = mBorderColorGreenValue.getProgress();
        int blue = mBorderColorBlueValue.getProgress();
        int alpha = mBorderColorAlphaValue.getProgress();

        return (alpha << 24) | (red << 16) | (green << 8) | blue;
    }
}
