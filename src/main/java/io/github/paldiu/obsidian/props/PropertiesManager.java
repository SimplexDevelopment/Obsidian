package io.github.paldiu.obsidian.props;

import io.github.paldiu.obsidian.Obsidian;
import io.github.paldiu.obsidian.utils.Constants;

import java.io.*;
import java.net.URISyntaxException;
import java.util.Properties;

public class PropertiesManager {
    private static final PropertiesManager instance = new PropertiesManager();
    private final Properties properties;
    private final File child;

    private PropertiesManager() {
        properties = new Properties();
        File parent = new File(ClassLoader.getSystemClassLoader().getResource(".").getPath());
        child = new File(parent, "options.properties");
    }

    public static PropertiesManager getInstance() {
        return instance;
    }

    public PropertiesManager setDefaultProperties() {
        properties.setProperty("name", "Obsidian");
        properties.setProperty("author", "Predicate<? super T>#0001");
        properties.setProperty("version", "1.0.0");
        properties.setProperty("encoding", "UTF_8");
        properties.setProperty("token", "BOT_TOKEN");
        return this;
    }

    public Properties getProperties() {
        verify();
        return properties;
    }

    public void build() {
        if (child.exists()) {
            Constants.getLogger().info("File already exists!");
            return;
        }

        verify();

        try (OutputStream stream = new FileOutputStream(child)) {
            properties.store(stream, null);
        } catch (IOException e) {
            Constants.getLogger().severe(e.getMessage());
        }
    }

    public void load() {
        if (!child.exists()) {
            setDefaultProperties().build();
        }

        try (InputStream input = new FileInputStream(child)) {
            properties.load(input);
        } catch (IOException ignored) {
        }
    }

    public String getName() {
        return property("name");
    }

    public String getAuthor() {
        return property("author");
    }

    public String getVersion() {
        return property("version");
    }

    public String getEncoding() {
        return property("encoding");
    }

    public String getToken() {
        return property("token");
    }

    private void verify() {
        if (properties.isEmpty()) {
            setDefaultProperties();
        }
    }

    private String property(String name) {
        verify();
        return properties.getProperty(name);
    }
}
