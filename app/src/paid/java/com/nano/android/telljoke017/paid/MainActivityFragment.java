package com.nano.android.telljoke017.paid;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.nano.android.jokerandroidlib.DisplayJoke;
import com.nano.android.telljoke017.R;



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
