package fun.billon.im.api.model;

import fun.billon.common.model.PaginationModel;
import lombok.Data;

import java.util.Date;

/**
 * im群组成员
 *
 * @author billon
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class ImGroupMemberModel extends PaginationModel {

    /**
     * 群成员
     */
    public static final int MEMBER = 0;

    /**
     * 群主
     */
    public static final int OWNER = 1;

    /**
     * id,主键
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 群组id
     */
    private Integer groupId;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 是否群主(0:成员;1:群主)
     */
    private Integer isOwner;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    public ImGroupMemberModel() {
    }

    public ImGroupMemberModel(Integer groupId) {
        this.groupId = groupId;
    }

    /**
     * 构造方法
     *
     * @param uid      用户id
     * @param groupId  群组id
     * @param nickname 昵称
     * @param avatar   头像
     * @param isOwner  是否群主(0:成员;1:群主)
     */
    public ImGroupMemberModel(Integer uid, Integer groupId, String nickname, String avatar, Integer isOwner) {
        this.uid = uid;
        this.groupId = groupId;
        this.nickname = nickname;
        this.avatar = avatar;
        this.isOwner = isOwner;
    }

}