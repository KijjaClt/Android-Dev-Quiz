package com.kijja.quizookbee.quiz4;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Quiz4 {
    private final static String ACCESS_KEY = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";

    public static void main(String[] args) {
        OkHttpClient.Builder client = new OkHttpClient().newBuilder();
        client.addInterceptor(chain -> {
            Request request = chain.request().newBuilder().addHeader("Authorization", ACCESS_KEY).build();
            chain.proceed(request);
            return null;
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ookbee.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();

        OokBeeService service = retrofit.create(OokBeeService.class);

        Call call = service.addBook(
                1911,
                2002,
                "Quiz test",
                "OokBee",
                35.55
        );

        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                if (response.code() == 200) {
                    List<Book> bookList = response.body();

                    if (bookList == null) {
                        System.out.println("Book list is empty");
                        return;
                    }

                    for (Book book : bookList) {
                        System.out.println(book.toString());
                    }
                } else {
                    System.out.println("API error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }
}
