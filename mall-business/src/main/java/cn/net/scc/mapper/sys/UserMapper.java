package cn.net.scc.mapper.sys;

import cn.net.scc.entity.sys.UserEntity;

import java.util.List;

import cn.net.scc.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户 mapper
 *
 * @author shicc 该项目是知识星球：java突击队 的内部项目
 * @date 2024-06-06 23:25:17
 */
public interface UserMapper extends BaseMapper  {
	/**
     * 查询用户信息
     *
     * @param id 用户ID
     * @return 用户信息
     */
	UserEntity findById(Long id);

	/**
     * 添加用户
     *
     * @param userEntity 用户信息
     * @return 结果
     */
	int insert(UserEntity userEntity);

	/**
     * 修改用户
     *
     * @param userEntity 用户信息
     * @return 结果
     */
	int update(UserEntity userEntity);

	/**
     * 批量删除用户
     *
     * @param ids id集合
     * @param entity 用户实体
     * @return 结果
     */
	int deleteByIds(@Param("ids") List<Long> ids, @Param("entity") UserEntity entity);

	int deleteById(@Param("id") Long id);

	/**
     * 批量查询用户信息
     *
     * @param ids ID集合
     * @return 部门信息
    */
	List<UserEntity> findByIds(List<Long> ids);
}
