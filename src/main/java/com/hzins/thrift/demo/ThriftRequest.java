package com.hzins.thrift.demo;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;

import java.nio.ByteBuffer;

/**
 * #author qinghao
 * #date 2019-04-21 11:16
 */
public class ThriftRequest {
    private String command = "ThriftGetEmailByContent";

    private  byte[] requestParam  ;

    public String getCommand() {
          return command;
        
    }

    public void setCommand(String command) {
                this.command = command;
    }

    public void setRequestParam(byte[] array) {
        this.requestParam  = array;
    }

    public byte[] getRequestParam() {
        return requestParam;
    }


    public void read(TProtocol prot) {
        try {
            this.requestParam = prot.readBinary().array();
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    public void write(TProtocol reqProt) {
        try {
            reqProt.writeBinary(ByteBuffer.wrap(requestParam));
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}
