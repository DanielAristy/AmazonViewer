package com.anncode.amazonviewer;
import com.anncode.amazonviewer.model.Book;
import com.anncode.amazonviewer.model.Chapter;
import com.anncode.amazonviewer.model.Movie;
import com.anncode.amazonviewer.model.Serie;
import com.anncode.makereport.Report;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu(){
        int exit = 0;
        do {
            System.out.println("BIENVENIDOS A AMAZON VIEWER\n");
            System.out.println("Selecciona el número de la opción deseada");
            System.out.println("1. Movies");
            System.out.println("2. Series");
            System.out.println("3. Books");
            System.out.println("4. Magazines");
            System.out.println("5. Report");
            System.out.println("6. Report today");
            System.out.println("0. Exit");

            //Leer los datos del usuario
            Scanner sc = new Scanner(System.in);
            int response = Integer.valueOf(sc.nextInt());

            switch (response){
                case 0:
                    exit = 0;
                    break;

                case 1:
                    showMovies();
                    break;

                case 2:
                    showSeries();
                    break;

                case 3:
                    showBooks();
                    break;

                case 4:
                    showMagazines();
                    break;

                case 5:
                    makeReport();
                    break;

                case 6:
                    makeReport(new Date());
                    break;

                default:
                    System.out.println("\n...¡¡Selecciona una opción!!..\n");
                    break;
            }

        }while (exit != 0);
    }

    static ArrayList<Movie> movies;
    public static void showMovies(){
        int exit = 1;
        movies = Movie.moviesList();
        do {
            System.out.println("\n :: MOVIES ::\n");

            for (int i = 0; i < movies.size() ; i++) {//1. Movie
                System.out.println(i+1 + ". " + movies.get(i).getTitle() + " Visto: " + movies.get(i).isViewed());
            }
            System.out.println("0. Regresar al Menu\n");

            //Leer Respuesta
            Scanner sc = new Scanner(System.in);
            int response = Integer.valueOf(sc.nextInt());
            if (response == 0){
                showMenu();
            }

            if (response > 0 ){
                Movie movieSelected = movies.get(response - 1);
                movieSelected.setViewed(true);
                Date dateI = movieSelected.starToSee(new Date());

                //Termine de ver la pelicula

                for (int i = 0; i < 10000; i++) {
                    System.out.println("......");
                }
                movieSelected.stopToSee(dateI, new Date());
                System.out.println("\nViste: " + movieSelected);
                System.out.println("Por: " + movieSelected.getTimeViewed() + " miliSegundos");
            }
        }while (exit != 0);
    }

    public static void showSeries(){
        int exit = 1;
        ArrayList<Serie> series = Serie.seriesList();

        do {
            System.out.println("\n :: SERIES ::\n");
            for (int i = 0; i < series.size(); i++) {
                System.out.println(i+1 + ". " + series.get(i).getTitle()+ " Visto: "+ series.get(i).isViewed());
            }
            System.out.println("0. Regresar al Menu\n");

            //Leer Datos
            Scanner sc = new Scanner(System.in);
            int response = Integer.valueOf(sc.nextInt());
            if (response == 0){
                showMenu();
            }

            showChapters(series.get(response-1).getChapters());

        }while (exit != 0);
    }

    public static void showChapters(ArrayList<Chapter> chaptersOfSerieSelected){
        int exit = 1;

        do {
            System.out.println("\n :: CHAPTERS ::\n");
            for (int i = 0; i < chaptersOfSerieSelected.size(); i++) {
                System.out.println(i+1+". "+ chaptersOfSerieSelected.get(i).getTitle()+" Visto: "+chaptersOfSerieSelected.get(i).isViewed());
            }

            System.out.println("0. Regresar al Menu\n");

            //Leer Datos
            Scanner sc = new Scanner(System.in);
            int response = Integer.valueOf(sc.nextInt());
            if (response == 0){
                exit = 0;
            }

            Chapter chapterSelected = chaptersOfSerieSelected.get(response-1);
            chapterSelected.setViewed(true);
            Date dateI = chapterSelected.starToSee(new Date());

            for (int i = 0; i < 10000; i++) {
                System.out.println("......");
             }

            //Termine de verla
            chapterSelected.stopToSee(dateI, new Date());
            System.out.println("\nViste: " + chapterSelected);
            System.out.println("Por: " + chapterSelected.getTimeViewed() + " miliSegundos");

        }while (exit != 0);
    }

    static ArrayList<Book> books;
    public static void showBooks(){

        books = Book.booksList();
        int exit = 1;
        do {
            System.out.println("\n :: BOOKS ::\n");
            for (int i = 0; i < books.size(); i++) {
                System.out.println((i+1)+". "+ books.get(i).getTitle()+ " Leido: "+books.get(i).isReaded());
            }
            System.out.println("0. Regresar al Menu\n");

            //Leer Respuesta
            Scanner sc = new Scanner(System.in);
            int response = Integer.valueOf(sc.nextInt());
            if (response == 0){
                exit = 0;
                showMenu();
            }

            if (response > 0){
                Book bookSelected = books.get(response-1);
                bookSelected.setReaded(true);

                Date dateI = bookSelected.starToSee(new Date());

                //Terminar de ver la Pélicula

                for (int i = 0; i <10000 ; i++) {
                    System.out.println("........");
                }

                bookSelected.stopToSee(dateI, new Date());
                System.out.println("\nViste: "+ bookSelected);
                System.out.println("Por: "+bookSelected.getTimeReaded()+" miliSegundos");
            }

        }while (exit != 0);
    }

    public static void showMagazines(){
        int exit = 0;
        do {
            System.out.println("\n :: MAGAZINES ::\n");
        }while (exit != 0);
    }

    public static void makeReport(){

        Report report = new Report();
        report.setNameFile("reporte");
        report.setExtension("txt");
        report.setTitle(":: VISTOS ::");
        String contentReport = "";

        for (Movie movie: movies) {
            if (movie.getIsViewed()){
                contentReport += movie.toString()+"\n";
            }
        }

        for (Book book: books) {
            if (book.getIsReaded()){
                contentReport += book.toString()+"\n";
            }
        }
        report.setContent(contentReport);
        report.mekeReport();
        System.out.println("Reporte Generado\n");
    }

    public static void makeReport(Date date){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = sdf.format(date);

        Report report = new Report();

        report.setNameFile("reporte " + dateString);
        report.setExtension("txt");
        report.setTitle(":: VISTOS ::");
        String contentReport = "";

        for (Movie movie: movies) {
            if (movie.getIsViewed()){
                contentReport += movie.toString()+"\n";
            }
        }

        for (Book book: books) {
            if (book.getIsReaded()){
                contentReport += book.toString()+"\n";
            }
        }
        report.setContent(contentReport);
        report.mekeReport();
        System.out.println("Reporte Generado\n");

    }
}
