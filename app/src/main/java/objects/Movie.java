package objects;

import android.net.Uri;

import java.util.Date;


/**
 * Created by Alexis on 31/12/2016.
 */

public class Movie {

    private String title;
    private String originalTitle;
    private String originalLanguage;
    private String imageUrl;
    private boolean adult;
    private String description;
    private Date fechaLanzamiento;
    private double voteAverage;


    public Movie(String title, String originalTitle, String originalLanguage, String imageUrl,
                 boolean adult, String description, Date fechaLanzamiento, double voteAverage) {
        this.title = title;
        this.originalTitle = originalTitle;
        this.originalLanguage = originalLanguage;
        this.imageUrl = imageUrl;
        this.adult = adult;
        this.description = description;
        this.fechaLanzamiento = fechaLanzamiento;
        this.voteAverage = voteAverage;
    }

    public String getTitle() {
        return title;
    }

    public String constructURL() {
        Uri uriBuilder =  new Uri.Builder()
                .scheme("http")
                .encodedAuthority("image.tmdb.org/t/p")
                .appendPath("w185")
                .appendEncodedPath(imageUrl)
                .build();
        String url = uriBuilder.toString();
        //String url = "http://image.tmdb.org/t/p/w185/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg";
        return url;

    }


}
