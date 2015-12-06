package com.filip.gunmarket;

/**
 * Created by Erdem on 2015-12-06.
 */
public class GameManager {
    int handGuns = 0;
    int longGuns = 0;
    int explosives = 0;

    int handGunPrice = 10;
    int longGunPrice = 20;
    int explosivePrice = 15;

    float connectionUSA = 0;
    float connectionEU = 0;
    float connectionRussia = 0;
    float connectionChina = 0.1f;


    float connectionLatin = 0;
    float connectionAfrica = 0;
    float connectionMiddleE = 0;
    float connectionSouthAsia = 0;


    int influencePoints = 0;
    int money = 1000;

    int currentRegion = 1;


    public String currentRegionName(){
        String temp = "";
        switch (currentRegion){
            case 1:
                temp = "United States";
                break;
            case  2:
                temp = "European Union";
                break;
            case 3:
                temp = "Russia";
                break;
            case 4:
                temp = "China";
                break;
            case 5:
                temp = "Latin America";
                break;
            case 6:
                temp = "Africa";
                break;
            case 7:
                temp = "Middle East";
                break;
            case 8:
                temp = "South Asia";
                break;
        }
        return temp;
    }
    public void changeMoney(int amount){
        money += amount;
    }

    public int getHandGunBuyPrice(boolean isBuyScreen) {
            return isBuyScreen ? handGunPrice-1 : handGunPrice+1;
    }
    public int getLongGunPrice(boolean isBuyScreen){
        return  isBuyScreen ? longGunPrice-2 : longGunPrice+2;
    }
    public int getExplosivePrice(boolean isBuyScreen){
        return isBuyScreen ? explosivePrice-2 : explosivePrice+2;
    }

    public int getMoney() {
        return money;
    }

    public int getHandGuns(){
        return handGuns;
    }
    public int getLongGuns(){
        return  longGuns;
    }
    public int getExplosives(){
        return  explosives;
    }
    public int getInfluencePoints(){
        return  influencePoints;
    }

    public float getConnectionAfrica() {
        return connectionAfrica;
    }

    public float getConnectionChina() {
        return connectionChina;
    }

    public float getConnectionEU() {
        return connectionEU;
    }

    public float getConnectionLatin() {
        return connectionLatin;
    }

    public float getConnectionMiddleE() {
        return connectionMiddleE;
    }

    public float getConnectionRussia() {
        return connectionRussia;
    }

    public float getConnectionSouthAsia() {
        return connectionSouthAsia;
    }

    public float getConnectionUSA() {
        return connectionUSA;
    }
}
