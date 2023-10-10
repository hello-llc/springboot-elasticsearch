package com.cun.util.es.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class SqlDateDeserializer extends JsonDeserializer<SqlDate> {
    @Override
    public SqlDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String source = jsonParser.getText().trim();
        if ("".equals(source)) {
            return null;
        }
        return new SqlDate(source);
    }
}
