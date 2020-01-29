package com.anncode.amazonviewer.model;

import java.util.Date;

public class Magazine extends  Publication{

    private int id;

    public Magazine(String title, Date editionDate, String editotial, String[] autors) {
        super(title, editionDate, editotial, autors);
    }

    @Override
    public String toString() {
        return  "\n :: MAGAZINE ::" +
                "\n Title: "+ getTitle() +
                "\n editionDate: "+ getEditionDate() +
                "\n Editorial: "+ getEditotial();
    }
}
