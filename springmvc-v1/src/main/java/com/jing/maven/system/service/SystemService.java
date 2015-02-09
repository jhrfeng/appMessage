package com.jing.maven.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jing.maven.manager.entity.Message;
import com.jing.maven.system.dao.SystemDao;
import com.jing.maven.system.entity.FeedbackPO;
import com.jing.maven.system.model.CompanyInfo;

@Service
public class SystemService {
	
	@Autowired
	private SystemDao systemDao;

	/**
	 * 问题反馈
	 * @param feedback
	 * @return
	 */
	public Message feedback(@RequestBody FeedbackPO feedback){
		Message message = new Message();
		try{
			if(null!=feedback && null!=feedback.getQuestion()  &&!"".equals(feedback.getQuestion())){
				feedback.setCreateDate("2012/12/12");
				feedback.setInfoId("");
				systemDao.save(feedback);
				message.setOptStatus(true);
				message.setMessage("感谢反馈");
				return message;
			}else{
				message.setOptStatus(false);
				message.setMessage("内容不能为空");
				return message;
			}
		}catch(Exception e){
			message.setOptStatus(false);
			message.setMessage("反馈失败");
			return message;
		}
		
	}
	
	/**
	 * 关于我们
	 * @return
	 */
	public CompanyInfo about(){
		return new CompanyInfo();
	}
}
