package demo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JUnit3Demo {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String className = "demo.TestCase";
		Class cls = Class.forName(className);
		Object obj=cls.newInstance();
		Method[] methods = cls.getDeclaredMethods();
		for (Method method : methods) {
			if (method.getName().startsWith("test")
					&& method.getParameterTypes().length == 0) {

				method.invoke(obj, null);
			}
		}
	}

}
