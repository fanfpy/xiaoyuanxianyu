package top.fanfpy.xiaoyuanxianyu.utils;

import top.fanfpy.xiaoyuanxianyu.VO.ResultVO;

/**
 * @author fanfp
 * @date 2018/4/29
 **/
public class ResultUtils {
    public static ResultVO<Object> success(Object object){
        ResultVO<Object> result = new ResultVO<>();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static ResultVO<Object> succes(){
        return success(null);
    }

    public static ResultVO erro(String msg){
        ResultVO result = new ResultVO();
        result.setCode(1);
        result.setMsg(msg);
        return result;
    }

}
