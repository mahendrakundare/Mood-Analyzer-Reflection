package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;

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
        Constructor<?> constructor=MoodAnalyserReflector.getConstructor();
        Object myObject = MoodAnalyserReflector.creatMoodAnalyser(constructor);
        Assert.assertEquals(new MoodAnalyzer("I am in the happy mood"), myObject);
    }

    @Test
    public void givenClassName_WhenImproper_ShouldThrowException() {
        MoodAnalyzer analyzer = null;
        try {
            Constructor<?> constructor=MoodAnalyserReflector.getConstructor();
            Object myObject = MoodAnalyserReflector.creatMoodAnalyser(constructor);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, e.type);
        }
    }

    @Test
    public void givenMessage_When_Notproper_Should_Return_NoSuchMethod_With_Parameters() {
        MoodAnalyzer moodAnalyzer = null;
        try {
            Constructor<?> constructor=MoodAnalyserReflector.getConstructor();
            Object myObject = MoodAnalyserReflector.creatMoodAnalyser(constructor);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.type);
        }
    }

    //
    @Test
    public void givenHappyMessage_WithReflection_ShouldReturnHappy() {
        try {
            Constructor<?> constructor=MoodAnalyserReflector.getConstructor();
            Object myObject = MoodAnalyserReflector.creatMoodAnalyser(constructor);
            Object analyseMood = MoodAnalyserReflector.invokeMethod(myObject, "analyzeMood");
            Assert.assertEquals("HAPPY", analyseMood);
        } catch (MoodAnalysisException e) {
            e.getCause().getCause().printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyser_OnChangeMood_shouldReturnHappy() {
        try {
            Constructor<?> constructor=MoodAnalyserReflector.getConstructor();
            Object myObject = MoodAnalyserReflector.creatMoodAnalyser(constructor);
            MoodAnalyserReflector.setFieldValue(myObject, "message", "I am in happy mood");
            Object analyseMood = MoodAnalyserReflector.invokeMethod(myObject, "analyzeMood");
            Assert.assertEquals("HAPPY", analyseMood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    //default constructor
    @Test
    public void givenHappyMessage_WithDefaultConstructor_ShouldReturnHappy() {
        try {
            Constructor<?> constructor=MoodAnalyserReflector.getConstructor();
            Object myObject = MoodAnalyserReflector.creatMoodAnalyser(constructor);
            MoodAnalyserReflector.setFieldValue(myObject, "message", "I am in happy mood");
            Object analyseMood = MoodAnalyserReflector.invokeMethod(myObject, "analyzeMood");
            Assert.assertEquals("HAPPY", analyseMood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }
}
