package com.zj.editvideo;

public class Sentence {

    private int mId;

    private String mName;


    public Sentence(int id, String name) {
        mId = id;
        mName = name;
    }


    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }


}
