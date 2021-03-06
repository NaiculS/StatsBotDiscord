package de.timmi6790.statsbotdiscord.events;

import de.timmi6790.statsbotdiscord.StatsBot;
import de.timmi6790.statsbotdiscord.modules.command.AbstractCommand;
import de.timmi6790.statsbotdiscord.modules.command.CommandParameters;
import de.timmi6790.statsbotdiscord.modules.command.CommandResult;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import net.dv8tion.jda.api.events.Event;

@EqualsAndHashCode(callSuper = true)
@Getter
public class EventCommandExecution extends Event {
    private final AbstractCommand command;
    private final CommandParameters parameters;

    public EventCommandExecution(final AbstractCommand command, final CommandParameters parameters) {
        super(StatsBot.getDiscord());

        this.command = command;
        this.parameters = parameters;
    }

    public static class Pre extends EventCommandExecution {
        public Pre(final AbstractCommand command, final CommandParameters parameters) {
            super(command, parameters);
        }
    }

    public static class Post extends EventCommandExecution {
        @Getter
        private final CommandResult commandResult;

        public Post(final AbstractCommand command, final CommandParameters parameters, final CommandResult commandResult) {
            super(command, parameters);

            this.commandResult = commandResult;
        }
    }
}
