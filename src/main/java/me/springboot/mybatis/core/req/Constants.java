package me.springboot.mybatis.core.req;

import com.alibaba.fastjson.serializer.SerializeConfig;

import java.util.HashMap;
import java.util.Map;

public class Constants {


    public static final int SUCCESS = 200;
    public static final int TOKEN_INVALID = 20001;
    public static final int UNKNOW_ERROR = 1000;
    public static final int SESSION_TIMEOUT = 1001;
    /**
     * 业务异常
     */
    public static final int BUSSINESS_ERROR = 1003;
    /**
     * 缺少参数
     */
    public static final int PARAMETER_MISSING = 1004;

    /**
     * 参数校验错误
     */
    public static final int PARAMETER_ERROR = 1009;

    /**
     * 默认每页条数
     */
    public static final int pageSize = 10;
    public static SerializeConfig config = new SerializeConfig();

    /**
     * 配置文件
     */
    public static Map<String, String> properties = new HashMap<String, String>();

    // REDIS KEY
    public static final String RDS_DEVICE_STATUS = "RDS_DEVICE_STATUS_";

    // 设备信息
    public static final String DEV = "DEV_";
    // 设备的类型()
    public static final String DET = "DET_";
    // 订单信息
    public static final String ORD_T = "ORD_T_";
    // 支付信息
    public static final String PAY = "PAY_";
    // 产品信息
    public static final String PRO = "PRO_";
    // 货道信息
    public static final String CHA = "CHA_";
    // 库存信息
    public static final String INV = "INV_";
}
