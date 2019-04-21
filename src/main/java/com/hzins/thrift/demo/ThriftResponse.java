package com.hzins.thrift.demo;

/**
 * #author qinghao
 * #date 2019-04-21 11:19
 */
public class ThriftResponse {
    private byte[] b  ;
    public void setBody(byte[] b) {
            this.b = b;
    }

    public byte[] getBody() {
        return b;
    }
}
