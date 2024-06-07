package cn.net.scc.mapper.sys;

import cn.net.scc.entity.sys.RoleMenuEntity;

import java.util.List;

import cn.net.scc.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 角色菜单关联 mapper
 *
 * @author shicc 该项目是知识星球：java突击队 的内部项目
 * @date 2024-06-06 23:25:17
 */
public interface RoleMenuMapper extends BaseMapper {
	/**
     * 查询角色菜单关联信息
     *
     * @param id 角色菜单关联ID
     * @return 角色菜单关联信息
     */
	RoleMenuEntity findById(Long id);

	/**
     * 添加角色菜单关联
     *
     * @param roleMenuEntity 角色菜单关联信息
     * @return 结果
     */
	int insert(RoleMenuEntity roleMenuEntity);

	/**
     * 修改角色菜单关联
     *
     * @param roleMenuEntity 角色菜单关联信息
     * @return 结果
     */
	int update(RoleMenuEntity roleMenuEntity);

	/**
     * 批量删除角色菜单关联
     *
     * @param ids id集合
     * @param entity 角色菜单关联实体
     * @return 结果
     */
	int deleteByIds(@Param("ids") List<Long> ids, @Param("entity") RoleMenuEntity entity);

	/**
     * 批量查询角色菜单关联信息
     *
     * @param ids ID集合
     * @return 部门信息
    */
	List<RoleMenuEntity> findByIds(List<Long> ids);
}
