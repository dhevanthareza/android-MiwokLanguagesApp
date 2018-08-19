package com.example.android.miwok;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FamilyActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_family);


        final ArrayList<Word> family = new ArrayList<Word>();
        family.add(new Word("Father", "әpә", R.drawable.family_father, R.raw.family_father));
        family.add(new Word("Mother", "әṭa", R.drawable.family_mother, R.raw.family_mother));
        family.add(new Word("Son", "angsi", R.drawable.family_son, R.raw.family_son));
        family.add(new Word("Daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
        family.add(new Word("Older Brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        family.add(new Word("Younger Brother", "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        family.add(new Word("Older Sister", "teṭe", R.drawable.family_older_sister, R.raw.family_older_sister)) ;
        family.add(new Word("Younger Sister", "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        family.add(new Word("Grand Mother", "ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        family.add(new Word("Grand Father", "paapa", R.drawable.family_grandfather, R.raw.family_grandfather));

        WordAdapter adapter = new WordAdapter(this, family, R.color.category_family);

        ListView list = (ListView) findViewById(R.id.listFamily);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word posisi = family.get(i);
                if(mediaPlayer != null){ releaseMedia();}
                mediaPlayer= MediaPlayer.create(FamilyActivity.this, posisi.getAudioResourceId());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(OnCompletion);
            }
        });
    }
    @Override
    protected void onStop() {
        super.onStop();
        releaseMedia();
    }
    public void releaseMedia(){
        if(mediaPlayer != null);
        mediaPlayer .release();
        mediaPlayer = null;
    }
}
