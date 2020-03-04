package com.anncode.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * <h1>Book</h1>
 *
 * Hereda de {@link Publication}
 * Implementa de {@link IVisualizable}
 *
 * @author Daniel
 * @version 1.1
 * @since 2019
 * */

public class Book extends Publication implements IVisualizable{

    private int id;
    private String isbn;
    private boolean readed;
    private int timeReaded;
    private ArrayList<Page> pages;


    public Book(String title, Date edititionDate, String editorial, String[] authors) {
        super(title, edititionDate, editorial);
        // TODO Auto-generated constructor stub
        setAuthors(authors);
    }

    public ArrayList<Page> getPages() {
        return pages;
    }

    public void setPages(ArrayList<Page> pages) {
        this.pages = pages;
    }

    public int getId() {
        return id;
    }


    public String getIsbn() {
        return isbn;
    }


    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public String isReaded() {
        String leido = "";
        if(readed == true) {
            leido = "Sí";
        }else {
            leido = "No";
        }

        return leido;
    }


    public void setReaded(boolean readed) {
        this.readed = readed;
    }

    public boolean getIsReaded() {
        return readed;
    }


    public int getTimeReaded() {
        return timeReaded;
    }


    public void setTimeReaded(int timeReaded) {
        this.timeReaded = timeReaded;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        String detailBook = "\n :: BOOK ::" +
                "\n Title: " + getTitle() +
                "\n Editorial: " + getEditorial() +
                "\n Edition Date: " + getEdititionDate() +
                "\n Authors: ";
        for (int i = 0; i < getAuthors().length; i++) {
            detailBook += "\t" + getAuthors()[i] + " ";
        }
        return  detailBook;
    }


    @Override
    public Date starToSee(Date dateI) {
        return dateI;
    }

    @Override
    public void stopToSee(Date dateI, Date dateF) {
        // TODO Auto-generated method stub
        if (dateF.getTime() > dateI.getTime()) {
            setTimeReaded((int)(dateF.getTime() - dateI.getTime()));
        }else {
            setTimeReaded(0);
        }
    }

    public static ArrayList<Book> makeBookList() {
        ArrayList<Book> books = new ArrayList();
        String[] authors = new String[3];
        for (int i = 0; i < 3; i++) {
            authors[i] = "author "+i;
        }
        for (int i = 1; i <= 5; i++) {
            books.add(new Book("Book " + i, new Date(), "editorial " + i, authors));
        }
        return books;
    }

    public void view(){
        setReaded(true);
        Date dateI = starToSee(new Date());

        int i = 0;

        do {
            System.out.println("......");
            System.out.println("Page "+ getPages().get(i).getPageNumber());
            System.out.println(getPages().get(i).getContent());
            System.out.println("......");
        }while (i < getPages().size());

        //Termine de verla
        stopToSee(dateI, new Date());
        System.out.println();
        System.out.println("Leíste: " + toString());
        System.out.println("Por: " + getTimeReaded() + " milisegundos");
    }

    public static class Page{
        private int id;
        private int pageNumber;
        private String content;

        public Page(int pageNumber, String content) {
            this.pageNumber = pageNumber;
            this.content = content;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPageNumber() {
            return pageNumber;
        }

        public void setPageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}










