package test.spring.core.utils;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串工具类
 *
 * @author yinli.wangyl
 * @date 2017/12/19
 */
public class StringUtil {

    public static final String SEPERATOR = ",";

    /**
     * 判断一个对象是否为空
     *
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        return null == obj || obj.toString().length() == 0;
    }

    /**
     * 判断一个对象是否不为空
     *
     * @param obj
     * @return
     */
    public static boolean isNotEmpty(Object obj) {
        return obj != null && obj.toString().length() > 0;
    }


    /**
     * 返回对象的字符串值，null则返回空串
     *
     * @param obj
     * @return
     */
    public static String toString(Object obj) {
        return null == obj ? "" : obj.toString();
    }

    /**
     * 用默认分隔符拼接字符串数组
     *
     * @param strArr
     * @return
     */
    public static String concatString(String... strArr) {
        if (ArrayUtils.isEmpty(strArr)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            if (StringUtils.isEmpty(str)) {
                continue;
            }
            sb.append(str);
            sb.append(SEPERATOR);
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "";
    }

    /**
     * 将字符串转换为列表
     *
     * @param str
     * @param seperator
     * @return
     */
    public static List<String> stringToList(String str, String seperator) {
        List<String> list = new ArrayList<String>();
        if (StringUtils.isEmpty(str)) {
            return list;
        }
        String[] arr = str.split(seperator);
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    /**
     * 首字母大写
     * @param str
     * @return
     */
    public static String upperCaseFirstLatter(String str){
        char[] strChar=str.toCharArray();
        strChar[0]-=32;
        return String.valueOf(strChar);
    }
}
