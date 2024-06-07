package cn.net.scc.entity.sys;

import cn.net.scc.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户头像实体 该项目是知识星球：java突击队 的内部项目
 * 
 * @author shicc
 * @date 2024-06-06 23:25:17
 */
@ApiModel("用户头像实体")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserAvatarEntity extends BaseEntity {
	

	/**
	 * 文件名
	 */
	@ApiModelProperty("文件名")
	private String fileName;

	/**
	 * 路径
	 */
	@ApiModelProperty("路径")
	private String path;

	/**
	 * 大小
	 */
	@ApiModelProperty("大小")
	private String fileSize;
}
