package com.anncode.amazonviewer.model;

import java.util.Date;

public class Publication {

    private String title;
    private Date editionDate;
    private String editotial;
    private String[] autors;

    public Publication(String title, Date editionDate, String editotial, String[] autors) {
        this.title = title;
        this.editionDate = editionDate;
        this.editotial = editotial;
        this.autors = autors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getEditionDate() {
        return editionDate;
    }

    public void setEditionDate(Date editionDate) {
        this.editionDate = editionDate;
    }

    public String getEditotial() {
        return editotial;
    }

    public void setEditotial(String editotial) {
        this.editotial = editotial;
    }

    public String[] getAutors() {
        return autors;
    }

    public void setAutors(String[] autors) {
        this.autors = autors;
    }
}
