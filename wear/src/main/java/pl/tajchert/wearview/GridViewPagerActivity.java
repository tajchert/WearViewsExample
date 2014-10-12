package pl.tajchert.wearview;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.wearable.view.GridViewPager;
import android.view.View;
import android.view.WindowInsets;

public class GridViewPagerActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridviewpager);
        final Resources res = getResources();
        final GridViewPager pager = (GridViewPager) findViewById(R.id.pager);
        pager.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
            @Override
            public WindowInsets onApplyWindowInsets(View v, WindowInsets insets) {
                final boolean round = insets.isRound();
                int rowMargin = res.getDimensionPixelOffset(R.dimen.card_margin);
                int colMargin = res.getDimensionPixelOffset(round ? R.dimen.column_padding_round : R.dimen.column_padding_rect);
                pager.setPageMargins(rowMargin, colMargin);
                return insets;
            }
        });
        pager.setAdapter(new GridViewPagerCustomAdapter(this, getFragmentManager()));
    }
}
