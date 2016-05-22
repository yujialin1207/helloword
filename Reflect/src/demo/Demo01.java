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
		// 运行期间动态获得类名
		String className = scan.nextLine();
		// 使用反射API动态加载类
		Class cls = Class.forName(className);
		System.out.println(cls);
		// 动态创建对象:调用类的无参数构造器创建对象
		Object obj = cls.newInstance();
		
		System.out.println(obj);
	}

}
