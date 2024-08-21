package com.niantic.exercises;

import com.niantic.models.LineItem;

import javax.sound.sampled.Line;
import java.util.List;

import static java.lang.Long.sum;

public class Reducers
{

    /*
    1) using one or more Java Stream functions calculate the total sales amount
       for all line items in the given list.

       hint: use the getLineTotal() method to calculate the sales total

     */
    public double totalSales(List<LineItem> lineItems)
    {
        var totalSalesAmount = lineItems.stream()
                .mapToDouble(LineItem::getLineTotal)
                .sum();

          return totalSalesAmount;
    }

    /*
    2) using one or more Java Stream functions calculate the average sales amount
       per line items in the given list.

     */
    public double averageSalesPerLineItem(List<LineItem> lineItems)
    {

        // calculate total sales amount by summing all line totals
        // mapToDouble to convert each line item's total to a double
        // reduce to calculate all the totals starting from 0.0
        var totalSalesAmount = lineItems.stream()
                .mapToDouble(LineItem::getLineTotal)
                .reduce(0.0, Double::sum);

        // calculate average by sum of sales divided by the size of line items
        return totalSalesAmount / lineItems.size();

    }

    /*
    3) using one or more Java Stream functions calculate the average sales amount
       per items in the given list.

       hint: unlike problem number 2, we are not looking for the average of line totals
       we are looking for the average of each item (line items can have multiple quantities
       of a single item)

     */
    public double averageSalesPerItem(List<LineItem> lineItems)
    {

        var totalSalesAmount = lineItems.stream()
                .mapToDouble(LineItem::getLineTotal)
                .reduce(0.0 , Double::sum);

        var totalItems = lineItems.stream()
                .mapToInt(LineItem::getQuantity)
                .reduce(0, Integer::sum);

        return totalSalesAmount / totalItems;

    }

    /*
    4) using one or more Java Stream functions calculate the total number
       of items that were purchased.

       hint: line items can have multiple quantities of an item

     */
    public int totalItemCount(List<LineItem> lineItems)
    {

        var itemCount = lineItems.stream()
                .mapToInt(LineItem::getQuantity)
                .reduce(0, Integer::sum);

        return itemCount;

    }

    /*
    5) using one or more Java Stream functions calculate the average number
       of items that were purchased per line item.

     */
    public double averageItemCount(List<LineItem> lineItems)
    {

        var totalAmountPurchased = lineItems.stream()
                .mapToInt(LineItem::getQuantity)
                .reduce(0, Integer::sum);

        return (double) totalAmountPurchased / lineItems.size();

    }

    /*
    6) using one or more Java Stream functions find the most expensive line item.

     */
    public double maxLineItem(List<LineItem> lineItems)
    {

        var maxItem = lineItems.stream()
                .mapToDouble(LineItem::getLineTotal)
                .reduce(0.0, Double::max);

        return maxItem;

    }

    /*
    7) using one or more Java Stream functions find the least expensive line item.

        hint: the least expensive line item is not $0.00

     */
    public double minLineItem(List<LineItem> lineItems)
    {
        var minItem = lineItems.stream()
                .mapToDouble(LineItem::getLineTotal)
                .min();

        return minItem.getAsDouble();
    }

}
