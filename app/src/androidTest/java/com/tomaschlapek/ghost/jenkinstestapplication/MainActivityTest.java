package com.tomaschlapek.ghost.jenkinstestapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.WindowManager;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

  public Activity currentActivity;

  @Rule
  public LifecycleRule<MainActivity> testRule = new LifecycleRule<>(MainActivity.class);

  @Before
  public void setUp() {
    testMyActivity();
  }

  public void testMyActivity() {
    currentActivity.runOnUiThread(
      new Runnable() {
        public void run() {
          currentActivity.getWindow().addFlags(
            WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON |
              WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        }
      }
    );
  }

  @Test
  public void generalTest() {
    onView(withId(R.id.hello)).check(matches(isDisplayed()));
  }

  /**
   * Defined lifecycle rule
   *
   * @param <A> Defined activity.
   */
  public class LifecycleRule<A extends MainActivity> extends ActivityTestRule<A> {
    public LifecycleRule(Class<A> activityClass) {
      super(activityClass);
    }

    /**
     * Invokes before activity launch.
     */
    @Override
    protected void beforeActivityLaunched() {
      super.beforeActivityLaunched();
      // Maybe prepare some mock service calls
      // Maybe override some dependency injection modules with mocks
    }

    /**
     * Invokes when activity get an intent.
     *
     * @return Custom intent.
     */
    @Override
    protected Intent getActivityIntent() {
      Intent customIntent = new Intent();
      // add some custom extras and stuff
      return customIntent;
    }

    /**
     * Invokes after launch of activity.
     */
    @Override
    protected void afterActivityLaunched() {
      super.afterActivityLaunched();
      currentActivity = getActivity();
      // maybe you want to do something here
    }

    /**
     * Invokes after activity finish.
     */
    @Override
    protected void afterActivityFinished() {
      super.afterActivityFinished();
      currentActivity = null;
      // Clean up mocks
    }
  }
}
