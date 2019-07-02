package fun.billon.im.api.hystrix;

import fun.billon.common.constant.CommonStatusCode;
import fun.billon.common.model.ResultModel;
import fun.billon.im.api.feign.IImService;
import fun.billon.im.api.model.ImGroupMemberModel;
import fun.billon.im.api.model.ImGroupModel;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * im断路器
 *
 * @author billon
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
public class ImServiceImplHystrix implements IImService {

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
    @Override
    @PostMapping("/group")
    public ResultModel<Integer> createGroup(@RequestHeader(value = "authentication") String authentication,
                                            @RequestHeader(value = "sid") String sid,
                                            @RequestParam Map<String, String> paramMap) {
        ResultModel resultModel = new ResultModel();
        resultModel.setFailed(CommonStatusCode.HYSTRIX_FALLBACK, "IM:HYSTRIX:FALLBACK:POST /group"
                + " -H [authentication:" + authentication + ",sid:" + sid + "]" + "-D [paramMap:" + paramMap + "]");
        return resultModel;
    }

    /**
     * 解散群组
     *
     * @param groupId  群组id 必填
     * @param paramMap paramMap.creatorId 群主id 必填
     * @return 操作结果
     */
    @Override
    @DeleteMapping("/group/{groupId}")
    public ResultModel deleteGroup(@RequestHeader(value = "authentication") String authentication,
                                   @RequestHeader(value = "sid") String sid,
                                   @PathVariable(value = "groupId") int groupId,
                                   @RequestParam Map<String, String> paramMap) {
        ResultModel resultModel = new ResultModel();
        resultModel.setFailed(CommonStatusCode.HYSTRIX_FALLBACK, "IM:HYSTRIX:FALLBACK:DELETE /group/" + groupId
                + " -H [authentication:" + authentication + ",sid:" + sid + "]" + "-D [paramMap:" + paramMap + "]");
        return resultModel;
    }

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
    @Override
    @PutMapping("/group/{groupId}")
    public ResultModel updateGroup(@RequestHeader(value = "authentication") String authentication,
                                   @RequestHeader(value = "sid") String sid,
                                   @PathVariable(value = "groupId") int groupId,
                                   @RequestParam Map<String, String> paramMap) {
        ResultModel resultModel = new ResultModel();
        resultModel.setFailed(CommonStatusCode.HYSTRIX_FALLBACK, "IM:HYSTRIX:FALLBACK:PUT /group/" + groupId
                + " -H [authentication:" + authentication + ",sid:" + sid + "]" + "-D [paramMap:" + paramMap + "]");
        return resultModel;
    }

    /**
     * 更新群组口令
     *
     * @param groupId  群组id 必填
     * @param paramMap paramMap.creatorId 群主id 必填
     * @return 群组信息
     */
    @Override
    @PutMapping("/group/{groupId}/password")
    public ResultModel<ImGroupModel> updateGroupPassword(@RequestHeader(value = "authentication") String authentication,
                                                         @RequestHeader(value = "sid") String sid,
                                                         @PathVariable(value = "groupId") int groupId,
                                                         @RequestParam Map<String, String> paramMap) {
        ResultModel resultModel = new ResultModel();
        resultModel.setFailed(CommonStatusCode.HYSTRIX_FALLBACK, "IM:HYSTRIX:FALLBACK:PUT /group/" + groupId + "/password"
                + " -H [authentication:" + authentication + ",sid:" + sid + "]" + "-D [paramMap:" + paramMap + "]");
        return resultModel;
    }

    /**
     * 移除群组成员
     *
     * @param groupId  群组id 必填
     * @param uid      用户id 必填
     * @param paramMap paramMap.creatorId 群主id 必填
     * @return 操作结果
     */
    @Override
    @DeleteMapping("/group/{groupId}/member/{uid}")
    public ResultModel removeGroupMember(@RequestHeader(value = "authentication") String authentication,
                                         @RequestHeader(value = "sid") String sid,
                                         @PathVariable(value = "groupId") int groupId,
                                         @PathVariable(value = "uid") int uid,
                                         @RequestParam Map<String, String> paramMap) {
        ResultModel resultModel = new ResultModel();
        resultModel.setFailed(CommonStatusCode.HYSTRIX_FALLBACK, "IM:HYSTRIX:FALLBACK:DELETE /group/" + groupId + "/member/" + uid
                + " -H [authentication:" + authentication + ",sid:" + sid + "]" + "-D [paramMap:" + paramMap + "]");
        return resultModel;
    }

    /**
     * 批量移除群组成员
     *
     * @param groupId  群组id 必填
     * @param uids     用户id列表(多个用户使用","分隔) 必填
     * @param paramMap paramMap.creatorId 群主id 必填
     * @return 操作结果
     */
    @Override
    @DeleteMapping("/group/{groupId}/member/uids/{uids}")
    public ResultModel removeGroupMembers(@RequestHeader(value = "authentication") String authentication,
                                          @RequestHeader(value = "sid") String sid,
                                          @PathVariable(value = "groupId") int groupId,
                                          @PathVariable(value = "uids") String uids,
                                          @RequestParam Map<String, String> paramMap) {
        ResultModel resultModel = new ResultModel();
        resultModel.setFailed(CommonStatusCode.HYSTRIX_FALLBACK, "IM:HYSTRIX:FALLBACK:DELETE /group/" + groupId + "/member/uids/" + uids
                + " -H [authentication:" + authentication + ",sid:" + sid + "]" + "-D [paramMap:" + paramMap + "]");
        return resultModel;
    }

