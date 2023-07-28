/*
 * (C) 2022 ngophuhung96.
 *
 * Visit my GitHub: https://github.com/ngophuhung96
 * Contact me:
 * Email: hungnp.1704@gmail.com
 * Mobile: 0943.911.704 / 0986.824.696
 */
package vn.honagi.administrative.utils;

import java.util.List;
import java.util.stream.Collectors;

public class CommonUtils {
	
	public static String getIds(List<Integer> idList) {
		return idList.stream()
			.map(String::valueOf)
			.collect(Collectors.joining(Constants.CONDITION_DELIMITER));
	}
	
	public static Integer parseStringToInt(String number) {
		try {
			return Integer.parseInt(number);
		} catch (NumberFormatException e) {
			return null;
		}
	}
	
}
