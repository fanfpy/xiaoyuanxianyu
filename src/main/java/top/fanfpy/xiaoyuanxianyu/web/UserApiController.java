package top.fanfpy.xiaoyuanxianyu.web;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import me.chanjar.weixin.common.error.WxErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import top.fanfpy.xiaoyuanxianyu.vo.ResultVO;
import top.fanfpy.xiaoyuanxianyu.entity.User;
import top.fanfpy.xiaoyuanxianyu.service.UserService;
import top.fanfpy.xiaoyuanxianyu.utils.ResultUtils;

import javax.validation.Valid;

/**
 * @author fanfp
 * @date 2018/04/18
 * */
@RequestMapping(value = "/api/user")
@RestController
public class UserApiController {

    private Logger logger = LoggerFactory.getLogger(UserApiController.class);
    @Autowired
    UserService userService;

    @Autowired
    private WxMaService wxMaService;

    /**
     *通过id更新用户
     * 打印错误
     * */
    @PutMapping(value = "/{id}")
    public ResultVO upateUser(@Valid User user, BindingResult bindingResult, @PathVariable("id") Integer id){
        if (bindingResult.hasErrors()){
            return ResultUtils.erro(bindingResult.getFieldError().getDefaultMessage());
        }
        user.setId(id);
        return ResultUtils.success(userService.save(user));
    }


    @GetMapping(value = "/code")
    public ResultVO userInfo(@Param("code") String code,
                         @Param("encryptedData") String encryptedData,
                         @Param("iv") String iv) throws WxErrorException {
        logger.info("code = {} encryptedData ={} iv = {}",code,encryptedData,iv);
        WxMaJscode2SessionResult wxMaJscode2SessionResult = wxMaService.getUserService().getSessionInfo(code);

        WxMaUserInfo userInfo = wxMaService.getUserService().getUserInfo(wxMaJscode2SessionResult.getSessionKey(),encryptedData,iv);
        if(userService.findByOpenid(userInfo.getOpenId())==null){
            //新用户
            User user = new User();
            user.setOpenid(userInfo.getOpenId());
            user.setUserImg(userInfo.getAvatarUrl());
            user.setUsername(userInfo.getNickName());
            user.setGoodsNum(0);

            return ResultUtils.success(userService.save(user));
        }else {
            //老用户
            return ResultUtils.success(userService.findByOpenid(userInfo.getOpenId()));
        }
    }
}
