package io.github.paldiu.obsidian.ticketer;

import discord4j.core.object.entity.User;

import java.util.function.Supplier;

public interface Ticket {
    User getUserCreated();

    User getAssignedUser();

    Supplier<String> getCommissionSpecifications();

    Supplier<Integer> getCommissionPrice();

    TicketStatus getTicketStatus();
}
