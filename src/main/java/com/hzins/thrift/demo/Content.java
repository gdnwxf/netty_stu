package com.hzins.thrift.demo;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;

/**
 * #author qinghao
 * #date 2019-04-21 11:16
 */
public class Content {

    Integer id;
    String phone;
    Integer price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void write(TProtocol tProtocol) {
         
    }

    public void setIdIsSet(boolean b) {

    }

    public void read(TProtocol p) {
        
    }
}
