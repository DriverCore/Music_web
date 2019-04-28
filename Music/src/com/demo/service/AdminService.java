package com.demo.service;

import java.sql.SQLException;
import java.util.List;

import com.demo.bean.Album;
import com.demo.bean.Music;
import com.demo.bean.User;
import com.demo.dao.AdminDao;

//����Ա��ҵ���߼�service��
public class AdminService {
	// ����dao��
	AdminDao dao = new AdminDao();

	// �û���¼���ܷ���
	public User login(String username, String password) {
		try {
			User u = dao.FindUser(username, password);
			if (u != null) {
				return u;// ���سɹ��û�
			} else {
				System.out.println("�û������������");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 1.��ѯ�����û��ķ���
	public List<User> findUser() {
		List<User> list = null;
		try {
			list = dao.findUser();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 2.�����û�id��ѯ
	public User findUserId(int id) {
		User u = null;
		try {
			u = dao.findUserId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	// 3.����id�޸��û�
	public boolean editUser(User u) {
		boolean b = false;
		try {
			b = dao.editUser(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	// 4.����idɾ��
	public boolean deleteUser(int id) {
		boolean b = false;
		try {
			b = dao.deleteUser(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	// 1.��ѯ�����û��ķ���
	public List<Music> findMusic() {
		List<Music> list = null;
		try {
			list = dao.findMusic();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 2.�����û�id��ѯ
	public Music findMusicId(int id) {
		Music m = null;
		try {
			m = dao.findMusicId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}

	// 3.����id�޸��û�
	public boolean editMusic(Music m) {
		boolean b = false;
		try {
			b = dao.editMusic(m);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	// 4.����idɾ������
	public boolean deleteMusic(int id) {
		boolean b = false;
		try {
			b = dao.deleteMusic(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	// 1.��ѯ���и����б�ķ���
	public List<Album> findAlbum() {
		List<Album> list = null;
		try {
			list = dao.findAlbum();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 2.����ר��id��ѯ
	public Album findAlbumId(int a_id) {
		Album a = null;
		try {
			a = dao.findAlbumId(a_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	// 3.����id�޸�ר��
	public boolean editAlbum(Album a){
		boolean b = false;
		try {
			b = dao.editAlbum(a);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	// 4.����idɾ������
	public boolean deleteAlbum(int a_id){
		boolean b = false;
		try {
			b = dao.deleteAlbum(a_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b ;
	}
}
