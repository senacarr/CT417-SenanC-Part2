package com.example.senan.beatdetection;

import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        MediaPlayer player = new MediaPlayer();
//        player.setDataSource();
//        player.


        String p = Environment.getExternalStorageDirectory().getPath();
        File m = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);

        ListView listView = (ListView) findViewById(R.id.listView);

        if(m.isDirectory()) {
            ArrayAdapter<String> adapter
                    = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, m.list());
            listView.setAdapter(adapter);
        }



        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());
    }







    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
}
