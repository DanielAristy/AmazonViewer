package com.anncode.amazonviewer.model;

import java.util.Date;

public interface IVisualizable {

    /**
     * Este método captura el tiempo exacto de inicio de visualización
     * @param dateI es un objeto {@code Date} con el tiempo de inicio exacto exacto.
     * @return Devuelvela fecha y hora capturada
     * */
    Date starToSee(Date dateI);

    /**
     * Este método captura el tiempo exacto de inicio y final visualización
     *
     * @param dateI es un objeto {@code Date} con el tiempo de inicio exacto.
     * @param dateF es un obejto {@code Date} con el tiempo final exacto.
     * */
    void stopToSee(Date dateI, Date dateF);
}
