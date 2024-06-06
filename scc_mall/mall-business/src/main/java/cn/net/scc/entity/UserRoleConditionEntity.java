package cn.net.scc.entity;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户角色关联查询条件实体
 * 
 * @author shicc 该项目是知识星球：java突击队 的内部项目
 * @date 2024-06-06 23:25:17
 */
@ApiModel("用户角色关联查询条件实体")
@Data
public class UserRoleConditionEntity extends RequestPageEntity {
	

	/**
	 *  ID
     */
	@ApiModelProperty("ID")
	private Long id;

	/**
	 *  用户ID
     */
	@ApiModelProperty("用户ID")
	private Long userId;

	/**
	 *  角色ID
     */
	@ApiModelProperty("角色ID")
	private Long roleId;
}
