package com.tomaschlapek.ghost.jenkinstestapplication;

import android.app.Application;
import android.content.Context;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, packageName = "com.tomaschlapek.ghost.jenkinstestapplication")
public class ExampleUnitTest {

  private Application mApp;
  private Context mContext;
  private ActivityController<MainActivity> mController;
  private MainActivity mActivity;

  /**
   * Set up activity and context
   */
  @Before
  public void setUp() {
    mApp = RuntimeEnvironment.application;
    mContext = mApp.getApplicationContext();
  }

  @Test
  public void addition_isCorrect() throws Exception {
    assertEquals(4, 2 + 2);
  }

  /**
   * After each test is onPause(), onStop() and onDestroy() called ona activity.
   */
  @After
  public void tearDown() {
  }
}