package com.nano.android.telljoke017;

import android.os.AsyncTask;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

import static junit.framework.Assert.assertTrue;

/**
 * Created by ahmed on 12/12/17.
 */
@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest {

    @Test
    public void testDoInBackground() throws Exception {
//        MainActivityFragment fragment = new MainActivityFragment();
//        fragment.Flag = true;
//        EndpointAsyncTask asyncTask = new EndpointAsyncTask();
//        String  joke = asyncTask.get();
//        Thread.sleep(5000);
//
        final CountDownLatch signal = new CountDownLatch(1);

    /* Just create an in line implementation of an asynctask. Note this
     * would normally not be done, and is just here for completeness.
     * You would just use the task you want to unit test in your project.
     */
        final AsyncTask<String, Void, String> myTask = new AsyncTask<String, Void, String>() {

            @Override
            protected String doInBackground(String... arg0) {
                //Do something meaningful.

                EndpointAsyncTask asyncTask = new EndpointAsyncTask();
                String Myjoke = null;
                try {
                     Myjoke = asyncTask.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                return Myjoke;
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                assertTrue("Error:  Joke = " + result, result.equals("I can't believe I made it anywhere creatively, though, because I was raised by two loving and supportive parents. Nothing squashes creativity more than unconditional love and support from a functional household. If you have kids, sh*t on their dreams a little bit."));


            /* This is the key, normally you would use some type of listener
             * to notify your activity that the async call was finished.
             *
             * In your test method you would subscribe to that and signal
             * from there instead.
             */
                signal.countDown();
            }
        };



    }




}
