package com.demo.Backstage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.Album;
import com.demo.service.AdminService;

/**
 * Servlet implementation class FindAlbumIdServlet
 */
@WebServlet("/FindAlbumIdServlet")
public class FindAlbumIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindAlbumIdServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����û�id��jspҳ�洫��
		int a_id = Integer.parseInt(request.getParameter("a_id"));
		// ����service����
		AdminService as = new AdminService();
		Album a = as.findAlbumId(a_id);
		// ��ȡ��ѯ���󣬴���
		request.setAttribute("p", a);
		request.getRequestDispatcher("/admin/editalbum.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
