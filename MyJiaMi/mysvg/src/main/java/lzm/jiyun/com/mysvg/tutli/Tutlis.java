package lzm.jiyun.com.mysvg.tutli;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by lenovo on 2018/1/7.
 */

public class Tutlis {


        private static Class<?> oClass;
        private static Type superclass;
        private static Type[] arguments;

        public static  <T>T  getT(Object o, int i){


            try {
                oClass = o.getClass();
                superclass = oClass.getGenericSuperclass();
                arguments = ((ParameterizedType) superclass).getActualTypeArguments();
                Type t=arguments[i];
                return ((Class<T>)t).newInstance();


            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            return null;
        }
}
