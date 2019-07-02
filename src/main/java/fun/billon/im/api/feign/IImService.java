package fun.billon.im.api.feign;

import fun.billon.common.model.ResultModel;
import fun.billon.im.api.hystrix.ImServiceImplHystrix;
import fun.billon.im.api.model.ImGroupMemberModel;
import fun.billon.im.api.model.ImGroupModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * im模块客户端
 *
 * @author billon
 * @version 1.0.0
 * @since 1.0.0
 */
@FeignClient(value = "im", fallback = ImServiceImplHystrix.class)
public interface IImService {

    /**
     * 创建群组
     *
     * @param paramMap paramMap.name 群组名称 必填
     *                 paramMap.creatorId 群主id 必填
     *                 paramMap.destination 目的地 选填
     *                 paramMap.latitude 目的地纬度(gps) 选填
     *                 paramMap.longitude 目的地经度(gps) 选填
     *                 paramMap.nickname 群主昵称 选填
     * @return 操作结果
     */
    @PostMapping("/group")
    ResultModel<Integer> createGroup(@RequestHeader(value = "authentication") String authentication,
                                     @RequestHeader(value = "sid") String sid,
                                     @RequestParam Map<String, String> paramMap);

    /**
     * 解散群组
     *
     * @param groupId  群组id 必填
     * @param paramMap paramMap.creatorId 群主id 必填
     * @return 操作结果
     */
    @DeleteMapping("/group/{groupId}")
    ResultModel deleteGroup(@RequestHeader(value = "authentication") String authentication,
                            @RequestHeader(value = "sid") String sid,
                            @PathVariable(value = "groupId") int groupId,
                            @RequestParam Map<String, String> paramMap);

    /**
     * 更新群组
     *
     * @param groupId  群组id 必填
     * @param paramMap paramMap.creatorId 群主id 必填
     *                 paramMap.name 群组名称 选填
     *                 paramMap.destination 目的地 选填
     *                 paramMap.latitude 目的地纬度(gps) 选填
     *                 paramMap.longitude 目的地经度(gps) 选填
     *                 paramMap.nickname 群主昵称 选填
     * @return 操作结果
     */
    @PutMapping("/group/{groupId}")
    ResultModel updateGroup(@RequestHeader(value = "authentication") String authentication,
                            @RequestHeader(value = "sid") String sid,
                            @PathVariable(value = "groupId") int groupId,
                            @RequestParam Map<String, String> paramMap);

    /**
     * 更新群组口令
     *
     * @param groupId  群组id 必填
     * @param paramMap paramMap.creatorId 群主id 必填
     * @return 群组信息
     */
    @PutMapping("/group/{groupId}/password")
    ResultModel<ImGroupModel> updateGroupPassword(@RequestHeader(value = "authentication") String authentication,
                                                  @RequestHeader(value = "sid") String sid,
                                                  @PathVariable(value = "groupId") int groupId,
                                                  @RequestParam Map<String, String> paramMap);

    /**
     * 移除群组成员
     *
     * @param groupId  群组id 必填
     * @param uid      用户id 必填
     * @param paramMap paramMap.creatorId 群主id 必填
     * @return 操作结果
     */
    @DeleteMapping("/group/{groupId}/member/{uid}")
    ResultModel removeGroupMember(@RequestHeader(value = "authentication") String authentication,
                                  @RequestHeader(value = "sid") String sid,
                                  @PathVariable(value = "groupId") int groupId,
                                  @PathVariable(value = "uid") int uid,
                                  @RequestParam Map<String, String> paramMap);

    /**
     * 批量移除群组成员
     *
     * @param groupId  群组id 必填
     * @param uids     用户id列表(多个用户使用","分隔) 必填
     * @param paramMap paramMap.creatorId 群主id 必填
     * @return 操作结果
     */
    @DeleteMapping("/group/{groupId}/member/uids/{uids}")
    ResultModel removeGroupMembers(@RequestHeader(value = "authentication") String authentication,
                                   @RequestHeader(value = "sid") String sid,
                                   @PathVariable(value = "groupId") int groupId,
                                   @PathVariable(value = "uids") String uids,
                                   @RequestParam Map<String, String> paramMap);

    /**
     * 获取群组信息
     *
     * @param groupId  群组id 必填
     * @param paramMap paramMap.currentUid 当前用户uid 选填
     *                 paramMap.requireOwner 是否需要群主信息(默认false) 选填
     *                 paramMap.requireMember 是否需要群成员信息(默认false) 选填
     * @return 操作结果
     */
    @GetMapping("/group/{groupId}")
    ResultModel<ImGroupModel> group(@RequestHeader(value = "authentication") String authentication,
                                    @RequestHeader(value = "sid") String sid,
                                    @PathVariable(value = "groupId") int groupId,
                                    @RequestParam Map<String, String> paramMap);

    /**
     * 获取群组列表
     *
     * @param uid      用户id 必填
     * @param paramMap paramMap.pageSize 分页大小(默认20) 选填
     *                 paramMap.pageIndex 页码(默认0) 选填
     *                 paramMap.requireOwner 是否需要群主信息(默认false) 选填
     * @return 操作结果
     */
    @GetMapping("/group/uid/{uid}")
    ResultModel<List<ImGroupModel>> groups(@RequestHeader(value = "authentication") String authentication,
                                           @RequestHeader(value = "sid") String sid,
                                           @PathVariable(value = "uid") int uid,
                                           @RequestParam Map<String, String> paramMap);

    /**
     * 加入群组
     *
     * @param paramMap paramMap.uid      用户id 必填
     *                 paramMap.groupPassword 群组口令 必填
     * @return 群组id
     */
    @PostMapping("/group/member")
    ResultModel<Integer> joinGroup(@RequestHeader(value = "authentication") String authentication,
                                   @RequestHeader(value = "sid") String sid,
                                   @RequestParam Map<String, String> paramMap);

    /**
     * 离开群组
     *
     * @param groupId 群组id 必填
     * @param uid     用户id 必填
     * @return 操作结果
     */
    @DeleteMapping("/group/{groupId}/{uid}")
    ResultModel leaveGroup(@RequestHeader(value = "authentication") String authentication,
                           @RequestHeader(value = "sid") String sid,
                           @PathVariable(value = "groupId") int groupId,
                           @PathVariable(value = "uid") int uid);

    /**
     * 更新群组用户信息
     *
     * @param groupId  群组id 必填
     * @param uid      用户id 必填
     * @param paramMap paramMap.nickname 昵称 选填
     *                 paramMap.avatar 头像 选填
     * @return 操作结果
     */
    @PutMapping("/group/{groupId}/{uid}")
    ResultModel updateGroupMember(@RequestHeader(value = "authentication") String authentication,
                                  @RequestHeader(value = "sid") String sid,
                                  @PathVariable(value = "groupId") int groupId,
                                  @PathVariable(value = "uid") int uid,
                                  @RequestParam Map<String, String> paramMap);

    /**
     * 获取群组用户信息
     *
     * @param groupId  群组id 必填
     * @param uid      用户id 必填
     * @param paramMap paramMap.currentUid 当前用户uid 选填
     * @return 群组用户信息
     */
    @GetMapping("/group/{groupId}/{uid}")
    ResultModel<ImGroupMemberModel> groupMember(@RequestHeader(value = "authentication") String authentication,
                                                @RequestHeader(value = "sid") String sid,
                                                @PathVariable(value = "groupId") int groupId,
                                                @PathVariable(value = "uid") int uid,
                                                @RequestParam Map<String, String> paramMap);

}