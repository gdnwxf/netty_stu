package com.hzins.thrift.demo;

import org.apache.thrift.TException;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TProtocol;

/**
 * #author qinghao
 * #date 2019-04-21 11:48
 */
public interface HelloWorldService {

     class Client{

        public Client(TProtocol protocol ) {
        }

        public String sayHello(String zhangsan) {
            return null;
        }
    }

     interface Iface{
        public String sayHello(String username) throws TException ;
    }
    
     class Processor<T extends HelloWorldService.Iface> implements TProcessor{
        public Processor(T helloService) {

        }

        @Override
        public boolean process(TProtocol tProtocol, TProtocol tProtocol1) throws TException {
            return false;
        }
    }
}
