package pl.tajchert.wearview;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.DismissOverlayView;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class DismissOverlayActivity extends Activity {

    private DismissOverlayView dismissOverlayView;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dismiss_overlay);
        dismissOverlayView = (DismissOverlayView) findViewById(R.id.dismiss_plain);
        gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public void onLongPress(MotionEvent e) {
                dismissOverlayView.show();
            }
        });
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
}
