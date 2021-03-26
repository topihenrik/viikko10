package com.example.viikko10;

import java.util.ArrayList;

public class SiteHistory {
    private ArrayList<String> sites;
    private int currentLocation;

    public SiteHistory() {
        this.sites = new ArrayList<>();
        currentLocation = -1;
    }

    public void newSiteUpdateHistory(String url) {
        if (currentLocation < sites.size()-1) {
            while (currentLocation < sites.size()-1) {
                sites.remove(currentLocation+1);
            }
        }
        if (sites.size() < 10) {
            sites.add(url);
            currentLocation += 1;
            System.out.println("Current location:" + currentLocation + "ArrayList size:" + sites.size());
        } else {
            sites.remove(0);
            sites.add(url);
            System.out.println("Current location:" + currentLocation + "ArrayList size:" + sites.size());
        }

    }

    public String getPreviousSite() {
        if (currentLocation <= 0) {
            System.out.println("Current location:" + currentLocation + "ArrayList size:" + sites.size());
            return sites.get(currentLocation);
        }
        currentLocation -= 1;
        System.out.println("Current location:" + currentLocation + "ArrayList size:" + sites.size());
        return sites.get(currentLocation);
    }

    public String getNextSite() {
        if (currentLocation < sites.size()-1) {
            currentLocation += 1;
            System.out.println("Current location:" + currentLocation + "ArrayList size:" + sites.size());
            return sites.get(currentLocation);
        }
        System.out.println("Current location:" + currentLocation + "ArrayList size:" + sites.size());
        return sites.get(currentLocation);
    }
}
