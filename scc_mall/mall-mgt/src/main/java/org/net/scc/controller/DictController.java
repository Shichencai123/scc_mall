package org.net.scc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.net.susan.entity.ResponsePageEntity;
import cn.net.scc.entity.DictConditionEntity;
import cn.net.scc.entity.DictEntity;
import cn.net.scc.service.DictService;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;

/**
 * 部门 接口层
 *
 * @author shicc 该项目是知识星球：java突击队 的内部项目
 * @date 2024-06-06 23:25:17
 */
@Api(tags = "部门操作", description = "部门接口")
@RestController
@RequestMapping("/v1/dict")
public class DictController {

	@Autowired
	private DictService dictService;

	/**
	 * 通过id查询部门信息
	 *
	 * @param id 系统ID
	 * @return 部门信息
	 */
	@ApiOperation(notes = "通过id查询部门信息", value = "通过id查询部门信息")
	@GetMapping("/findById")
	public DictEntity findById(Long id) {
		return dictService.findById(id);
	}

	/**
    * 根据条件查询部门列表
    *
    * @param dictConditionEntity 条件
    * @return 部门列表
    */
	@ApiOperation(notes = "根据条件查询部门列表", value = "根据条件查询部门列表")
	@PostMapping("/searchByPage")
	public ResponsePageEntity<DictEntity> searchByPage(@RequestBody DictConditionEntity dictConditionEntity) {
		return dictService.searchByPage(dictConditionEntity);
	}


	/**
     * 添加部门
     *
     * @param dictEntity 部门实体
     * @return 影响行数
     */
	@ApiOperation(notes = "添加部门", value = "添加部门")
	@PostMapping("/insert")
	public int insert(@RequestBody DictEntity dictEntity) {
		return dictService.insert(dictEntity);
	}

	/**
     * 修改部门
     *
     * @param dictEntity 部门实体
     * @return 影响行数
     */
	@ApiOperation(notes = "修改部门", value = "修改部门")
	@PostMapping("/update")
	public int update(@RequestBody DictEntity dictEntity) {
		return dictService.update(dictEntity);
	}

	/**
     * 批量删除部门
     *
     * @param ids 部门ID集合
     * @return 影响行数
     */
	@ApiOperation(notes = "批量删除部门", value = "批量删除部门")
	@PostMapping("/deleteByIds")
	public int deleteByIds(@RequestBody @NotNull List<Long> ids) {
		return dictService.deleteByIds(ids);
	}
}