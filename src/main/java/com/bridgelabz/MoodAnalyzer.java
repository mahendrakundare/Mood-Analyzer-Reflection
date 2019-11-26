package com.bridgelabz;

public class MoodAnalyzer {

    private String message;

    public MoodAnalyzer() {
    }

    public MoodAnalyzer(String message) {
        this.message = message;
    }

    public String analyzeMood(String message) {
        if (message.contains("sad"))
            return "SAD";
        else
            return "HAPPY";
    }

    public String analyzeMood(){
        if (message.contains("sad"))
            return "SAD";
        else
            return "HAPPY";
    }
}
