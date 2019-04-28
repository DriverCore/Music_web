package com.demo.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.demo.bean.Music;
import com.demo.dao.MusicDao;

@WebServlet(urlPatterns="/upload")
public class uploadServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������������
		try {
		DiskFileItemFactory factory =new DiskFileItemFactory();
		File f =new File("E:\\Temp");//�Ż�,����ڴ����
		if (!f.exists()) {//��������ھͽ���һ���µ��ļ���
			f.mkdirs();
		}
		factory.setRepository(f);//���û���·��
		//ͨ���������󣬻�ý���������
		ServletFileUpload sfu = new ServletFileUpload(factory);
		sfu.setHeaderEncoding("utf-8");
		//ͨ�����������󣬽���request�еı��ļ�����Ϊ��ͨ�ֶκ��ļ��ֶ�
		List<FileItem> flist =sfu.parseRequest(request);
		//������װ�����ݵ�javaBean����
		Music m =new Music();
		//ѭ�����������list�����еı��ֶ�(��ͨ�ֶκ��ļ��ֶ�)
		for (FileItem item : flist) {
			if (item.isFormField()) {//�ж��Ƿ�����ͨ�ֶΣ�������������ͨ�ֶδ���else������ļ��ֶδ���
				String name=item.getFieldName();
				//��ȡ�ֶ�ֵ
				String value =item.getString("utf-8");//���ڿ��ܳ�������ʹ�ô������ķ���
				if ("Mname".equals(name)) {
					m.setMname(value);
				}
				if ("singer".equals(name)) {
					m.setSinger(value);
				}
				if ("a_id".equals(name)) {
					m.setA_id(value);
				}
			}else {
				String fname=item.getName();//��ȡ�ϴ��ļ����ļ���
				//��ȡ����ļ���
				fname =fname.substring(fname.lastIndexOf("."));//�ӵ�ȡ
				fname=UUID.randomUUID().toString()+fname;//�����ļ���
				m.setUrl(fname);
				String webpath="/upload/";//�ڷ����������ļ���
				//�����������ļ���·�����ļ�����ϳ������ķ�������·��
				String filepath =getServletContext().getRealPath(webpath+fname);
				//���ֽ���д�ļ�
				File file =new File(filepath);
				//�������ϲ��ļ���upload
				file.getParentFile().mkdirs();
				file.createNewFile();//�����ļ�
				InputStream in =item.getInputStream();
				//����������� �򿪷������˵��ļ��ϴ�
				FileOutputStream fout = new FileOutputStream(file);
				//���ĶԿ�
				byte[] buf=new byte[1024];//ÿ�ζ�ȡ1���ֽ�
				int len;//һ�ζ�ȡ����ĳ���
				//��ʼ��ȡ�ϴ��ļ����ֽ�,��������������������ϴ��ļ������
				while((len=in.read(buf))>0){
					fout.write(buf, 0, len);
				}
				//�ر���
				in.close();
				fout.close();
				//ɾ����ʱ�ļ�
				item.delete();
			}
		}
			MusicDao md =new MusicDao();
			boolean result=md.addMusic(m);
			if (result) {
				response.sendRedirect("listMusic");
			}else{
				response.getWriter().println("error");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
