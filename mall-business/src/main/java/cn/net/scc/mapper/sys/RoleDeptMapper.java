package cn.net.scc.mapper.sys;

import cn.net.scc.entity.sys.RoleDeptEntity;

import java.util.List;

import cn.net.scc.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 角色部门关联 mapper
 *
 * @author shicc 该项目是知识星球：java突击队 的内部项目
 * @date 2024-06-06 23:25:17
 */
public interface RoleDeptMapper extends BaseMapper {
	/**
     * 查询角色部门关联信息
     *
     * @param id 角色部门关联ID
     * @return 角色部门关联信息
     */
	RoleDeptEntity findById(Long id);

	/**
     * 添加角色部门关联
     *
     * @param roleDeptEntity 角色部门关联信息
     * @return 结果
     */
	int insert(RoleDeptEntity roleDeptEntity);

	/**
     * 修改角色部门关联
     *
     * @param roleDeptEntity 角色部门关联信息
     * @return 结果
     */
	int update(RoleDeptEntity roleDeptEntity);

	/**
     * 批量删除角色部门关联
     *
     * @param ids id集合
     * @param entity 角色部门关联实体
     * @return 结果
     */
	int deleteByIds(@Param("ids") List<Long> ids, @Param("entity") RoleDeptEntity entity);

	/**
     * 批量查询角色部门关联信息
     *
     * @param ids ID集合
     * @return 部门信息
    */
	List<RoleDeptEntity> findByIds(List<Long> ids);
}
