package cn.net.scc.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 请求条件实体
 *
 */
@Data
public class RequestConditionEntity extends RequestPageEntity {


    /**
     * 创建日期范围
     */
    @ApiModelProperty("创建日期范围")
    private List<String> betweenTime;

    /**
     * 创建开始时间
     */
    private String createBeginTime;

    /**
     * 创建结束时间
     */
    private String createEndTime;

}
