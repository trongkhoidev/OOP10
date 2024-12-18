package nguyentrongkhoi_5867.Exercise3;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Bidding extends JFrame {
    private double initNumber = 0.0; // Số ban đầu (số thực)
    private double finalNumber = 0.0; // Số sau khi random (số thực)
    private int balance = 100; // Số tiền mặc định
    private JLabel balanceDisplay; // Hiển thị số dư (Balance)
    private JLabel numberDisplay; // Hiển thị số hiện tại hoặc đếm ngược trong vòng tròn
    private JLabel resultDisplay; // Hiển thị kết quả thắng/thua
    private JTextField betAmountInput; // Ô nhập tiền cược
    private JButton increaseButton, decreaseButton, historyButton; // Nút UP, DOWN, và History
    private Timer countdownTimer, resultTimer; // Timer cho đếm ngược và ẩn kết quả
    private ArrayList<String[]> bettingHistory; // Danh sách lưu trữ lịch sử đặt cược
    private int historyIndex = 1; // Đếm số lượt đặt cược

    public Bidding() {
        // Thiết lập JFrame
        setTitle("Youth playground");
        setSize(450, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Lịch sử đặt cược
        bettingHistory = new ArrayList<>();

        // Hiển thị số dư
        balanceDisplay = new JLabel("Balance: " + balance, SwingConstants.LEFT);
        balanceDisplay.setFont(new Font("Arial", Font.BOLD, 18));
        balanceDisplay.setBounds(20, 10, 200, 30);
        add(balanceDisplay);

        // Nút History
        historyButton = new JButton("History");
        historyButton.setBounds(300, 10, 120, 30);
        customizeButton(historyButton);
        historyButton.addActionListener(e -> showBettingHistory());
        add(historyButton);

        // Hiển thị số trong vòng tròn
        numberDisplay = new JLabel(String.format("%.2f", initNumber), SwingConstants.CENTER) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int diameter = Math.min(getWidth(), getHeight()) - 10;
                int x = (getWidth() - diameter) / 2;
                int y = (getHeight() - diameter) / 2;

                g.setColor(Color.LIGHT_GRAY);
                g.fillOval(x, y, diameter, diameter);

                g.setColor(Color.BLACK);
                g.drawOval(x, y, diameter, diameter);

                g.setFont(new Font("Arial", Font.BOLD, 40));
                String text = getText();
                FontMetrics fm = g.getFontMetrics();
                int textWidth = fm.stringWidth(text);
                int textHeight = fm.getAscent();
                g.drawString(text, getWidth() / 2 - textWidth / 2, getHeight() / 2 + textHeight / 4);
            }
        };
        numberDisplay.setBounds(100, 50, 200, 200);
        add(numberDisplay);

        // Hiển thị kết quả thắng/thua
        resultDisplay = new JLabel("", SwingConstants.CENTER);
        resultDisplay.setFont(new Font("Arial", Font.BOLD, 24));
        resultDisplay.setOpaque(true);
        resultDisplay.setBounds(100, 250, 200, 50);
        add(resultDisplay);

        // Ô nhập tiền cược
        betAmountInput = new JTextField();
        betAmountInput.setFont(new Font("Arial", Font.PLAIN, 16));
        betAmountInput.setBounds(100, 320, 200, 30);
        betAmountInput.setHorizontalAlignment(SwingConstants.CENTER);
        betAmountInput.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkBetAmount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkBetAmount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkBetAmount();
            }
        });
        add(betAmountInput);

        // Nút Increase (UP)
        increaseButton = new JButton("UP");
        increaseButton.setBounds(50, 370, 120, 40);
        customizeButton(increaseButton);
        increaseButton.addActionListener(e -> processBet("UP"));
        add(increaseButton);

        // Nút Decrease (DOWN)
        decreaseButton = new JButton("DOWN");
        decreaseButton.setBounds(230, 370, 120, 40);
        customizeButton(decreaseButton);
        decreaseButton.addActionListener(e -> processBet("DOWN"));
        add(decreaseButton);
    }

    private void customizeButton(JButton button) {
        button.setBackground(new Color(255, 215, 0));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    }

    private void checkBetAmount() {
        try {
            int betAmount = Integer.parseInt(betAmountInput.getText());
            if (betAmount > balance || betAmount <= 0) {
                disableButtons();
            } else {
                enableButtons();
            }
        } catch (NumberFormatException e) {
            disableButtons();
        }
    }

    private void disableButtons() {
        increaseButton.setEnabled(false);
        decreaseButton.setEnabled(false);
    }

    private void enableButtons() {
        increaseButton.setEnabled(true);
        decreaseButton.setEnabled(true);
    }

    private void processBet(String choice) {
        int betAmount = Integer.parseInt(betAmountInput.getText());
        balance -= betAmount;
        balanceDisplay.setText("Balance: " + balance);
        startCountdown(choice, betAmount);
    }

    private void startCountdown(String choice, int betAmount) {
        increaseButton.setEnabled(false);
        decreaseButton.setEnabled(false);

        final int[] counter = {5};
        resultDisplay.setVisible(false);
        numberDisplay.setText(String.valueOf(counter[0]));

        countdownTimer = new Timer(1000, e -> {
            counter[0]--;
            if (counter[0] > 0) {
                numberDisplay.setText(String.valueOf(counter[0]));
            } else {
                countdownTimer.stop();
                playGame(choice, betAmount);
                enableButtons();
            }
        });
        countdownTimer.start();
    }

    private void playGame(String choice, int betAmount) {
        finalNumber = -10.0 + Math.random() * 20.0;
        String result;
        int moneyChange;

        if ((choice.equals("UP") && finalNumber > initNumber) ||
                (choice.equals("DOWN") && finalNumber < initNumber) ||
                (finalNumber == initNumber)) {
            result = "WIN";
            resultDisplay.setBackground(Color.GREEN);
            moneyChange = betAmount * 2;
            balance += moneyChange;
        } else {
            result = "LOSE";
            resultDisplay.setBackground(Color.RED);
            moneyChange = -betAmount;
        }

        bettingHistory.add(new String[]{
                String.valueOf(historyIndex++),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                String.valueOf(betAmount),
                result,
                choice.toUpperCase(),
                String.valueOf(moneyChange)
        });

        resultDisplay.setText(result);
        resultDisplay.setVisible(true);
        numberDisplay.setText(String.format("%.2f", finalNumber));
        balanceDisplay.setText("Balance: " + balance);

        initNumber = finalNumber;

        if (resultTimer != null) {
            resultTimer.stop();
        }
        resultTimer = new Timer(2000, e -> resultDisplay.setVisible(false));
        resultTimer.start();
    }

    private void showBettingHistory() {
        String[] columnNames = {"Index", "Time", "Bet Amount", "Status", "Choice", "Money"};
        String[][] data = bettingHistory.toArray(new String[0][]);

        JTable table = new JTable(new DefaultTableModel(data, columnNames)) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        TableColumn indexColumn = table.getColumnModel().getColumn(0);
        indexColumn.setMinWidth(50);
        indexColumn.setMaxWidth(70);
        indexColumn.setPreferredWidth(60);

        TableColumn timeColumn = table.getColumnModel().getColumn(1);
        timeColumn.setPreferredWidth(200);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setFont(new Font("Arial", Font.PLAIN, 14));

                if (column == 2 || column == 5) {
                    c.setForeground(new Color(255, 215, 0));
                } else if (column == 3) {
                    String status = (String) value;
                    c.setForeground(status.equals("WIN") ? Color.GREEN : Color.RED);
                } else {
                    c.setForeground(Color.BLACK);
                }
                return c;
            }
        });

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 14));
        header.setBackground(Color.LIGHT_GRAY);

        JScrollPane scrollPane = new JScrollPane(table);

        JDialog dialog = new JDialog(this, "History", true);
        dialog.setSize(800, 400);
        dialog.setLocationRelativeTo(this);
        dialog.add(scrollPane);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Bidding game = new Bidding();
            game.setVisible(true);
        });
    }
}
