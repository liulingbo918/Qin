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
		if (Command.LOGIN.equals(qmp.getCommand())){
			//验证用户
			UserController lc = new UserController(qmp.getLoginContainer().getUser());
			
			System.out.println(qmp.getLoginContainer().getUser().getNickName());
			int uid = qmp.getLoginContainer().getLoginUserID();
			String loginRes = lc.doLogin();
			QinMessagePacket qinResponse = new QinMessagePacket(loginRes);
			String lastOnline = lc.getLastOnline();
			//System.out.println(loginRes);
			if (Command.LOGINSUCCESS.equals(loginRes) && lc.updateState()){
				//获取离线消息
				MessageController mc = new MessageController();
				qinResponse.setMessageListContainer(new MessageListContainer(mc.getOffLineMsg(lastOnline, uid)));
				//获取好友列表
				FriendController fc = new FriendController();
				//int uid = qmp.getLoginContainer().getLoginUserID();
				qinResponse.setOnlineinfoContainerList(fc.getAllFriend(uid));
				
				//获取加友加群消息
			}
			else{
				qinResponse.setCommand(Command.LOGINFAIL);
				qinResponse.setResponseMsg(lc.getResponseMsg());
			}
			return qinResponse;
		}
		else if (Command.REGISTER.equals(qmp.getCommand())){
			System.out.println(qmp.getCommand());
			
			UserController uc = new UserController(qmp.getRegisterContainer().getUser());
			QinMessagePacket qinResponse = null;
			//System.out.println("-++++--");
			if (uc.register()){
				//System.out.println("------");
				qinResponse = new QinMessagePacket(Command.REGISTERSUCCESS);
				qinResponse.setResponseMsg(uc.getResponseMsg());
			}
			else{
				qinResponse = new QinMessagePacket(Command.REGISTERFAIL);
				qinResponse.setResponseMsg("系统繁忙，请稍后重试");
			}
			return qinResponse;
		}
		else if (Command.LOGOUT.equals(qmp.getCommand())){
			//System.out.println(qmp.getCommand());
			
			UserController uc = new UserController(qmp.getLogoutContainer().getUid(), 
					qmp.getLogoutContainer().getPassword());
			uc.logout();
			return new QinMessagePacket(Command.LOGOUT);
		}
		else if (Command.SENDPRIVATEMSG.equals(qmp.getCommand())){
			MessageController mc = new MessageController();
			mc.deliverMsg(qmp.getMessageContainer());
			return null;
		}
		else{
			System.out.println("else");
			return null; 
		}
	}
}
