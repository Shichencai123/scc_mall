package cn.net.scc.service.sys;

import java.util.List;

import cn.net.scc.entity.ResponsePageEntity;
import cn.net.scc.mapper.BaseMapper;
import cn.net.scc.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.net.scc.mapper.sys.RoleDeptMapper;
import cn.net.scc.entity.sys.RoleDeptConditionEntity;
import cn.net.scc.entity.sys.RoleDeptEntity;
/**
 * 角色部门关联 服务层
 *
 * @author shicc 该项目是知识星球：java突击队 的内部项目
 * @date 2024-06-06 23:25:17
 */
@Service
public class RoleDeptService extends BaseService< RoleDeptEntity,  RoleDeptConditionEntity> {

	@Autowired
	private RoleDeptMapper roleDeptMapper;

	/**
     * 查询角色部门关联信息
     *
     * @param id 角色部门关联ID
     * @return 角色部门关联信息
     */
	public RoleDeptEntity findById(Long id) {
	    return roleDeptMapper.findById(id);
	}

	/**
     * 根据条件分页查询角色部门关联列表
     *
     * @param roleDeptConditionEntity 角色部门关联信息
     * @return 角色部门关联集合
     */
	public ResponsePageEntity<RoleDeptEntity> searchByPage(RoleDeptConditionEntity roleDeptConditionEntity) {
		int count = roleDeptMapper.searchCount(roleDeptConditionEntity);
		if (count == 0) {
			return ResponsePageEntity.buildEmpty(roleDeptConditionEntity);
		}
		List<RoleDeptEntity> dataList = roleDeptMapper.searchByCondition(roleDeptConditionEntity);
		return ResponsePageEntity.build(roleDeptConditionEntity, count, dataList);
	}

    /**
     * 新增角色部门关联
     *
     * @param roleDeptEntity 角色部门关联信息
     * @return 结果
     */
	public int insert(RoleDeptEntity roleDeptEntity) {
	    return roleDeptMapper.insert(roleDeptEntity);
	}

	/**
     * 修改角色部门关联
     *
     * @param roleDeptEntity 角色部门关联信息
     * @return 结果
     */
	public int update(RoleDeptEntity roleDeptEntity) {
	    return roleDeptMapper.update(roleDeptEntity);
	}

	/**
     * 批量删除角色部门关联对象
     *
     * @param ids 系统ID集合
     * @return 结果
     */
	public int deleteByIds(List<Long> ids) {
		List<RoleDeptEntity> entities = roleDeptMapper.findByIds(ids);
		//AssertUtil.notEmpty(entities, "角色部门关联已被删除");

		RoleDeptEntity entity = new RoleDeptEntity();
		//FillUserUtil.fillUpdateUserInfo(entity);
		return roleDeptMapper.deleteByIds(ids, entity);
	}

	@Override
	protected BaseMapper getBaseMapper() {
		return roleDeptMapper;
	}

}
