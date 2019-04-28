package com.demo.SMS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * http���󹤾�
 */
public class HttpUtil
{
	/**
	 * ����ͨ�ò���timestamp��sig��respDataType
	 * 
	 * @return
	 */
	public static String createCommonParam()
	{
		// ʱ���
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String timestamp = sdf.format(new Date());

		// ǩ��
		String sig = DigestUtils.md5Hex(Config.ACCOUNT_SID + Config.AUTH_TOKEN + timestamp);

		return "&timestamp=" + timestamp + "&sig=" + sig + "&respDataType=" + Config.RESP_DATA_TYPE;
	}

	/**
	 * post����
	 * 
	 * @param url
	 *            ���ܺͲ���
	 * @param body
	 *            Ҫpost������
	 * @return
	 * @throws IOException
	 */
	public static String post(String url, String body)
	{
		String result = "";
		try
		{
			OutputStreamWriter out = null;//���������
			BufferedReader in = null;//�����ַ�����������
			URL realUrl = new URL(url);//����url
			URLConnection conn = realUrl.openConnection();//������URLָ����Դ�Ļ����

			// �������Ӳ���
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(5000);//��������ʱ��
			conn.setReadTimeout(20000);//���ö�ȡ���ʱ��

			// �ύ����
			out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
			out.write(body);
			out.flush();

			// ��ȡ��������
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line = "";
			boolean firstLine = true; // ����һ�в��ӻ��з�
			while ((line = in.readLine()) != null)
			{
				if (firstLine)
				{
					firstLine = false;
				} else
				{
					result += System.lineSeparator();
				}
				result += line;
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

}