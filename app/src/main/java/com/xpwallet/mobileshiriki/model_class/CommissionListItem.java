package com.xpwallet.mobileshiriki.model_class;

/**
 * Created by Desktop on 22-Dec-16.
 */
public class CommissionListItem {
    String service_type;
    String sub_type;
    String post_balance;
    String txn_date;
    String amount;

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    public String getSub_type() {
        return sub_type;
    }

    public void setSub_type(String sub_type) {
        this.sub_type = sub_type;
    }

    public String getPost_balance() {
        return post_balance;
    }

    public void setPost_balance(String post_balance) {
        this.post_balance = post_balance;
    }

    public String getTxn_date() {
        return txn_date;
    }

    public void setTxn_date(String txn_date) {
        this.txn_date = txn_date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
