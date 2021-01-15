package Week_01;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HelloClassLoader extends ClassLoader {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> clazz = new HelloClassLoader().findClass("Hello");
        clazz.getDeclaredMethod("hello").invoke(clazz.newInstance());
    }

    @Override
    protected Class<?> findClass(String name) {
        byte[] bytes = null;
        try {
            bytes = Files.readAllBytes(Paths.get("./Week_01/" + name + ".xlass"));
            bytes = decode(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(name, bytes, 0, bytes.length);
    }

    public byte[] decode(byte[] bytes) {
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (255 - bytes[i]);
        }
        return bytes;
    }
}
