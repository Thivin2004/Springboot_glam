package com.spring.thivin;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Glam
{
    @Id
    int itemId;
    String itemName;
    String itemDescription;
    public int getItemId() {
        return itemId;
    }
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public String getItemDescription() {
        return itemDescription;
    }
    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    
}