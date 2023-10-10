package com.cun.util.es.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

import java.io.IOException;
import java.sql.Date;

@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
public class SqlDate extends Date implements JsonSerializable {

    public SqlDate(int year, int month, int day) {
        super(year, month, day);
    }

    public SqlDate(long date) {
        super(date);
    }

    public SqlDate(Date date) {
        super(date.getTime());
    }

    public SqlDate(String dateStr) {
        super(DateUtil.parseDate(dateStr).getTime());
    }

    @Override
    public void serialize(JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(this.toString());
    }

    @Override
    public void serializeWithType(JsonGenerator gen, SerializerProvider serializers, TypeSerializer typeSer) throws IOException {
        WritableTypeId typeIdDef = typeSer.writeTypePrefix(gen, typeSer.typeId(this, JsonToken.VALUE_STRING));
        gen.writeString(this.toString());
        typeSer.writeTypeSuffix(gen, typeIdDef);
    }
}
