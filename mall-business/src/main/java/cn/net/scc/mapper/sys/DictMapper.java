package cn.net.scc.mapper.sys;

import cn.net.scc.entity.sys.DictConditionEntity;
import cn.net.scc.entity.sys.DictEntity;

import java.util.List;

import cn.net.scc.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 部门 mapper
 *
 * @author shicc 该项目是知识星球：java突击队 的内部项目
 * @date 2024-06-06 23:25:17
 */
public interface DictMapper extends BaseMapper<DictEntity, DictConditionEntity> {
	/**
     * 查询部门信息
     *
     * @param id 部门ID
     * @return 部门信息
     */
	DictEntity findById(Long id);

	/**
     * 添加部门
     *
     * @param dictEntity 部门信息
     * @return 结果
     */
	int insert(DictEntity dictEntity);

	/**
     * 修改部门
     *
     * @param dictEntity 部门信息
     * @return 结果
     */
	int update(DictEntity dictEntity);

	/**
     * 批量删除部门
     *
     * @param ids id集合
     * @param entity 部门实体
     * @return 结果
     */
	int deleteByIds(@Param("ids") List<Long> ids, @Param("entity") DictEntity entity);

	/**
     * 批量查询部门信息
     *
     * @param ids ID集合
     * @return 部门信息
    */
	List<DictEntity> findByIds(List<Long> ids);
}
