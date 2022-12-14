package com.osokin.forms;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;


public class FileNotFoundForm extends JFrame {
    private JPanel panel1;
    private JLabel messageLabel;

    public FileNotFoundForm() {
        setContentPane(panel1);
        setTitle("Ошибка");
        setSize(500, 150);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        messageLabel = new JLabel();
        messageLabel.setText("Ошибка! Файл с таким названием не найден! Введите корректный путь к файлу.");
        panel1.add(messageLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }

}
