package com.kijja.quizookbee.quiz4;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface OokBeeService {
    @FormUrlEncoded
    @POST("user/{userId}/books")
    Call<List<Book>> addBook(
            @Path("userId") int userId,
            @Field("bookId") int bookId,
            @Field("bookName") String bookName,
            @Field("bookAuthor") String bookAuthor,
            @Field("bookPrice") double bookPrice
    );
}