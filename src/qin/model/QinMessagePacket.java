package qin.model;

import java.io.Serializable;

import qin.model.msgContainer.*;


public class QinMessagePacket implements Serializable {
	private static final long serialVersionUID = 1L;

	private String command;
	
	//private RegisterContainer registerContainer = null;
	private LoginContainer loginContainer = null;
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
	 * �� �������� command �йص� set��get����
	 * @return
	 */
	public String getCommand() {
		return command;
	}
	public void setCommand(String _command) {
		command = _command;
	}
	

	/***
	 * �� ע�� �йص�set��get����
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
	 * �� ��¼ �йص�set��get����
	 * @return
	 */
	public LoginContainer getLoginContainer() {
		return loginContainer;
	}
	public void setLoginContainer(LoginContainer _loginContainer) {
		loginContainer = _loginContainer;
	}
	
	
	/***
	 * �� ע�� �йص�set��get����
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
	 * �� ��ѯ�û���Ϣ �йص�set��get����
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
	 * �� ���Ӻ��� �йص�set��get����
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
	 * �� ����Ⱥ �йص�set��get����
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
	 * �� ��ѯȺ �йص�set��get����
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
	 * �� ����Ⱥ �йص�set��get����
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
	 * �� ����Ⱥ���� �йص�set��get����
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
	 * �� �����û���Ϣ �йص�set��get����
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
	 * �� ���� �йص�set��get����
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
