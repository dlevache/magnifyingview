package fr.elbaquero.magnifyingview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import fr.elbaquero.R;

/**
 * {@link MagnifyingView} test activity.
 */
public class MagnifyingViewTestActivity extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        View magnifiedView = findViewById(R.id.test_image);
        MagnifyingView magnifyingView = new MagnifyingView(this);
        magnifyingView.attach(magnifiedView);
    }
}
