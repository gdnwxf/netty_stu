package org.xtwy.user;

import com.google.protobuf.ByteString;
import com.sun.org.apache.xpath.internal.operations.String;
import org.xtwy.pb.PbClient;
import org.xtwy.pb.protocol.EmailProbuf.Email;
import org.xtwy.pb.protocol.RequestMsgProbuf.RequestMsg;
import org.xtwy.pb.protocol.UserProbuf.User;

public class UserService {
	
	public User save() throws Exception{
		User.Builder user = User.newBuilder();
		user.setId(1);
		user.setPhone("138xxxxxx");
		user.setUserName("zhangsan");
		RequestMsg.Builder requestMsg = RequestMsg.newBuilder();
		requestMsg.setCmd("saveUser");
		requestMsg.setRequestParam(user.build().toByteString());
		return User.parseFrom(PbClient.startClient(requestMsg));
		
	}
	
	public Email getEmail() throws Exception{
		User.Builder user = User.newBuilder();
		user.setId(1);
		user.setPhone("138xxxxxx");
		user.setUserName("zhangsan");
		RequestMsg.Builder requestMsg = RequestMsg.newBuilder();
		requestMsg.setCmd("getEmailByUser");
		requestMsg.setRequestParam(user.build().toByteString());
		return Email.parseFrom(PbClient.startClient(requestMsg));
		
	}
	public String getEmailByUser() throws Exception{
		RequestMsg.Builder requestMsg = RequestMsg.newBuilder();
		requestMsg.setCmd("getEmailByUser");
		requestMsg.setRequestParam(ByteString.copyFromUtf8("你好啊"));
		ByteString bytes = PbClient.startClient(requestMsg);
		return bytes.toString();

	}

}
