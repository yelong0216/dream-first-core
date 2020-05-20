	/**
 * 
 */
package org.yelong.dream.first.core.platform.user.service;

import java.util.List;

import org.yelong.core.annotation.Nullable;
import org.yelong.core.jdbc.sql.condition.ConditionSqlFragment;
import org.yelong.dream.first.core.platform.user.model.User;

/**
 * @author PengFei
 * @since 1.0.0
 */
public interface UserCommonService {

	/**
	 * 根据用户名称查询用户记录
	 * @param userName 用户名称
	 * @return 用户
	 */
	User findByUserName(String userName) ;
	
	/**
	 * 修改密码
	 * @param userId 用户id
	 * @param oldPassword 原密码
	 * @param newPassword 新密码
	 */
	void modifyPassword(String userId , String oldPassword,String newPassword) ;
	
	/**
	 * 获取密码签名
	 * @param password 密码
	 * @return 密码签名
	 */
	String getPwdSign(String password);
	
	/**
	 * 删除用户，且删除用户关联的角色，附属部门等信息
	 * @param userId 用户id
	 */
	void remove(String userId) ;
	
	/**
	 * 删除多个用户
	 * @param userId 用户id
	 */
	default void removeByBatch(String [] userIds) {
		for (String userId : userIds) {
			remove(userId);
		}
	}
	
	/**
	 * 重置密码
	 * @param userId 用户id
	 */
	void resetPassword(String userId) ;
	
	/**
	 * 重置多个用户密码
	 * @param userIds 用户id数组
	 */
	default void resetPasswordByBatch(String [] userIds) {
		for (String userId : userIds) {
			resetPassword(userId);
		}
	}
	
	/**
	 * 锁定用户
	 * @param userId 用户id
	 */
	void lockUser(String userId) ;
	
	/**
	 * 锁定多个用户
	 * @param userIds 用户id数组
	 */
	default void lockUserByBatch(String [] userIds) {
		for (String userId : userIds) {
			lockUser(userId);
		}
	}
	
	/**
	 * 解锁用户
	 * @param userId 用户id
	 */
	void unLockUser(String userId) ;
	
	/**
	 * 解锁多个用户
	 * @param userIds 用户id数组
	 */
	default void unLockUserByBatch(String [] userIds) {
		for (String userId : userIds) {
			unLockUser(userId);
		}
	}
	
	/**
	 * 查询密码签名
	 * @param password 密码
	 * @return 密码签名
	 */
	String getPasswordSign(String password);
	
	@Deprecated
	List<User> findByRoleCondition(@Nullable ConditionSqlFragment condition);
	
}
