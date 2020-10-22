package com.llayjun.millet.common.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义的业务状态码
 * API 统一返回状态码
 *
 * @ClassName: ResultCode
 * @Description: 自定义的业务状态码
 * @Author pengke
 * @DateTime 2020年2月8日 下午11:57:46
 */
public enum BusinessExceptionEnum {

    /**
     * =============平台基本异常错误编码：100-1000 ======================
     */
    /**
     * @Fields UNKNOWN_ERROR : 未知错误
     */
    UNKNOWN_ERROR(100, "未知错误"),
    SYSTEM_INNER_ERROR(101, "系统繁忙，请稍后重试"),
    PUBLIC_SIGN_ERROR(102, "签名错误"),
    PUBLIC_NO_LOGIN(103, "亲，需要登录才能访问哦"),
    PUBLIC_PERMISSION_NO_ACCESS(104, "无访问权限"),

    //-begin------------数据异常错误：110-119-开始---------

    /**
     * @Fields PUBLIC_DATA_NOT_FOUND : 数据没有找到
     */
    PUBLIC_DATA_NOT_FOUND(110, "数据没有找到"),
    /**
     * @Fields PUBLIC_DATA_IS_WRONG : 数据有误
     */
    PUBLIC_DATA_IS_WRONG(111, "数据有误"),
    /**
     * @Fields PUBLIC_DATA_EXISTED : 数据已存在
     */
    PUBLIC_DATA_EXISTED(112, "数据已存在"),

    //-end------------数据异常错误：110-119-结束---------

    //-begin------------参数异常错误：120-129------------

    /**
     * @Fields PUBLIC_PARAM_IS_INVALID : 参数无效
     */
    PUBLIC_PARAM_IS_INVALID(120, "参数无效/不合法"),
    /**
     * @Fields PUBLIC_PARAM_IS_BLANK : 参数为空
     */
    PUBLIC_PARAM_IS_BLANK(121, "参数为空"),
    /**
     * @Fields PUBLIC_PARAM_TYPE_BIND_ERROR : 参数类型错误
     */
    PUBLIC_PARAM_TYPE_ERROR(122, "参数类型错误"),
    /**
     * @Fields PUBLIC_PARAM_NOT_COMPLETE : 参数缺失/不全
     */
    PUBLIC_PARAM_NOT_COMPLETE(123, "参数缺失/不全"),

    //-end------------参数异常错误：120-129------------

    //-begin------------接口异常错误：130-139------------

    PUBLIC_INTERFACE_INNER_INVOKE_ERROR(130, "内部系统接口调用异常"),
    PUBLIC_INTERFACE_OUTTER_INVOKE_ERROR(131, "外部系统接口调用异常"),
    PUBLIC_INTERFACE_FORBID_VISIT(132, "该接口禁止访问"),
    PUBLIC_INTERFACE_ADDRESS_INVALID(133, "接口地址无效"),
    PUBLIC_INTERFACE_REQUEST_TIMEOUT(134, "接口请求超时"),
    PUBLIC_INTERFACE_EXCEED_LOAD(135, "接口负载过高"),
    PUBLIC_INTERFACE_NOT_FOUND(136, "接口/页面地址不存在"),

    //-end------------接口异常错误：130-139------------


    //-begin------------幂等 锁 异常错误：140-149------------

    PUBLIC_IDEMPOTENCY_ERROR(140, "幂等异常啊"),
    PUBLIC_LOCK_ERROR(141, "分布式锁异常"),

    //-end------------幂等 锁 异常错误：140-149------------

    /**
     * =============用户服务异常错误编码：1100-1199 ======================
     */

    /**
     * @Fields USER_USERNAME_NOT_NULL : 用户名不能为空
     */
    USER_USERNAME_NOT_NULL(1100, "用户名不能为空"),

    /**
     * @Fields USER_TOKEN_ERROR : 令牌失效或错误
     */
    USER_TOKEN_ERROR(1101, "令牌失效或错误"),

