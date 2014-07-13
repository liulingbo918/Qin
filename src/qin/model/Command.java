package qin.model;

public class Command {

	/***
	 * 与注册有关的信令
	 */
    // 客户端 --> 服务端	用户注册信令
    public final static String REGISTER = "register";
    // 服务端 --> 客户端	用户注册成功信令
    public final static String REGISTERSUCCESS = "registerSuccess";
    // 服务端 --> 客户端	用户注册失败信令
    public final static String REGISTERFAIL = "registerFail";
    
    
	/***
	 * 与登录有关的信令
	 */
    // 客户端 --> 服务端	用户登录信令
    public final static String LOGIN = "login";
    // 服务端 --> 客户端	用户登录成功信令
    public final static String LOGINSUCCESS = "loginSuccess";
    // 服务端 --> 客户端	用户登录失败信令
    public final static String LOGINFAIL = "loginFail";
    // 服务端 --> 客户端	好友登录信令(用于通知其好友，使得好友把他的图像变亮)
    public final static String FRIENDLOGIN = "friendLogin";
    
  
	/***
	 * 与注销有关的信令
	 */
    // 客户端 --> 服务端	用户注销信令
    public final static String LOGOUT = "logout";
    // 服务端 --> 客户端	用户注销信令(用于通知其好友，使得好友把他的图像变暗)
    public final static String FRIENDLOGOUT = "friendLogout";
    
    
    
	/***
	 * 与查询用户有关的信令
	 */
    // 客户端 --> 服务端	查找用户信令
    public final static String FINDUSER = "findUser";
    // 服务端 --> 客户端	获得查询用户信息信令
    public final static String GAINUSERINFO = "gainUserInfo";
    
    
	/***
	 * 与添加好友有关的信令
	 */
    // 客户端 --> 服务端	添加好友
    public final static String ADDFRIEND = "addFriend";
    // 服务端 --> 客户端(请求方)	等待被请求方处理添加请求
    public final static String WAITFORUSERRESPOND = "waitForUserRespond";
    // 服务端 --> 客户端(请求方)	获得被请求方处理结果
    public final static String GAINMAKEFRIENDRESPOND = "gainMakeFriendRespond";
    // 服务端 --> 客户端(被请求方)	收到添加好友请求
    public final static String RECEIVEMAKEFRIENDAPPLICATION = "receiveMakeFriendApplication";
    // 服务端(被请求方) --> 服务端	处理添加好友请求
    public final static String RESPONDMAKEFRIENDAPPLICATION = "respondMakeFriendApplication";
 
    
	/***
	 * 与创建群有关的信令
	 */
    // 客户端 --> 服务端	发送创建群请求
    public final static String CREATEGROUP = "createGroup";
    // 服务端 --> 客户端	成功创建群
    public final static String CREATEGROUPSUCCESS = "createGroupSuccess";
    
    
	/***
	 * 与查找群有关的信令
	 */
    // 客户端 --> 服务端	查找群
    public final static String FINDGROUP = "findGroup";
    // 服务端 --> 客户端	获得群息
    public final static String GAINGROUPINFO = "gainGroupInfo";
    
    
	/***
	 * 与加入群有关的信令
	 */
    // 客户端 --> 服务端	申请加入群
    public final static String JOININGROUP = "joinInGroup";
    // 服务端 --> 客户端(请求方)	等待群(主)处理添加请求
    public final static String WAITFORGROUPRESPOND = "waitForGroupRespond";
    // 服务端 --> 客户端(请求方)	获得群(主)处理结果
    public final static String GAINGROUPRESPOND = "gainGroupRespond";
    // 服务端 --> 客户端(群主)	收到加入群请求
    public final static String RECEIVEJIONINGROUPAPPLICATION = "receiveJoinInGroupApplication";
    // 服务端(群主) --> 服务端	处理加入群请求
    public final static String RESPONDJIONINGROUPAPPLICATION = "respondJoinInGroupApplication";
    
    
    /***
     * 与修改个人消息、群消息有关的信令
     */
    // 客户端 --> 服务端	修改个人消息
    public final static String CHANGEUSERINFO = "changeUserInfo";
    // 服务端 --> 客户端	修改群消息
    public final static String CHANGEGROUPINFO = "changeGroupInfo";
    
    
	/***
	 * 与聊天有关的信令
	 */
    // 客户端(发送方) --> 服务端	发送私聊信息
    public final static String SENDPRIVATEMSG = "sendPrivateMsg";
    // 服务端 --> 客户端(接收方)	接收私聊信息
    public final static String RECEIVEPRIVATEMSG = "receivePrivateMsg";
    // 客户端(发送方) --> 服务端	发送群聊信息
    public final static String SENDGROUPMSG = "sendGroupMsg";
    // 服务端 --> 客户端(接收方) 	接群私聊信息
    public final static String RECEIVEGROUPMSG = "receiveGroupMsg";
    
    
	/***
	 * 与发送有关的信令
	 */
    // 客户端(发送方) --> 客户端(接收方)	发送文件请求
    public final static String SENDFILE = "sendFile";
    // 客户端(接收方) --> 客户端(接收方)	同意接收文件
    public final static String  RECEIVEFILE = "receiveFile"; 
    // 客户端(接收方) --> 客户端(接收方)	拒绝接收文件
    public final static String  REFUSETORECEIVEFILE = "refuseToReceiveFile";   
}


