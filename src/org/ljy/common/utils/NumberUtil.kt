package org.ljy.common.utils

import java.lang.Math.pow
import java.math.BigDecimal
import java.util.*

/**
 * @author ljy
 */
class NumberUtil {
    companion object {
        private val TEN = BigDecimal.valueOf(10)
        private val NUMBER_IN_CHINESE = arrayOf('零','壹','贰','叁','肆','伍','陆','柒','捌','玖','拾','佰','仟','万','亿')
        private val UNIT_IN_CHINESE = arrayOf('元','角','分')

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

        fun numberMoneyToChineseMoney(money:Int){
            var moneyArray = money.toString().toCharArray();


        }

        /**
         * 用逗号分隔int数字，三位一组
         */
        @JvmStatic
        fun splitNumberWithComma(number:Int):String = splitNumber(number,Math.abs(number) < 1000)

        /**
         * 用逗号分隔long数字，三位一组
         */
        @JvmStatic
        fun splitNumberWithComma(number:Long):String = splitNumber(number,Math.abs(number) < 1000)

        /**
         * int数字转为科学计数法
         */
        @JvmStatic
        fun intToScientificNotation(number: Int): String = toScientificNotation(BigDecimal(number))

        /**
         * long数字转为科学计数法
         */
        @JvmStatic
        fun longToScientificNotation(number: Long): String = toScientificNotation(BigDecimal.valueOf(number))

        /**
         * double数字转为科学计数法
         */
        @JvmStatic
        fun doubleToScientificNotation(number: Double): String = toScientificNotation(BigDecimal.valueOf(number))

        /**
         * 用逗号分隔数字，三位一组
         */
        private fun splitNumber(number: Number,needSplit:Boolean): String {
            val numStr = number.toString()
            return when(needSplit){
                true -> numStr
                false -> {
                    val numberSb = StringBuilder(numStr);
                    for (i in numberSb.length - 3 downTo 0 step 3) {
                        numberSb.insert(i, ",")
                    }
                    numberSb.toString()
                }
            }
        }

        /**
         * 数字转为科学计数法
         */
        private fun toScientificNotation(number: BigDecimal): String {
            var num = number
            val sb = StringBuilder();
            var length = 0
            while (num > TEN) {
                num = num.divide(TEN)
                length++
            }
            return sb.append(num).append("E").append(length).toString()
        }

    }

}