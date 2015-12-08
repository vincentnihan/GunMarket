package com.filip.gunmarket;

import java.util.Random;

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

    int year = 1990;
    int month = 1;
    float time = 0;
    float turnTime = 5;


    int influencePoints = 0;
    int money = 1000;

    Random rand = new Random();

    int currentRegion = 1;

    int[] opportunityArray = new int[8];

    public int getCurrentRegion() {
        return currentRegion;
    }

    public void setCurrentRegion(int currentRegion) {
        this.currentRegion = currentRegion;
    }

    public void newTurn(){
            for (int i = 0;i <8; i++ ){

                int r = rand.nextInt(100)+1;
                if (r < 35+getConnectionByNum(i+1)){
                    if(r%2 == 1)
                        opportunityArray[i] = 1;
                    else
                        opportunityArray[i] = 2;
                }else{
                    opportunityArray[i] = 0;
                }


            }

    }

    public void progressTime(float dTime){
        time += dTime;
        if (time >= turnTime){
            time = 0;
            newTurn();
        }
    }

    public int[] getOpportunityArray() {
        return opportunityArray;
    }

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

    public int getHandGunPrice(boolean isBuyScreen) {
            return isBuyScreen ? handGunPrice-1 : handGunPrice+1;
    }
    public int getLongGunPrice(boolean isBuyScreen){
        return  isBuyScreen ? longGunPrice-2 : longGunPrice+2;
    }
    public int getExplosivePrice(boolean isBuyScreen){
        return isBuyScreen ? explosivePrice-2 : explosivePrice+2;
    }



    public void sellHandGun(){
        handGuns--;
        changeMoney(getHandGunPrice(false));
        if (getConnectionByNum(currentRegion) < 0.4f)
        connectionChange(currentRegion, 0.01f);
    }
    public void sellLongGun(){
        longGuns--;
        changeMoney(getLongGunPrice(false));
        connectionChange(currentRegion, 0.015f);
    }
    public  void sellExplosives(){
        explosives--;
        changeMoney(getExplosivePrice(false));
    }
    public void buyHandGun(){
        handGuns++;
        changeMoney(-getHandGunPrice(true));
        if (getConnectionByNum(currentRegion) < 0.4f)
            connectionChange(currentRegion, 0.01f);
    }
    public void buyLongGun(){
        longGuns++;
        changeMoney(-getLongGunPrice(true));
        connectionChange(currentRegion, 0.015f);
    }
    public  void buyExplosives(){
        explosives++;
        changeMoney(-getExplosivePrice(true));
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

    public float getConnectionByNum(int num){
        switch (num){
            case 1:
                return getConnectionUSA();
            case 2:
                return  getConnectionEU();
            case 3:
                return getConnectionRussia();
            case 4:
                return getConnectionChina();
            case 5:
                return getConnectionLatin();
            case 6:
                return  getConnectionAfrica();
            case 7:
                return  getConnectionMiddleE();
            case 8:
                return  getConnectionSouthAsia();
        }
        return  0;
    }

    void connectionChange(int location, float Val)
    {
        float temp = getConnectionByNum(location);
        temp += Val;
        if(temp > 1)
        {
            temp = 1;
        }
        else if (temp < 0)
        {
            temp = 0;
        }
        switch(location)
        {
            case 1:
                connectionUSA = temp;
            case 2:
                connectionEU = temp;
            case 3:
                connectionRussia = temp;
            case 4:
                connectionChina = temp;
            case 5:
                connectionLatin = temp;
            case 6:
                connectionAfrica = temp;
            case 7:
                connectionMiddleE = temp;
            case 8:
                connectionSouthAsia = temp;

        }
    }

}
