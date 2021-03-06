package org.xtwy.http;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponseDecoder;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.AttributeKey;

import java.net.URI;

import org.xtwy.netty.constants.CommonConstant;
import org.xtwy.util.JsonUtils;

public class HttpClient {
	public  static Bootstrap b;
	public static  PooledByteBufAllocator  allocator = new PooledByteBufAllocator();
	static{
		try {
			     EventLoopGroup workerGroup = new NioEventLoopGroup();
			      b = new Bootstrap(); // (1)
				 b.group(workerGroup); // (2)
				 b.channel(NioSocketChannel.class); // (3)
				 b.option(ChannelOption.SO_KEEPALIVE, true); // (4)
				 b.handler(new ChannelInitializer<SocketChannel>() {
				     @Override
				     public void initChannel(SocketChannel ch) throws Exception {

				    	 ch.pipeline().addLast(new HttpRequestEncoder());
				    	 ch.pipeline().addLast(new HttpObjectAggregator(65536));
				    	 ch.pipeline().addLast(new HttpResponseDecoder());
				    	 ch.pipeline().addLast(new HttpClientHandler());
				     }
				 });
				
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 public static Object startClient(RequestParam requestParam) throws Exception {
		/*     ChannelFuture  f= b.connect("localhost", 8999).sync(); 
		     URI uri = new URI("http://127.0.0.1:8999");
		     ByteBuf content = Unpooled.wrappedBuffer(JsonUtils.beanToJson(requestParam).getBytes("UTF-8"));
		     DefaultFullHttpRequest  req = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, uri.toASCIIString(), content);
		     req.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
		     req.headers().set(HttpHeaderNames.HOST, "127.0.0.1");
		     req.headers().setInt(HttpHeaderNames.CONTENT_LENGTH,content.readableBytes());
		     req.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);*/
		 
		     ChannelFuture  f= b.connect("localhost", 8999).sync(); 
		     URI uri = new URI("http://127.0.0.1:8999");
		     ByteBuf content = Unpooled.wrappedBuffer(JsonUtils.beanToJson(requestParam).getBytes("UTF-8"));
		     DefaultFullHttpRequest req = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, uri.toASCIIString(), content);
		     req.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/plain");
		     req.headers().set(HttpHeaderNames.HOST,"127.0.0.1");
		     req.headers().setInt(HttpHeaderNames.CONTENT_LENGTH,content.readableBytes());
		     req.headers().set(HttpHeaderNames.CONNECTION,HttpHeaderValues.KEEP_ALIVE);
		     f.channel().writeAndFlush(req);
			 f.channel().closeFuture().sync();
			 return f.channel().attr(AttributeKey.valueOf(CommonConstant.ATTRIBUTE_KEY)).get();
		
	 }
	 
	 
	 
	 
}
