package com.kackan.weather_app.utils;

import java.util.List;

public class ListUtils {
    public static boolean isEmpty(List<?> list) {
        if (list == null) {
            return true;
        }
        if (list.isEmpty()) {
            return true;
        }
        return false;
    }
}
