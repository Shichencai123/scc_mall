package cn.net.scc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 角色菜单关联实体 该项目是知识星球：java突击队 的内部项目
 * 
 * @author shicc
 * @date 2024-06-06 23:25:17
 */
@ApiModel("角色菜单关联实体")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleMenuEntity extends BaseEntity {
	

	/**
	 * 角色ID
	 */
	@ApiModelProperty("角色ID")
	private Long roleId;

	/**
	 * 菜单ID
	 */
	@ApiModelProperty("菜单ID")
	private Long menuId;
}
