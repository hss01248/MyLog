package com.orhanobut.logger.util;

import android.util.Pair;

import com.orhanobut.logger.PrintStyle;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * @author Kale
 * @date 2016/3/23
 */
public class ObjParser {

    // 基本数据类型
    private final static String[] TYPES = {"int", "java.lang.String", "boolean", "char",
            "float", "double", "long", "short", "byte"};

    public static String parseObj(Object object) {
        if (object == null) {
            return "null";
        }

        final String simpleName = object.getClass().getSimpleName();
        if (object.getClass().isArray()) {
            StringBuilder msg = new StringBuilder("Temporarily not support more than two dimensional Array!");
            int dim = ArrayParser.getArrayDimension(object);
            switch (dim) {
                case 1:
                    Pair pair = ArrayParser.arrayToString(object);
                    msg = new StringBuilder(simpleName.replace("[]", "[" + pair.first + "] {\n  "));
                    msg.append(pair.second).append(PrintStyle.NEWLINE_AND_SPACE);
                    break;
                case 2:
                    Pair pair1 = ArrayParser.arrayToObject(object);
                    Pair pair2 = (Pair) pair1.first;
                    msg = new StringBuilder(simpleName.replace("[][]", "[" + pair2.first + "][" + pair2.second + "] {\n  "));
                    msg.append(pair1.second) .append(PrintStyle.NEWLINE_AND_SPACE);
                    break;
                default:
                    break;
            }
            return msg + "}";
        } else if (object instanceof Collection) {
            Collection collection = (Collection) object;
            String msg = "%s size = %d [\n  ";
            msg = String.format(Locale.ENGLISH, msg, simpleName, collection.size());
            if (!collection.isEmpty()) {
                Iterator iterator = collection.iterator();
                int flag = 0;
                while (iterator.hasNext()) {
                    String itemString = "[%d]:%s%s";
                    Object item = iterator.next();
                    msg += String.format(Locale.ENGLISH, itemString,
                            flag,
                            objectToString(item),
                            flag++ < collection.size() - 1 ? ",\n  " : "\n  ");
                }
            }
            return msg + "]";
        } else if (object instanceof Map) {
            String msg = simpleName + " {\n  ";
            Map map = (Map) object;
            Set keys = map.keySet();
            for (Object key : keys) {
                String itemString = "[%s -> %s]\n  ";
                Object value = map.get(key);
                msg += String.format(itemString, objectToString(key), objectToString(value));
            }
            return msg + "}";
        } else {
            return objectToString(object);
        }
    }


    /**
     * 将对象转化为String
     */
    protected static <T> String objectToString(T object) {
        if (object == null) {
            return "Object{object is null}";
        }
        String toStr = object.toString();
        if (toStr.startsWith(object.getClass().getName() + "@")) {
            StringBuilder builder = new StringBuilder(toStr + "{");
            builder.append(PrintStyle.NEWLINE_AND_SPACE);
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                boolean flag = false;
                for (String type : TYPES) {
                    if (field.getType().getName().equalsIgnoreCase(type)) {
                        flag = true;
                        Object value = null;
                        try {
                            value = field.get(object);
                        } catch (IllegalAccessException e) {
                            value = e;
                        } finally {
                            builder.append(String.format("%s=%s,", field.getName(), value == null ? "null" : value.toString()))
                                    .append(PrintStyle.NEWLINE_AND_SPACE);
                        }
                    }
                }
                if (!flag) {
                    try {
                        Object objectf = field.get(object);
                        String objStr = objectf == null ? "null" : objectf.toString();
                        builder.append(String.format("%s=%s,", field.getName(), objStr))
                                .append(PrintStyle.NEWLINE_AND_SPACE);//"Object"
                    } catch (Exception e) {
                        e.printStackTrace();
                        builder.append(String.format("%s=%s,", field.getName(), "object"))
                                .append(PrintStyle.NEWLINE_AND_SPACE);
                    }
                }
            }
            int idx = builder.lastIndexOf(",");
            if(idx > 0){
                return builder.replace(idx, idx+2, "  }").toString();
            }
            return builder.toString();
        } else {
            return toStr;
        }
    }
}
