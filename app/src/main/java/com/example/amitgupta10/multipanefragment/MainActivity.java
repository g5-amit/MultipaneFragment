package com.example.amitgupta10.multipanefragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

public class MainActivity extends FragmentActivity
        implements HeadlinesFragment.OnHeadlineSelectedListener {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("amit", "Activity onCreate() 1");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_articles);

        // Check whether the activity is using the layout version with
        // the fragment_container FrameLayout. If so, we must add the first fragment
        if (findViewById(R.id.headlines_fragment) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create an instance of ExampleFragment
            HeadlinesFragment firstFragment = new HeadlinesFragment();

            // In case this activity was started with special instructions from an Intent,
            // pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.headlines_fragment, firstFragment).commit();
        }
        if (findViewById(R.id.article_fragment) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create an instance of ExampleFragment
            HeadlinesFragment secFragment = new HeadlinesFragment();

            // In case this activity was started with special instructions from an Intent,
            // pass the Intent's extras to the fragment as arguments
            secFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.article_fragment, secFragment).commit();
        }
        Log.d("amit", "Activity onCreate() 2");
    }

    @Override
    protected void onStart() {
        Log.d("amit", "Activity onStart() 1");
        super.onStart();
        Log.d("amit", "Activity onStart() 2");
    }

    @Override
    protected void onResume() {
        Log.d("amit", "Activity onResume() 1");
        super.onResume();
        Log.d("amit", "Activity onResume() 2");
    }

    @Override
    protected void onPause() {
        Log.d("amit", "Activity onPause() 1");
        super.onPause();
        Log.d("amit", "Activity onPause() 2");
    }

    @Override
    protected void onDestroy() {
        Log.d("amit", "Activity onDestroy() 1");
        super.onDestroy();
        Log.d("amit", "Activity onDestroy() 2");
    }

    public  void displayFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.headlines_fragment, fragment).commit();
        ft.addToBackStack("stack1");
    }

    public void onArticleSelected(int position) {
        // The user selected the headline of an article from the HeadlinesFragment

        // Capture the article fragment from the activity layout

        ArticleFragment articleFragment = new ArticleFragment();
        Bundle b = new Bundle();
        b.putInt("position", position);
        articleFragment.setArguments(b);
        if(position ==1) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.headlines_fragment, articleFragment).commit();
            ft.addToBackStack("stack1");
        }else{
            FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
            ft2.replace(R.id.article_fragment, articleFragment).commit();
            ft2.addToBackStack("stack2");
        }

//        ArticleFragment articleFrag = (ArticleFragment)
//                getSupportFragmentManager().findFragmentById(R.id.article_fragment);

//        if (articleFragment != null) {
//            // If article frag is available, we're in two-pane layout...
//
//            // Call a method in the ArticleFragment to update its content
//            articleFragment.updateArticleView(position);
//
//        } else {
            // If the frag is not available, we're in the one-pane layout and must swap frags...

            // Create fragment and give it an argument for the selected article
//            ArticleFragment newFragment = new ArticleFragment();
//            Bundle args = new Bundle();
//            args.putInt(ArticleFragment.ARG_POSITION, position);
//            newFragment.setArguments(args);
//            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//
//            // Replace whatever is in the fragment_container view with this fragment,
//            // and add the transaction to the back stack so the user can navigate back
//            transaction.replace(R.id.fragment_container, newFragment);
//            transaction.addToBackStack(null);
//
//            // Commit the transaction
//            transaction.commit();
//        }
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        getSupportFragmentManager().popBackStackImmediate("stack1", FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }
}