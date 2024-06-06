package org.net.scc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.net.susan.entity.ResponsePageEntity;
import cn.net.scc.entity.RoleDeptConditionEntity;
import cn.net.scc.entity.RoleDeptEntity;
import cn.net.scc.service.RoleDeptService;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;

/**
 * 角色部门关联 接口层
 *
 * @author shicc 该项目是知识星球：java突击队 的内部项目
 * @date 2024-06-06 23:25:17
 */
@Api(tags = "角色部门关联操作", description = "角色部门关联接口")
@RestController
@RequestMapping("/v1/roleDept")
public class RoleDeptController {

	@Autowired
	private RoleDeptService roleDeptService;

	/**
	 * 通过id查询角色部门关联信息
	 *
	 * @param id 系统ID
	 * @return 角色部门关联信息
	 */
	@ApiOperation(notes = "通过id查询角色部门关联信息", value = "通过id查询角色部门关联信息")
	@GetMapping("/findById")
	public RoleDeptEntity findById(Long id) {
		return roleDeptService.findById(id);
	}

	/**
    * 根据条件查询角色部门关联列表
    *
    * @param roleDeptConditionEntity 条件
    * @return 角色部门关联列表
    */
	@ApiOperation(notes = "根据条件查询角色部门关联列表", value = "根据条件查询角色部门关联列表")
	@PostMapping("/searchByPage")
	public ResponsePageEntity<RoleDeptEntity> searchByPage(@RequestBody RoleDeptConditionEntity roleDeptConditionEntity) {
		return roleDeptService.searchByPage(roleDeptConditionEntity);
	}


	/**
     * 添加角色部门关联
     *
     * @param roleDeptEntity 角色部门关联实体
     * @return 影响行数
     */
	@ApiOperation(notes = "添加角色部门关联", value = "添加角色部门关联")
	@PostMapping("/insert")
	public int insert(@RequestBody RoleDeptEntity roleDeptEntity) {
		return roleDeptService.insert(roleDeptEntity);
	}

	/**
     * 修改角色部门关联
     *
     * @param roleDeptEntity 角色部门关联实体
     * @return 影响行数
     */
	@ApiOperation(notes = "修改角色部门关联", value = "修改角色部门关联")
	@PostMapping("/update")
	public int update(@RequestBody RoleDeptEntity roleDeptEntity) {
		return roleDeptService.update(roleDeptEntity);
	}

	/**
     * 批量删除角色部门关联
     *
     * @param ids 角色部门关联ID集合
     * @return 影响行数
     */
	@ApiOperation(notes = "批量删除角色部门关联", value = "批量删除角色部门关联")
	@PostMapping("/deleteByIds")
	public int deleteByIds(@RequestBody @NotNull List<Long> ids) {
		return roleDeptService.deleteByIds(ids);
	}
}
