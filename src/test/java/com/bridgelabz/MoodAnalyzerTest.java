package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MoodAnalyzerTest {

    @Test
    public void givenMessage_WhenSad_ShouldReturnSad() throws MoodAnalysisException {
        MoodAnalyzer analyzer = new MoodAnalyzer("This is sad message");
        String mood = analyzer.analyzeMood();
        Assert.assertEquals("SAD",mood);
    }

    //Repeated TC1.1
    @Test
    public void givenMessageToConstructor_WhenSad_ShouldReturnSad() throws MoodAnalysisException {
        MoodAnalyzer analyzer = new MoodAnalyzer("I am in sad Mood");
        String mood = analyzer.analyzeMood();
        Assert.assertEquals("SAD",mood);
    }

    //Repeadted TC1.2
    @Test
    public void givenMessageToConstructor_WhenHappy_ShouldReturnHappy() throws MoodAnalysisException {
        MoodAnalyzer analyzer = new MoodAnalyzer("I am in happy Mood");
        String mood = analyzer.analyzeMood();
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void givenMessage_WhenNull_ShouldReturnHappy() throws MoodAnalysisException {
        MoodAnalyzer analyzer = new MoodAnalyzer(null);
        String mood = analyzer.analyzeMood();
        Assert.assertEquals("HAPPY", mood);
    }

    @Test
    public void givenMessageNull_ShouldThrowException() {
        MoodAnalyzer analyzer = new MoodAnalyzer(null);
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(MoodAnalysisException.class);
            analyzer.analyzeMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("Please enter proper mood", e.getMessage());
        }
    }

    @Test
    public void givenMessageEmpty_ShouldThrowException() {
        MoodAnalyzer analyzer = new MoodAnalyzer("");
        try {
            analyzer.analyzeMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_EMPTY, e.type);
        }
    }

    @Test
    public void givenMoodAnalyseClass_WhenProper_ReturnObject() throws MoodAnalysisException {
        MoodAnalyzer analyzer = MoodAnalyserFactory.creatMoodAnalyser("I am in the happy mood");
        Assert.assertEquals(new MoodAnalyzer("I am in the happy mood"), analyzer);
    }
}
