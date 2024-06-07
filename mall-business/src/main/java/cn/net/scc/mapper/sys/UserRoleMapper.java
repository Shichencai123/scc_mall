package cn.net.scc.mapper.sys;

import cn.net.scc.entity.sys.UserRoleEntity;

import java.util.List;

import cn.net.scc.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户角色关联 mapper
 *
 * @author shicc 该项目是知识星球：java突击队 的内部项目
 * @date 2024-06-06 23:25:17
 */
public interface UserRoleMapper extends BaseMapper {
	/**
     * 查询用户角色关联信息
     *
     * @param id 用户角色关联ID
     * @return 用户角色关联信息
     */
	UserRoleEntity findById(Long id);

	/**
     * 添加用户角色关联
     *
     * @param userRoleEntity 用户角色关联信息
     * @return 结果
     */
	int insert(UserRoleEntity userRoleEntity);

	/**
     * 修改用户角色关联
     *
     * @param userRoleEntity 用户角色关联信息
     * @return 结果
     */
	int update(UserRoleEntity userRoleEntity);

	/**
     * 批量删除用户角色关联
     *
     * @param ids id集合
     * @param entity 用户角色关联实体
     * @return 结果
     */
	int deleteByIds(@Param("ids") List<Long> ids, @Param("entity") UserRoleEntity entity);

	/**
     * 批量查询用户角色关联信息
     *
     * @param ids ID集合
     * @return 部门信息
    */
	List<UserRoleEntity> findByIds(List<Long> ids);
}
