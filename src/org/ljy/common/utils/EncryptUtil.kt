package org.ljy.common.utils

import java.security.MessageDigest


/**
 * @author ljy
 */
class EncryptUtil {
    companion object {
        /**
         * 用MD5给文本加密
         */
        @JvmStatic
        fun md5Encrypt(plainText: String): String {
            val messageDigest: MessageDigest
            var md5Sum = ""
            try {
                messageDigest = MessageDigest.getInstance("MD5")
                messageDigest.update(plainText.toByteArray(charset("utf-8")))
                val bytes = messageDigest.digest()
                var byteToInt: Int
                val buf = StringBuilder()
                for (bt in bytes) {
                    byteToInt = bt.toInt()
                    if (byteToInt < 0) {
                        byteToInt += 256
                    }
                    if (byteToInt < 16) {
                        buf.append("0")
                    }
                    buf.append(Integer.toHexString(byteToInt))
                }
                md5Sum = buf.toString()
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return md5Sum
        }
    }
}