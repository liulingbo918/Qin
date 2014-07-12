package qin.model;

public class Command {

	/***
	 * ��ע���йص�����
	 */
    // �ͻ��� --> �����	�û�ע������
    public final static String REGISTER = "register";
    // ����� --> �ͻ���	�û�ע��ɹ�����
    public final static String REGISTERSUCCESS = "registerSuccess";
    // ����� --> �ͻ���	�û�ע��ʧ������
    public final static String REGISTERFAIL = "registerFail";
    
    
	/***
	 * ���¼�йص�����
	 */
    // �ͻ��� --> �����	�û���¼����
    public final static String LOGIN = "login";
    // ����� --> �ͻ���	�û���¼�ɹ�����
    public final static String LOGINSUCCESS = "loginSuccess";
    // ����� --> �ͻ���	�û���¼ʧ������
    public final static String LOGINFAIL = "loginFail";
    // ����� --> �ͻ���	���ѵ�¼����(����֪ͨ����ѣ�ʹ�ú��Ѱ�����ͼ�����)
    public final static String FRIENDLOGIN = "friendLogin";
    
  
	/***
	 * ��ע���йص�����
	 */
    // �ͻ��� --> �����	�û�ע������
    public final static String LOGOUT = "logout";
    // ����� --> �ͻ���	�û�ע������(����֪ͨ����ѣ�ʹ�ú��Ѱ�����ͼ��䰵)
    public final static String FRIENDLOGOUT = "friendLogout";
    
    
    
	/***
	 * ���ѯ�û��йص�����
	 */
    // �ͻ��� --> �����	�����û�����
    public final static String FINDUSER = "findUser";
    // ����� --> �ͻ���	��ò�ѯ�û���Ϣ����
    public final static String GAINUSERINFO = "gainUserInfo";
    
    
	/***
	 * ����Ӻ����йص�����
	 */
    // �ͻ��� --> �����	��Ӻ���
    public final static String ADDFRIEND = "addFriend";
    // ����� --> �ͻ���(����)	�ȴ������󷽴����������
    public final static String WAITFORUSERRESPOND = "waitForUserRespond";
    // ����� --> �ͻ���(����)	��ñ����󷽴�����
    public final static String GAINMAKEFRIENDRESPOND = "gainMakeFriendRespond";
    // ����� --> �ͻ���(������)	�յ���Ӻ�������
    public final static String RECEIVEMAKEFRIENDAPPLICATION = "receiveMakeFriendApplication";
    // �����(������) --> �����	������Ӻ�������
    public final static String RESPONDMAKEFRIENDAPPLICATION = "respondMakeFriendApplication";
 
    
	/***
	 * �봴��Ⱥ�йص�����
	 */
    // �ͻ��� --> �����	���ʹ���Ⱥ����
    public final static String CREATEGROUP = "createGroup";
    // ����� --> �ͻ���	�ɹ�����Ⱥ
    public final static String CREATEGROUPSUCCESS = "createGroupSuccess";
    
    
	/***
	 * �����Ⱥ�йص�����
	 */
    // �ͻ��� --> �����	����Ⱥ
    public final static String FINDGROUP = "findGroup";
    // ����� --> �ͻ���	���ȺϢ
    public final static String GAINGROUPINFO = "gainGroupInfo";
    
    
	/***
	 * �����Ⱥ�йص�����
	 */
    // �ͻ��� --> �����	�������Ⱥ
    public final static String JOININGROUP = "joinInGroup";
    // ����� --> �ͻ���(����)	�ȴ�Ⱥ(��)�����������
    public final static String WAITFORGROUPRESPOND = "waitForGroupRespond";
    // ����� --> �ͻ���(����)	���Ⱥ(��)������
    public final static String GAINGROUPRESPOND = "gainGroupRespond";
    // ����� --> �ͻ���(Ⱥ��)	�յ�����Ⱥ����
    public final static String RECEIVEJIONINGROUPAPPLICATION = "receiveJoinInGroupApplication";
    // �����(Ⱥ��) --> �����	�������Ⱥ����
    public final static String RESPONDJIONINGROUPAPPLICATION = "respondJoinInGroupApplication";
    
    
    /***
     * ���޸ĸ�����Ϣ��Ⱥ��Ϣ�йص�����
     */
    // �ͻ��� --> �����	�޸ĸ�����Ϣ
    public final static String CHANGEUSERINFO = "changeUserInfo";
    // ����� --> �ͻ���	�޸�Ⱥ��Ϣ
    public final static String CHANGEGROUPINFO = "changeGroupInfo";
    
    
	/***
	 * �������йص�����
	 */
    // �ͻ���(���ͷ�) --> �����	����˽����Ϣ
    public final static String SENDPRIVATECHAT = "sendPrivateChat";
    // ����� --> �ͻ���(���շ�)	����˽����Ϣ
    public final static String RECEIVEPRIVATECHAT = "receivePrivateChat";
    // �ͻ���(���ͷ�) --> �����	����Ⱥ����Ϣ
    public final static String SENDGROUPCHAT = "sendGroupChat";
    // ����� --> �ͻ���(���շ�) 	��Ⱥ˽����Ϣ
    public final static String RECEIVEGROUPCHAT = "receiveGroupChat";
    
    
	/***
	 * �뷢���йص�����
	 */
    // �ͻ���(���ͷ�) --> �ͻ���(���շ�)	�����ļ�����
    public final static String SENDFILE = "sendFile";
    // �ͻ���(���շ�) --> �ͻ���(���շ�)	ͬ������ļ�
    public final static String  RECEIVEFILE = "receiveFile"; 
    // �ͻ���(���շ�) --> �ͻ���(���շ�)	�ܾ������ļ�
    public final static String  REFUSETORECEIVEFILE = "refuseToReceiveFile";   
}


