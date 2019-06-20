package com.yaoyang.recruitment.enumeration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 系统响应码
 *
 * @author zhangsl
 * @date 2018-01-24
 */
public enum ResponseCode {

    //0 通用
    QUERY_SUCCESS("0001", "查询成功"),
    OPT_SUCCESS("0002", "操作成功"),

    QUERY_FAIL("0003", "查询失败"),
    OPT_FAIL("0004", "操作失败"),
    UPLOAD_FAIL("0005", "上传失败"),

    TOKEN_NULL("0006", "令牌为空"),
    TOKEN_ERROR("0007", "令牌错误"),

    NOT_LOGIN("0008", "请先登录"),
    LOGIN_EXPIRE("0009", "请重新登录"),
    REQUEST_ILLEGAL("0010", "非法请求"),

    TRANSFER_FAILED("0011", "转账失败"),
    MOBILE_ILLEGAL("0012", "请输入正确的手机号码"),
    SEND_FAIL("0013", "发送失败"),
    LOW_VERSION("0014", "请升级APP"),


    //1 已存在
    DEVICE_USER_EXIST("1001", "设备已绑定"),
    ROLE_EXIST("1003", "角色已存在"),
    ADMIN_EXIST("1004", "管理员已存在"),
    PERMISSION_EXIST("1005", "权限名已存在"),
    MOBILE_EXIST("1006", "手机号码已存在"),
    SITE_CONFIG_EXIST("1007", "配置已存在"),
    FIELD_EXIST("1008", "行业已存在"),

    //2 不存在
    NO_ADMIN("2001", "管理员不存在"),
    NO_ROLE("2002", "角色不存在"),
    NO_PERMISSION("2003", "权限不存在"),
    NO_PROVINCE("2004", "省份不存在"),
    NO_CITY("2005", "城市不存在"),
    NO_DISTRICT("2006", "县区不存在"),
    NO_MOBILE("2007", "请输入手机号码"),
    NO_BALANCE("2008", "余额不足"),
    NO_BANKCARD("2009", "没有银行卡"),
    NO_USER("2010", "用户不存在"),
    NO_DEVICE_USER("2011", "设备未绑定"),
    NO_SITE_CONFIG("2012", "配置不存在"),
    NO_AGENT("2013", "项目方不存在"),
    NO_FIELD("2014", "业态不存在"),
    NO_DEVICE("2015", "请输入正确设备号"),
    NO_ORDER("2016", "订单不存在"),
    NO_PROXY("2017", "推荐人必须为代理商或商家"),
    NO_GUEST("2018", "该用户不是普通用户"),
    NO_PROXY_APPLY("2019", "申请单不存在"),

    //3 无法操作
    PERMISSION_DENY("3001", "权限不足"),
    UNABLE_LOGIN("3002", "无法登录"),
    UNABLE_CREATE("3003", "无法创建"),
    UNABLE_EDIT("3004", "无法修改"),
    UNABLE_DELETE("3005", "无法删除"),
    USER_DISABLE("3006", "用户被禁用"),
    FILE_TOO_LONG("3007", "素材大小超过限制"),
    PAYOUT_DENY("3008", "每月仅可提现一次"),


    //4 参数
    PARAM_ILLEGAL("4001", "非法参数"),
    LOGIN_NAME_NULL("4002", "登录名为空"),
    PASSWORD_NULL("4003", "请输入登录密码"),
    PASSWORD_ILLEGAL("4005", "密码长度不能少于6位，必须是数字加字母"),
    WALLET_REPEAT_PASSWORD_ERROR("4006", "请输入重复密码"),
    REPEAT_PASSWORD_NO_EQUAL("4007", "两次输入密码不一致，请重新输入"),
    NAME_NULL("4009", "请输入您的手机号"),
    NO_REGISTER("4010", "此登录名没有注册，请重新输入"),
    ACCOUNT_ABNORMAL("4011", "您的账号出现异常，暂时不能登录，稍后再试。"),
    PASSWORD_ERROR("4012", "密码错误，请重新输入"),
    UNBIND_MERCHANT("4013", "未绑定商家"),
    MOBILE_NULL("4014", "请输入手机号码"),
    IMG_CODE_ERROR("4015", "图片验证码错误"),
    IMG_CODE_EXPIRE("4016", "图片验证码过期"),
    SMS_CODE_ERROR("4017", "短信验证码错误"),
    SMS_CODE_EXPIRE("4018", "短信验证码过期"),
    SMS_CODE_EXIST("4019", "验证码已发送，稍后再试。"),
    BALANCE_NULL("4020", "请输入余额"),
    PROXY_EXIST("4021", "此区域代理已存在"),
    NOT_REMAINDER("4022", "申请金额非整数倍"),
    PARAMETER_ERROR("4023", "请输入正确的参数类型"),
    NO_ICON("4024", "请添加icon"),
    NO_REG("4025", "用户未注册"),
    BALANCE_LESS("4026", "余额不足"),
    VERIFICATION_CODE_ERROR("4027", "验证码错误"),
    PAYOUT_LESS("4028", "申请金额低于最低金额"),
    DEVICE_BIND("4029", "该用户已绑定"),
    RECHARGE_LESS("4030", "充值金额低于最低金额"),
    LESS_MIN_CPC("4031", "不能低于CPC最低投放金"),
    LESS_MIN_CPA("4032", "不能低于CPA最低投放金"),
    ORDER_NOT_AUDIT("4033", "订单审核未通过或未审核"),
    ORDER_NOT_PAYED("4034", "仅可以审核已支付订单"),
    NO_RECOMMEND("4035", "推荐人不存在"),
    LAUNCH_BALANCE_LESS("4036", "投放金不足"),
    WEB_SHOW_AWARD_LESS("4037", "节目奖励需大于零"),
    WEB_SHOW_NOT_ALLOW("4038", "仅海报区CPA, CPC可制作节目"),
    TRANSFER_SELF("4039", "不能转赠本人");


    private String code;
    private String message;

    private ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static Map<String, ResponseCode> getCodeMap() {
        Map<String, ResponseCode> result = new LinkedHashMap<>();
        for (ResponseCode commonCode : ResponseCode.values()) {
            result.put(commonCode.getCode() + "", commonCode);
        }
        return result;
    }

    public static Map<String, ResponseCode> getMessageMap() {
        Map<String, ResponseCode> result = new LinkedHashMap<>();
        for (ResponseCode commonCode : ResponseCode.values()) {
            result.put(commonCode.getMessage() + "", commonCode);
        }
        return result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