    /**
     * @Fields USER_CODE_NOT_NULL : 验证码不能为空
     */
    USER_CODE_NOT_NULL(1102, "验证码不能为空"),

    /**
     * @Fields USER_PWD_NOT_NULL : 密码不能同时为空
     */
    USER_PWD_NOT_NULL(1103, "密码不能同时为空"),

    /**
     * @Fields USER_LOGIN_PWD_WRONG : 用户名或密码错误
     */
    USER_LOGIN_PWD_WRONG(1104, "用户名或密码错误"),

    /**
     * @Fields USER_LOGIN_CODE_WRONG : 用户名或验证码错误
     */
    USER_LOGIN_CODE_WRONG(1105, "用户名或验证码错误"),

    /**
     * @Fields USER_PHONE_NOT_NULL : 手机号码不能为空
     */
    USER_PHONE_NOT_NULL(1106, "手机号码不能为空"),

    /**
     * @Fields USER_PHONE_GESHI_INVALID : 手机号码格式不对
     */
    USER_PHONE_GESHI_INVALID(1107, "手机号码格式不对"),

    /**
     * @Fields USER_CODE_INVALID : 验证码无效
     */
    USER_CODE_INVALID(1108, "验证码无效"),

    /**
     * @Fields USER_LOGIN_TYPE_INVALID : 登录方式有误
     */
    USER_LOGIN_TYPE_INVALID(1109, "登录方式有误"),

    /**
     * @Fields USER_PHONE_REPEAT : 手机号已存在
     */
    USER_PHONE_REPEAT(1110, "手机号已存在"),

    /**
     * @Fields USER_MERCHANTS_APPLY_FAIL : 商户认证申请失败
     */
    USER_MERCHANTS_APPLY_FAIL(1111, "商户认证申请失败"),

    /**
     * @Fields USER_SNO_REPEAT : 学号不能为空
     */
    USER_SNO_NOT_NULL(1112, "学号不能为空"),

    /**
     * @Fields USER_SNO_REPEAT : 姓名不能为空
     */
    USER_TRUE_NAME_NOT_NULL(1113, "姓名不能为空"),

    /**
     * @Fields USER_SNO_REPEAT : 密码重置失败
     */
    USER_PWD_FAIL(1114, "密码重置失败"),

    /**
     * @Fields USER_REGISTER_FAIL : 注册失败
     */
    USER_REGISTER_FAIL(1115, "注册失败"),

    /**
     * @Fields USER_VERSION_EXIST : 未找到版本信息
     */
    USER_VERSION_EXIST(1116, "未找到版本信息"),

    /**
     * @Fields USER_UPDATE_PERSONAL_DATA_FAIL : 个人资料修改失败
     */
    USER_UPDATE_PERSONAL_DATA_FAIL(1117, "个人资料修改失败"),

    /**
     * @Fields USER_UPDATE_PWD_FAIL : 密码修改失败
     */
    USER_UPDATE_PWD_FAIL(1118, "密码修改失败"),

    /**
     * @Fields USER_PWD_OLD_FAIL : 原密码不正确
     */
    USER_PWD_OLD_FAIL(1119, "原密码不正确"),

    USER_CERTIFICATION_EXIST(1120, "已完成实名认证，请勿重复认证"),

    USER_SIGN_EXIST(1121, "已完成签约，请勿重复签约"),

    USER_CERTIFICATION_NOT_FOUND(1122, "未完成实名认证"),

    USER_SIGN_NOT_FOUND(1123, "未完成签约"),

    USER_ID_CARD_EXIST(1124, "身份证号已存在"),

    USER_PHONE_FAIL(1125, "账户当前绑定的手机号不一致"),

    USER_BIND_PHONE_FAIL(1126, "该手机号已绑定其它账号"),

