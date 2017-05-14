package com.toolsmi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.toolsmi.dao.EmailDao;
import com.toolsmi.entity.Condition;
import com.toolsmi.entity.Email;
import com.toolsmi.util.Format;
import com.toolsmi.util.SameUserUtil;

@Service("emailService")
public class EmailServiceImpl implements EmailService {

	private EmailDao emailDao;
	private Map<String, Object> map = new HashMap<String, Object>();

	@Autowired
	public void setEmailDao(EmailDao emailDao) {
		this.emailDao = emailDao;
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> queryEmailBySendid(Condition condition) {
		map.clear();
		List<Email> es=new ArrayList<Email>();
		if (condition.getEmailParams() == null
				|| condition.getEmailParams().size() == 0) {
			es = emailDao.querySuitBySendid(SameUserUtil.getUser()
					.getId());
		} else if (condition.getEmailParams() != null
				&& condition.getEmailParams().size() > 0) {
			es=emailDao.queryBySendidAndCondition(condition);
		}
		if (es != null && es.size() > 0) {
			condition.setTotalCount(es.size());
			List<Email> emails = emailDao.queryBySendid(
					condition.getCurrentPage(), condition.getPageSize(),
					SameUserUtil.getUser().getId());
			emails = prase(emails, 4);
			if (emails == null || emails.size() == 0) {
				map.put("sendemail", "您的发件箱是空的");
				return map;
			}
			map.put("condition", condition);
			map.put("sendemail", emails);
			return map;
		} else {
			map.put("sendemail", "您的发件箱是空的");
			return map;
		}
		return getEmailBySend(condition);
	}

	@Transactional(readOnly = true)
	private Map<String, Object> getEmailBySend(Condition condition) {
		map.clear();
		List<Email> es = emailDao.querySuitBySendid(SameUserUtil.getUser()
				.getId());
		es = praseStatus(es, 4);
		if (es != null && es.size() > 0) {
			condition.setTotalCount(es.size());
			List<Email> emails = emailDao.queryBySendid(
					condition.getCurrentPage(), condition.getPageSize(),
					SameUserUtil.getUser().getId());
			emails = prase(emails, 4);
			if (emails == null || emails.size() == 0) {
				map.put("sendemail", "您的发件箱是空的");
				return map;
			}
			map.put("condition", condition);
			map.put("sendemail", emails);
			return map;
		} else {
			map.put("sendemail", "您的发件箱是空的");
			return map;
		}
	}

	private List<Email> prase(List<Email> emails, Integer status) {
		List<Email> es = new ArrayList<Email>();
		for (Email e : emails) {
			if ((e.getStatus() & status) == status) {
				if (status.equals(4)) {
					e.setReceivename(emailDao.queryUserRealnameById(e
							.getReceiveid()));
				} else if (status.equals(2)) {
					e.setSendname(emailDao.queryUserRealnameById(e
							.getReceiveid()));
				}
				es.add(e);
			}
		}
		return es;
	}

	private List<Email> praseStatus(List<Email> emails, Integer status) {
		List<Email> es = new ArrayList<Email>();
		for (Email e : emails) {
			if ((e.getStatus() & status) == status) {
				es.add(e);
			}
		}
		return es;
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> queryEmailByReceiveid(Condition condition) {
		if (condition.getEmailParams() == null
				|| condition.getEmailParams().size() == 0) {
			return getEmailByReceive(condition);
		} else if (condition.getEmailParams() != null
				&& condition.getEmailParams().size() > 0) {
			return emailDao.queryByReceiveidAndCondition(condition);
		}
	}

	@Transactional(readOnly = true)
	private Map<String, Object> getEmailByReceive(Condition condition) {
		map.clear();
		List<Email> es = emailDao.querySuitBySendid(SameUserUtil.getUser()
				.getId());
		es = praseStatus(es, 2);
		if (es != null && es.size() > 0) {
			condition.setTotalCount(es.size());
			condition.setTotalCount(emailDao.queryCountByReceiveid(SameUserUtil
					.getUser().getId()));
			List<Email> emails = emailDao.queryByReceiveid(
					condition.getCurrentPage(), condition.getPageSize(),
					SameUserUtil.getUser().getId());
			emails = prase(emails, 2);
			if (emails == null || emails.size() == 0) {
				map.put("receiveemail", "您的收件箱是空的");
				return map;
			}

			map.put("condition", condition);
			map.put("receiveemail", emails);
			return map;

		} else {
			map.put("receiveemail", "您的收件箱是空的");
			return map;
		}
	}
}
