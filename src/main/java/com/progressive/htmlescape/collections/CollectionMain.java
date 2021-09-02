package com.progressive.htmlescape.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionMain {
    public static void main(String[] args) {
        Movie movie1 = new Movie("A",5);
        Movie movie2 = new Movie("B",2);
        Movie movie3 = new Movie("C",6);
        Movie movie4 = new Movie("D",4);
        Movie movie5 = new Movie("E",8);
        List<Movie> movies = new ArrayList<Movie>(){{
            add(movie1);
            add(movie2);
            add(movie3);
            add(movie4);
            add(movie5);
        }};
        Collections.sort(movies);
        movies.forEach(x-> System.out.println(x.toString()));
    }
}
