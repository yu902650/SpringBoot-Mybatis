package me.springboot.mybatis.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 洞察工具类： 此工具类一般做判断使用
 *
 * @author jgshun
 */
public class Detect {
    public static final String EMPTY_STRING = "";
    /**
     * 手机浏览器标识
     */
    // private static final String[] MOBILE_KEYWORDS = new String[] { "android",
    // "iphone", "ipod", "ipad", "windowsphone", "mqqbrowser" };

    /**
     * 手机浏览器标识--ipad
     */
    private static final String[] MOBILE_KEYWORDS_IPAD = new String[]{"ipad"};

    /**
     * 手机浏览器标识--iphone
     */
    private static final String[] MOBILE_KEYWORDS_IPHONE = new String[]{
            "iphone", "ipod", "gk_ios", "ipad"};

    /**
     * 手机浏览器标识--android
     */
    private static final String[] MOBILE_KEYWORDS_ANDROID = new String[]{
            "android", "gk_android"};

    /**
     * 手机浏览器标识--windowsphone
     */
    private static final String[] MOBILE_KEYWORDS_WINDOWS_PHONE = new String[]{"windowsphone"};

    /**
     * 手机浏览器标识--other mobile
     */
    private static final String[] MOBILE_KEYWORDS_OTHER_MOBILE = new String[]{"mqqbrowser"};

    /**
     * pc浏览器标识
     */
    private static final String[] PC_KEYWORDS = new String[]{"windowsnt",
            "macintosh"};

    /**  */
    public static boolean notEmpty(String string) {
        return null != string && !EMPTY_STRING.equals(string);
    }

    public static boolean notEmpty(byte[] bytes) {
        return (null != bytes && 0 < bytes.length);
    }

    public static boolean notEmpty(List<?> list) {
        return null != list && !list.isEmpty();
    }

    public static boolean notEmpty(Map<?, ?> map) {
        return null != map && !map.isEmpty();
    }

    public static boolean notEmpty(Collection<?> collection) {
        return null != collection && !collection.isEmpty();
    }

    public static boolean notEmpty(short[] array) {
        return null != array && array.length > 0;
    }

    public static boolean notEmpty(int[] array) {
        return null != array && array.length > 0;
    }

    public static boolean notEmpty(long[] array) {
        return null != array && array.length > 0;
    }

    public static boolean notEmpty(String[] array) {
        return null != array && array.length > 0;
    }

    public static <T extends Object> boolean notEmpty(T[] array) {
        return null != array && array.length > 0;
    }

    /**
     * 判断字符串是否是整型
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        if (null == str || str.equals("")){
            return false;
        }
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    /****
     * 判断开头是否是数字
     *
     * @Title: isStartWithNumeric
     * @Description: 判断开头是否是数字
     * @param @param str
     * @param @return 设定文件
     * @author liu zheng yang
     * @return boolean 返回类型
     * @throws
     */
    public static boolean isStartWithNumeric(String str) {
        int chr = str.charAt(0);
        if (chr < 48 || chr > 57) {
            return false;
        }
        return true;
    }

    /**
     * 检查内容是否图片内容
     *
     * @param content
     * @return
     */
    public static boolean checkIsImage(String content) {
        String[] tags = {".png", ".jpg", ".gif", ".jpeg", ".ico"};
        boolean flag = false;
        for (String tag : tags) {
            if (content.contains(tag)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /***
     * 判断 String 是否是 int
     *
     * @param input
     * @return
     */
    public static boolean isInteger(String input) {
        Matcher mer = Pattern.compile("^[+-]?[0-9]+$").matcher(input);
        return mer.find();
    }

    /**
     * 验证邮箱
     *
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 验证手机号码
     *
     * @param mobileNumber
     * @return
     */
    public static boolean checkMobileNumber(String mobileNumber) {
        boolean flag = false;
        try {
            if (Detect.notEmpty(mobileNumber) && mobileNumber.length() == 11
                    && Detect.isNumeric(mobileNumber)) {
                flag = true;
            }
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }


    public static boolean isContainSpecialCode(String str) {
        Pattern p = Pattern.compile("[\\[\\]~!@#$%^&*()_+<>?:\"{},./;'\\\\]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }

    public static boolean isContainChinese(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }

}
