package utils.controller;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

public class ParameterizedMap<T> implements ParameterizedType {
    private Class<T> wrapped;


    public ParameterizedMap(Class<T> clazz) {
        this.wrapped = clazz;
    }

    @Override
    public Type[] getActualTypeArguments() {
        return new Type[]{String.class, wrapped};
    }

    @Override
    public Type getRawType() {
        return Map.class;
    }

    @Override
    public Type getOwnerType() {
        return null;
    }
}
