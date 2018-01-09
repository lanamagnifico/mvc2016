package com.mvc.common.service;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Loader {

    private static DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/hrmdb");
        dataSource.setUsername("root");
        dataSource.setPassword("openMySQL");
        return dataSource;
    }

    public static void main(String[] args)  {

//        String src ="";
        // loading persons
//        src = "/Users/magnifico/Desktop/pers.csv";
//        try {
//           loadPersonsFromCSV(src);
//        } catch (Exception ex) {
//            System.out.println("fail load persons "+ex.getMessage());
 //       }

        //loading positions
//        src = "/Users/magnifico/Desktop/positions.csv";
//        try {
//            loadPositionsFromCSV(src);
//        } catch (Exception ex) {
//            System.out.println("fail load persons "+ex.getMessage());
//        }

        UUID uuid = UUID.fromString("811a482e-a2ad-11de-a0c4-003048652711");
        //UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString());
        String suuid = uuid.toString();
        String partial_id = suuid.substring(14,18) + suuid.substring(9, 13) + suuid.substring(0, 8) + suuid.substring(19, 23) + suuid.substring(24);
//        byte[] final_id = HexUtils.fromHexString(partial_id);
        ByteBuffer bb = ByteBuffer.wrap(new byte[16])
                .order(ByteOrder.BIG_ENDIAN)
                .putLong(uuid.getMostSignificantBits())
                .putLong(uuid.getLeastSignificantBits());

        System.out.println(Arrays.toString(bb.array()));
        ByteBuffer bb2 = ByteBuffer.wrap(bb.array());
        Long high = bb2.getLong();
        Long low = bb2.getLong();

        UUID uuid2 = new UUID(high,low);
        System.out.println(uuid2.toString());
    }

    private static void loadPersonsFromCSV(String src) throws IOException, ParseException{
        NamedParameterJdbcTemplate jdbc = new NamedParameterJdbcTemplate(dataSource());
        Reader in = new FileReader(src);
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
        for (CSVRecord record : records) {
            String name = record.get(0);
            String birthday = record.get(1);
            String gender = record.get(2);

            if (birthday.length()==4) continue;

            DateFormat df1 = new SimpleDateFormat("dd.MM.yyyy");
            DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
            Date result =  df1.parse(birthday);

            Map<String, Object> params = new HashMap<String, Object>();
            params.put("name", name);
            params.put("birthday", df2.format(result));
            params.put("gender",gender=="Женский"?"f":"m");
            String sql = "insert into persons(name,birthday,gender) values(:name,:birthday,:gender)";
            jdbc.update(sql, params);
        }
    }

    private static void loadPositionsFromCSV(String src) throws IOException, ParseException{
        NamedParameterJdbcTemplate jdbc = new NamedParameterJdbcTemplate(dataSource());
        Reader in = new FileReader(src);
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
        for (CSVRecord record : records) {
            String name = record.get(0);
            String req = record.get(1);
            String resp = record.get(2);
            String cond = record.get(3);
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("name", name);
            params.put("conditions", cond);
            params.put("requirements", req+"\n"+resp);
            String sql = "insert into positions(name,conditions,requirements) values(:name,:conditions,:requirements)";
            jdbc.update(sql, params);
        }
    }
}
