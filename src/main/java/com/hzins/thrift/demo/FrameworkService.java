package com.hzins.thrift.demo;

import org.apache.thrift.TException;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TProtocol;

/**
 * #author qinghao
 * #date 2019-04-21 11:19
 */
public interface FrameworkService {
     interface Iface{
       public  ThriftResponse execute(ThriftRequest request) throws TException ;
    }

    class Client{
        public Client(TProtocol protocol){
            
        }

       public ThriftResponse execute(ThriftRequest request) {
           return null;
       }
   }

    class Processor<T extends FrameworkService.Iface> implements TProcessor {

       public Processor(T t) {
       }

       @Override
       public boolean process(TProtocol tProtocol, TProtocol tProtocol1) throws TException {
           return false;
       }
   }
}
