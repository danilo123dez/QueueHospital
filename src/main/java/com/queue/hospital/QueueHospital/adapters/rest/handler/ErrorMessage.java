package com.queue.hospital.QueueHospital.adapters.rest.handler;

import lombok.Getter;

import java.util.Collection;

public class ErrorMessage {
    @Getter
    private final Collection<String> mensagens;

    public ErrorMessage(Collection<String> mensagens) {
        this.mensagens = mensagens;
    }
}
