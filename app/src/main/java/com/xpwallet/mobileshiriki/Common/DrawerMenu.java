package com.xpwallet.mobileshiriki.Common;

public class DrawerMenu {
    private String label;
    private int image;
    private String actionClass;
    private String pName;
    private String pValue;
    private int functionCode;

    public DrawerMenu(int image, String label, int functionCode) {
        this.image = image;
        this.label = label;
        this.functionCode = functionCode;
    }

    public DrawerMenu(int image, String label, String actionClass) {
        this.image = image;
        this.label = label;
        this.actionClass = actionClass;
    }

    public DrawerMenu(int image, String label, String actionClass, String pName, String pValue) {
        this(image, label, actionClass);
        this.pName = pName;
        this.pValue = pValue;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getActionClass() {
        return actionClass;
    }

    public void setActionClass(String actionClass) {
        this.actionClass = actionClass;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpValue() {
        return pValue;
    }

    public void setpValue(String pValue) {
        this.pValue = pValue;
    }

    public int getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(int functionCode) {
        this.functionCode = functionCode;
    }
}
