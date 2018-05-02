package top.fanfpy.xiaoyuanxianyu.utils;

import top.fanfpy.xiaoyuanxianyu.VO.Result;

/**
 * @author fanfp
 * @date 2018/4/29
 **/
public class ResultUtils {
    public static Result<Object> success(Object object){
        Result<Object> result = new Result<>();
        result.setCode(0);
        result.setMsg("成功");
        result.setDate(object);
        return result;
    }

    public static Result<Object> succes(){
        return success(null);
    }

    public static Result erro(String msg){
        Result result = new Result();
        result.setCode(1);
        result.setMsg(msg);
        return result;
    }

}
