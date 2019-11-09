package com.zhkj.syyj.Utils;

public class RequstUrlUtils {
    public static class URL{
        //请求头
        public static  String HOST="http://192.168.1.188:99";

        //注册
        public static String Logon=HOST+"/user/reg";

        //上传图片
        public static String Upload=HOST+"/api/upload";

        //检测手机号是否已使用
        public static String IssetMobile=HOST+"/api/issetMobile";

        //发送短信( 1 注册/绑定新手机号 2 找回密码 6 验证原手机号)
        public static String SendCode=HOST+"/api/sendCode";

        //模拟验证码
        public static String GetCode=HOST+"/api/getCode";

        //手机登录
        public static String Login=HOST+"/user/login";

        //个人中心
        public static String Index=HOST+"/user/index";

        //商城分类
        public static String CategoryList=HOST+"/goods/categoryList";

        //找回密码
        public static String ResetPass=HOST+"/user/resetPass";

        //更换手机号
        public static String updateMobile=HOST+"/user/updateMobile";

        //验证验证码
        public static String CheckCode=HOST+"/user/checkCode";

        //系统/服务消息列表
        public static String MessageNoticeList=HOST+"/user/messageNoticeList";

        //消息详情
        public static String Message_notice_info=HOST+"user/message_notice_info";

        //修改个人信息
        public static String SaveUserInfo=HOST+"user/saveUserInfo";
    }
}
