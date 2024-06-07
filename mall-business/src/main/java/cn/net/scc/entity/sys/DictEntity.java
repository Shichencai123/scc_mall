package cn.net.scc.entity.sys;

import cn.net.scc.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 部门实体 该项目是知识星球：java突击队 的内部项目
 * 
 * @author shicc
 * @date 2024-06-06 23:25:17
 */
@ApiModel("部门实体")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DictEntity extends BaseEntity {
	

	/**
	 * 父字段ID
	 */
	@ApiModelProperty("父字段ID")
	private Long parentId;

	/**
	 * 字典名称
	 */
	@ApiModelProperty("字典名称")
	private String dictName;

	/**
	 * 字典描述
	 */
	@ApiModelProperty("字典描述")
	private String dictDescription;
}
