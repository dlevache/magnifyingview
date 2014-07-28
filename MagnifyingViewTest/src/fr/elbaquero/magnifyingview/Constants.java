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

import android.graphics.Color;

/**
 * Constants.
 */
public class Constants
{
    /** Preferences key: activation. */
    public static final String PREFERENCES_KEY_ACTIVATION = "PREFERENCES_KEY_ACTIVATION";

    /** Preferences key: radius. */
    public static final String PREFERENCES_KEY_RADIUS = "PREFERENCES_KEY_RADIUS";

    /** Preferences key: border width. */
    public static final String PREFERENCES_KEY_BORDER_WIDTH = "PREFERENCES_KEY_BORDER_WIDTH";

    /** Preferences key: border color. */
    public static final String PREFERENCES_KEY_BORDER_COLOR = "PREFERENCES_KEY_BORDER_COLOR";

    /** Preferences key: offset X. */
    public static final String PREFERENCES_KEY_OFFSET_X = "PREFERENCES_KEY_OFFSET_X";

    /** Preferences key: offset Y. */
    public static final String PREFERENCES_KEY_OFFSET_Y = "PREFERENCES_KEY_OFFSET_Y";

    /** Preferences default value: activation. */
    public static final boolean PREFERENCES_DEFAULT_ACTIVATION = true;

    /** Preferences default value: radius. */
    public static final int PREFERENCES_DEFAULT_RADIUS = 100;

    /** Preferences default value: border width. */
    public static final int PREFERENCES_DEFAULT_BORDER_WIDTH = 2;

    /** Preferences default value: border color. */
    public static final int PREFERENCES_DEFAULT_BORDER_COLOR = Color.BLACK;

    /** Preferences default value: offset X. */
    public static final int PREFERENCES_DEFAULT_OFFSET_X = 0;

    /** Preferences default value: offset Y. */
    public static final int PREFERENCES_DEFAULT_OFFSET_Y = 0;

    /**
     * Empty, private constructor.
     */
    private Constants()
    {
    }
}
