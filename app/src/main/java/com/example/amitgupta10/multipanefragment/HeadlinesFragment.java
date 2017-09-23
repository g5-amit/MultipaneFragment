/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.amitgupta10.multipanefragment;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HeadlinesFragment extends ListFragment {
    OnHeadlineSelectedListener mCallback;

    // The container Activity must implement this interface so the frag can deliver messages
    public interface OnHeadlineSelectedListener {
        /** Called by HeadlinesFragment when a list item is selected */
        public void onArticleSelected(int position);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("amit", "Fragment onCreate() 1");
        super.onCreate(savedInstanceState);

        // We need to use a different list item layout for devices older than Honeycomb
        int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ?
                android.R.layout.simple_list_item_activated_1 : android.R.layout.simple_list_item_1;

        // Create an array adapter for the list view, using the Ipsum headlines array
        setListAdapter(new ArrayAdapter<String>(getActivity(), layout, Ipsum.Headlines));
        Log.d("amit", "Fragment onCreate() 2");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("amit", "Fragment onCreateView() 1");
        View view =  super.onCreateView(inflater, container, savedInstanceState);
        Log.d("amit", "Fragment onCreateView() 2");
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d("amit", "Fragment onActivityCreated() 1");
        super.onActivityCreated(savedInstanceState);
        Log.d("amit", "Fragment onActivityCreated() 2");

    }

    @Override
    public void onStart() {
        Log.d("amit", "Fragment onStart() 1");
        super.onStart();

        // When in two-pane layout, set the listview to highlight the selected list item
        // (We do this during onStart because at the point the listview is available.)
        if (getFragmentManager().findFragmentById(R.id.article_fragment) != null) {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }
        Log.d("amit", "Fragment onStart() 2");

    }

    @Override
    public void onAttach(Activity activity) {
        Log.d("amit", "Fragment onAttach() 1");
        super.onAttach(activity);
        Log.d("amit", "Fragment onAttach() 2");

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception.
        try {
            mCallback = (OnHeadlineSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        Log.d("amit", "Fragment onViewStateRestored() 1");
        super.onViewStateRestored(savedInstanceState);
        Log.d("amit", "Fragment onViewStateRestored() 2");
    }

    @Override
    public void onResume() {
        Log.d("amit", "Fragment onResume() 1");
        super.onResume();
        Log.d("amit", "Fragment onResume() 2");

    }

    @Override
    public void onPause() {
        Log.d("amit", "Fragment onPause() 1");
        super.onPause();
        Log.d("amit", "Fragment onPause() 2");
    }

    @Override
    public void onStop() {
        Log.d("amit", "Fragment onStop() 1");
        super.onStop();
        Log.d("amit", "Fragment onStop() 2");
    }

    @Override
    public void onDestroyView() {
        Log.d("amit", "Fragment onDestroyView() 1");
        super.onDestroyView();
        Log.d("amit", "Fragment onDestroyView() 2");
    }

    @Override
    public void onDestroy() {
        Log.d("amit", "Fragment onDestroy() 1");
        super.onDestroy();
        Log.d("amit", "Fragment onDestroy() 2");
    }

    @Override
    public void onDetach() {
        Log.d("amit", "Fragment onDetach() 1");
        super.onDetach();
        Log.d("amit", "Fragment onDetach() 2");
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // Notify the parent activity of selected item
        mCallback.onArticleSelected(position);
        
        // Set the item as checked to be highlighted when in two-pane layout
        getListView().setItemChecked(position, true);
    }
}