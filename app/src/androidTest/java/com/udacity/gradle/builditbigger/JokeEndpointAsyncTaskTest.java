package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.text.TextUtils;

import com.udacity.gradle.builditbigger.lib.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.lib.EndpointsAsyncTaskDelegate;

import java.util.concurrent.CountDownLatch;

public class JokeEndpointAsyncTaskTest  extends AndroidTestCase {

    private final CountDownLatch signal = new CountDownLatch(1);

    private class TestJokeAsyncTask extends EndpointsAsyncTask {
        public TestJokeAsyncTask(EndpointsAsyncTaskDelegate delegate) {
            super(delegate);
        }

        @Override
        protected void onPostExecute(String result) {
            assertTrue("Result should not be empty", !TextUtils.isEmpty(result));
            //assertFalse(true);
            signal.countDown();

        }
    }

    public void testJokeAsyncTaskResponse() throws Throwable {

        final TestJokeAsyncTask testJokeAsyncTask = new TestJokeAsyncTask(null);
        testJokeAsyncTask.execute();
        signal.await(); //Wait till AsyncTask finishes
    }
}