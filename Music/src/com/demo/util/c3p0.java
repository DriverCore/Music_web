package com.demo.util;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;



import com.mchange.v2.c3p0.ComboPooledDataSource;

//���ݿ����ӳ�-----����c3p0����
public class c3p0 {
	public static DataSource ds=null ;//����Դ----���Դ�����Դ��ȡ����Connection
	//������Դ��ֵ---ͨ��c3p0�������ӳ�
	static{
		//��ȡ�������ӳ�
		ComboPooledDataSource bds=new ComboPooledDataSource();
		//������Դ���ò���
		//�������ݿ��������:SQLServer/MySql/Oracle���ݿ�
		try {
			bds.setDriverClass("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//�������ݿ��λ��:Э��,ip��ַ,�˿ں�,���ݿ���,
		bds.setJdbcUrl("jdbc:sqlserver://localhost:xxxx;databaseName=xxxx");
		//���õ�¼�û���
		bds.setUser("xx");
		//���õ�¼����
		bds.setPassword("xxxxxxxx");
		//�������ӳس�ʼ����
		bds.setInitialPoolSize(5);
		//�������ӳ������������
		bds.setMaxPoolSize(10);
		//�����ӳظ�����Դ��ֵ
		ds=bds;
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
	}
}
