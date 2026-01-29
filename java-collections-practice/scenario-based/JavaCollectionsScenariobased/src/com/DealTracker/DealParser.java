package com.DealTracker;

import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.regex.*;

public class DealParser {

    public List<Deal> parseFile(String fileName) throws Exception {

        FileInputStream fis = new FileInputStream(fileName);
        StringBuilder sb = new StringBuilder();
        int ch;

        while ((ch = fis.read()) != -1) {
            sb.append((char) ch);
        }
        fis.close();

        String data = sb.toString();

        Pattern p = Pattern.compile(
                "DealCode:\\s*(.*)\\nValidTill:\\s*(.*)\\nDiscount:\\s*(\\d+)%\\nMinimumPurchase:\\s*(\\d+)",
                Pattern.MULTILINE
        );

        Matcher m = p.matcher(data);

        List<Deal> list = new ArrayList<>();

        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate today = LocalDate.now();

        while (m.find()) {

            String code = m.group(1).trim();
            LocalDate date = LocalDate.parse(m.group(2).trim(), f);
            int discount = Integer.parseInt(m.group(3));
            int min = Integer.parseInt(m.group(4));

            if (date.isBefore(today)) continue;

            list.add(new Deal(code, discount, date, min));
        }

        return list;
    }
}
