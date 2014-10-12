package pl.tajchert.wearview;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.DelayedConfirmationView;
import android.view.View;

public class ConfirmationOverlayActivity extends Activity implements DelayedConfirmationView.DelayedConfirmationListener {

    private DelayedConfirmationView delayedConfirmationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_overlay);

        delayedConfirmationView = (DelayedConfirmationView) findViewById(R.id.delayed_confirmation);
        delayedConfirmationView.setTotalTimeMs(2000);
        delayedConfirmationView.setListener(ConfirmationOverlayActivity.this);
    }

    @Override
    public void onTimerFinished(View view) {
        view.setPressed(false);
    }

    @Override
    public void onTimerSelected(View view) {
        view.setPressed(true);
        delayedConfirmationView.start();
    }
}
