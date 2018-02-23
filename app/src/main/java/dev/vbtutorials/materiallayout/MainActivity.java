package dev.vbtutorials.materiallayout;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.widget.ImageView;
import android.widget.TextView;

import static android.R.id.primary;

public class MainActivity extends AppCompatActivity {
    CollapsingToolbarLayout collapsingToolbarLayout;
    ImageView iv_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //find views and related operations
        ViewCompat.setTransitionName(findViewById(R.id.app_bar_layout), "VB Tutorials");
        iv_image= (ImageView) findViewById(R.id.iv_bg_image);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        iv_image.setImageResource(R.drawable.bg_rose);

        collapsingToolbarLayout.setTitle("VB Tutorials");
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));

        //find palette from image
        Bitmap myBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bg_rose);
        if (myBitmap != null && !myBitmap.isRecycled()) {
            Palette palette = Palette.from(myBitmap).generate();
            int defaultValue = 0x39796b;
            collapsingToolbarLayout.setContentScrimColor(palette.getVibrantColor(defaultValue));
            collapsingToolbarLayout.setStatusBarScrimColor(palette.getDarkVibrantColor(defaultValue));

        }



    }


}
