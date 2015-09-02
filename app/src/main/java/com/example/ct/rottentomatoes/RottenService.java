package com.example.ct.rottentomatoes;

import com.example.ct.rottentomatoes.models.MovieDetail;
import com.example.ct.rottentomatoes.models.Movies;
import com.orhanobut.wasp.CallBack;
import com.orhanobut.wasp.http.GET;
import com.orhanobut.wasp.http.Query;


public interface RottenService {

    @GET("/lists/movies/box_office.json")
    void getBoxOffice(@Query("limit") int limit,
                   CallBack<Movies> callBack);

    @GET("/lists/movies/in_theaters.json")
    void getInTheaters(@Query("page_limit") int pageLimit,
                   CallBack<Movies> callBack);

    @GET("/lists/movies/opening.json")
    void getOpening(@Query("limit") int limit,
                    CallBack<Movies> callBack);

    @GET("/lists/movies/upcoming.json")
    void getUpcoming(@Query("page_limit") int pageLimit,
                     CallBack<Movies> callBack);

}
