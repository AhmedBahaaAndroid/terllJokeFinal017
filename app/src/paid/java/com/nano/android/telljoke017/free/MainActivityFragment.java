package com.nano.android.telljoke017.free;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainActivityFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainActivityFragment#newInstance} factory method to
 * create an instance of this fragment.
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
