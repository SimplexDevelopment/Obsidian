package io.github.paldiu.obsidian.ticketer;

public enum TicketStatus {
    OPEN("The ticket has been marked as open."),
    PENDING("The ticket is now pending approval."),
    IN_PROGRESS("The ticket is now in progress."),
    COMPLETED("The ticket has been marked as completed."),
    CLOSED("The ticket has been marked as closed.");

    private final String message;

    TicketStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
