
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame {
    
    private Tablero tablero;
    private Top10 top10;
    private JComboBox<String> comboTamanos;
    private JTextField campoNombre;
    private JButton btnIniciar;
    private JButton btnTop10;
    private PanelTablero panelTablero;

    public VentanaPrincipal() {
        super("Lights Out");
        
        // Window setup
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize game logic classes
        tablero = new Tablero();
        top10 = new Top10();

        // Components for the top (North)
        JPanel panelNorte = new JPanel();
        comboTamanos = new JComboBox<>(new String[]{"3x3", "4x4", "5x5"});
        campoNombre = new JTextField(10);
        btnIniciar = new JButton("Iniciar");
        btnTop10 = new JButton("Top 10");
        
        btnIniciar.addActionListener(e -> iniciarJuego());
        btnTop10.addActionListener(e -> mostrarTop10());
        
        panelNorte.add(new JLabel("Tamaño: "));
        panelNorte.add(comboTamanos);
        panelNorte.add(new JLabel("Nombre: "));
        panelNorte.add(campoNombre);
        panelNorte.add(btnIniciar);
        panelNorte.add(btnTop10);
        
        add(panelNorte, BorderLayout.NORTH);

        // Panel for the game board (Center)
        panelTablero = new PanelTablero(tablero);
        add(panelTablero, BorderLayout.CENTER);

        setVisible(true);
    }

    private void iniciarJuego() {
        // TODO: Implement game start logic
    }
    
    private void mostrarTop10() {
        // TODO: Show the Top10 window
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaPrincipal());
    }
}
