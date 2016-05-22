package demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Utils {
	/**
	 * 调用某对象的某方法
	 * 
	 * @param obj
	 *            某个对象
	 * @param method
	 *            某方法名
	 * @param paramTypes
	 *            参数类型列表
	 * @param params
	 *            参数列表
	 * @return 方法结果
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * 
	 */
	public static Object execute(Object obj, String method, Class[] paramTypes,
			Object[] params) throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		Class cls = obj.getClass();
		Method m = cls.getDeclaredMethod(method, paramTypes);
		Object val = m.invoke(obj, params);
		return val;

	}

	/**
	 * 返回某对象的某个属性
	 * 
	 * @param obj
	 * @param fieldName某个属性的名
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static Object get(Object obj, String fieldName)
			throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException {
		// 找到Class
		Class cls = obj.getClass();
		// 找到属性信息
		Field field = cls.getDeclaredField(fieldName);
		// 找到属性信息Field的get方法获取属性值
		Object val = field.get(obj);
		return val;
	}

	/**
	 * 创建调用“某个类”的“某个构造器”创建一个对象
	 * 
	 * @param className
	 *            某个类名
	 * @param paramTypes
	 *            某个构造器参数类型列表
	 * @param params
	 *            调用构造器是传递的参数列表
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws IllegalArgumentException
	 */
	public static Object create(String className, Class[] paramTypes,
			Object[] params) throws ClassNotFoundException, SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {
		// 动态加载类
		Class cls = Class.forName(className);
		// 找到构造器信息
		Constructor constructor = cls.getDeclaredConstructor(paramTypes);
		Object obj = constructor.newInstance(params);
		return obj;
	}

	/**
	 * 显示一个类的全部构造器信息
	 */
	public static void showInit(String className) throws Exception {
		Class cls = Class.forName(className);
		Constructor[] constructors = cls.getDeclaredConstructors();
		for (Constructor constructor : constructors) {
			System.out.print(constructor.getName() + "");
			System.out
					.println(Arrays.toString(constructor.getParameterTypes()));

		}
	}

	/**
	 * 显示一个类的全部方法信息
	 */
	public static void showMethods(String className) throws Exception {
		Class cls = Class.forName(className);
		/*
		 * 返回cls类信息中全部的方法信息
		 */
		Method[] methods = cls.getDeclaredMethods();
		for (Method method : methods) {
			System.out.print(method.getReturnType() + " ");
			System.out.print(method.getName() + " ");
			System.out.println(Arrays.toString(method.getParameterTypes()));
		}
	}

	/**
	 * 显示一个类是全部属性信息
	 * 
	 * @param className
	 *            类名
	 * @throws ClassNotFoundException
	 * @throws Exception
	 *             类名错误时候抛出异常
	 */
	public static void showFields(String className)
			throws ClassNotFoundException {
		// 动态加载类
		Class cls = Class.forName(className);

		// 动态获取全部属性信息
		Field[] fields = cls.getDeclaredFields();
		// for循环遍历属性数组，显示全部属性信息
		for (Field field : fields) {
			System.out.print(field.getType() + " ");
			System.out.println(field.getName());

		}
	}
}
