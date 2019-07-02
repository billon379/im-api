package fun.billon.im.api.model;

import com.alibaba.fastjson.annotation.JSONField;
import fun.billon.common.model.PaginationModel;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * im群组
 *
 * @author billon
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class ImGroupModel extends PaginationModel {

    /**
     * 口令过期时间(7天)
     */
    public static final int PASSWORD_EXPIRE_TIME = 7;

    /**
     * 群组最大人数(10)
     */
    public static final int MAX_MEMBER = 10;

    /**
     * 群组id,主键
     */
    private Integer id;

    /**
     * 群组名称
     */
    private String name;

    /**
     * 目的地
     */
    private String destination;

    /**
     * 目的地纬度(gps)
     */
    private Double latitude;

    /**
     * 目的地经度(gps)
     */
    private Double longitude;

    /**
     * 口令
     */
    private String password;

    /**
     * 口令过期时间
     */
    private Date passwordExpireTime;

    /**
     * 最大成员数量(默认10)
     */
    private Integer maxMember;

    /**
     * 群成员数
     */
    private Integer memberCount;

    /**
     * 群主id
     */
    private Integer creatorId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否需要群主信息-扩展字段
     */
    @JSONField(serialize = false)
    private boolean requireOwner = false;

    /**
     * 是否需要群成员信息-扩展字段
     */
    @JSONField(serialize = false)
    private boolean requireMember = false;

    /**
     * 群组用户信息-扩展字段
     */
    private ImGroupMemberModel owner;

    /**
     * 群组用户信息-扩展字段
     */
    private List<ImGroupMemberModel> members;

    public ImGroupModel() {
    }

    /**
     * 构造方法
     *
     * @param id 群组id
     */
    public ImGroupModel(Integer id) {
        this.id = id;
    }

}