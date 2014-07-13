package qin.control;

import qin.model.Command;
import qin.model.QinMessagePacket;
import qin.model.msgContainer.MessageListContainer;

public class QinHandler {
	private QinMessagePacket qmp = null;
	
	public QinHandler(QinMessagePacket _qmp){
		this.qmp = _qmp;
	}
	
	public QinMessagePacket getResponse(){
		System.out.println("getResponse");
		if (Command.LOGIN.equals(qmp.getCommand())){
			//验证用户
			UserController lc = new UserController(qmp.getLoginContainer().getUser());
			String loginRes = lc.doLogin();
			QinMessagePacket qinResponse = new QinMessagePacket(loginRes);
			String lastOnline = lc.getLastOnline();
			//System.out.println(loginRes);
			if (Command.LOGINSUCCESS.equals(loginRes) && lc.updateState()){
				//获取离线消息
				MessageController mc = new MessageController();
				qinResponse.setMessageListContainer(new MessageListContainer(mc.getOffLineMsg(lastOnline)));
				//获取好友列表
				FriendController fc = new FriendController();
				int uid = qmp.getLoginContainer().getLoginUserID();
				qinResponse.setOnlineinfoContainerList(fc.getAllFriend(uid));
				
				//获取加友加群消息
			}
			else{
				qinResponse.setCommand(Command.LOGINFAIL);
				qinResponse.setResponseMsg(lc.getErrMsg());
			}
			return qinResponse;
		}
		else if (Command.REGISTER.equals(qmp.getCommand())){
			System.out.println(qmp.getCommand());
			UserController uc = new UserController(qmp.getRegisterContainer().getUser());
			QinMessagePacket qinResponse = null;
			if (uc.register()){
				qinResponse = new QinMessagePacket(Command.REGISTERSUCCESS);
			}
			else{
				qinResponse = new QinMessagePacket(Command.REGISTERFAIL);
				qinResponse.setResponseMsg("系统繁忙，请稍后重试");
			}
			return qinResponse;
		}
		else{
			System.out.println("else");
			return null; 
		}
	}
}
