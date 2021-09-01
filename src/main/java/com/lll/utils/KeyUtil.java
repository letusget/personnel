package com.lll.utils;

import java.util.UUID;

/**
 * 随机生成主键工具类
 */
public class KeyUtil
{
    /**
     * 生成8位UUId，可以确保不重复
     */
    public static String[] chars = new String[]{ "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
            "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public static  String genUniqueKey()
    {
        StringBuffer shortBuffer = new StringBuffer();
        //将生成的UUID的 "-" 替换为 " "
        String uuid = UUID.randomUUID().toString().replace("-", "");
        //生成8位 UUID
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();

    }
}
