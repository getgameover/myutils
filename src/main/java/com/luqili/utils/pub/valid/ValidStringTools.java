package com.luqili.utils.pub.valid;

import java.util.regex.Pattern;

import com.luqili.utils.pub.idcard.IDCardUtils;
import com.luqili.utils.pub.string.StringUtils;

/**
 * 正则表达式验证字符串
 * 
 * @author luqili
 *
 */
public class ValidStringTools {
    public static final String PATTERN_VALID_PHONE = "^1\\d{10}$";
    public static final String PATTERN_VALID_QQ = "^\\d{5,13}$";
    public static final String PATTERN_VALID_EMAIL = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
    public static final String PATTERN_VALID_CHINESE = "^[\u4e00-\u9fa5]+$";
    public static final String PATTERN_VALID_IPV4 = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
            + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\." + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
            + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
    public static final String PATTERN_VALID_IPV6 = "^([\\dA-Fa-f]{1,4}:){7}[\\dA-Fa-f]{1,4}$";

    /**
     * 验证内容与正则表达式是否匹配
     * 
     * @param content
     * @param pattern
     * @return
     */
    public static boolean validPattern(String content, String pattern) {
        return Pattern.matches(pattern, content);
    }

    /**
     * 验证手机号是否符合规范
     * 
     * @param phone
     * @return
     */
    public static boolean validPhone(String phone) {
        return validPattern(phone, PATTERN_VALID_PHONE);
    }

    /**
     * 验证身份证号是否符合规范
     * <p>
     * 18位身份证号,符合校验规则(生日,年龄,行政区划,校验码)
     * </p>
     * 
     * @param idcard
     * @return
     */
    public static boolean validIdCard(String idcard) {
        return IDCardUtils.validIdCardCode(idcard);
    }

    /**
     * 验证QQ号码是否符合规则
     * <p>
     * 5-13位的纯数字编号
     * </p>
     * 
     * @param qq
     * @return
     */
    public static boolean validQQ(String qq) {
        return validPattern(qq, PATTERN_VALID_QQ);
    }

    /**
     * 验证E-mail是否符合规则
     * <p>
     * E-mail长度不能超过64位
     * </p>
     * 
     * @param email
     * @return
     */
    public static boolean validEmail(String email) {
        if (StringUtils.isNotBlank(email)) {
            if (email.length() > 64) {
                return false;
            }
        } else {
            return false;
        }
        return validPattern(email, PATTERN_VALID_EMAIL);
    }

    /**
     * 验证是否全部为中文
     * 
     * <pre>
     * ValidStringTools.validChinese("") = false
     * ValidStringTools.validChinese("有标点符号。") = false
     * ValidStringTools.validChinese("这是中文") = true
     * ValidStringTools.validChinese("繁体字龍") = true
     * ValidStringTools.validChinese("偏僻字嵾寤") = true
     * </pre>
     * 
     * @param ch
     * @return
     */
    public static boolean validChinese(String ch) {
        return validPattern(ch, PATTERN_VALID_CHINESE);
    }

    /**
     * 验证字符串的长度是否在 min<= str.length <=max
     * 
     * @param str
     * @param min
     * @param max
     * @return
     */
    public static boolean validLength(String str, int min, int max) {
        int len = StringUtils.length(str);
        return len >= min && len <= max;
    }

    /**
     * 验证字符串是否符合IPv4规则
     * <p>
     * IPv4的ip地址都是（1~255）.（0~255）.（0~255）.（0~255）的格式
     * </p>
     * 
     * <pre>
     * ValidStringTools.validIpv4("") = false
     * ValidStringTools.validIpv4("255.255.255.255") = true
     * ValidStringTools.validIpv4("1.2.3.255") = true
     * ValidStringTools.validIpv4("255.256.255.255") = false
     * ValidStringTools.validIpv4("255.235.20.2.2") = false
     * </pre>
     * 
     * @param ip
     * @return
     */
    public static boolean validIpv4(String ip) {
        return validPattern(ip, PATTERN_VALID_IPV4);
    }

    /**
     * 验证字符串是否符合IPv6规则
     * <p>
     * IPv6的ip地址都是"0:0:0:0:0:0:0:1"
     * </p>
     * 
     * <pre>
     * ValidStringTools.validIpv6("") = false
     * ValidStringTools.validIpv6("0:0:0:0:0:0:0:1") = true
     * ValidStringTools.validIpv6("FFFF:FFFF:FFFF:FFFF:FFFF:FFFF:FFFF:1") = true
     * ValidStringTools.validIpv6("FFFG:FFFF:FFFF:FFFF:FFFF:FFFF:FFFF:1") = false
     * ValidStringTools.validIpv6("FFFFF:FFFF:FFFF:FFFF:FFFF:FFFF:FFFF:1") = false
     * </pre>
     * 
     * @param ip
     * @return
     */
    public static boolean validIpv6(String ip) {
        return validPattern(ip, PATTERN_VALID_IPV6);
    }
}
