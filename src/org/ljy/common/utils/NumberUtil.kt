package org.ljy.common.utils

import java.lang.Math.pow
import java.util.*

/**
 * @author ljy
 */
class NumberUtil {
    companion object {
        /**
         * 产生一个[0,maxNum)之间的随机数
         */
        @JvmStatic
        fun randomNumber(maxNum: Int): Int {
            if (maxNum <= 0) {
                throw IllegalArgumentException("Max number can not smaller than 0")
            }
            return Random().nextInt(maxNum)
        }

        /**
         * 产生一个指定长度的随机数
         */
        @JvmStatic
        fun generateRandomNumberByLength(length: Int): Int {
            if (length <= 0) {
                throw IllegalArgumentException("Length can not smaller than 0")
            }
            if (length == 1) {
                return Random().nextInt(10)
            }
            val baseNum = pow(10.0, (length - 1) * 1.0).toInt()
            val tailNum = (length - 1 downTo 1).sumBy { 9 * pow(10.0, (it - 1) * 1.0).toInt() }
            return Random().nextInt((8 * baseNum + tailNum)) + baseNum
        }

    }

}