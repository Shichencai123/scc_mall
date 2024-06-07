package cn.net.scc.mapper.sys;

import cn.net.scc.entity.sys.MenuConditionEntity;
import cn.net.scc.entity.sys.MenuEntity;
import cn.net.scc.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

/**
 * 菜单 mapper
 *
 * @author 苏三 该项目是知识星球：java突击队 的内部项目
 * @date 2024-01-08 14:03:44
 */
public interface MenuMapper extends BaseMapper<MenuEntity, MenuConditionEntity> {
    /**
     * 查询菜单信息
     *
     * @param id 菜单ID
     * @return 菜单信息
     */
    MenuEntity findById(Long id);

    /**
     * 查询菜单信息
     *
     * @param ids 菜单ID
     * @return 菜单信息
     */
    List<MenuEntity> findByIds(List<Long> ids);

    /**
     * 根据角色ID查询菜单列表
     *
     * @param roleIdList 角色ID集合
     * @return 菜单列表
     */
    List<MenuEntity> findMenuByRoleIdList(@Param("roleIdList") Collection<Long> roleIdList);


    /**
     * 添加菜单
     *
     * @param menuEntity 菜单信息
     * @return 结果
     */
    int insert(MenuEntity menuEntity);

    /**
     * 修改菜单
     *
     * @param menuEntity 菜单信息
     * @return 结果
     */
    int update(MenuEntity menuEntity);

    /**
     * 删除菜单
     *
     * @param ids        菜单ID
     * @param menuEntity 菜单实体
     * @return 结果
     */
    int deleteByIds(@Param("ids") List<Long> ids, @Param("menuEntity") MenuEntity menuEntity);

}
