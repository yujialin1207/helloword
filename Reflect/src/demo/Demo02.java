package demo;

import java.lang.reflect.Field;

public class Demo02 {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		String className="demo.Koo";
		//��̬������
		Class cls=Class.forName(className);
		//��̬��ȡ������Ϣ
		Field[] field=cls.getDeclaredFields();
		//Field��װ��һ��������ص���Ϣ
		System.out.println(field.length);
		//getName()��ȡ������
		System.out.println(field[0].getName());
		System.out.println(field[1].getName());

	}

}
