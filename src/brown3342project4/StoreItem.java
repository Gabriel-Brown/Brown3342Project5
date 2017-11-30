/******************************************************
‘***  Project 3 - Inheritance and Polymorphism
‘***  Gabriel Brown
‘******************************************************
‘*** To Demonstrate Inheritance and Polymorphism
‘***
‘******************************************************
‘*** 10/03/2017
‘******************************************************
‘*****************************************************/
package brown3342project4;
import java.io.Serializable;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gb011
 */
public class StoreItem implements Serializable
{
    private static int itemCount;
    private String title;
    private String author;
    private Date dateAcquired;
    private int purchasePrice;
    private int askingPrice;
        
    public StoreItem (String title, String author, Date dateAcquired, int purchasePrice, int askingPrice)
    {
        setTitle(title);
        setAuthor(author);
        setDateAcquired(dateAcquired);
        setPurchasePrice(purchasePrice);
        setAskingPrice(askingPrice);
    }

    public static int getItemCount() {
        return itemCount;
    }

    public static void setItemCount(int aItemCount) {
        itemCount = aItemCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDateAcquired() {
        return dateAcquired;
    }

    public void setDateAcquired(Date dateAcquired) {
        this.dateAcquired = dateAcquired;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getAskingPrice() {
        return askingPrice;
    }

    public void setAskingPrice(int askingPrice) {
        this.askingPrice = askingPrice;
    }

    public void remove()//remove should decrement the itemCount var
    {
        itemCount--;
    }

}
