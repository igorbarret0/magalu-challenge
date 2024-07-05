package com.challenge.magalums.config;

import com.challenge.magalums.entity.Channel;
import com.challenge.magalums.entity.Status;
import com.challenge.magalums.repository.ChannelRepository;
import com.challenge.magalums.repository.StatusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    private StatusRepository statusRepository;
    private ChannelRepository channelRepository;

    public DataLoader(StatusRepository statusRepository,
                      ChannelRepository channelRepository) {
        this.statusRepository = statusRepository;
        this.channelRepository = channelRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(Channel.Values.values())
                .map(Channel.Values::toChannel)
                .forEach(channelRepository::save);

        Arrays.stream(Status.Values.values())
                .map(Status.Values::toStatus)
                .forEach(statusRepository::save);
    }
}
