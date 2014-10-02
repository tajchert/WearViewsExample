package pl.tajchert.wearview;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.DismissOverlayView;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class StubActivity extends Activity implements View.OnLongClickListener{

    private TextView mTextView;
    private DismissOverlayView mDismissOverlayView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stub);
        mDismissOverlayView = new DismissOverlayView(this);

        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);
                stub.setOnLongClickListener(StubActivity.this);
                stub.addView(mDismissOverlayView,new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT));
            }
        });

    }

    @Override
    public boolean onLongClick(View v) {
        mDismissOverlayView.show();
        return true;
    }
}
