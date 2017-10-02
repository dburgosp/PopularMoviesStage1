package com.example.android.popularmoviesstage1;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by David on 19/09/2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesViewHolder> {

    private static final String TAG = MoviesAdapter.class.getSimpleName();
    private ArrayList<Movie> moviesArray;
    private FrameLayout.LayoutParams layoutParams;

    /**
     * Set a click listener to the RecyclerView, so we can manage OnClick events from the Main
     * Activity from which the RecyclerView is created.
     *
     * Source: https://antonioleiva.com/recyclerview-listener/
     */
    public interface OnItemClickListener {
        void onItemClick(Movie item);
    }
    private final OnItemClickListener listener;

    /**
     * Constructor for this class.
     *
     * @param moviesArray  is the list of movies that will be represented into the adapter.
     * @param widthPixels  is the width in pixels of a movie poster.
     * @param heightPixels is the height in pixels of a movie poster.
     */
    MoviesAdapter(ArrayList<Movie> moviesArray, int widthPixels, int heightPixels, OnItemClickListener listener) {
        Log.i(TAG, "(MoviesAdapter) Object created");
        this.moviesArray = moviesArray;
        this.listener = listener;
        layoutParams = new FrameLayout.LayoutParams(widthPixels, heightPixels);
    }

    /**
     * Setter method for updating the list of movies in the adapter.
     *
     * @param moviesArray is the new list of movies.
     */
    void setMoviesArray(ArrayList<Movie> moviesArray) {
        Log.i(TAG, "(setMoviesArray) Movie list updated");
        this.moviesArray = moviesArray;
    }

    /**
     * Called when RecyclerView needs a new {@link MoviesViewHolder} of the given type to represent
     * an item.
     * <p>
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     * <p>
     * The new ViewHolder will be used to display items of the adapter using
     * {@link #onBindViewHolder(MoviesViewHolder, int)}. Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary {@link View#findViewById(int)} calls.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     * @see #getItemViewType(int)
     * @see #onBindViewHolder(MoviesViewHolder, int)
     */
    @Override
    public MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i(TAG, "(onCreateViewHolder) ViewHolder created");
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new MoviesViewHolder(view);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link MoviesViewHolder#itemView} to reflect the item at the given
     * position.
     * <p>
     * Note that unlike {@link ListView}, RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the <code>position</code> parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use {@link MoviesViewHolder#getAdapterPosition()} which will
     * have the updated adapter position.
     * <p>
     * Override {@link #onBindViewHolder(MoviesViewHolder, int)} instead if Adapter can
     * handle efficient partial bind.
     *
     * @param viewHolder The ViewHolder which should be updated to represent the contents of the
     *                   item at the given position in the data set.
     * @param position   The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(MoviesViewHolder viewHolder, int position) {
        Log.i(TAG, "(onBindViewHolder) Displaying data at position " + position);
        if (!moviesArray.isEmpty()) {
            // Set info for current movie.
            viewHolder.bind(moviesArray.get(position), listener, layoutParams);
        }
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        int itemCount = moviesArray.size();
        Log.i(TAG, "(getItemCount) Number of items in this adapter: " + itemCount);
        return itemCount;
    }
}