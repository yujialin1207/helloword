package demo;

import java.util.Scanner;

public class Demo01 {

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		Scanner scan = new Scanner(System.in);
		// �����ڼ䶯̬�������
		String className = scan.nextLine();
		// ʹ�÷���API��̬������
		Class cls = Class.forName(className);
		System.out.println(cls);
		// ��̬��������:��������޲�����������������
		Object obj = cls.newInstance();
		
		System.out.println(obj);
	}

}
