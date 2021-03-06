package com.qzw.contrllor.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.converter </p>
 * <p> 类名称：DoubleConverter.java  </p>
 * <p> 类描述：自定义的SpringMVC转换器：用于把null或空串转换成0的Double类型 </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2015年11月14日  下午6:09:10
 * @version 1.0
 */
public class DoubleConverter implements Converter<String, Double> {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public Double convert(String source) {
		if (source == null || source.trim().equals("")) {
			source = "0";
		}
		try {
			return Double.parseDouble(source);
		} catch (NumberFormatException e) {
			logger.error("Double参数类型转换异常", e);
		}
		return null;
	}
}