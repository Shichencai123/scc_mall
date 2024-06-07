package cn.net.scc.entity.sys;

import cn.net.scc.entity.RequestPageEntity;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 角色部门关联查询条件实体
 * 
 * @author shicc 该项目是知识星球：java突击队 的内部项目
 * @date 2024-06-06 23:25:17
 */
@ApiModel("角色部门关联查询条件实体")
@Data
public class RoleDeptConditionEntity extends RequestPageEntity {
	

	/**
	 *  ID
     */
	@ApiModelProperty("ID")
	private Long id;

	/**
	 *  
     */
	@ApiModelProperty("")
	private Long roleId;

	/**
	 *  
     */
	@ApiModelProperty("")
	private Long deptId;
}
