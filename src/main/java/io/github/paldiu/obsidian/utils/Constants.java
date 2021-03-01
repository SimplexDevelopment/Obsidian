package io.github.paldiu.obsidian.utils;

import java.util.function.Consumer;
import java.util.logging.Logger;

// Utility Class
public final class Constants {
    private static final Logger logger = Logger.getLogger("obsidian");

    public static Logger getLogger() {
        return logger;
    }

    public static <T> void forEach(T[] array, Consumer<T> action) {
        for (T obj : array) {
            action.accept(obj);
        }
    }
}
