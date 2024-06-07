package cn.net.scc.service.sys;

import cn.hutool.core.bean.BeanUtil;
import cn.net.scc.entity.ResponsePageEntity;
import cn.net.scc.entity.sys.MenuConditionEntity;
import cn.net.scc.entity.sys.MenuEntity;
import cn.net.scc.mapper.BaseMapper;
import cn.net.scc.mapper.sys.MenuMapper;
import cn.net.scc.mapper.sys.RoleMenuMapper;
import cn.net.scc.service.BaseService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.compress.utils.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 菜单 服务层
 *
 */
@Service
public class MenuService extends BaseService<MenuEntity, MenuConditionEntity> {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;

    /**
     * 查询菜单信息
     *
     * @param id 菜单ID
     * @return 菜单信息
     */
    public MenuEntity findById(Long id) {
        return menuMapper.findById(id);
    }

    /**
     * 根据条件分页查询菜单列表
     *
     * @param menuConditionEntity 菜单信息
     * @return 菜单集合
     */
   /* public ResponsePageEntity<MenuEntity> searchByPage(MenuConditionEntity menuConditionEntity) {
        BetweenTimeUtil.parseTime(menuConditionEntity);
        int count = menuMapper.searchCount(menuConditionEntity);
        if (count == 0) {
            return ResponsePageEntity.buildEmpty(menuConditionEntity);
        }
        List<MenuEntity> dataList = menuMapper.searchByCondition(menuConditionEntity);
        return ResponsePageEntity.build(menuConditionEntity, count, dataList);
    }*/

    /**
     * 获取菜单树
     *
     * @return 菜单树
     */
   /* public List<MenuTreeDTO> getMenuTree() {
        MenuConditionEntity menuConditionEntity = new MenuConditionEntity();
        menuConditionEntity.setPageSize(0);
        menuConditionEntity.setPid(0L);
        List<MenuEntity> menuEntities = menuMapper.searchByCondition(menuConditionEntity);
        if (CollectionUtils.isEmpty(menuEntities)) {
            return Collections.emptyList();
        }

        List<MenuTreeDTO> result = Lists.newArrayList();
        for (MenuEntity menuEntity : menuEntities) {
            MenuTreeDTO menuTreeDTO = buildMenuTreeDTO(menuEntity);
            menuTreeDTO.setAlwaysShow(true);
            result.add(menuTreeDTO);
            buildChildren(menuEntity, menuTreeDTO);
        }
        return result;
    }
*/

   /* private void buildChildren(MenuEntity menuEntity, MenuTreeDTO menuTreeDTO) {
        MenuConditionEntity menuConditionEntity = new MenuConditionEntity();
        menuConditionEntity.setPageSize(0);
        menuConditionEntity.setPid(menuEntity.getId());
        List<MenuEntity> childrenEntities = menuMapper.searchByCondition(menuConditionEntity);
        if (CollectionUtils.isNotEmpty(childrenEntities)) {
            for (MenuEntity childrenEntity : childrenEntities) {
                MenuTreeDTO childrenMenuTreeDTO = buildMenuTreeDTO(childrenEntity);
                menuTreeDTO.addChildren(childrenMenuTreeDTO);
                buildChildren(childrenEntity, childrenMenuTreeDTO);
            }
        }
    }*/


   /* private MenuTreeDTO buildMenuTreeDTO(MenuEntity menuEntity) {
        MenuTreeDTO menuTreeDTO = BeanUtil.copyProperties(menuEntity, MenuTreeDTO.class);
        menuTreeDTO.setAlwaysShow(false);
        MetaDTO metaDTO = new MetaDTO();
        menuTreeDTO.setMeta(metaDTO);
        metaDTO.setIcon(menuTreeDTO.getIcon());
        metaDTO.setTitle(menuTreeDTO.getName());
        metaDTO.setNoCache(true);
        return menuTreeDTO;
    }*/


    /**
     * 保存菜单
     *
     * @param menuEntity 菜单信息
     */
    public void save(MenuEntity menuEntity) {
        if (Objects.isNull(menuEntity.getId())) {
            //FillUserUtil.fillCreateUserInfo(menuEntity);
            menuMapper.insert(menuEntity);
        } else {
            //FillUserUtil.fillUpdateUserInfo(menuEntity);
            menuMapper.update(menuEntity);
        }
    }

    /**
     * 新增菜单
     *
     * @param menuEntity 菜单信息
     * @return 结果
     */
    public int insert(MenuEntity menuEntity) {
        //FillUserUtil.fillCreateUserInfo(menuEntity);
        return menuMapper.insert(menuEntity);
    }

    /**
     * 修改菜单
     *
     * @param menuEntity 菜单信息
     * @return 结果
     */
    public int update(MenuEntity menuEntity) {
        //AssertUtil.notNull(menuEntity.getId(), "菜单ID不能为空");
        //FillUserUtil.fillUpdateUserInfo(menuEntity);
        return menuMapper.update(menuEntity);
    }

    /**
     * 删除菜单对象
     *
     * @param ids 系统ID集合
     * @return 结果
     */
    public int deleteByIds(List<Long> ids) {
        List<MenuEntity> menuEntities = menuMapper.findByIds(ids);
        //AssertUtil.notEmpty(menuEntities, "菜单已被删除");

        MenuEntity menuEntity = new MenuEntity();
        //FillUserUtil.fillUpdateUserInfo(menuEntity);
        return menuMapper.deleteByIds(ids, menuEntity);

    }

    /**
     * 导出excel
     *
     * @param response            响应
     * @param menuConditionEntity 条件
     * @throws IOException 异常
     */
    public void export(HttpServletResponse response, MenuConditionEntity menuConditionEntity) throws IOException {
        //BetweenTimeUtil.parseTime(menuConditionEntity);
        menuConditionEntity.setPageSize(0);
        List<MenuEntity> menuEntities = menuMapper.searchByCondition(menuConditionEntity);
        //ExcelUtil.exportExcel("菜单数据", MenuEntity.class, menuEntities, response);
    }

    @Override
    protected BaseMapper getBaseMapper() {
        return menuMapper;
    }
}
