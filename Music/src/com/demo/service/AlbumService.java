package com.demo.service;

import java.util.List;

import com.demo.bean.Album;
import com.demo.bean.Music;
import com.demo.bean.PageBean;
import com.demo.dao.AlbumDao;

public class AlbumService {
	//��ҳ����
		public PageBean findMusicByPage(int currentPage,int currentCount){
			AlbumDao dao =new AlbumDao();
			PageBean bean =new PageBean();
			//��װÿҳ��ʾ����������
			bean.setCurrentCount(currentCount);
			//��װ��ǰҳ��
			bean.setCurrentPage(currentPage);
			try {
				int totalCount=dao.findCount();
				//��װ�ܼ�¼����
				bean.setTotalCount(totalCount);
				//�����ҳ�� ==ceil(��ҳ��/ÿ��ҳ��)����ȡ��
				int totalPage=(int )Math.ceil(totalCount*1.0/currentCount);
				//��װ��ҳ��
				bean.setTotalPage(totalPage);
				//����dao����������ȡ��ǰҳ������
				List<Album> ps =dao.findByPage(currentPage, currentCount);
				//��װ
				bean.setPs(ps);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return bean;
		}
		
	
}
