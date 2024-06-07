package cn.net.scc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.net.scc.mapper.UserRoleMapper;
import cn.net.scc.entity.UserRoleConditionEntity;
import cn.net.scc.entity.UserRoleEntity;
import cn.net.scc.entity.ResponsePageEntity;
import cn.net.susan.util.AssertUtil;
import cn.net.susan.util.FillUserUtil;
import cn.net.susan.mapper.BaseMapper;
/**
 * 用户角色关联 服务层
 *
 * @author shicc 该项目是知识星球：java突击队 的内部项目
 * @date 2024-06-06 23:25:17
 */
@Service
public class UserRoleService extends BaseService< UserRoleEntity,  UserRoleConditionEntity> {

	@Autowired
	private UserRoleMapper userRoleMapper;

	/**
     * 查询用户角色关联信息
     *
     * @param id 用户角色关联ID
     * @return 用户角色关联信息
     */
	public UserRoleEntity findById(Long id) {
	    return userRoleMapper.findById(id);
	}

	/**
     * 根据条件分页查询用户角色关联列表
     *
     * @param userRoleConditionEntity 用户角色关联信息
     * @return 用户角色关联集合
     */
	public ResponsePageEntity<UserRoleEntity> searchByPage(UserRoleConditionEntity userRoleConditionEntity) {
		int count = userRoleMapper.searchCount(userRoleConditionEntity);
		if (count == 0) {
			return ResponsePageEntity.buildEmpty(userRoleConditionEntity);
		}
		List<UserRoleEntity> dataList = userRoleMapper.searchByCondition(userRoleConditionEntity);
		return ResponsePageEntity.build(userRoleConditionEntity, count, dataList);
	}

    /**
     * 新增用户角色关联
     *
     * @param userRoleEntity 用户角色关联信息
     * @return 结果
     */
	public int insert(UserRoleEntity userRoleEntity) {
	    return userRoleMapper.insert(userRoleEntity);
	}

	/**
     * 修改用户角色关联
     *
     * @param userRoleEntity 用户角色关联信息
     * @return 结果
     */
	public int update(UserRoleEntity userRoleEntity) {
	    return userRoleMapper.update(userRoleEntity);
	}

	/**
     * 批量删除用户角色关联对象
     *
     * @param ids 系统ID集合
     * @return 结果
     */
	public int deleteByIds(List<Long> ids) {
		List<UserRoleEntity> entities = userRoleMapper.findByIds(ids);
		AssertUtil.notEmpty(entities, "用户角色关联已被删除");

		UserRoleEntity entity = new UserRoleEntity();
		FillUserUtil.fillUpdateUserInfo(entity);
		return userRoleMapper.deleteByIds(ids, entity);
	}

	@Override
	protected BaseMapper getBaseMapper() {
		return userRoleMapper;
	}

}
