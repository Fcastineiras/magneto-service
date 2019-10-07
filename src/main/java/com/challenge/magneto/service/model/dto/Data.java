package com.challenge.magneto.service.model.dto;

import org.bson.Document;

public interface Data {

    public default Data getObject(Document document) {
        return null;
    }

}
