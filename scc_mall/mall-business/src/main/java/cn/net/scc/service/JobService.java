package cn.net.scc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.net.scc.mapper.JobMapper;
import cn.net.scc.entity.JobConditionEntity;
import cn.net.scc.entity.JobEntity;
import cn.net.scc.entity.ResponsePageEntity;
import cn.net.susan.util.AssertUtil;
import cn.net.susan.util.FillUserUtil;
import cn.net.susan.mapper.BaseMapper;
/**
 * 岗位 服务层
 *
 * @author shicc 该项目是知识星球：java突击队 的内部项目
 * @date 2024-06-06 23:25:17
 */
@Service
public class JobService extends BaseService< JobEntity,  JobConditionEntity> {

	@Autowired
	private JobMapper jobMapper;

	/**
     * 查询岗位信息
     *
     * @param id 岗位ID
     * @return 岗位信息
     */
	public JobEntity findById(Long id) {
	    return jobMapper.findById(id);
	}

	/**
     * 根据条件分页查询岗位列表
     *
     * @param jobConditionEntity 岗位信息
     * @return 岗位集合
     */
	public ResponsePageEntity<JobEntity> searchByPage(JobConditionEntity jobConditionEntity) {
		int count = jobMapper.searchCount(jobConditionEntity);
		if (count == 0) {
			return ResponsePageEntity.buildEmpty(jobConditionEntity);
		}
		List<JobEntity> dataList = jobMapper.searchByCondition(jobConditionEntity);
		return ResponsePageEntity.build(jobConditionEntity, count, dataList);
	}

    /**
     * 新增岗位
     *
     * @param jobEntity 岗位信息
     * @return 结果
     */
	public int insert(JobEntity jobEntity) {
	    return jobMapper.insert(jobEntity);
	}

	/**
     * 修改岗位
     *
     * @param jobEntity 岗位信息
     * @return 结果
     */
	public int update(JobEntity jobEntity) {
	    return jobMapper.update(jobEntity);
	}

	/**
     * 批量删除岗位对象
     *
     * @param ids 系统ID集合
     * @return 结果
     */
	public int deleteByIds(List<Long> ids) {
		List<JobEntity> entities = jobMapper.findByIds(ids);
		AssertUtil.notEmpty(entities, "岗位已被删除");

		JobEntity entity = new JobEntity();
		FillUserUtil.fillUpdateUserInfo(entity);
		return jobMapper.deleteByIds(ids, entity);
	}

	@Override
	protected BaseMapper getBaseMapper() {
		return jobMapper;
	}

}
