
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelTablero extends JPanel implements MouseListener {
    
    private Tablero tablero;

    public PanelTablero(Tablero tablero) {
        this.tablero = tablero;
        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int rows = tablero.getFilas();
        int cols = tablero.getColumnas();
        int cellWidth = getWidth() / cols;
        int cellHeight = getHeight() / rows;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (tablero.estaEncendida(i, j)) {
                    g.setColor(Color.YELLOW);
                } else {
                    g.setColor(Color.GRAY);
                }
                g.fillRect(j * cellWidth, i * cellHeight, cellWidth, cellHeight);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = e.getY() / (getHeight() / tablero.getFilas());
        int col = e.getX() / (getWidth() / tablero.getColumnas());
        tablero.jugar(row, col);
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
