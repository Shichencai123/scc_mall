package cn.net.scc.service.sys;

import java.util.List;

import cn.net.scc.entity.ResponsePageEntity;
import cn.net.scc.mapper.BaseMapper;
import cn.net.scc.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.net.scc.mapper.sys.DeptMapper;
import cn.net.scc.entity.sys.DeptConditionEntity;
import cn.net.scc.entity.sys.DeptEntity;

/**
 * 部门 服务层
 *
 */
@Service
public class DeptService extends BaseService<DeptEntity, DeptConditionEntity> {

	@Autowired
	private DeptMapper deptMapper;

	/**
     * 查询部门信息
     *
     * @param id 部门ID
     * @return 部门信息
     */
	public DeptEntity findById(Long id) {
	    return deptMapper.findById(id);
	}

	/**
     * 根据条件分页查询部门列表
     *
     * @param deptConditionEntity 部门信息
     * @return 部门集合
     */
	public ResponsePageEntity<DeptEntity> searchByPage(DeptConditionEntity deptConditionEntity) {
		int count = deptMapper.searchCount(deptConditionEntity);
		if (count == 0) {
			return ResponsePageEntity.buildEmpty(deptConditionEntity);
		}
		List<DeptEntity> dataList = deptMapper.searchByCondition(deptConditionEntity);
		return ResponsePageEntity.build(deptConditionEntity, count, dataList);
	}

    /**
     * 新增部门
     *
     * @param deptEntity 部门信息
     * @return 结果
     */
	public int insert(DeptEntity deptEntity) {
	    return deptMapper.insert(deptEntity);
	}

	/**
     * 修改部门
     *
     * @param deptEntity 部门信息
     * @return 结果
     */
	public int update(DeptEntity deptEntity) {
	    return deptMapper.update(deptEntity);
	}

	/**
     * 批量删除部门对象
     *
     * @param ids 系统ID集合
     * @return 结果
     */
	public int deleteByIds(List<Long> ids) {
		// fixme
		List<DeptEntity> entities = deptMapper.findByIds(ids);
		return deptMapper.deleteByIds(ids, entities.get(0));
	}

	@Override
	protected BaseMapper getBaseMapper() {
		return deptMapper;
	}

}
