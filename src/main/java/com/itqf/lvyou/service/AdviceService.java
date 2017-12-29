package com.itqf.lvyou.service;

import java.util.List;
import com.itqf.lvyou.model.Advice;

/**
 * 投诉建议service业务逻辑处理
 * @author Administrator
 *
 */
public interface AdviceService {

	/**
	 * 获取所有投诉建议
	 * @return
	 */
	public abstract List<Advice> getAllAdvice();

}
