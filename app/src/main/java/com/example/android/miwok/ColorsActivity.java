package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.lang.reflect.Array;

public class ColorsActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    private MediaPlayer.OnCompletionListener OnComplettion = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMedia();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        final ArrayList<Word> color = new ArrayList<Word>();
        color.add(new Word("Red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
        color.add(new Word("Green", "chokokki", R.drawable.color_green, R.raw.color_green));
        color.add(new Word("Brown", "takaakki", R.drawable.color_brown, R.raw.color_brown));
        color.add(new Word("Gray","ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
        color.add(new Word("Black", "kululli", R.drawable.color_black, R.raw.color_black));
        color.add(new Word("White", "kelelli", R.drawable.color_white, R.raw.color_white));
        color.add(new Word("Dust Yellow", "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        color.add(new Word("Mustrad Yellow", "chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        WordAdapter adapter = new WordAdapter(this, color, R.color.category_colors);

        ListView list = (ListView) findViewById(R.id.listColor);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word posisi = color.get(position);
                if(mediaPlayer != null){ releaseMedia();}
                mediaPlayer = MediaPlayer.create(ColorsActivity.this, posisi.getAudioResourceId());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(OnComplettion);
            }
        });
    }
    @Override
    protected void onStop() {
        super.onStop();
        releaseMedia();
    }
    public void releaseMedia(){
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}

