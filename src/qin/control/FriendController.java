package qin.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import qin.model.msgContainer.OnlineInfoContainer;

public class FriendController {

	private DBOperator dbop = null;
	
	public FriendController(){
		dbop = new DBOperator();
	}
	
	public ArrayList<OnlineInfoContainer> getAllFriend(int uid){
		ArrayList<OnlineInfoContainer> friendList = new ArrayList<OnlineInfoContainer>();
		String sql = "SELECT uid, IPAddr, port, isOnline FROM user WHERE uid IN "
				+ "(SELECT uid1 FROM user2user WHERE uid2 = " + uid + " UNION "
				+ "SELECT uid2 FROM user2user WHERE uid1 = " + uid + ")";
		ResultSet rs = null;
		
		try{
			rs = dbop.query(sql);
			while (rs.next()){
				OnlineInfoContainer info = new OnlineInfoContainer();
				info.setUid(rs.getInt("uid"));
				info.setIPAddr(rs.getString("IPAddr"));
				info.setPort(rs.getInt("port"));
				String online = rs.getString("isOnline");
				if (online.equals("1"))
					info.setIsOnline(true);
				else
					info.setIsOnline(false);
				friendList.add(info);
			}
		} catch (Exception e){
			
		}
		return friendList;
	}
}
