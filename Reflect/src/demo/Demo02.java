package demo;

import java.lang.reflect.Field;

public class Demo02 {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		String className="demo.Koo";
		//动态加载类
		Class cls=Class.forName(className);
		//动态获取属性信息
		Field[] field=cls.getDeclaredFields();
		//Field封装了一个属性相关的信息
		System.out.println(field.length);
		//getName()获取属性名
		System.out.println(field[0].getName());
		System.out.println(field[1].getName());

	}

}
