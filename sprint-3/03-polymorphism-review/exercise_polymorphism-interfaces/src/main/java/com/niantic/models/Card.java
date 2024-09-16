package com.niantic.models;

import java.util.HashMap;
import java.util.Map;

public class Card implements Comparable<Card>
{
    private String suit;
    private String faceValue;

    public Card(String suit, String faceValue)
    {
        this.suit = suit;
        this.faceValue = faceValue;
    }

    public String getSuit()
    {
        return suit;
    }

    public String getFaceValue()
    {
        return faceValue;
    }

    public int getPointValue()
    {
        return cardValues.get(faceValue);
    }

    public String getColor()
    {
        switch (suit.toLowerCase())
        {
            case "hearts":
            case "diamonds":
                return "Red";
            default:
                return "Black";
        }
    }

    // Lookup map for card face values
    private static final Map<String, Integer> cardValues = new HashMap<>()
    {{
        put("2", 2);
        put("3", 3);
        put("4", 4);
        put("5", 5);
        put("6", 6);
        put("7", 7);
        put("8", 8);
        put("9", 9);
        put("10", 10);
        put("J", 11);
        put("Q", 12);
        put("K", 13);
        put("A", 14);
    }};


    private static final Map<String, Integer> suitOrder = new HashMap<>()
    {{
        put("spades", 1);
        put("hearts", 2);
        put("diamonds", 3);
        put("clubs", 4);
    }};

    @Override
    public int compareTo(Card other) {

        int thisSuitPriority = suitOrder.get(this.suit.toLowerCase());
        int otherSuitPriority = suitOrder.get(other.suit.toLowerCase());

        if (thisSuitPriority != otherSuitPriority) {
            return Integer.compare(thisSuitPriority, otherSuitPriority);
        }


        int thisFaceValuePriority = cardValues.get(this.faceValue);
        int otherFaceValuePriority = cardValues.get(other.faceValue);

        return Integer.compare(thisFaceValuePriority, otherFaceValuePriority);
    }

}
