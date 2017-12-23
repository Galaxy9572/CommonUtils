package org.ljy.common.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter



/**
 * ljy56
 * 2017/12/22
 */
class TimeUtil {
    companion object {
        /** 日期格式：yyyy:MM:dd */
        const val DATE_PATTERN_COLON = "yyyy:MM:dd"
        /** 日期格式：yyyy年MM月dd日 */
        const val DATE_PATTERN_CHAR = "yyyy年MM月dd日"
        /** 日期格式：yyyy */
        const private val YEAR_PATTERN = "yyyy"
        /** 日期格式：MM */
        const private val MONTH_PATTERN = "MM"
        /** 日期格式：dd */
        const private val DAY_PATTERN = "dd"

        /**
         * 获取当前毫秒时间戳
         */
        @JvmStatic fun currentTimeMillis(): Long {
            return System.currentTimeMillis();
        }

        /**
         * 获取当前秒时间戳
         */
        @JvmStatic fun currentTimeSeconds(): Long {
            return System.currentTimeMillis()/1000;
        }

        /**
         * 获取当前日期
         */
        @JvmStatic fun getCurrentDate(pattern: String): String {
            val currentDate = LocalDate.now()
            return currentDate.format(DateTimeFormatter.ofPattern(pattern))
        }

        /**
         * 获取当前年份
         */
        @JvmStatic fun getCurrentYear(): String {
            val currentDate = LocalDate.now()
            return currentDate.format(DateTimeFormatter.ofPattern(YEAR_PATTERN))
        }

        /**
         * 获取当前月份
         */
        @JvmStatic fun getCurrentMonth(): String {
            val currentDate = LocalDate.now()
            return currentDate.format(DateTimeFormatter.ofPattern(MONTH_PATTERN))
        }

        /**
         * 获取当前月份所载的日期
         */
        @JvmStatic fun getCurrentDay(): String {
            val currentDate = LocalDate.now()
            return currentDate.format(DateTimeFormatter.ofPattern(DAY_PATTERN))
        }

        /**
         * 获取当前日期，格式为yyyy-MM-dd
         */
        @JvmStatic fun getCurrentDate(): String {
            return LocalDate.now().toString()
        }
    }

}
