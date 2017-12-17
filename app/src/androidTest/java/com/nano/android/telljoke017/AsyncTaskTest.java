package com.nano.android.telljoke017;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertTrue;

/**
 * Created by ahmed on 12/12/17.
 */
@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest {

    @Test
    public void testDoInBackground() throws Exception {
        MainActivityFragment fragment = new MainActivityFragment();
        fragment.Flag = true;
        EndpointAsyncTask asyncTask = new EndpointAsyncTask();
        String joke = asyncTask.get();
        Thread.sleep(5000);
        assertTrue("Error:  Joke = " + joke, joke.equals("I can't believe I made it anywhere creatively, though, because I was raised by two loving and supportive parents. Nothing squashes creativity more than unconditional love and support from a functional household. If you have kids, sh*t on their dreams a little bit."));

    }




}
