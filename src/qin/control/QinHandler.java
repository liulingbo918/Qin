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
			//验证登录
			UserController lc = new UserController(qmp.getLoginContainer());
			String loginRes = lc.doLogin();
			QinMessagePacket qinResponse = new QinMessagePacket(loginRes);
			String lastOnline = lc.getLastOnline();
			if (Command.LOGINSUCCESS.equals(loginRes) && lc.updateState()){
				//获取离线消息
				MessageController mc = new MessageController();
				qinResponse.setMessageListContainer(new MessageListContainer(mc.getOffLineMsg(lastOnline)));
				
				//获取好友列表
				
				//获取加友加群消息
			}
			else
				qinResponse.setCommand(Command.LOGINFAIL);
			
			return qinResponse;
		}
		else{
			System.out.println("else");
			return null; 
		}
	}
}
