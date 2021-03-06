package com.example.spart.myapplication.Api;





import com.example.spart.myapplication.MyArticleSearchAPI.ArticleSearchResponse;
import com.example.spart.myapplication.MyBusinessAPI.BusinessResponse;
import com.example.spart.myapplication.MyMostPopularAPI.MostPopularResponse;
import com.example.spart.myapplication.MyTopStoriesAPI.TopStoriesResponse;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

import static com.example.spart.myapplication.Utils.Constant.API_KEY;
import static com.example.spart.myapplication.Utils.Constant.BUSINESS;
import static com.example.spart.myapplication.Utils.Constant.MOST_POPULAR;
import static com.example.spart.myapplication.Utils.Constant.SEARCH_ARTICLES;
import static com.example.spart.myapplication.Utils.Constant.SPORTS;
import static com.example.spart.myapplication.Utils.Constant.TOP_STORIES;



public interface SectionsAPI {

    @GET(TOP_STORIES + "?api-key=" + API_KEY)
    Call<TopStoriesResponse> TSArticles();

    @GET(MOST_POPULAR +  "?api-key=" + API_KEY)
    Call<MostPopularResponse> MPArticles(@Header("time-period") String time, @Header("section") String section);

    @GET(BUSINESS +  "?api-key=" + API_KEY)
    Call<BusinessResponse> BUArticles(@Header("section") String section);


    @GET(SEARCH_ARTICLES +  "?api-key=" + API_KEY)
    Observable<ArticleSearchResponse> SearchArticles(@Query("q") String keyWords, @Query("fq") String category, @Query("begin_date") String beginDate, @Query("end_date") String endDate);


}





