package com.example.taskmaster;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)

public class ExampleInstrumentedTest {
    public static final String STRING_TO_BE_TYPED = "Dawood";

@Rule
public ActivityScenarioRule<MainActivity> main =
        new ActivityScenarioRule<>(MainActivity.class);


//    @Test
//    public void changeName() {
//        onView(withId(R.id.settings)).perform(click());
//
//        onView(withId(R.id.instructorNameInput)).perform(typeText(STRING_TO_BE_TYPED), closeSoftKeyboard());
//        onView(withId(R.id.save)).perform(click());
//
//        onView(withId(R.id.output)).check(matches(withText(STRING_TO_BE_TYPED+ "s tasks")));
//    }
//    @Test
//    public void testTheMainActivity() {
//        onView(withId(R.id.textView)).check(matches(withText("My Tasks")));
//    }
//
//
//    @Test
//    public void testAddNewTask() {
//        onView(withId(R.id.button1)).perform(click());
//
//        onView(withId(R.id.newTaskBody)).perform(typeText("lab31"), closeSoftKeyboard());
//        onView(withId(R.id.newTaskName)).perform(typeText("espresso"), closeSoftKeyboard());
//        onView(withId(R.id.status)).perform(typeText("in progress"), closeSoftKeyboard());
//        onView(withId(R.id.button3)).perform(click());
//        pressBack();
//        onView(ViewMatchers.withId(R.id.ss)).check(matches(isDisplayed()));
//
//    }
//
//    @Test
//    public void testTheAllTask() {
//        onView(withId(R.id.button2)).perform(click());
//        onView(withId(R.id.textView4)).check(matches(withText("All Tasks")));
//    }
//
//
//    @Test
//    public void taskDetails(){
//        onView(withId(R.id.ss)).perform(actionOnItemAtPosition(0, click()));
//        onView(withText("lab29")).check(matches(isDisplayed()));
//    }
//
}
