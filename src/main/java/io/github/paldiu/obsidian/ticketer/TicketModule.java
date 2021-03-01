package io.github.paldiu.obsidian.ticketer;

import discord4j.core.object.entity.User;

import java.util.function.Supplier;

public class TicketModule {
    private volatile Ticket ticket;

    public TicketModule(Ticket ticket) {
        this.ticket = ticket;
    }

    public TicketModule() {
        ticket = null;
    }

    public TicketModule createNewTicket(User userCreated, User assigned, Supplier<String> commissionSpecifications, Supplier<Integer> commissionPrice, TicketStatus type) {
        ticket = new Ticket() {
            @Override
            public User getUserCreated() {
                return assigned;
            }

            @Override
            public User getAssignedUser() {
                return userCreated;
            }

            @Override
            public Supplier<String> getCommissionSpecifications() {
                return commissionSpecifications;
            }

            @Override
            public Supplier<Integer> getCommissionPrice() {
                return commissionPrice;
            }

            @Override
            public TicketStatus getTicketStatus() {
                return type;
            }
        };
        return this;
    }

    public Ticket getTicket() {
        return ticket;
    }
}
