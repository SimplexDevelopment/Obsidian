package io.github.paldiu.obsidian;

import io.github.paldiu.obsidian.utils.Bot;

public final class Obsidian {
    private static Bot bot;

    public static void main(String[] args) {
        bot = new Bot();
        getBot().verify();
    }

    public static Bot getBot() {
        return bot;
    }
}
