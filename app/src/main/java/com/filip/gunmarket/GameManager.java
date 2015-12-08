package com.filip.gunmarket;

import com.filip.androidgames.framework.Game;

import java.util.Random;

/**
 * Created by Erdem on 2015-12-06.
 */
public class GameManager {
    Game game;
    float doomsdayCounter = 0;

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
    int money = 100;

    Random rand = new Random();

    int currentRegion = 1;

    int[] opportunityArray = new int[8];

    public GameManager(Game myGame){
        game = myGame;
    }

    public void investHawk(){
        if(money>=10 && influencePoints>= 3){
            changeMoney(-10);
            changeInfluencePoints(-3);
            connectionChange(currentRegion, 0.15f);
        }
    }
    public void investDove(){
        if (money>= 10 && influencePoints >= 3){
            changeMoney(-10);
            changeInfluencePoints(-3);
            changeDoomsdayCounter(-0.03f);
        }
    }

    public int getCurrentRegion() {
        return currentRegion;
    }

    public void setCurrentRegion(int currentRegion) {
        this.currentRegion = currentRegion;
    }

    public void changeDoomsdayCounter(float amount){
        doomsdayCounter+= amount;

        if (doomsdayCounter<0)
            doomsdayCounter=0;
    }
    public void changeDate()
    {
        month++;
        if(month >= 13)
        {
            month = 1;
            year++;
            if (year >= 2015)
                winGame();
        }
    }
    public String getDate()
    {
        switch(month)
        {
            case 1:
                return "January " + year;
            case 2:
                return "February " + year;
            case 3:
                return "March " + year;
            case 4:
                return "April " + year;
            case 5:
                return "May " + year;
            case 6:
                return "June " + year;
            case 7:
                return "July " + year;
            case 8:
                return "August " + year;
            case 9:
                return "September " + year;
            case 10:
                return "October " + year;
            case 11:
                return "November " + year;
            case 12:
                return "December " + year;
            default:
                return "Error";
        }
    }
    public  void winGame(){
        game.setScreen(new WinLoseScreen(game, 0));
    }

    public void newTurn(){
        changeDate();
        if (doomsdayCounter >= 1){
            //END GAME
            game.setScreen(new WinLoseScreen(game, 2));
        }
        changeDoomsdayCounter(0.006f);
        Assets.bubbleForm.play(1);


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
        changeDoomsdayCounter(0.001f);

        handGuns--;
        changeMoney(getHandGunPrice(false));
        if (getConnectionByNum(currentRegion) < 0.4f)
        connectionChange(currentRegion, 0.01f);
    }
    public void sellLongGun(){
        changeDoomsdayCounter(0.001f);
        longGuns--;
        changeMoney(getLongGunPrice(false));
        connectionChange(currentRegion, 0.015f);
    }
    public  void sellExplosives(){
        changeDoomsdayCounter(0.001f);
        explosives--;
        changeMoney(getExplosivePrice(false));
    }
    public void buyHandGun(){
        changeDoomsdayCounter(0.001f);
        handGuns++;
        changeMoney(-getHandGunPrice(true));
        if (getConnectionByNum(currentRegion) < 0.4f)
            connectionChange(currentRegion, 0.01f);
    }
    public void buyLongGun(){
        changeDoomsdayCounter(0.001f);
        longGuns++;
        changeMoney(-getLongGunPrice(true));
        connectionChange(currentRegion, 0.015f);
    }
    public  void buyExplosives(){
        changeDoomsdayCounter(0.001f);
        explosives++;
        changeMoney(-getExplosivePrice(true));
    }
    public int getMoney() {
        return money;
    }

    public float getDoomsdayCounter() {
        return doomsdayCounter;
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
    public void changeInfluencePoints(int amount){
        influencePoints+= amount;
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

        //ERDEM - influence stuff
        if (Val>0 && temp>0.5f)
            changeInfluencePoints(1);

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
                break;
            case 2:
                connectionEU = temp;
                break;
            case 3:
                connectionRussia = temp;
                break;
            case 4:
                connectionChina = temp;
                break;
            case 5:
                connectionLatin = temp;
                break;
            case 6:
                connectionAfrica = temp;
                break;
            case 7:
                connectionMiddleE = temp;
                break;
            case 8:
                connectionSouthAsia = temp;
                break;
        }
    }

    ////////////////EVENTS



    eventClass newPolitical = new eventClass(1, "A new political figure is rising in the region",
            "He asks for your help, offers to return the favor in the future.", "($20K for 1 Influence p)", "Offer Help", "Deny");

    eventClass newGuerilla = new eventClass(2, "A new revolutionary movement is starting in this continent",
            "Making deals with them would be very profitable, at the expense of USA relations",
            "(USA connections drops to 0 for $35K)", "Make the deal", "No deal");

    eventClass counterRevolution = new eventClass(3, "CIA is arming a counter-revolutionary force in the continent.",
            "We can act as their middleman",
            "+15% USA connection & +15% this region's connection for +3% Doomsday", "Deal", "No Deal");
    eventClass coupAttempt = new eventClass(4, "There will be a coup attempt in this continent.",
            "We can support them with weapons.(Bought auto, if Inventory is not enough)","(-20 containers of LongGuns, +10 Influence pts, +1% Doomsday ctr", "Help them", "No deal");

    eventClass[] randomEvents = new eventClass[]{
            newPolitical,
            newGuerilla,
            counterRevolution,
            coupAttempt
    };
    public void eventResult(int eventNo, boolean isPositiveReply) {
        if (isPositiveReply) {
            switch (eventNo) {
                case 4:
                    longGuns -= 20;
                    changeInfluencePoints(10);
                    changeDoomsdayCounter(0.01f);
                    break;
                case 1:
                    changeMoney(-20);
                    changeInfluencePoints(1);
                    break;
                case 2:
                    changeMoney(35);
                    connectionChange(1,-1);
                    break;
                case 3:
                    connectionChange(1, 0.15f);
                    connectionChange(currentRegion, 0.15f);
                    changeDoomsdayCounter(0.03f);
                    break;



            }
        }
    }

    eventClass generateEvent(){
        return  counterRevolution;
        //return randomEvents[rand.nextInt(randomEvents.length)];
    }

}
