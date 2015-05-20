package io.kimo.themoviedb.presentation.view.ui.fragment;

import android.os.Bundle;
import android.view.View;

import io.kimo.themoviedb.R;
import io.kimo.themoviedb.domain.mapper.MovieMapper;
import io.kimo.themoviedb.presentation.model.MovieModel;
import io.kimo.themoviedb.presentation.view.MovieDetailView;
import io.kimo.themoviedb.presentation.view.ui.BaseFragment;

public class MovieDetailFragment extends BaseFragment implements MovieDetailView {

    public static final String TAG = MovieDetailFragment.class.getSimpleName();
    public static final String MOVIE_MODEL = TAG + ".MOVIE_MODEL";

    private MovieModel movieModel;

    public static MovieDetailFragment newInstance(MovieModel movieModel) {
        MovieDetailFragment fragment = new MovieDetailFragment();

        Bundle args = new Bundle();
        args.putString(MOVIE_MODEL, new MovieMapper().serializeModel(movieModel));

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        Bundle args = getArguments();

        if (args != null) {
            movieModel = new MovieMapper().deserializeModel(args.getString(MOVIE_MODEL));
        }

        super.onCreate(savedInstanceState);
    }

    @Override
    public void instantiatePresenter() {

    }

    @Override
    public void initializePresenter() {

    }

    @Override
    public void finalizePresenter() {

    }

    @Override
    public int getLayoutResource() {
        return R.layout.fragment_movie_detail;
    }

    @Override
    public void mapGUI(View view) {

    }

    @Override
    public void configureGUI() {
        getActivity().setTitle(movieModel.getName());
    }

    @Override
    public void updateImage(String value) {

    }

    @Override
    public void updateTitle(String value) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showRetry(String msg) {

    }

    @Override
    public void hideRetry() {

    }

    @Override
    public void showEmpty(String msg) {

    }

    @Override
    public void hideEmpty() {

    }

    @Override
    public void showView() {

    }

    @Override
    public void hideView() {

    }

    @Override
    public void destroyItself() {

    }
}
