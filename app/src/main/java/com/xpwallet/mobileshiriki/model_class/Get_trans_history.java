package com.xpwallet.mobileshiriki.model_class;

/**
 * Created by Desktop on 18-Nov-16.
 */
public class Get_trans_history {
    String id, service_type, sub_type,
     txn_date,
     amount,
     account_id,
     desc,
     param;

    public String getParam() {
        return param;
    }

    public void setParam(String param1) {
        this.param = param1;
    }
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc1) {
        this.desc = desc1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }
}
