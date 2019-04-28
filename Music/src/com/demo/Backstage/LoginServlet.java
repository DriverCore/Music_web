package com.demo.Backstage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.User;
import com.demo.service.AdminService;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ�û��ύ���û���������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//2.����UserService�еĵ�¼����
		AdminService us = new AdminService();
		User u = us.login(username, password);
		if(u!=null){//��¼�ɹ�
			//3.�����û���¼״̬�������û����뵽session��
			request.getSession().setAttribute("user", u);
			//4.�ж��û��Ľ�ɫ���������û�/��ͨ�û�
			String role = u.getRole();//��ȡ�û���ɫ
			if("�����û�".equals(role)){//����Ա����̨����
				response.sendRedirect(request.getContextPath()+"/admin/login.jsp");
			}else{//��ͨ�û���ǰ̨��ҳ���
				response.sendRedirect(request.getContextPath()+"/admin/index.jsp");
			}
		}else{//��¼ʧ��
			request.setAttribute("login_msg", "��¼ʧ�ܣ�1.�û������������2.�û���δ����");
			request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
