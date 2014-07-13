package qin.control;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import qin.model.Command;
import qin.model.QinMessagePacket;
import qin.model.domainClass.Message;
import qin.model.msgContainer.MessageContainer;

public class MessageController {
	private DBOperator dbop = null;
	
	public MessageController(){
		dbop = new DBOperator();
	}
	
	public ArrayList<Message> getOffLineMsg(String lastOnline, int uid){
		Date d = new Date();
		DateFormat df = DateFormat.getDateTimeInstance();
		String nowTime = df.format(d);
		
		ArrayList<Message> msgList = new ArrayList<Message>();
		String sql = "SELECT * FROM message WHERE unix_timestamp(dateTime) > unix_timestamp(\'"
				+ lastOnline + "\') AND unix_timestamp(dateTime) < unix_timestamp(\'"
				+ nowTime + "\') AND destinationId = " + uid;
		ResultSet rs = null;
		
		try{
			rs = dbop.query(sql);
			while (rs.next()){
				Message msg = new Message();
				msg.setSourceId(rs.getInt("sourceId"));
				msg.setDestinationId(rs.getInt("destinationId"));
				msg.setDateTime(rs.getString("dateTime"));
				msg.setDetail(rs.getString("detail"));
				String isQM = rs.getString("isQunMsg");
				if (isQM.equals("1"))
					msg.setIsQunMsg(true);
				else
					msg.setIsQunMsg(false);
				msgList.add(msg);
			}
		} catch (Exception e) {
		}
		return msgList;
	}
	
	public void sendMsg(String ip, int port, MessageContainer mc){
		QinMessagePacket qm = new QinMessagePacket(Command.RECEIVEPRIVATEMSG);
		qm.setMessageContainer(mc);
		Socket socketConnection;
		try {
			socketConnection = new Socket(ip, port);
			ObjectOutputStream out = new ObjectOutputStream(socketConnection.getOutputStream());
			out.writeObject(qm);
			out.flush();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public void deliverMsg(MessageContainer mc){
		Message msg = mc.getMessage();
		
		Date d = new Date();
		DateFormat df = DateFormat.getDateTimeInstance();
		String datetime = df.format(d);
		String sql = "INSERT INTO message(sourceId, destinationId, detail, dateTime) VALUES("
				+ msg.getSourceId() + ", " + msg.getDestinationId() + ", \'" 
				+ msg.getDetail() +"\', \'" + datetime + "\')";
		System.out.println(sql);
		dbop.insert(sql);
		
		String findUser = "SELECT isOnline FROM user WHERE uid = " + msg.getDestinationId();
		ResultSet res = null;
		String online = null;
		try{
			res = dbop.query(findUser);
			if (res.next()){
				online = res.getString("isOnline");
			}
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		mc.getMessage().setDateTime(datetime);
		if ("1".equals(online)){
			String findDest = "SELECT IPAddr, port FROM user WHERE uid = " + msg.getDestinationId();
			ResultSet rs = null;
			String ip = null;
			int port;
			try {
				rs = dbop.query(findDest);
				if (rs.next()){
					ip = rs.getString("IPAddr");
					port = rs.getInt("port");
					sendMsg(ip, port, mc);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
