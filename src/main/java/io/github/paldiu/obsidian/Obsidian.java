package io.github.paldiu.obsidian;

import io.github.paldiu.obsidian.utils.Constants;

public final class Obsidian {
    // This class only initializes the bot.
    // Using utility classes to manage instances.
    public static void main(String[] args) {
        Constants.getRegistry().verify();
    }
}
