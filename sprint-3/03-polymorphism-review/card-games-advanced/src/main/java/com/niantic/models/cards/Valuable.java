package com.niantic.models.cards;

public interface Valuable
{
    int getValue();
    boolean hasMultipleValues();
    int[] getPossibleValues();
    int getHighestValue();
    int getLowestValue();
}
