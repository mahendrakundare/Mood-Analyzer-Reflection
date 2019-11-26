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

    //Repeated TC1.1
    @Test
    public void givenMessageToConstructor_WhenSad_ShouldReturnSad() {
        MoodAnalyzer analyzer = new MoodAnalyzer("I am in sad Mood");
        String mood = analyzer.analyzeMood();
        Assert.assertEquals("SAD",mood);
    }

    //Repeadted TC1.2
    @Test
    public void givenMessageToConstructor_WhenHappy_ShouldReturnHappy() {
        MoodAnalyzer analyzer = new MoodAnalyzer("I am in happy Mood");
        String mood = analyzer.analyzeMood();
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void givenMessage_WhenNull_ShouldReturnHappy() {
        MoodAnalyzer analyzer = new MoodAnalyzer(null);
        String mood = analyzer.analyzeMood();
        Assert.assertEquals("HAPPY", mood);
    }
}
