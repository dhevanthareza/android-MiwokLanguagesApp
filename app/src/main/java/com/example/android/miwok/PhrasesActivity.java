package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    private MediaPlayer.OnCompletionListener OnCompletion = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMedia();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        final ArrayList<Word> phrases = new ArrayList<Word>();
        phrases.add(new Word("Father", "әpә", R.raw.phrase_are_you_coming));
        phrases.add(new Word("Mother", "әṭa", R.raw.phrase_come_here));
        phrases.add(new Word("Son", "angsi", R.raw.phrase_how_are_you_feeling));
        phrases.add(new Word("Daughter", "tune", R.raw.phrase_im_coming));
        phrases.add(new Word("Older Brother", "taachi", R.raw.phrase_im_feeling_good));
        phrases.add(new Word("Younger Brother", "chalitti", R.raw.phrase_lets_go));
        phrases.add(new Word("Older Sister", "teṭe", R.raw.phrase_my_name_is));
        phrases.add(new Word("Younger Sister", "kolliti", R.raw.phrase_what_is_your_name));
        phrases.add(new Word("Grand Mother", "ama", R.raw.phrase_where_are_you_going));
        phrases.add(new Word("Grand Father", "paapa", R.raw.phrase_yes_im_coming));

        WordAdapter adapter = new WordAdapter(this, phrases, R.color.category_phrases);

        ListView list = (ListView) findViewById(R.id.list_phrases);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word posisi = phrases.get(i);
                if(mediaPlayer != null){ releaseMedia();}
                mediaPlayer = MediaPlayer.create(PhrasesActivity.this, posisi.getAudioResourceId());
                mediaPlayer.start();
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
