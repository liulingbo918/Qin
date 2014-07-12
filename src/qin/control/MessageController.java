package qin.control;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import qin.model.domainClass.Message;

public class MessageController {
	private DBOperator dbop = null;
	
	public MessageController(){
		dbop = new DBOperator();
	}
	
	public ArrayList<Message> getOffLineMsg(String lastOnline){
		Date d = new Date();
		DateFormat df = DateFormat.getDateTimeInstance();
		String nowTime = df.format(d);
		
		ArrayList<Message> msgList = new ArrayList<Message>();
		String sql = "SELECT * FROM message WHERE unix_timestamp(dateTime) > unix_timestamp(\'"
				+ lastOnline + "\') AND unix_timestamp(dateTime) < unix_timestamp(\'"
				+ nowTime + "\')";
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
	
	
	public void deliverMsg(){
		
	}
}
