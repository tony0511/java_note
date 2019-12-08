package com.vince.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> 描述: 生成控制台表格</p>
 *
 * @author vince
 * @version 1.0
 */
public class ConsoleTable {

    private List<List> rows = new ArrayList<List>();

    private int column;

    private int[] columnLen;

    private static int margin = 2;

    private boolean printHeader = false;

    public ConsoleTable(int column, boolean printHeader) {
        this.printHeader = printHeader;
        this.column = column;
        this.columnLen = new int[column];
    }

    public void appendRow() {
        List row = new ArrayList(column);
        rows.add(row);
    }

    public ConsoleTable appendColumn(Object value) {
        if (value == null) {
            value = "NULL";
        }
        List row = rows.get(rows.size() - 1);
        row.add(value);
        int len = value.toString().getBytes().length;
        if (columnLen[row.size() - 1] < len)
            columnLen[row.size() - 1] = len;
        return this;
    }

    public String toString() {
        StringBuilder buf = new StringBuilder();

        int sumLen = 0;
        for (int len : columnLen) {
            sumLen += len;
        }
        if (printHeader)
            buf.append("|").append(printChar('=', sumLen + margin * 2 * column + (column - 1))).append("|\n");
        else
            buf.append("|").append(printChar('-', sumLen + margin * 2 * column + (column - 1))).append("|\n");
        for (int ii = 0; ii < rows.size(); ii++) {
            List row = rows.get(ii);
            for (int i = 0; i < column; i++) {
                String o = "";
                if (i < row.size())
                    o = row.get(i).toString();
                buf.append('|').append(printChar(' ', margin)).append(o);
                buf.append(printChar(' ', columnLen[i] - o.getBytes().length + margin));
            }
            buf.append("|\n");
            if (printHeader && ii == 0)
                buf.append("|").append(printChar('=', sumLen + margin * 2 * column + (column - 1))).append("|\n");
            else
                buf.append("|").append(printChar('-', sumLen + margin * 2 * column + (column - 1))).append("|\n");
        }
        return buf.toString();
    }

    private String printChar(char c, int len) {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < len; i++) {
            buf.append(c);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        ConsoleTable t = new ConsoleTable(8, true);
        t.appendRow();
        t.appendColumn("id")
                .appendColumn("brand")
                .appendColumn("style")
                .appendColumn("color")
                .appendColumn("size")
                .appendColumn("num")
                .appendColumn("price")
                .appendColumn("description");


        System.out.println(t.toString());
    }

}
