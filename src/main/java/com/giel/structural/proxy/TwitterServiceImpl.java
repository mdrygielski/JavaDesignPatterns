package com.giel.structural.proxy;

public class TwitterServiceImpl implements TwitterService {
    @Override
    public String getTimeline(String screenName) {
        return "sample timeline message";
    }

    @Override
    public void postToTimeline(String screenName, String message) {
        System.out.println("Posting to timeline");
    }
}
