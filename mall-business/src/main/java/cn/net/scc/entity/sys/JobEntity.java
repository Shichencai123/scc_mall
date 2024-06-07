package cn.net.scc.entity.sys;

import cn.net.scc.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 岗位实体 该项目是知识星球：java突击队 的内部项目
 * 
 * @author shicc
 * @date 2024-06-06 23:25:17
 */
@ApiModel("岗位实体")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobEntity extends BaseEntity {
	

	/**
	 * 岗位名称
	 */
	@ApiModelProperty("岗位名称")
	private String name;

	/**
	 * 岗位排序
	 */
	@ApiModelProperty("岗位排序")
	private Integer sort;

	/**
	 * 部门ID
	 */
	@ApiModelProperty("部门ID")
	private Long deptId;

	/**
	 * 有效状态 1:有效 0:无效
	 */
	@ApiModelProperty("有效状态 1:有效 0:无效")
	private Integer validStatus;
}
