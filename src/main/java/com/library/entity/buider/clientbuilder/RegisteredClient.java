package com.library.entity.buider.clientbuilder;

import com.library.entity.Client;
import com.library.model.request.ClientRequest;
import java.time.LocalDate;

public class RegisteredClient extends ClientBuilder {

    private ClientRequest clientRequest;

    public RegisteredClient(ClientRequest clientRequest) {
        this.clientRequest = clientRequest;
    }

    @Override
    public void buid() {
        createNewClient();
        client.setId(clientRequest.getId());
        client.setFirstName(clientRequest.getFirstName());
        client.setLastName(clientRequest.getLastName());
        client.setLogin(clientRequest.getLogin());
        client.setPassword(clientRequest.getPassword());
        client.setHomeAddress(clientRequest.getHomeAdress());
        client.setPhoneNumber(clientRequest.getPhoneNumber());
        client.setBirthDate(LocalDate.parse(clientRequest.getBirthDate()));
        client.setRegistrationDate(LocalDate.now());
    }

    @Override
    public Client getInstance() {
        return client;
    }
}
