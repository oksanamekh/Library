package com.library.entity.buider.clientbuilder;

import com.library.entity.Client;
import com.library.entity.buider.ClassBuilder;

public abstract class ClientBuilder implements ClassBuilder<Client> {

    protected Client client;

    protected void createNewClient() {
        client = new Client();
    }
}