    /**
     * =============订单服务异常错误编码：1200-1299 ======================
     */
    ORDER_NO_NOT_NULL(1200, "订单号不能为空"),
    ORDER_NO_NOT_OURSELF(1201, "当前订单不是自己的"),
    ORDER_PAY_CHANNEL_NOT_NULL(1202, "支付渠道不能为空"),
    ORDER_ORDER_SOURCE_NOT_NULL(1203, "订单来源不能为空"),
    ORDER_ORDER_STATUS_NOT_PAY_NOT(1204, "订单状态不是未支付订单"),
    PAY_CHANEL_NOT_FOUND(1205, "未找到对应的支付方式"),
    BALANCE_NOT_ENOUGH(1206, "用户余额不足"),
    BALANCE_NOT_FOUND(1207, "用户钱包账户未找到"),
    ORDER_NO_FOUNT(1208, "订单号未找到"),
    ORDER_NO_EXIST(1209, "未找到订单"),
    PAY_WX_ERROR(1210, "微信支付错误"),
    PAY_ALI_ERROR(1211, "支付宝支付错误"),
    ORDER_CREATE_FAIL(1211, "创建订单失败"),

    /**
     * =============商户任务服务异常错误编码：1300-1399 ======================
     */
    MERCHANT_TASK_APPLY_FAIL(1300, "申请任务失败"),
    MERCHANT_TASK_APPLY_ERROR(1301, "请勿重复申请"),
    MERCHANT_TASK_USER_RESUME_FAIL(1302, "简历投递失败"),
    MERCHANT_TASK_START_FAIL(1303, "开始任务失败"),
    MERCHANT_TASK_SUBMIT_FAIL(1304, "提交任务失败"),
    MERCHANT_TASK_PUBLISH_FAIL(1305, "任务发布失败"),
    MERCHANT_TASK_SIGN_EXIST(1306, "商户未签约"),
    MERCHANT_TASK_CURRENT_NUM_FULL(1307, "任务人数已满"),
    MERCHANT_TASK_DATA_NO_EXIST(1308, "商户任务信息不存在"),
    MERCHANT_TASK_APPLY_ME_ERROR(1309, "不可申请自己发布的任务"),
    MERCHANT_TASK_APPLY_STATE_UPDATE_ERROR(1310, "状态已变更，不可同意"),


    /**
     * =============商户服务异常错误编码：1400-1499 ======================
     */
    MERCHANT_SIGN_UP_FAIL(1400, "签约失败"),
    MERCHANT_APPLY_EXIST(1401, "商户认证未完成"),
    MERCHANT_APPLY_EXISTENCE_ERROR(1402, "已存在认证申请记录"),
    MERCHANT_INVOICE_TITLE_NO_EXIST(1403, "未找到发票抬头信息"),
    MERCHANT_INVOICE_ERROR(1404, "开票失败"),
    ;

    private Integer code;

    private String message;

    BusinessExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public static String getMessage(String name) {
        for (BusinessExceptionEnum item : BusinessExceptionEnum.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return name;
    }

    public static Integer getCode(String name) {
        for (BusinessExceptionEnum item : BusinessExceptionEnum.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }

    /**
     * 根据code获取枚举值
     *
     * @param code
     * @return
     */
    public static BusinessExceptionEnum getEumByCode(Integer code) {
        for (BusinessExceptionEnum item : BusinessExceptionEnum.values()) {
            if (item.code.equals(code)) {
                return item;
            }
        }
        return UNKNOWN_ERROR;
    }


    @Override
    public String toString() {
        return this.name();
    }

    //校验重复的code值
    public static void main(String[] args) {
        BusinessExceptionEnum[] ApiResultCodes = BusinessExceptionEnum.values();
        List<Integer> codeList = new ArrayList<Integer>();
        for (BusinessExceptionEnum ApiResultCode : ApiResultCodes) {
            if (codeList.contains(ApiResultCode.code)) {
                System.out.println(ApiResultCode.code);
            } else {
                codeList.add(ApiResultCode.code());
            }
        }
    }

}
