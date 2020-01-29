package com.anncode.amazonviewer.model;

import java.util.ArrayList;

public class Chapter extends Movie {

    private int id;
    private int sessionNumber;

    //Polimorfismo
    public Chapter(String title, String genre, String creator, int duration, short year, int sessionNumber) {
        super(title, genre, creator, duration, year);
        this.sessionNumber = sessionNumber;
    }

    //Polimorfismo
    @Override
    public int getId() {
        return this.id;
    }

    public int getSessionNumber() {
        return sessionNumber;
    }

    public void setSessionNumber(int sessionNumber) {
        this.sessionNumber = sessionNumber;
    }

    public static ArrayList<Chapter> chaptersList(){

        ArrayList<Chapter> chapters = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            chapters.add(new Chapter("Chapter "+i, "Genre "+i,"Creator "+i,120+i,(short)(2017+i),i));
        }
        return chapters;
    }

    @Override
    public String toString() {
        return " \n :: CHAPTER ::" +
                "\n Title: "+ getTitle() +
                "\n Genre: "+ getGenre() +
                "\n Year: "+ getYear() +
                "\n Duration: "+ getDuration();
    }
}