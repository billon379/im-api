package fun.billon.im.api.constant;

/**
 * im模块状态码
 *
 * @author billon
 * @version 1.0.0
 * @since 1.0.0
 */
public class ImStatusCode {

    /**
     * im模块状态码偏移基地址(140000)
     */
    private static final int IM_STATUS_OFFSET = 140000;

    /**
     * 数据库操作异常(140001)
     */
    public static final int IM_DB_EXCEPTION = IM_STATUS_OFFSET + 1;

    /**
     * 群组不存在(140002)
     */
    public static final int IM_GROUP_NOT_EXISTS = IM_STATUS_OFFSET + 2;

    /**
     * 无权限操作群组(140003)
     */
    public static final int IM_GROUP_OPERATION_FORBIDDEN = IM_STATUS_OFFSET + 3;

    /**
     * 用户不在当前群组(140004)
     */
    public static final int IM_GROUP_MEMBER_NOT_EXISTS = IM_STATUS_OFFSET + 4;

    /**
     * 用户已经加入群组(140005)
     */
    public static final int IM_GROUP_MEMBER_ALREADY_EXISTS = IM_STATUS_OFFSET + 5;

    /**
     * 群组已满(140006)
     */
    public static final int IM_GROUP_MEMBER_REACH_MAX = IM_STATUS_OFFSET + 5;

}