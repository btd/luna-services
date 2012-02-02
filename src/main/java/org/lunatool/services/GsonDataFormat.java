/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lunatool.services;

import org.apache.camel.Exchange;
import org.apache.camel.spi.DataFormat;
import com.google.gson.Gson;
import java.io.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @author denis.bardadym
 */
public class GsonDataFormat implements DataFormat {

    private static final Logger log = LoggerFactory.getLogger(GsonDataFormat.class);

    private Gson gson = new Gson();
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
