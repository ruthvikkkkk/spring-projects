package com.myexamples.reactivetwo.reactivetwo.utils;

import com.myexamples.reactivetwo.reactivetwo.dto.DirectorDto;
import com.myexamples.reactivetwo.reactivetwo.dto.MovieDto;
import com.myexamples.reactivetwo.reactivetwo.entity.Director;
import com.myexamples.reactivetwo.reactivetwo.entity.Movie;
import org.springframework.beans.BeanUtils;

public class DataUtils {

    public static Movie dtoToEntity(MovieDto movieDto){
        Movie movie = new Movie();
        BeanUtils.copyProperties(movieDto, movie);
        return movie;
    }

    public static Director dtoToEntity(DirectorDto directorDto){
        Director director = new Director();
        BeanUtils.copyProperties(directorDto, director);
        return director;
    }

    public static MovieDto entityToDto(Movie movie){
        MovieDto movieDto = new MovieDto();
        BeanUtils.copyProperties(movie, movieDto);
        return movieDto;
    }

    public static DirectorDto entityToDto(Director director){
        DirectorDto directorDto = new DirectorDto();
        BeanUtils.copyProperties(director, directorDto);
        return directorDto;
    }
}
