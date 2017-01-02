package objects;

import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;


/**
 * Created by Alexis on 31/12/2016.
 */

public class MovieImageView {

    private Bitmap image;
    private String movieTitle;
    private String imageUrl;

    public MovieImageView(String movieTitle, String imageUrl) {
        this.movieTitle = movieTitle;
        this.imageUrl = imageUrl;
    }


    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public Bitmap getImage() {
        return image;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String constructURL() {
        Uri uriBuilder =  new Uri.Builder()
                .scheme("http")
                .encodedAuthority("image.tmdb.org/t/p")
                .appendPath("w185")
                .appendEncodedPath(imageUrl)
                .build();
        String url = uriBuilder.toString();
        Log.v("Construct URL", url);
        //String url = "http://image.tmdb.org/t/p/w185/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg";
        return url;

    }


}
