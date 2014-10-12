package pl.tajchert.wearview;


import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.wearable.view.CardFragment;
import android.support.wearable.view.FragmentGridPagerAdapter;
import android.support.wearable.view.ImageReference;
import android.view.Gravity;

public class GridViewPagerCustomAdapter extends FragmentGridPagerAdapter {

    private final Context mContext;

    public GridViewPagerCustomAdapter(Context ctx, FragmentManager fm) {
        super(fm);
        mContext = ctx;
    }

    private static class Page {
        String title;
        String text;
        int iconRes;
        int cardGravity = Gravity.CENTER;
        boolean expansionEnabled = true;
        float expansionFactor = 1.0f;
        int expansionDirection = CardFragment.EXPAND_DOWN;

        public Page(String titleRes, String textRes, int iconRes) {
            this.title = titleRes;
            this.text = textRes;
            this.iconRes = iconRes;
        }
    }

    private final Page[][] PAGES = {
            {
                    new Page("GridViewPager", "Content text...", R.drawable.ic_launcher),
            },
            {
                    new Page("True grid!", "Swipe right to see magic.", R.drawable.ic_launcher),
                    new Page("Whoa!", "You didn/'t expect that, did you?", R.drawable.ic_launcher),
            },
    };

    @Override
    public Fragment getFragment(int row, int col) {
        Page page = PAGES[row][col];
        String title = page.title;
        String text = page.text;
        CardFragment fragment = CardFragment.create(title, text, page.iconRes);
        // Advanced settings
        fragment.setCardGravity(page.cardGravity);
        fragment.setExpansionEnabled(page.expansionEnabled);
        fragment.setExpansionDirection(page.expansionDirection);
        fragment.setExpansionFactor(page.expansionFactor);
        return fragment;
    }

    @Override
    public ImageReference getBackground(int row, int column) {
        return ImageReference.forDrawable(R.drawable.ic_launcher);
    }

    @Override
    public int getRowCount() {
        return PAGES.length;
    }

    @Override
    public int getColumnCount(int rowNum) {
        return PAGES[rowNum].length;
    }
}