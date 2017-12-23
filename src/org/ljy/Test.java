package org.ljy;

import org.ljy.common.utils.StringUtil;

/**
 * @author ljy
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(StringUtil.isEmail("zzz@qq.com"));
        System.out.println(StringUtil.underLineToCamelCase("ljy_qq_com"));
    }

}
