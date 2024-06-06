package cn.net.scc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.net.scc.mapper.DictMapper;
import cn.net.scc.entity.DictConditionEntity;
import cn.net.scc.entity.DictEntity;
import cn.net.scc.entity.ResponsePageEntity;
import cn.net.susan.util.AssertUtil;
import cn.net.susan.util.FillUserUtil;
import cn.net.susan.mapper.BaseMapper;
/**
 * 部门 服务层
 *
 * @author shicc 该项目是知识星球：java突击队 的内部项目
 * @date 2024-06-06 23:25:17
 */
@Service
public class DictService extends BaseService< DictEntity,  DictConditionEntity> {

	@Autowired
	private DictMapper dictMapper;

	/**
     * 查询部门信息
     *
     * @param id 部门ID
     * @return 部门信息
     */
	public DictEntity findById(Long id) {
	    return dictMapper.findById(id);
	}

	/**
     * 根据条件分页查询部门列表
     *
     * @param dictConditionEntity 部门信息
     * @return 部门集合
     */
	public ResponsePageEntity<DictEntity> searchByPage(DictConditionEntity dictConditionEntity) {
		int count = dictMapper.searchCount(dictConditionEntity);
		if (count == 0) {
			return ResponsePageEntity.buildEmpty(dictConditionEntity);
		}
		List<DictEntity> dataList = dictMapper.searchByCondition(dictConditionEntity);
		return ResponsePageEntity.build(dictConditionEntity, count, dataList);
	}

    /**
     * 新增部门
     *
     * @param dictEntity 部门信息
     * @return 结果
     */
	public int insert(DictEntity dictEntity) {
	    return dictMapper.insert(dictEntity);
	}

	/**
     * 修改部门
     *
     * @param dictEntity 部门信息
     * @return 结果
     */
	public int update(DictEntity dictEntity) {
	    return dictMapper.update(dictEntity);
	}

	/**
     * 批量删除部门对象
     *
     * @param ids 系统ID集合
     * @return 结果
     */
	public int deleteByIds(List<Long> ids) {
		List<DictEntity> entities = dictMapper.findByIds(ids);
		AssertUtil.notEmpty(entities, "部门已被删除");

		DictEntity entity = new DictEntity();
		FillUserUtil.fillUpdateUserInfo(entity);
		return dictMapper.deleteByIds(ids, entity);
	}

	@Override
	protected BaseMapper getBaseMapper() {
		return dictMapper;
	}

}
