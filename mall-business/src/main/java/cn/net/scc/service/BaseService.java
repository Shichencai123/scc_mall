package cn.net.scc.service;

import cn.net.scc.mapper.BaseMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * 公共service
 *
 */
@Slf4j
public abstract class BaseService<K, V> {

    /**
     * 获取BaseMapper
     *
     * @return BaseMapper
     */
    protected abstract BaseMapper getBaseMapper();

}