    /**
     * 获取群组信息
     *
     * @param groupId  群组id 必填
     * @param paramMap paramMap.currentUid 当前用户uid 选填
     *                 paramMap.requireOwner 是否需要群主信息(默认false) 选填
     *                 paramMap.requireMember 是否需要群成员信息(默认false) 选填
     * @return 操作结果
     */
    @Override
    @GetMapping("/group/{groupId}")
    public ResultModel<ImGroupModel> group(@RequestHeader(value = "authentication") String authentication,
                                           @RequestHeader(value = "sid") String sid,
                                           @PathVariable(value = "groupId") int groupId,
                                           @RequestParam Map<String, String> paramMap) {
        ResultModel resultModel = new ResultModel();
        resultModel.setFailed(CommonStatusCode.HYSTRIX_FALLBACK, "IM:HYSTRIX:FALLBACK:GET /group/" + groupId
                + " -H [authentication:" + authentication + ",sid:" + sid + "]" + "-D [paramMap:" + paramMap + "]");
        return resultModel;
    }

    /**
     * 获取群组列表
     *
     * @param uid      用户id 必填
     * @param paramMap paramMap.pageSize 分页大小(默认20) 选填
     *                 paramMap.pageIndex 页码(默认0) 选填
     *                 paramMap.requireOwner 是否需要群主信息(默认false) 选填
     * @return 操作结果
     */
    @Override
    @GetMapping("/group/uid/{uid}")
    public ResultModel<List<ImGroupModel>> groups(@RequestHeader(value = "authentication") String authentication,
                                                  @RequestHeader(value = "sid") String sid,
                                                  @PathVariable(value = "uid") int uid,
                                                  @RequestParam Map<String, String> paramMap) {
        ResultModel resultModel = new ResultModel();
        resultModel.setFailed(CommonStatusCode.HYSTRIX_FALLBACK, "IM:HYSTRIX:FALLBACK:GET /group/uid/" + uid
                + " -H [authentication:" + authentication + ",sid:" + sid + "]" + "-D [paramMap:" + paramMap + "]");
        return resultModel;
    }

    /**
     * 加入群组
     *
     * @param paramMap paramMap.uid      用户id 必填
     *                 paramMap.groupPassword 群组口令 必填
     * @return 群组id
     */
    @Override
    @PostMapping("/group/member")
    public ResultModel<Integer> joinGroup(@RequestHeader(value = "authentication") String authentication,
                                          @RequestHeader(value = "sid") String sid,
                                          @RequestParam Map<String, String> paramMap) {
        ResultModel resultModel = new ResultModel();
        resultModel.setFailed(CommonStatusCode.HYSTRIX_FALLBACK, "IM:HYSTRIX:FALLBACK:POST /group/member"
                + " -H [authentication:" + authentication + ",sid:" + sid + "]" + "-D [paramMap:" + paramMap + "]");
        return resultModel;
    }

    /**
     * 离开群组
     *
     * @param groupId 群组id 必填
     * @param uid     用户id 必填
     * @return 操作结果
     */
    @Override
    @DeleteMapping("/group/{groupId}/{uid}")
    public ResultModel leaveGroup(@RequestHeader(value = "authentication") String authentication,
                                  @RequestHeader(value = "sid") String sid,
                                  @PathVariable(value = "groupId") int groupId,
                                  @PathVariable(value = "uid") int uid) {
        ResultModel resultModel = new ResultModel();
        resultModel.setFailed(CommonStatusCode.HYSTRIX_FALLBACK, "IM:HYSTRIX:FALLBACK:DELETE /group/" + groupId + "/" + uid
                + " -H [authentication:" + authentication + ",sid:" + sid + "]");
        return resultModel;
    }

    /**
     * 更新群组用户信息
     *
     * @param groupId  群组id 必填
     * @param uid      用户id 必填
     * @param paramMap paramMap.nickname 昵称 选填
     *                 paramMap.avatar 头像 选填
     * @return 操作结果
     */
    @Override
    @PutMapping("/group/{groupId}/{uid}")
    public ResultModel updateGroupMember(@RequestHeader(value = "authentication") String authentication,
                                         @RequestHeader(value = "sid") String sid,
                                         @PathVariable(value = "groupId") int groupId,
                                         @PathVariable(value = "uid") int uid,
                                         @RequestParam Map<String, String> paramMap) {
        ResultModel resultModel = new ResultModel();
        resultModel.setFailed(CommonStatusCode.HYSTRIX_FALLBACK, "IM:HYSTRIX:FALLBACK:PUT /group/" + groupId + "/" + uid
                + " -H [authentication:" + authentication + ",sid:" + sid + "]" + "-D [paramMap:" + paramMap + "]");
        return resultModel;
    }

    /**
     * 获取群组用户信息
     *
     * @param groupId  群组id 必填
     * @param uid      用户id 必填
     * @param paramMap paramMap.currentUid 当前用户uid 选填
     * @return 群组用户信息
     */
    @Override
    @GetMapping("/group/{groupId}/{uid}")
    public ResultModel<ImGroupMemberModel> groupMember(@RequestHeader(value = "authentication") String authentication,
                                                       @RequestHeader(value = "sid") String sid,
                                                       @PathVariable(value = "groupId") int groupId,
                                                       @PathVariable(value = "uid") int uid,
                                                       @RequestParam Map<String, String> paramMap) {
        ResultModel resultModel = new ResultModel();
        resultModel.setFailed(CommonStatusCode.HYSTRIX_FALLBACK, "IM:HYSTRIX:FALLBACK:GET /group/" + groupId + "/" + uid
                + " -H [authentication:" + authentication + ",sid:" + sid + "]" + "-D [paramMap:" + paramMap + "]");
        return resultModel;
    }

}