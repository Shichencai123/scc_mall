package cn.net.scc.mapper.sys;

import cn.net.scc.entity.sys.UserAvatarConditionEntity;
import cn.net.scc.entity.sys.UserAvatarEntity;

import java.util.List;
import cn.net.scc.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户头像 mapper
 *
 */
public interface UserAvatarMapper extends BaseMapper<UserAvatarEntity, UserAvatarConditionEntity> {
	/**
     * 查询用户头像信息
     *
     * @param id 用户头像ID
     * @return 用户头像信息
     */
	UserAvatarEntity findById(Long id);

	/**
     * 添加用户头像
     *
     * @param userAvatarEntity 用户头像信息
     * @return 结果
     */
	int insert(UserAvatarEntity userAvatarEntity);

	/**
     * 修改用户头像
     *
     * @param userAvatarEntity 用户头像信息
     * @return 结果
     */
	int update(UserAvatarEntity userAvatarEntity);

	/**
     * 批量删除用户头像
     *
     * @param ids id集合
     * @param entity 用户头像实体
     * @return 结果
     */
	int deleteByIds(@Param("ids") List<Long> ids, @Param("entity") UserAvatarEntity entity);

	/**
     * 批量查询用户头像信息
     *
     * @param ids ID集合
     * @return 部门信息
    */
	List<UserAvatarEntity> findByIds(List<Long> ids);
}
