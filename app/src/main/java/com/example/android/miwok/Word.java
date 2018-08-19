package com.example.android.miwok;

import android.provider.ContactsContract;

public class Word {
    private String mDefaultTranslation, mMiwokTranslation;
    private Integer mImageResourceId = -1;
    private static final int NO_IMAGE_PROVIDED = -1;
    private Integer mAudioResourceId;


    public Word(String DefaultTranslation, String MiwokTranslation, Integer ImageResourceId, Integer AudioResourceId){
        mDefaultTranslation = DefaultTranslation;
        mMiwokTranslation = MiwokTranslation;
        mImageResourceId = ImageResourceId;
        mAudioResourceId = AudioResourceId;
    }

    public Word(String DefaultTranslation, String MiwokTranslation, Integer AudioResourceId){
        mDefaultTranslation = DefaultTranslation;
        mMiwokTranslation = MiwokTranslation;
        mAudioResourceId = AudioResourceId;
    }


    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public Integer getImageResourceId() {
        return mImageResourceId;
    }

    public Integer getAudioResourceId(){
        return mAudioResourceId;
    };

    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
