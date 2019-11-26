package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {

    @Test
    public void givenMessage_WhenSad_ShouldReturnSad() {
        MoodAnalyzer analyzer = new MoodAnalyzer("This is sad message");
        String mood = analyzer.analyzeMood();
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void givenMessage_WhenHappy_ShouldReturnHappy() {
        MoodAnalyzer analyzer = new MoodAnalyzer();
        String mood = analyzer.analyzeMood("I am in angry mood");
        Assert.assertEquals("HAPPY",mood);
    }
}
