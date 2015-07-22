package com.example.administrator.gifloading;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.administrator.gifloading.view.GifLoadingView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GifLoadingView gifLoadingView = new GifLoadingView((android.view.ViewGroup) findViewById(R.id.content).getRootView()
                ,this,new int[]{R.drawable.gif_loading1,R.drawable.gif_loading2,R.drawable.gif_loading3
        ,R.drawable.gif_loading4,R.drawable.gif_loading5,R.drawable.gif_loading6,R.drawable.gif_loading7});
        gifLoadingView.show();
        gifLoadingView.setCanceledOnTouchOutside(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
