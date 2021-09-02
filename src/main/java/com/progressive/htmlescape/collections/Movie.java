package com.progressive.htmlescape.collections;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Movie implements Comparable<Movie> {
    private String name;
    private Integer year;

    @Override
    public int compareTo(Movie movie) {
        return this.year - movie.year;
    }

    public Movie(String name, Integer year) {
        this.name = name;
        this.year = year;
    }

}
