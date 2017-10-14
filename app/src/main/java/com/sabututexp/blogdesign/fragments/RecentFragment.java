package com.sabututexp.blogdesign.fragments;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sabututexp.blogdesign.R;
import com.sabututexp.blogdesign.adapter.AlbumsAdapter;
import com.sabututexp.blogdesign.models.Album;

import java.util.ArrayList;
import java.util.List;

public class RecentFragment extends Fragment {

    private RecyclerView recyclerView;
    private AlbumsAdapter adapter;
    private List<Album> albumList;

    public RecentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_recent, container, false);


        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        albumList = new ArrayList<>();
        adapter = new AlbumsAdapter(getActivity().getApplicationContext(), albumList);


        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity().getApplicationContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAlbums();

        return view;
    }

    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.hinder,
                R.drawable.mjbad,
                R.drawable.download,
                R.drawable.adele,
                R.drawable.melvis,
                R.drawable.chief_keef,
                R.drawable.love_on_top,
                R.drawable.killers,
                R.drawable.danger_doom,
                R.drawable.hits_and_unreleased,
                R.drawable.fame,
                R.drawable.fan_of_a_fan,
                R.drawable.heart_of_the_getto,
                R.drawable.legend,
                R.drawable.tragically_hip,
                R.drawable.hqdefault,
                R.drawable.kid_rock,
                R.drawable.pendulum_immersion_artwork,
                R.drawable.radio,
                R.drawable.the_wombats,
                R.drawable.mawlka,
                R.drawable.stack_on_dack,
                R.drawable.queen,
                R.drawable.nothing_real,
                R.drawable.piano};

        Album a = new Album("Maroon 5", 11, covers[14]);
        albumList.add(a);

        a = new Album("Born to Die", 12, covers[15]);
        albumList.add(a);

        a = new Album("Honeymoon", 14, covers[16]);
        albumList.add(a);

        a = new Album("I Need a Doctor", 1, covers[17]);
        albumList.add(a);

        a = new Album("Loud", 11, covers[18]);
        albumList.add(a);

        a = new Album("Legend", 14, covers[19]);
        albumList.add(a);

        a = new Album("Hello", 11, covers[20]);
        albumList.add(a);

        a = new Album("Greatest Hits", 17, covers[21]);
        albumList.add(a);

        a = new Album("True Romance", 13, covers[0]);
        albumList.add(a);

        a = new Album("Chief Keef", 8, covers[1]);
        albumList.add(a);

        a = new Album("Danger Doom", 19, covers[2]);
        albumList.add(a);

        a = new Album("Fame", 18, covers[3]);
        albumList.add(a);

        a = new Album("Kid Rock", 5, covers[6]);
        albumList.add(a);

        a = new Album("Killers", 9, covers[7]);
        albumList.add(a);

        a = new Album("Legend", 17, covers[8]);
        albumList.add(a);

        a = new Album("Love On Top", 15, covers[9]);
        albumList.add(a);

        a = new Album("BAD", 48, covers[10]);
        albumList.add(a);

        a = new Album("Hinder", 3, covers[4]);
        albumList.add(a);

        a = new Album("Hits And Unreleased", 38, covers[5]);
        albumList.add(a);

        a = new Album("Piano", 28, covers[11]);
        albumList.add(a);

        a = new Album("Queen", 12, covers[12]);
        albumList.add(a);

        a = new Album("Radio", 11, covers[13]);
        albumList.add(a);



        adapter.notifyDataSetChanged();
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}
