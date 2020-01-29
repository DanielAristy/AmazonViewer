package com.anncode.amazonviewer.model;

import java.util.ArrayList;

public class Serie extends Film {

    private int id;
    private int sessionQuantity;
    private ArrayList<Chapter> chapters;

    public Serie(String title, String genre, String creator, int duration, int sessionQuantity,ArrayList<Chapter> chapters) {
        //Hace referencia a la clase padre
        super(title, genre, creator, duration);
        //Elementos hijos de la clase padre por eso usamos this
        this.sessionQuantity = sessionQuantity;
        this.chapters = chapters;
    }

    public int getId() {
        return id;
    }

    public int getSessionQuantity() {
        return sessionQuantity;
    }

    public void setSessionQuantity(int sessionQuantity) {
        this.sessionQuantity = sessionQuantity;
    }

    public ArrayList<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(ArrayList<Chapter> chapters) {
        this.chapters = chapters;
    }

    public static ArrayList<Serie> seriesList(){
        ArrayList<Serie> series = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            series.add(new Serie("Serie "+i, "Genre "+ i,
                    "Creator " +i, 1200 +i,i+1,Chapter.chaptersList()));
        }
        return series;
    }

    @Override
    public String toString() {
        return " \n :: SERIE ::" +
                "\n Title: "+ getTitle() +
                "\n Genre: "+ getGenre() +
                "\n Year: "+ getYear() +
                "\n Year: "+ getCreator() +
                "\n Duration: "+ getDuration();
    }
}
