package adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alexis.popularmovies.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import objects.Movie;


/**
 * Created by Alexis on 31/12/2016.
 */

public class MovieAdapter extends ArrayAdapter<Movie> {

    private final static String LOG_TAG = MovieAdapter.class.getSimpleName();


    Context mContext;
    List<Movie> mMovies;

    public MovieAdapter(Context context, List<Movie> objects) {
        super(context, R.layout.grid_item_layout, objects);
        this.mContext = context;
        this.mMovies = objects;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View movieView;
        MovieHolder movieHolder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            movieView = inflater.inflate(R.layout.grid_item_layout, null);

            movieHolder = new MovieHolder();
            movieHolder.movieImage = (ImageView) movieView.findViewById(R.id.movie_image);
            movieHolder.movieTitle = (TextView) movieView.findViewById(R.id.movie_title);
            movieHolder.movieImage.setPadding(8,8,8,8);
            movieHolder.movieImage.setAdjustViewBounds(true);
            movieHolder.movieImage.setScaleType(ImageView.ScaleType.FIT_CENTER);

            movieView.setTag(movieHolder);

        }else {
            movieView = convertView;
        }

        movieHolder = (MovieHolder) movieView.getTag();


        movieHolder.movieTitle.setText(mMovies.get(position).getTitle());

        Picasso.with(mContext)
                .load(mMovies.get(position).constructURL())
                //.error()
                .into(movieHolder.movieImage);


        return movieView;
    }

    static class MovieHolder{
        protected ImageView movieImage;
        protected TextView movieTitle;
    }
}
