package com.xpwallet.mobileshiriki.model_class;

/**
 * Created by arjun on 27/01/2017.
 */

public class BeanClass {
    String id,duration,operator_list;

    public String getId(){
        return id;
    }

    public void setId(String id1) {
        this.id = id1;
    }
    public String getDuration(){
        return duration;
    }

    public void setDuration(String duration1) {
        this.duration = duration1;
    }


    public String getOperator_list(){
        return operator_list;
    }
    public void setOperator_list(String operator_list1){
        this.operator_list=operator_list1;
    }
}
