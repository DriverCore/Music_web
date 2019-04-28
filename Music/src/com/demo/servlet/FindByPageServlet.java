package com.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.PageBean;
import com.demo.service.AlbumService;
import com.demo.service.MusicService;
@WebServlet(urlPatterns="/FindByPage")
public class FindByPageServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.���嵱ǰ��ҳ��Ϊ��һҳ
		int currentPage=1;
		String page =request.getParameter("currentPage");
		if (page!=null) {
			currentPage=Integer.parseInt(page);
		}
		//����ÿҳ��ʾ����---4��/ҳ
		int currentCount=4;
		String count=request.getParameter("currentCount");
		if (count!=null) {
			currentCount=Integer.parseInt(count);
		}
		//����service��ҳ��ʾ������������ȡ��ǰҳ��bean����
		AlbumService as =new AlbumService();
		PageBean bean =as.findMusicByPage(currentPage, currentCount);
		//�Ѳ�ѯ��ȡ�����ݴ��뵽request���������
		request.setAttribute("bean", bean);
		request.getRequestDispatcher("message.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
