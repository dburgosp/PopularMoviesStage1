# Popular Movies - Stage 1

This is a simple Android Studio project for the [Associate Android Developer Fast Track Nanodegree Program](https://in.udacity.com/course/associate-android-developer-fast-track--nd818) taught by Udacity and Google. The goal was to build an app to help users discover popular and recent movies, fetching information from [The Movie DB API](https://www.themoviedb.org/documentation/api).

The app works like this:

* Present the user with a grid arrangement of movie posters upon launch.
* Allow the user to change sort order via a setting. The sort order can be by most popular or by highest-rated.
* Allow the user to tap on a movie poster and transition to a details screen with additional information such as:
  * Original title.
  * Movie poster image thumbnail.
  * A plot synopsis (called overview in the api).
  * User rating (called vote_average in the api).
  * Release date.

Some screen captures:

<IMG src="https://github.com/dburgosp/PopularMoviesStage1/blob/master/img-popular.jpg?raw=true" width="150" height="279" title="Popular movies list" alt="Popular movies list"/> <IMG src="https://github.com/dburgosp/PopularMoviesStage1/blob/master/img-top-rated.jpg?raw=true" width="150" height="279" title="Top rated movies list" alt="Top rated movies list"/> <IMG src="https://github.com/dburgosp/PopularMoviesStage1/blob/master/img-movie-details.jpg?raw=true" width="150" height="279" title="Movie details" alt="Movie details"/>

# Notes

* **You need an API key from The Movie DB to run this app**. I have removed my personal API key from this project by moving it to gradle.properties and adding this file to .gitignore before sharing my project to GitHub, as explained in [this post from Richard Rose's Blog](https://richardroseblog.wordpress.com/2016/05/29/hiding-secret-api-keys-from-git/). You can get information for getting your own free API key from The Movie DB [here](https://www.themoviedb.org/faq/api).
* As recommended, I have used [Picasso](http://square.github.io/picasso/) to manage the movie posters.
* Besides the Project Specifications below, I have implemented some suggestions from the reviewer of this project in the course:
  * I have moved the AsyncTask class that fetches information from The Movie DB into a separate file, in order to make the code more maintainable, as explained in [this post from James Elsey's blog](http://www.jameselsey.co.uk/blogs/techblog/extracting-out-your-asynctasks-into-separate-classes-makes-your-code-cleaner/).
  * In my first solution, the click event to open a new activity with the movie details was managed within the ViewHolder code. I have finally set a click listener to my RecyclerView, as explained in [this page from Antonio Leiva's website](https://antonioleiva.com/recyclerview-listener/), so I can now manage the click event from my main activity, while creating and configuring the RecyclerView. Thus, the details activity will be opened from the main activity rather than from the ViewHolder.
  * My Movie objects (my custom class for storing movie information) are now created as Parcelable, so I can pass this objects between activities, as explained in [this guide from CodePath](https://guides.codepath.com/android/using-parcelable).

# Project Specifications

## Common Project Requirements

* App is written solely in the Java Programming Language.
* Movies are displayed in the main layout via a grid of their corresponding movie poster thumbnails.
* UI contains an element (i.e a spinner or settings menu) to toggle the sort order of the movies by: most popular, highest rated.
* UI contains a screen for displaying the details for a selected movie.
* Movie details layout contains title, release date, movie poster, vote average, and plot synopsis.

## User Interface - Function

* When a user changes the sort criteria (“most popular and highest rated”) the main view gets updated correctly.
* When a movie poster thumbnail is selected, the movie details screen is launched.

## Network API Implementation

* In a background thread, app queries the [/movie/popular](https://developers.themoviedb.org/3/movies/get-popular-movies) or [/movie/top_rated](https://developers.themoviedb.org/3/movies/get-top-rated-movies) API for the sort criteria specified in the settings menu.

## General Project Guidelines

* App conforms to common standards found in the [Android Nanodegree General Project Guidelines](http://udacity.github.io/android-nanodegree-guidelines/core.html).
