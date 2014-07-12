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
		System.out.println(nowTime);;
		System.out.println(lastOnline);
		
		nowTime = "2014-07-22 17:09:11";
		ArrayList<Message> msgList = new ArrayList<Message>();
		String sql = "SELECT * FROM message WHERE unix_timestamp(dateTime) > unix_timestamp(\'"
				+ lastOnline + "\') AND unix_timestamp(dateTime) < unix_timestamp(\'"
				+ nowTime + "\')";
		ResultSet rs = null;
		System.out.println("================");
		try{
			rs = dbop.query(sql);
			System.out.println("++++++++++++++++++");
			while (rs.next()){
				System.out.println("----------");
				Message msg = new Message();
				msg.setSourceId(rs.getInt("sourceId"));
				System.out.println(msg.getSourceId());
				msg.setDestinationId(rs.getInt("destinationId"));
				System.out.println(msg.getDestinationId());
				msg.setDateTime(rs.getString("dateTime"));
				System.out.println(msg.getDateTime());
				msg.setDetail(rs.getString("detail"));
				System.out.println(msg.getDetail());
				String isQM = rs.getString("isQunMsg");
				if (isQM.equals("1"))
					msg.setIsQunMsg(true);
				else
					msg.setIsQunMsg(false);
				System.out.println(msg.isQunMsg());
				msgList.add(msg);
				System.out.println(msgList.size());
			}
		} catch (Exception e) {
		}
		return msgList;
	}
}
