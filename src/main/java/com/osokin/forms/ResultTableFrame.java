package com.osokin.forms;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class ResultTableFrame extends JFrame {

    public ResultTableFrame(String[][] reportArr) {

        JFrame form = new JFrame("Отчет");
        JTable table = creatingTable(reportArr);
        formSettings(form);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder("Data:"));
        panel.setPreferredSize(new Dimension(600, 100));
        table.setBackground(panel.getBackground());
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
        form.add(panel);
        form.pack();
        form.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        form.setVisible(true);
    }

    private void formSettings(JFrame form) {
        form.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        form.setSize(500, 500);
        form.setLocationRelativeTo(null);
    }

    public JTable creatingTable(String[][] reportArr) {
        final String[][] Data = reportArr;
         return new JTable(new AbstractTableModel() {
            public int getRowCount() {
                return Data.length;
            }

            public int getColumnCount() {
                return Data[0].length;
            }

            public Object getValueAt(int rowIndex, int columnIndex) {
                return Data[rowIndex][columnIndex];
            }
        });

    }
}
