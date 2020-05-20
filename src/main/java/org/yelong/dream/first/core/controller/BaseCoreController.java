/**
 * 
 */
package org.yelong.dream.first.core.controller;

import java.util.Date;

import org.yelong.dream.first.core.login.CurrentLoginUserInfo;
import org.yelong.dream.first.core.login.CurrentLoginUserInfoHolder;
import org.yelong.dream.first.core.platform.user.model.User;
import org.yelong.support.json.gson.adapter.DateTypeAdapter;
import org.yelong.support.json.gson.adapter.StringTypeAdapter;
import org.yelong.support.json.gson.model.sql.SqlModelExclusionStrategy;
import org.yelong.support.spring.mvc.controller.AbstractSpringMvcController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 基础的 controller
 * 
 * 提供默认的json转换，获取当前登陆人等公共且常用的方法
 * 
 * @author PengFei
 * @since 1.0.0
 */
public abstract class BaseCoreController extends AbstractSpringMvcController{
	
	/**
	 * 使用默认的Gson将对象转换转换为json
	 * @param obj 对象
	 * @return json格式的字符串
	 * @see #getGson()
	 */
	protected String toJson(Object obj) {
		Gson gson = getGson();
		return gson.toJson(obj);
	}
	
	/**
	 * 获取默认的Gson
	 * @return Gson
	 * @see #createDefaultGsonBuilder()
	 */
	protected Gson getGson() {
		return createDefaultGsonBuilder().create();
	}
	
	/**
	 * 创建默认Gson构建器<br/>
	 * 1、Date类型属性如果为null则返回""，否则返回时间格式为：yyyy-MM-dd HH:mm:ss<br/>
	 * 2、如果字符串为null则返回""<br/>
	 * 3、忽略对SqlModel的属性
	 * @return Gson构建器
	 */
	protected GsonBuilder createDefaultGsonBuilder() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Date.class, new DateTypeAdapter());
		gsonBuilder.registerTypeAdapter(String.class, new StringTypeAdapter());
		gsonBuilder.addSerializationExclusionStrategy(SqlModelExclusionStrategy.DEFAULT);
		return gsonBuilder;
	}
	
	/**
	 * @return 当前登录人
	 */
	protected CurrentLoginUserInfo getCurrentLoginUserInfo() {
		return CurrentLoginUserInfoHolder.currentLoginUserInfo();
	}
	
	/**
	 * @return 获取当前登录人用户信息
	 */
	protected User getCurrentLoginUser(){
		CurrentLoginUserInfo currentLoginUserInfo = getCurrentLoginUserInfo();
		return null == currentLoginUserInfo ? null : currentLoginUserInfo.getUser();
	}

}
