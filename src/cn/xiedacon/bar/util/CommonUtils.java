package cn.xiedacon.bar.util;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import com.sun.org.apache.commons.beanutils.BeanUtils;

/**
 * 基于common-utils
 * 
 * @author xieda
 * 
 */
public class CommonUtils {

	/**
	 * 将map中的数据转移到been中
	 * 
	 * @param map
	 * @param clazz
	 * @return
	 */
	public static <T> T toBean(Map<?, ?> map, Class<T> clazz) {
		try {
			T been = clazz.newInstance();
			ConvertUtils.register(new DateConverter(), Date.class);
			BeanUtils.populate(been, map);
			return been;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 将been中的数据转到map中
	 * 
	 * @param been
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	@SuppressWarnings("unchecked")
	public static <T> Map<String, Object> toMap(T been) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		return BeanUtils.describe(been);
	}

	/**
	 * 产生一个32位长的uuid
	 * 
	 * @return
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}

	/**
	 * 将集合中的数据转换到数组中
	 * 
	 * @param collection
	 * @return
	 */
	public static <T> Object[] toArray(Collection<T> collection) {
		Iterator<T> it = collection.iterator();
		Object[] array = new Object[collection.size()];
		for (int i = 0; it.hasNext(); i++) {
			array[i] = it.next();
		}
		return array;
	}

	/**
	 * 适合用于需要高精确度的运算
	 * 
	 * @param x
	 * @param operator
	 * @param y
	 * @return
	 */
	public static <T extends Number> Number calculate(T x, String operator, T y) {
		Number x1 = (Number) x;
		Number y1 = (Number) y;
		Number result;
		if ("+".equals(operator)) {
			result = BigDecimal.valueOf(x1.longValue()).add(BigDecimal.valueOf(y1.longValue()));
		} else if ("-".equals(operator)) {
			result = BigDecimal.valueOf(x1.longValue()).subtract(BigDecimal.valueOf(y1.longValue()));
		} else if ("*".equals(operator)) {
			result = BigDecimal.valueOf(x1.longValue()).multiply(BigDecimal.valueOf(y1.longValue()));
		} else if ("/".equals(operator)) {
			result = BigDecimal.valueOf(x1.longValue()).divide(BigDecimal.valueOf(y1.longValue()));
		} else {
			throw new RuntimeException("暂不支持的运算类型：" + operator);
		}
		return result;
	}
}
