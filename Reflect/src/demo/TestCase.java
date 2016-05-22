package demo;

import java.lang.reflect.InvocationTargetException;

import javax.rmi.CORBA.Util;

import org.junit.Test;

public class TestCase {
	@Test
	public void test1() throws Exception {
		Utils.showInit("java.lang.String");

	}

	@Test
	public void tset2() throws SecurityException, IllegalArgumentException,
			ClassNotFoundException, NoSuchMethodException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {
		String className = "demo.Koo";
		// 参数类型列表(int)
		Class[] types = new Class[] { int.class,String.class };
		// 参数列表
		Object[] params = new Object[] { 200,"hah" };
		Object obj = Utils.create(className, types, params);
		System.out.println(obj);
	}
	@Test
	public void test3() throws SecurityException, IllegalArgumentException, NoSuchFieldException, IllegalAccessException {
		Koo koo=new Koo();
		koo.a=2;
		Object val=Utils.get(koo,"a");
		System.out.println(val);
	}
	@Test
	public void test4() throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		Koo koo=new Koo();
		Object val=Utils.execute(koo, "sayHello", new Class[]{String.class,String.class}, new Object[]{"yjl","yht"});
		System.out.println(val);
	}
}
