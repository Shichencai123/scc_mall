package cn.net.scc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.net.scc.mapper.RoleMenuMapper;
import cn.net.scc.entity.RoleMenuConditionEntity;
import cn.net.scc.entity.RoleMenuEntity;
import cn.net.scc.entity.ResponsePageEntity;
import cn.net.susan.util.AssertUtil;
import cn.net.susan.util.FillUserUtil;
import cn.net.susan.mapper.BaseMapper;
/**
 * 角色菜单关联 服务层
 *
 * @author shicc 该项目是知识星球：java突击队 的内部项目
 * @date 2024-06-06 23:25:17
 */
@Service
public class RoleMenuService extends BaseService< RoleMenuEntity,  RoleMenuConditionEntity> {

	@Autowired
	private RoleMenuMapper roleMenuMapper;

	/**
     * 查询角色菜单关联信息
     *
     * @param id 角色菜单关联ID
     * @return 角色菜单关联信息
     */
	public RoleMenuEntity findById(Long id) {
	    return roleMenuMapper.findById(id);
	}

	/**
     * 根据条件分页查询角色菜单关联列表
     *
     * @param roleMenuConditionEntity 角色菜单关联信息
     * @return 角色菜单关联集合
     */
	public ResponsePageEntity<RoleMenuEntity> searchByPage(RoleMenuConditionEntity roleMenuConditionEntity) {
		int count = roleMenuMapper.searchCount(roleMenuConditionEntity);
		if (count == 0) {
			return ResponsePageEntity.buildEmpty(roleMenuConditionEntity);
		}
		List<RoleMenuEntity> dataList = roleMenuMapper.searchByCondition(roleMenuConditionEntity);
		return ResponsePageEntity.build(roleMenuConditionEntity, count, dataList);
	}

    /**
     * 新增角色菜单关联
     *
     * @param roleMenuEntity 角色菜单关联信息
     * @return 结果
     */
	public int insert(RoleMenuEntity roleMenuEntity) {
	    return roleMenuMapper.insert(roleMenuEntity);
	}

	/**
     * 修改角色菜单关联
     *
     * @param roleMenuEntity 角色菜单关联信息
     * @return 结果
     */
	public int update(RoleMenuEntity roleMenuEntity) {
	    return roleMenuMapper.update(roleMenuEntity);
	}

	/**
     * 批量删除角色菜单关联对象
     *
     * @param ids 系统ID集合
     * @return 结果
     */
	public int deleteByIds(List<Long> ids) {
		List<RoleMenuEntity> entities = roleMenuMapper.findByIds(ids);
		AssertUtil.notEmpty(entities, "角色菜单关联已被删除");

		RoleMenuEntity entity = new RoleMenuEntity();
		FillUserUtil.fillUpdateUserInfo(entity);
		return roleMenuMapper.deleteByIds(ids, entity);
	}

	@Override
	protected BaseMapper getBaseMapper() {
		return roleMenuMapper;
	}

}
