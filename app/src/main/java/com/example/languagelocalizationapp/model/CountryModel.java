package com.example.languagelocalizationapp.model;

/**
 * Created by geet-pc on 04/03/19.
 */

public class CountryModel {
    String textTitle;
    String languageCode;

    public CountryModel(String textTitle, String languageCode) {
        this.textTitle = textTitle;
        this.languageCode=languageCode;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public String getTextTitle() {
        return textTitle;
    }

}
