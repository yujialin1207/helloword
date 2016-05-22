package demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Utils {
	/**
	 * ����ĳ�����ĳ����
	 * 
	 * @param obj
	 *            ĳ������
	 * @param method
	 *            ĳ������
	 * @param paramTypes
	 *            ���������б�
	 * @param params
	 *            �����б�
	 * @return �������
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
	 * ����ĳ�����ĳ������
	 * 
	 * @param obj
	 * @param fieldNameĳ�����Ե���
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static Object get(Object obj, String fieldName)
			throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException {
		// �ҵ�Class
		Class cls = obj.getClass();
		// �ҵ�������Ϣ
		Field field = cls.getDeclaredField(fieldName);
		// �ҵ�������ϢField��get������ȡ����ֵ
		Object val = field.get(obj);
		return val;
	}

	/**
	 * �������á�ĳ���ࡱ�ġ�ĳ��������������һ������
	 * 
	 * @param className
	 *            ĳ������
	 * @param paramTypes
	 *            ĳ�����������������б�
	 * @param params
	 *            ���ù������Ǵ��ݵĲ����б�
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
		// ��̬������
		Class cls = Class.forName(className);
		// �ҵ���������Ϣ
		Constructor constructor = cls.getDeclaredConstructor(paramTypes);
		Object obj = constructor.newInstance(params);
		return obj;
	}

	/**
	 * ��ʾһ�����ȫ����������Ϣ
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
	 * ��ʾһ�����ȫ��������Ϣ
	 */
	public static void showMethods(String className) throws Exception {
		Class cls = Class.forName(className);
		/*
		 * ����cls����Ϣ��ȫ���ķ�����Ϣ
		 */
		Method[] methods = cls.getDeclaredMethods();
		for (Method method : methods) {
			System.out.print(method.getReturnType() + " ");
			System.out.print(method.getName() + " ");
			System.out.println(Arrays.toString(method.getParameterTypes()));
		}
	}

	/**
	 * ��ʾһ������ȫ��������Ϣ
	 * 
	 * @param className
	 *            ����
	 * @throws ClassNotFoundException
	 * @throws Exception
	 *             ��������ʱ���׳��쳣
	 */
	public static void showFields(String className)
			throws ClassNotFoundException {
		// ��̬������
		Class cls = Class.forName(className);

		// ��̬��ȡȫ��������Ϣ
		Field[] fields = cls.getDeclaredFields();
		// forѭ�������������飬��ʾȫ��������Ϣ
		for (Field field : fields) {
			System.out.print(field.getType() + " ");
			System.out.println(field.getName());

		}
	}
}
