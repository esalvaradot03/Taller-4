
import javax.swing.*;
import java.awt.*;

public class VentanaTop10 extends JDialog {
    
    private Top10 top10;
    private JList<RegistroTop10> listaTop10;

    public VentanaTop10(JFrame parent, Top10 top10) {
        super(parent, "Top 10 Puntuaciones", true);
        this.top10 = top10;
        
        setSize(300, 400);
        setLayout(new BorderLayout());
        
        // Create a custom renderer for the JList
        listaTop10 = new JList<>(top10.getRegistros().toArray(new RegistroTop10[0]));
        listaTop10.setCellRenderer(new Top10Renderer());
        
        add(new JScrollPane(listaTop10), BorderLayout.CENTER);
        
        setVisible(true);
    }

    // Custom renderer to display each Top10 entry
    private class Top10Renderer extends JLabel implements ListCellRenderer<RegistroTop10> {
        @Override
        public Component getListCellRendererComponent(JList<? extends RegistroTop10> list, RegistroTop10 registro, int index, boolean isSelected, boolean cellHasFocus) {
            setText((index + 1) + ". " + registro.getNombre() + " - " + registro.getPuntos() + " puntos");
            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }
            setOpaque(true);
            return this;
        }
    }
}
