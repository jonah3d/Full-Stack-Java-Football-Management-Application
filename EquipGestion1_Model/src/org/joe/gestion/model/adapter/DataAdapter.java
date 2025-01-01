package org.joe.gestion.model.adapter;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jonah
 */
public class DataAdapter extends XmlAdapter<String, Date> {

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date unmarshal(String date) throws Exception {

        return sdf.parse(date);
    }

    @Override
    public String marshal(Date date) throws Exception {
        return sdf.format(date);
    }

}
