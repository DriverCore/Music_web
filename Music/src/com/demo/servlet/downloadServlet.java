package com.demo.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/download")
public class downloadServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ���ص��ļ���
		String fname=request.getParameter("fname");
		String folder="/upload/";//�����ļ���
		//����ͷ֪ͨ
		response.addHeader("Content-Type", "application/octet-stream");//�������ͣ��������ļ�
		response.addHeader("Content-Disposition", "attachment;filename="+fname);//��������-�ļ���Ϊ
		//һ����--ͨ���ֽ��������ļ�
		//�ȶ�������������Դ���ֽ�������
		InputStream in =getServletContext().getResourceAsStream(folder+fname);//������--��ȡ��Դ��
		//��ȡ������������������
		OutputStream out =response.getOutputStream();//����ֽ���
		//���ĶԿ�
		byte[] buf=new byte[1024];
		int len;
		while((len=in.read(buf))!=-1){
			out.write(buf,0,len);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
