package io.kimo.themoviedb.domain.usecase;


import android.content.Context;

import java.util.List;

import io.kimo.themoviedb.domain.BaseUseCase;
import io.kimo.themoviedb.domain.BaseUseCaseCallback;
import io.kimo.themoviedb.domain.entity.MovieEntity;
import io.kimo.themoviedb.domain.service.API;
import io.kimo.themoviedb.domain.service.response.SearchMovieResponse;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class SearchMovieUseCase extends BaseUseCase {

    public interface SearchMovieUseCaseCallback extends BaseUseCaseCallback {
        void onMoviesSearched(List<MovieEntity> movieEntities);
    }

    private String apiKey;
    private String query;

    public SearchMovieUseCase(Context context, String apiKey, String query, SearchMovieUseCaseCallback callback) {
        super(context, callback);
        this.apiKey = apiKey;
        this.query = query;
    }

    @Override
    public void onRun() throws Throwable {
        super.onRun();

        API.http().searchMovie(apiKey, query, new Callback<SearchMovieResponse>() {
            @Override
            public void success(SearchMovieResponse searchMovieResponse, Response response) {
                ((SearchMovieUseCaseCallback) callback).onMoviesSearched(searchMovieResponse.getResults());
            }

            @Override
            public void failure(RetrofitError error) {
                if (error.getKind() == RetrofitError.Kind.NETWORK) {
                    errorReason = NETWORK_ERROR;
                } else {
                    errorReason = error.getResponse().getReason();
                }
                onCancel();
            }
        });
    }
}
