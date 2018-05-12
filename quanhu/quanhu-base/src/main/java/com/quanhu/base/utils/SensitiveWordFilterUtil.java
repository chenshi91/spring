/*created by chenshi    at 2018-05-12*/
package com.quanhu.base.utils;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 * 读取敏感词库，将敏感词放入HashSet中，构建一个DFA算法模型：<br>
 * 中 = {
 *      国 = {
 *           人 = {
 *                民 = {}
 *                }
 *           男 = {
 *                人 = {}
 *               }
 *           }
 *      }
 *  五 = {
 *      星 = {
 *          红 = {
 *              旗 = {
 *                  }
 *              }
 *          }
 *      }
 */
public class SensitiveWordFilterUtil {
    private static final Map<Character,Map> wordMap=new HashMap();

    public  static void  addSensitiveWord(Set<String> strings){
        Map<Character,Map> nowMap=wordMap;
        Map<Character,Map> valueMap = null;
        for (String string : strings) {
            char[] chars=string.toCharArray();
            for (char c : chars) {
                Object object = nowMap.get(c);
                if (object==null) {
                    valueMap=new HashMap<>();
                    nowMap.put(c,valueMap);
                    nowMap=nowMap.get(c);
                } else {
                    nowMap=(Map<Character,Map>)object;
                }
            }
            nowMap=wordMap;
        }
    }


    public static String sensitiveWordFilter(String content){
        Map<Character,Map> nowMap=wordMap;
        HashMap<Object, Object> indexMap = new HashMap<>();
        for (int i = 0; i < content.length(); i++) {
            char c = content.charAt(i);
            Map map = nowMap.get(c);
            if (map!=null) {
                //是敏感字符，不是最后一个字符，继续匹配
                if (map.values().size()>0) {
                    nowMap=map;

                }else {
                    //是敏感字符，是最后一个字符，不继续匹配
                    indexMap.put(i,null);
                }

            }
            nowMap=wordMap;
        }
        return content;
    }

    public static void main(String[] args){
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("日本男人");
        hashSet.add("日本鬼子");
        hashSet.add("毛泽东");
        addSensitiveWord(hashSet);

    }

}
