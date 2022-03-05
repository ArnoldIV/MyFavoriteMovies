package com.arnold.myfavoritemovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.arnold.myfavoritemovies.databinding.ActivityAddEditBinding;
import com.arnold.myfavoritemovies.model.Movie;

public class AddEditActivity extends AppCompatActivity {
    private Movie movie;
    public static final String MOVIE_ID = "movieId";
    public static final String MOVIE_NAME = "movieName";
    public static final String MOVIE_DESCRIPTION = "movieDescription";
    private ActivityAddEditBinding activityAddEditBinding;
    private AddEditActivityClickHandlers addEditActivityClickHandlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);

        movie = new Movie();
        activityAddEditBinding = DataBindingUtil.
                setContentView(this, R.layout.activity_add_edit);
        activityAddEditBinding.setMovie(movie);
        addEditActivityClickHandlers = new AddEditActivityClickHandlers(this);
        activityAddEditBinding.setClickHandlers(addEditActivityClickHandlers);

        Intent intent = getIntent();
        /*if pressed object in recycler view have id,then title change to "Edit movie" and
        open info of pressed movie,else create new movie
        */
        if (intent.hasExtra(MOVIE_ID)) {
            setTitle("Edit movie");
            movie.setMovieName(intent.getStringExtra(MOVIE_NAME));
            movie.setMovieDescription(intent.getStringExtra(MOVIE_DESCRIPTION));
        } else {
            setTitle("Add movie");
        }
    }

    public class AddEditActivityClickHandlers {
        Context context;

        public AddEditActivityClickHandlers(Context context) {
            this.context = context;
        }
        //after filling all strings and pressing button "Okey" add new movie
        public void onOKButtonClicked(View view) {
            if (movie.getMovieName() == null) {
                Toast.makeText(context, "Please input the name", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent();
                intent.putExtra(MOVIE_NAME, movie.getMovieName());
                intent.putExtra(MOVIE_DESCRIPTION, movie.getMovieDescription());
                setResult(RESULT_OK, intent);
                finish();
            }
        }
    }
}