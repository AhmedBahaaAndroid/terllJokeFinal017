package com.nano.android.telljoke017;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.nano.android.jokerandroidlib.DisplayJoke;

/**
 * Created by ahmed on 12/12/17.
 */

public class MainActivityFragment extends Fragment {
    ProgressBar progressBar = null;
    public String loadedJoke = null;
    public boolean Flag = false;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        Button button = (Button) root.findViewById(R.id.jokebtn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
               progressBar.setVisibility(View.VISIBLE);
                getMyJoke();
            }
        });

        progressBar = (ProgressBar) root.findViewById(R.id.progressbar);
        progressBar.setVisibility(View.GONE);
        return root;
    }


    public void getMyJoke(){

//        JokerTeller joker = new JokerTeller();
//
//     //   Toast.makeText(this.getContext(), joker.getJoke(), Toast.LENGTH_SHORT).show();
//
//
//
//        // Create Intent to launch JokeFactory Activity
//        Intent intent = new Intent(this.getContext(),  DisplayJoke.class);
//        // Put the string in the envelope
//        intent.putExtra("JOKE", joker.getJoke());
//        startActivity(intent);
       new EndpointAsyncTask().execute(this);
    }

    public void DisplayJokeActivity(){

        if (!Flag) {
            Context context = getActivity();

            Intent intent = new Intent(context, DisplayJoke.class);
            intent.putExtra("JOKE", loadedJoke);
            Toast.makeText(context, loadedJoke, Toast.LENGTH_LONG).show();
            context.startActivity(intent);
           progressBar.setVisibility(View.GONE);
        }
    }
}
