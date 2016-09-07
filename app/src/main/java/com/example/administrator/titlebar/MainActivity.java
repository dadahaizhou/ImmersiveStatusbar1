package com.example.administrator.titlebar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.util.LruCache;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.zhou.titleapplication.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setStatusBarColor(R.color.colorStatue);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        Log.i("test","fab "+fab);
        if(fab==null){
            startActivity(new Intent(MainActivity.this,Main2Activity.class));
        }
          else {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "JumpToMain2Act", Snackbar.LENGTH_LONG)
                            .setAction("Go", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Log.i("test", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                                    startActivity(new Intent(MainActivity.this, Main2Activity.class));
                                }
                            }).show();
                }
            });
        }

        TextView tv= (TextView) findViewById(R.id.textview);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchFullWindow();
            }
        });
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
        else if(id == R.id.action_switch){
            switchFullWindow();
        }

        return super.onOptionsItemSelected(item);
    }

    boolean isFullwindow = false;

    void switchFullWindow() {
        Log.i("switch","switchFullWindow main isFullWindow:"+isFullwindow);
        if (isFullwindow) {
            fitSystemShowStateBar();
        } else {
            showActionBar(false);
            setStatusBarColor(R.color.colorAccent);
        }
        isFullwindow = !isFullwindow;

    }
    private final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);

    LruCache lrucahe=new LruCache(maxMemory/8){
        @Override
        protected int sizeOf(Object key, Object value) {
            return super.sizeOf(key, value);
        }

        @Override
        protected void entryRemoved(boolean evicted, Object key, Object oldValue, Object newValue) {
            super.entryRemoved(evicted, key, oldValue, newValue);
        }
    };

}
