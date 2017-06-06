package com.xpwallet.mobileshiriki.model_class;

import android.graphics.drawable.Drawable;

public class MenuItem {
    private String label;
    private Drawable image;

    public MenuItem(String label, Drawable image) {
        this.label = label;
        this.image = image;
    }



   public String getlabel(){
       return label;
   }

    public void setLabel(String label) {
        this.label = label;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }
}
