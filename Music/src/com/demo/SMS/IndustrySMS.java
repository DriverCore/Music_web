package com.demo.SMS;

/**
 * ��֤��֪ͨ���Žӿ�
 * 
 * @ClassName: IndustrySMS
 * @Description: ��֤��֪ͨ���Žӿ�
 *
 */
public class IndustrySMS
{
	private static String operation = "/industrySMS/sendSMS";//����
	private static String accountSid = Config.ACCOUNT_SID;
	private static String smsContent="��XXXX����¼��֤�룺" ;//��������
	/**
	 * ��֤��֪ͨ����
	 */
	public static String execute(String to,String code)
	{
		String url = Config.BASE_URL + operation;
		String body ="accountSid="+accountSid+"&smsContent="+"��XXXX����¼��֤�룺"+code+"����Ǳ��˲���������Դ˶��š�"+"&to="+to+ HttpUtil.createCommonParam();

		// �ύ����
		String result = HttpUtil.post(url, body);
		return result;
	}
}
