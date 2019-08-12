package me.springboot.mybatis.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 随机数工具类
 *
 * @ClassName: RandomUtil
 * @Description: 生成随机数
 * @author YuanXiaoGang
 * @date 2014年12月29日 上午9:34:37
 */
public class RandomUtil {
	public static final String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static final String letterChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static final String numberChar = "0123456789";

	public static String generateMixString(int length) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(allChar.charAt(random.nextInt(letterChar.length())));
		}
		return sb.toString();
	}

	/**
	 * 生成指定长度的随机码
	 *
	 * @param length
	 * @return
	 */
	public static String generateNumberString(int length) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(numberChar.charAt(random.nextInt(numberChar.length())));
		}
		return sb.toString();
	}

	/**
	 * 生成指定长度的随机码
	 *
	 * @param length
	 *            指定生成随机码的长度
	 * @param numberChar
	 *            指定生成随机码的源
	 * @return
	 */
	public static String generateNumberString(int length, String numberChar) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(numberChar.charAt(random.nextInt(numberChar.length())));
		}
		return sb.toString();
	}

	public static String generateUpperString(int length) {
		return generateMixString(length).toUpperCase();
	}

	/****
	 *
	 * @Title: getRandomList
	 * @Description: TODO获取随机的集合
	 * @param @param list
	 * @param @param count
	 * @param @return 设定文件
	 * @author liu zheng yang
	 * @return List 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public static List getRandomList(List list, int count) {
		List b = null;
		if (null != list) {
			if (count >= list.size()) {
				return list;
			}
			List a = new ArrayList();
			a.addAll(list);
			b = new ArrayList();
			int size = a.size();
			for (int i = 0; i < count; i++) {
				int index = (int) Math.floor(Math.random() * size);
				Object obj = a.get(index);
				if (!b.contains(obj)) {
					b.add(obj);
				}
				a.remove(index);
				size--;
			}
		}
		return b;
	}

	/**
	 * 随机两位
	 *
	 * @param dateStr
	 * @return
	 */
	public static String getRandomIn100(String dateStr) {
		String str = Math.random() + "";
		str = str.substring(2, 4);
		return dateStr + str;
	}

	/**
	 * 生成随机字符串
	 * @author  wanggq
	 * @param len   字符串长度
	 * @param isNums   是否是纯数字
	 * @return	字符串
	 */
	public static String randomStr(int len, boolean isNums) {
		String nums = "0123456789";
		String letterNums = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		if (isNums) {
			for (int i = 0; i < len; i++) {
				int num = random.nextInt(nums.length());
				sb.append(nums.charAt(num));
			}
		} else {
			for (int i = 0; i < len; i++) {
				int num = random.nextInt(letterNums.length());
				sb.append(letterNums.charAt(num));
			}
		}
		return sb.toString();
	}

}
