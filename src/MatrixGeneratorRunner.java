import javax.swing.*;

public class MatrixGeneratorRunner {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      JFrame f = new JFrame("MatrixGenerator");
      MatrixGenerator p = new MatrixGenerator();
      f.add(p);
      f.pack();
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setVisible(true);
    });
  }
}
