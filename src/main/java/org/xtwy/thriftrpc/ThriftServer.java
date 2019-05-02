package org.xtwy.thriftrpc;

import com.hzins.thrift.demo.HelloWorldService;
import com.hzins.thrift.demo.HelloWorldService.Processor;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;


public class ThriftServer    {



	public static void startServer(int port) throws Exception{
		TProcessor processor = new Processor<HelloWorldService.Iface>(new HelloServiceImpl());
		TServerSocket transport = new TServerSocket(port);
		TServer.Args args = new TServer.Args(transport);
		args.processor(processor);
		args.protocolFactory(new TBinaryProtocol.Factory());
		TServer server =  new TSimpleServer(args);
		server.serve();
	}

	public static void main(String[] args) throws Exception {
		startServer(8081);
	}


}
