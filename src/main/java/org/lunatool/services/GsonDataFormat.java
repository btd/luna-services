/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lunatool.services;

import com.google.gson.*;
import org.apache.camel.Exchange;
import org.apache.camel.spi.DataFormat;
import java.io.*;
import java.lang.reflect.Type;
import java.util.Date;
import org.joda.time.DateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author denis.bardadym
 */
public class GsonDataFormat implements DataFormat {

    private static class DateTimeTypeConverter
            implements JsonSerializer<DateTime>, JsonDeserializer<DateTime> {

        @Override
        public JsonElement serialize(DateTime src, Type srcType, JsonSerializationContext context) {
            return new JsonPrimitive(src.toString());
        }

        @Override
        public DateTime deserialize(JsonElement json, Type type, JsonDeserializationContext context)
                throws JsonParseException {
            try {
                return new DateTime(json.getAsString());
            } catch (IllegalArgumentException e) {
                // May be it came in formatted as a java.util.Date, so try that
                Date date = context.deserialize(json, Date.class);
                return new DateTime(date);
            }
        }
    }
    private static final Logger log = LoggerFactory.getLogger(GsonDataFormat.class);
    private Gson gson = gson = (new GsonBuilder()).registerTypeAdapter(DateTime.class, new DateTimeTypeConverter()).create();
    private Class<?> clazz;

    public GsonDataFormat(String className) throws ClassNotFoundException {
        clazz = Class.forName(className);
    }

    @Override
    public void marshal(Exchange exchng, Object o, OutputStream out) throws Exception {
        Writer writer = new BufferedWriter(new OutputStreamWriter(out));
        gson.toJson(o, writer);
        writer.close();
    }

    @Override
    public Object unmarshal(Exchange exchng, InputStream in) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        Object result = gson.fromJson(reader, clazz);

        reader.close();
        return result;
    }
}
