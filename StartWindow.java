import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

class ImagePanel extends JPanel {
    private ImageIcon backgroundIcon;

    public ImagePanel() {
        try {
            backgroundIcon = new ImageIcon(ImageIO.read(this.getClass().getResource("background.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Vẽ hình nền kích thước thực tế của cửa sổ
        g.drawImage(backgroundIcon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }
}

public class StartWindow extends JFrame {

    public StartWindow() {
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream("Roboto-Regular.ttf")));
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        // Tạo ImagePanel để chứa cả hình nền và logo
        ImagePanel imagePanel = new ImagePanel();
        imagePanel.setLayout(new BorderLayout());

        // Thêm logo vào phía trên của ImagePanel
        ImageIcon logo = new ImageIcon();
        try {
            BufferedImage originalImage = ImageIO.read(this.getClass().getResource("logo.png"));
            int newWidth = 325; // Kích thước mới cho logo
            int newHeight = (int) ((double) originalImage.getHeight() / originalImage.getWidth() * newWidth);
            Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
            logo = new ImageIcon(scaledImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        imagePanel.add(new JLabel(logo), BorderLayout.NORTH);

        // Thêm nút vào phía dưới của ImagePanel
        JPanel buttonsC = new JPanel();
        buttonsC.setLayout(new BoxLayout(buttonsC, BoxLayout.Y_AXIS));
        FansyButton startButton = new FansyButton("Start Game");
        FansyButton mini = new FansyButton("Whack a mole");
        FansyButton exit = new FansyButton("Exit");

        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mini.setAlignmentX(Component.CENTER_ALIGNMENT);
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Menu("Game beta");
                dispose();
            }
        });

        mini.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Whack();
                dispose();
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttonsC.add(Box.createVerticalGlue()); // Giữ chỗ trống ở đầu
        buttonsC.add(startButton);
        buttonsC.add(mini);
        buttonsC.add(exit);
        buttonsC.add(Box.createVerticalGlue()); // Giữ chỗ trống ở cuối

        imagePanel.add(buttonsC, BorderLayout.SOUTH);

        // Đặt ImagePanel làm nội dung chính của cửa sổ
        setContentPane(imagePanel);

        System.out.print('\n');
        System.out.println("Minesweepers Game");
        System.out.println("-----------------------------------------");
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StartWindow());
    }
}
