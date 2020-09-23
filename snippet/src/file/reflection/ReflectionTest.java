package file.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

public class ReflectionTest {
    public static void main(String[] args) {
        try {
            // Class.forName의 함수를 사용해서 문자열로 Class<?> 타입을 취득해 올 수 있다.
            Class<?> clz = Class.forName("file.reflection.Callee");
            Object obj = clz.newInstance();
            Method method = ReflectionTest.getMethod(clz, "print", null);
            if(method != null) {
                method.invoke(obj);
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private static Method getMethod(Class clazz, String methodName, List<String> argList) {
        int argSize = (argList != null) ? argList.size() : 0;
        for(Method method: clazz.getDeclaredMethods()) {
            if(method.getName().equals("print") && method.getParameterTypes().length == argSize) {
                return method;
            }
        }
        return null;
    }

    public static void main3(String[] args) {
        try {
            // Class.forName의 함수를 사용해서 문자열로 Class<?> 타입을 취득해 올 수 있다.
            Class<?> clz = Class.forName("file.reflection.Callee");
            // String으로 취득한 클래스 타입으로 생성자를 취득합니다.
            Constructor<?> constructor = clz.getConstructor();
            // 생성자를 통해 newInstance 함수를 호출하여 Node 인스턴스를 생성한다.
            Object node = constructor.newInstance();
            // node 인스턴스의 toString 함수를 실행한다.
            System.out.println(node.toString());
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static void main2(String[] args) {
        try {
            // Node 클래스의 타입을 선언한다.
            Class<?> cls = Callee.class;
            // Node 클래스의 생성자를 취득한다.
            Constructor<?> constructor = cls.getConstructor();
            // 생성자를 통해 newInstance 함수를 호출하여 Node 인스턴스를 생성한다.
            Callee node = (Callee)constructor.newInstance();
            // node 인스턴스의 print 함수를 실행한다.
            node.print();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
