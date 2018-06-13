package com.dawnsoft.dawn.nepalyoga.helper;

/**
 * Created by dawn on 3/28/2018.
 */

public class YogaDescription {
    private int image;
    private String sanskritName;
    private String englishName;
    private String overviewDesc;
    private String moveIntoAsana;
    private String pictureStep;
    private String benefit;
    private String precaution;

    public YogaDescription(){}

    public YogaDescription(int image, String sanskritName, String englishName,
                           String overviewDesc, String moveIntoAsana, String pictureStep,
                           String benefit, String precaution) {
        this.image = image;
        this.sanskritName = sanskritName;
        this.englishName = englishName;
        this.overviewDesc = overviewDesc;
        this.moveIntoAsana = moveIntoAsana;
        this.pictureStep = pictureStep;
        this.benefit = benefit;
        this.precaution = precaution;
    }

    public int getImage() {
        return image;
    }

    public String getSanskritName() {
        return sanskritName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public String getOverviewDesc() {
        return overviewDesc;
    }

    public String getMoveIntoAsana() {
        return moveIntoAsana;
    }

    public String getPictureStep() {
        return pictureStep;
    }

    public String getBenefit() {
        return benefit;
    }

    public String getPrecaution() {
        return precaution;
    }
}
