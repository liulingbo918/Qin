package qin.model;

import java.io.Serializable;
import java.util.ArrayList;

import qin.model.msgContainer.*;


public class QinMessagePacket implements Serializable {
	private static final long serialVersionUID = 1L;

	private String command;
	
	//private RegisterContainer registerContainer = null;
	private LoginContainer loginContainer = null;
	private MessageContainer msgContainer = null;
	private MessageListContainer msgListContainer = null;
	
	private OnlineInfoContainer onlineinfoContainer = null;
	private ArrayList<OnlineInfoContainer> onlineinfoContainerList = null;
	//private LogoutContainer logoutSeqment = null;
	
	//private FindUserContainer findUserContainer = null;
	//private MakeFriendContainer makeFriendContainer = null;
	
	//private CreateGroupContainer createGroupContainer = null;
	//private FindGroupContainer findGroupContainer = null;
	//private JoinInGroupContainer joinInGroupContainer = null;
	
	//private ChangeGroupInfoContainer  changeGroupInfoContainer = null;
	//private ChangeUserInfoContainer	changeUserInfoContainer  = null;
	
	//private ChatContainer chatContainer = null;
	
	
	
	public QinMessagePacket(String _command) {
		command = _command;
	}
	
	
	/***
	 * 与 操作类型 command 有关的 set、get函数
	 * @return
	 */
	public String getCommand() {
		return command;
	}
	public void setCommand(String _command) {
		command = _command;
	}
	

	/***
	 * 与 注册 有关的set、get函数
	 * @return
	 *//*
	public RegisterContainer getRegisterContainer() {
		return registerContainer;
	}
	public void setRegisterContainer(RegisterContainer _registerContainer) {
		registerContainer = _registerContainer;
	}
	*/
	
	/***
	 * 与 登录 有关的set、get函数
	 * @return
	 */
	public LoginContainer getLoginContainer() {
		return loginContainer;
	}
	public void setLoginContainer(LoginContainer _loginContainer) {
		loginContainer = _loginContainer;
	}
	
	public MessageContainer getMessageContainer(){
		return msgContainer;
	}
	
	public void setMessageContainer(MessageContainer msgc){
		msgContainer = msgc;
	}
	
	public MessageListContainer getMessageListContainer(){
		return msgListContainer;
	}
	
	public void setMessageListContainer(MessageListContainer msgListc){
		msgListContainer = msgListc;
	}
	
	public OnlineInfoContainer getOnlineInfoContainer(){
		return onlineinfoContainer;
	}
	
	public void setOnlineInfoContainer(OnlineInfoContainer online){
		onlineinfoContainer = online;
	}
	
	public ArrayList<OnlineInfoContainer> getOnlineinfoContainerList(){
		return onlineinfoContainerList;
	}
	
	public void setOnlineinfoContainerList(ArrayList<OnlineInfoContainer> list){
		onlineinfoContainerList = list;
	}
	
	/***
	 * 与 注销 有关的set、get函数
	 * @return
	 *//*
	public LogoutContainer getLogoutContainer() {
		return logoutSeqment;
	}
	public void setLogoutContainer(LogoutContainer _logoutContainer) {
		logoutSeqment = _logoutContainer;
	}
*/
	
	/***
	 * 与 查询用户信息 有关的set、get函数
	 * @return
	 *//*
	public FindUserContainer getFindUserContainer() {
		return findUserContainer;
	}
	public void setFindUserContainer(FindUserContainer _findUserContainer) {
		findUserContainer = _findUserContainer;
	}
	*/
	
	/***
	 * 与 添加好友 有关的set、get函数
	 * @return
	 *//*
	public MakeFriendContainer getMakeFriendContainer() {
		return  makeFriendContainer;
	}
	public void setMakeFriendContainer(MakeFriendContainer _makeFriendContainer) {
		makeFriendContainer = _makeFriendContainer;
	}
	*/
	
	/***
	 * 与 创建群 有关的set、get函数
	 * @return
	 *//*
	public CreateGroupContainer getCreateGroupContainer() {
		return createGroupContainer;
	}
	public void setCreateGroupContainer(CreateGroupContainer _createGroupContainer) {
		createGroupContainer = _createGroupContainer;
	}
	*/
	
	/***
	 * 与 查询群 有关的set、get函数
	 * @return
	 *//*
	public FindGroupContainer getFindGroupContainer() {
		return findGroupContainer;
	}
	public void setFindGroupContainer(FindGroupContainer _findGroupContainer) {
		findGroupContainer = _findGroupContainer;
	}
	*/
	
	/***
	 * 与 加入群 有关的set、get函数
	 * @return
	 *//*
	public JoinInGroupContainer  getJoinInGroupContainer() {
		return joinInGroupContainer;
	}
	public void setJoinInGroupContainer(JoinInGroupContainer _joinInGroupContainer) {
		joinInGroupContainer = _joinInGroupContainer;
	}
	*/
	
	/***
	 * 与 更改群设置 有关的set、get函数
	 * @return
	 *//*
	public ChangeGroupInfoContainer getChangeGroupInfoContainer() {
		return changeGroupInfoContainer;
	}
	public void setChangeGroupInfoContainer(ChangeGroupInfoContainer _changeGroupInfoContainer) {
		changeGroupInfoContainer = _changeGroupInfoContainer;
	}
	*/
	
	/***
	 * 与 更改用户信息 有关的set、get函数
	 * @return
	 *//*
	public ChangeUserInfoContainer getChangeUserInfoContainer() {
		return changeUserInfoContainer;
	}
	public void setChangeUserInfoContainer(ChangeUserInfoContainer _changeUserInfoContainer) {
		changeUserInfoContainer = _changeUserInfoContainer ;
	}
	*/
	/***
	 * 与 聊天 有关的set、get函数
	 * @return
	 *//*
	public ChatContainer getChatContainer() {
		return chatContainer;
	}
	public void setChatContainer(ChatContainer _chatContainer) {
		chatContainer = _chatContainer;
	}
	*/
}

