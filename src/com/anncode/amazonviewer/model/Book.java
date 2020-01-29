package com.anncode.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

public class Book extends Publication implements IVisualizable{

    private int id;
    private String isbn;
    private boolean readed;
    private int timeReaded;

    public Book(String title, Date editionDate, String editotial, String[] autors, String isbn) {
        super(title, editionDate, editotial, autors);
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean getIsReaded(){
        return readed;
    }
    public String isReaded() {
        String leido = "";
        if (readed == true){
            leido = "Sí";
        }else {
            leido = "No";
        }
        return leido;
    }

    public void setReaded(boolean readed) {
        this.readed = readed;
    }

    public int getTimeReaded() {
        return timeReaded;
    }

    public void setTimeReaded(int timeReaded) {
        this.timeReaded = timeReaded;
    }

    @Override
    public Date starToSee(Date dateI) {
        return dateI;
    }

    @Override
    public void stopToSee(Date dateI, Date dateF) {

        if (dateF.getTime() > dateI.getTime()){
            setTimeReaded((int)(dateF.getTime() - dateI.getTime()));
        }else {
            setTimeReaded(0);
        }
    }

    public static ArrayList<Book> booksList(){

        ArrayList<Book> books = new ArrayList<>();
        String[] autors = new String[3];
        for (int i = 0; i < 3 ; i++) {
            autors[i] = "author "+i;
        }
        for (int i = 0; i < 5 ; i++) {
            books.add(new Book("Book "+i,new Date(),"Editorial "+i,autors,"ABC"+i));
        }
        return books;
    }

    @Override
    public String toString() {

        String detailBook = "\n :: BOOK ::" +
                "\n Title: "+ getTitle() +
                "\n editionDate: "+ getEditionDate() +
                "\n Editorial: "+ getEditotial() +
                "\n Isbn: "+ getIsbn();
        for (int i = 0; i < getAutors().length ; i++) {
            detailBook += "\t" + getAutors()[i];
        }

        return detailBook;
    }
}
