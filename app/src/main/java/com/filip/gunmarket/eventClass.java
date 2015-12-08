package com.filip.gunmarket;

/**
 * Created by Administrator on 2015/12/7.
 */
public class eventClass {
    String eventTopic;
    String eventText1;
    String eventText2;
    String eventText3;
    String optionA;
    String optionB;

    int eventNum;

    public eventClass
            (int num,
             String A,
             String B,
             String C,
             String op1,
             String op2)
    {
        eventNum = num;
        eventText1 = A;
        eventText2 = B;
        eventText3 = C;
        optionA = op1;
        optionB = op2;
    }
}
