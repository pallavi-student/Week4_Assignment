package com.week4.day6.annotation;


    // Class with Deprecated and New Methods
    class LegacyAPI {

        @Deprecated
        public void oldFeature() {
            System.out.println("This is an old feature (Deprecated).");
        }

        public void newFeature() {
            System.out.println("This is the new and recommended feature.");
        }
    }

    // Main class
    public class Deprecatedex {
        public static void main(String[] args) {
            LegacyAPI api = new LegacyAPI();
            api.oldFeature();  // Shows warning in IDE
            api.newFeature();  // No warning, preferred method
        }
    }



