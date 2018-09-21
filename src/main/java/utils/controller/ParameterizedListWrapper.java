package utils.controller;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class ParameterizedListWrapper<T> implements ParameterizedType {
    private final Class<T> wrapped;


    public ParameterizedListWrapper(final Class<T> clazz) {
        this.wrapped = clazz;
    }

    @Override
    public Type[] getActualTypeArguments() {
        return new Type[]{wrapped};
    }

    @Override
    public Type getRawType() {
        return List.class;
    }

    @Override
    public Type getOwnerType() {
        return null;
    }
}
