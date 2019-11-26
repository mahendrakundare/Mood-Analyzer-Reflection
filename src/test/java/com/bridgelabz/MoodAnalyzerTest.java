package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {

    @Test
    public void givenMessage_WhenSad_ShouldReturnSad() {
        MoodAnalyzer analyzer = new MoodAnalyzer();
        String mood = analyzer.analyzeMood("This is sad message");
        Assert.assertEquals("SAD",mood);
    }
}
