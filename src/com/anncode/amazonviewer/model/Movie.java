package com.anncode.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

public class Movie extends Film implements IVisualizable {

    private int id;
    private int timeViewed;

    //Aplicando la herencia con el constructor de la clase padre en este caso de la clase Film
    public Movie(String title, String genre, String creator, int duration, short year) {
        super(title, genre, creator, duration);
        setYear(year);
    }

    public void showData(){
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public int getId() {
        return id;
    }

    public int getTimeViewed() {
        return timeViewed;
    }

    public void setTimeViewed(int timeViewed) {
        this.timeViewed = timeViewed;
    }

    @Override
    public Date starToSee(Date dateI) {
        return dateI;
    }

    @Override
    public void stopToSee(Date dateI, Date dateF) {

        if (dateF.getTime() > dateI.getTime()){
            setTimeViewed((int)(dateF.getTime() - dateI.getTime()));
        }else {
            setTimeViewed(0);
        }
    }

    public static ArrayList<Movie> moviesList(){
        ArrayList<Movie> movies = new ArrayList<>();

        for (int i = 1; i <= 5 ; i++) {
            movies.add(new Movie("Movie "+ i, "Genero "+i, "Creator "+i, 120+i, (short)(2017+i)));
        }
        return movies;
    }

    @Override
    public String toString() {
        return " \n :: MOVIE ::" +
                "\n Title: "+ getTitle() +
                "\n Genre: "+ getGenre() +
                "\n Year: "+ getYear() +
                "\n Duration: "+ getDuration();
    }
}
