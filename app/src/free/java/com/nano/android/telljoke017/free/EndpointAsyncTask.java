package com.nano.android.telljoke017.free;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.ahmed.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;


/**
 * Created by ahmed on 12/12/17.
 */

public class EndpointAsyncTask extends AsyncTask<com.nano.android.telljoke017.free.MainActivityFragment, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    private MainActivityFragment mainActivityFragment;
    @Override
    protected String doInBackground(MainActivityFragment... params) {
        if(myApiService == null) {  // Only do this once
//         MyApi.Builder builder = new
//                    MyApi.Builder(AndroidHttp.newCompatibleTransport(),
//                    new AndroidJsonFactory(), null)
//                    // options for running against local devappserver
//                    // ­ 10.0.2.2 is localhost's IP address in Android emulator
//                    // ­ turn off compression when running against local devappserver
//                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
//                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
//                        @Override                         public void initialize(AbstractGoogleClientRequest<?>
//                                                                                         abstractGoogleClientRequest) throws IOException {
//                            abstractGoogleClientRequest.setDisableGZipContent(true);
//                        }
//                    });
            // end options for devappserver

            mainActivityFragment = params[0];
            context = mainActivityFragment.getActivity();
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new
                    AndroidJsonFactory(), null)
                    .setRootUrl("https://nanofinalpro.appspot.com/_ah/api/");

            myApiService = builder.build();
        }



        try {
            return myApiService.tellJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        /*// Create Intent to launch JokeFactory Activity
        Intent intent = new Intent(context, DisplayJokeActivity.class);
        // Put the string in the envelope
        intent.putExtra(DisplayJokeActivity.JOKE_KEY,result);
        context.startActivity(intent);
        ///
*/
        mainActivityFragment.loadedJoke = result;
        mainActivityFragment.DisplayJokeActivity();
        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
    }
}