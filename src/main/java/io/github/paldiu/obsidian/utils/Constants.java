package io.github.paldiu.obsidian.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Constants {
    private static final Logger logger = LoggerFactory.getLogger("obsidian");
    private static final Registry registry = new Registry();

    public static Logger getLogger() {
        return logger;
    }

    public static Registry getRegistry() {
        return registry;
    }
}
