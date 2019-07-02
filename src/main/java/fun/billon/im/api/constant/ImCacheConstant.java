package fun.billon.im.api.constant;

/**
 * 缓存相关常量配置
 *
 * @author billon
 * @version 1.0.0
 * @since 1.0.0
 */
public class ImCacheConstant {

    /**
     * 群组相关缓存配置
     */
    /**
     * 群组缓存配置,namespace
     */
    public static final String CACHE_NAMESPACE_IM_GROUP_MODEL = "fun.billon.im.api.model.ImGroupModel";
    /**
     * 缓存键值id
     */
    public static final String CACHE_KEY_IM_GROUP_MODEL_ID = "${imGroupModel.id}";

    /**
     * 群成员相关缓存配置
     */
    /**
     * 群组缓存配置,namespace
     */
    public static final String CACHE_NAMESPACE_IM_GROUP_MEMBER_MODEL = "fun.billon.im.api.model.ImGroupMemberModel";
    /**
     * 缓存键值id
     */
    public static final String CACHE_KEY_IM_GROUP_MEMBER_MODEL_ID = "${imGroupMemberModel.id}";

}