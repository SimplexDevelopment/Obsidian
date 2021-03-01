package io.github.paldiu.obsidian.utils;

import discord4j.common.util.Snowflake;
import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.object.entity.User;
import discord4j.discordjson.json.ApplicationInfoData;
import discord4j.discordjson.json.UserData;
import discord4j.rest.response.ResponseFunction;
import io.github.paldiu.obsidian.props.PropertiesManager;

public final class Bot {
    private final GatewayDiscordClient gateway;
    private final DiscordClient client;
    private final String token;

    public Bot() {
        PropertiesManager.getInstance().load();
        token = PropertiesManager.getInstance().getToken();
        client = DiscordClient.builder(token)
                .onClientResponse(ResponseFunction.emptyIfNotFound())
                .build();
        client.getApplicationInfo()
                .map(ApplicationInfoData::owner)
                .map(UserData::id)
                .map(Snowflake::asLong)
                .doOnNext(ownerId -> {
                    Constants.getLogger().info(ownerId.toString());
                })
                .block();
        gateway = client.login().block();
    }

    public void verify() {
        getGateway().getEventDispatcher().on(ReadyEvent.class).subscribe(event -> {
            final User self = event.getSelf();
            Constants.getLogger().info(String.format("Logged in as %s#%s", self.getUsername(), self.getDiscriminator()));
        });
    }

    public GatewayDiscordClient getGateway() {
        return gateway;
    }

    public DiscordClient getClient() {
        return client;
    }

    public String getToken() {
        return token;
    }
}
