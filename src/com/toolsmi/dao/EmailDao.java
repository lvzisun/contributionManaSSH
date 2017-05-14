package com.toolsmi.dao;

import java.util.List;

import com.toolsmi.entity.Email;

public interface EmailDao {

	Integer queryCountBySendid(Integer id);

	List<Email> queryBySendid(Integer currentPage, Integer pageSize, Integer id);

	Integer queryCountBySendidAndReceiveid(Integer id, Integer receiveid);

	List<Email> queryBySendidAndReceiveid(Integer currentPage,
			Integer pageSize, Integer id, Integer receiveid);

	Integer queryCountBySendidAndContent(Integer id, String content);

	List<Email> queryBySendidAndContent(Integer currentPage, Integer pageSize,
			Integer id, String content);

	Integer queryCountBySendidAndTitle(Integer id, String title);

	List<Email> queryBySendidAndTitle(Integer currentPage, Integer pageSize,
			Integer id, String title);

	Integer queryCountByReceiveid(Integer id);

	List<Email> queryByReceiveid(Integer currentPage, Integer pageSize,
			Integer id);

	Integer queryCountByReceiveidAndContent(Integer id, String content);

	List<Email> queryByReceiveidAndContent(Integer currentPage,
			Integer pageSize, Integer id, String content);

	Integer queryCountByReceiveidAndTitle(Integer id, String title);

	List<Email> queryReceiveidAndTitle(Integer currentPage, Integer pageSize,
			Integer id, String title);

	String queryUserRealnameById(Integer receiveid);

	List<Email> querySuitBySendid(Integer id);

	List<Email> queryBySendidAndTitleByOrder(Integer currentPage,
			Integer pageSize, Integer id, String title, String order);

	List<Email> querySuitBySendidAndTitle(Integer id, String title);

	List<Email> querySuitBySendidAndContent(Integer id, String content);

	List<Email> queryBySendidAndContentByOrder(Integer currentPage,
			Integer pageSize, Integer id, String content, String order);

}
