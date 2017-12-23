package org.ljy.common.utils

import java.util.regex.Pattern

/**
 * @author ljy
 */
class StringUtil {
    companion object {
        private val EMAIL_PATTERN = Pattern.compile("[A-Za-z\\d]+@[A-Za-z\\d]+.[a-z]+")
        private val CAMEL_CASE_PATTERN = Pattern.compile("[A-Za-z\\d]+_?");

        /**
         * 验证字符串是否为Email格式
         */
        @JvmStatic
        fun isEmail(email: String): Boolean {
            return EMAIL_PATTERN.matcher(email).find()
        }

        /**
         * 将用下划线分割的字符串转为驼峰格式
         */
        @JvmStatic
        fun underLineToCamelCase(str: String): String {
            if ("" == str) {
                return ""
            }
            val sb = StringBuffer()
            val matcher = CAMEL_CASE_PATTERN.matcher(str)
            while (matcher.find()) {
                val word = matcher.group()
                val char = when (matcher.start() == 0) {
                    true -> Character.toLowerCase(word[0])
                    false -> Character.toUpperCase(word[0])
                }
                sb.append(char)
                val index = word.lastIndexOf('_')
                when (index > 0) {
                    true -> sb.append(word.substring(1, index).toLowerCase())
                    false -> sb.append(word.substring(1).toLowerCase())
                }
            }
            return sb.toString()
        }
    }
}