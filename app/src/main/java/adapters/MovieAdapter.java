package adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alexis.popularmovies.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

import objects.MovieImageView;


/**
 * Created by Alexis on 31/12/2016.
 */

public class MovieAdapter extends ArrayAdapter<MovieImageView> {

    private final static String LOG_TAG = MovieAdapter.class.getSimpleName();


    Context mContext;
    List<MovieImageView> mMovieImageViews;

    public MovieAdapter(Context context, List<MovieImageView> objects) {
        super(context, R.layout.grid_item_layout, objects);
        this.mContext = context;
        this.mMovieImageViews = objects;

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


        movieHolder.movieTitle.setText(mMovieImageViews.get(position).getMovieTitle());

        final MovieHolder finalMovieHolder = movieHolder;
        Picasso.with(mContext)
                .load(mMovieImageViews.get(position).constructURL())
                //.error()
                .into(movieHolder.movieImage);


        return movieView;
    }

    static class MovieHolder implements Target{
        protected ImageView movieImage;
        protected TextView movieTitle;


        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
            movieImage.setImageBitmap(bitmap);
            Log.v("onBitmapLoaded", "Image Loaded");
        }

        @Override
        public void onBitmapFailed(Drawable errorDrawable) {
            movieImage.setImageDrawable(errorDrawable);
            Log.e(LOG_TAG, "Error on loading Image with Picasso");
        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {
            movieImage.setImageDrawable(placeHolderDrawable);
        }
    }
}
