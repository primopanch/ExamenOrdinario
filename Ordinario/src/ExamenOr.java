import java.awt.*;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class ExamenOr extends JFrame {

    public ExamenOr() {
        setTitle("Ordinario");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JMenuBar barraMenu = new JMenuBar();
        barraMenu.add(new JMenu("Archivo"));
        barraMenu.add(new JMenu("Ayuda"));
        setJMenuBar(barraMenu);

        JToolBar barraHerr = new JToolBar();
        barraHerr.setFloatable(false);
        barraHerr.add(new JButton("Nueva Actividad"));
        barraHerr.add(new JButton("Abrir Contrato"));
        add(barraHerr, BorderLayout.NORTH);

        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Multiplan");
        
        DefaultMutableTreeNode acc = new DefaultMutableTreeNode("Acciones");
        acc.add(new DefaultMutableTreeNode("Acciones Programadas"));
        acc.add(new DefaultMutableTreeNode("Acciones Cerradas"));
        
        DefaultMutableTreeNode contr = new DefaultMutableTreeNode("Contratos");
        contr.add(new DefaultMutableTreeNode("Contratos No Agrupados"));
        
        DefaultMutableTreeNode grps = new DefaultMutableTreeNode("Grupos");
        grps.add(new DefaultMutableTreeNode("AA"));
        grps.add(new DefaultMutableTreeNode("AB"));

        raiz.add(acc);
        raiz.add(contr);
        raiz.add(grps);

        JTree arbol = new JTree(raiz);
        JScrollPane scrollArbol = new JScrollPane(arbol);

        String[] columnas = {"No", "Nombre", "Mes", "Estado"};
        String[][] datos = {
            {"1", "Ejemplo Nombre 1", "6", "CERRADO"},
            {"2", "Ejemplo Nombre 2", "25", "CERRADO"},
            {"3", "Ejemplo Nombre 3", "18", "CERRADO"},
            {"4", "Ejemplo Nombre 4", "22", "RECIBIDO"}
        };
        JTable tabla = new JTable(datos, columnas);
        JScrollPane scrollTabla = new JScrollPane(tabla);

        JTabbedPane pest = new JTabbedPane();
        
        JPanel panelDet = new JPanel(new BorderLayout());
        
        JPanel panelForm = new JPanel(new GridLayout(2, 1, 5, 5));
        
        JPanel f1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        f1.add(new JLabel("Contrato #:"));
        f1.add(new JTextField("288/1", 10));
        f1.add(new JLabel("Fecha Firma:"));
        f1.add(new JTextField("29-06-2000", 10));
        f1.add(new JLabel("Estado:"));
        f1.add(new JTextField("CERRADO", 10));
        
        JPanel f2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        f2.add(new JLabel("Tipo:"));
        f2.add(new JComboBox<>(new String[]{"Opción 1", "Opción 2"}));
        f2.add(new JLabel("Importancia:"));
        f2.add(new JComboBox<>(new String[]{"Alta", "Media", "Baja"}));
        
        panelForm.add(f1);
        panelForm.add(f2);
        
        JTextArea areaDesc = new JTextArea("El atributo de versión se refiere, por defecto,\na una revisión particular de la plataforma Java 2...");
        JScrollPane scrollDesc = new JScrollPane(areaDesc);
        scrollDesc.setBorder(BorderFactory.createTitledBorder("Descripción"));

        panelDet.add(panelForm, BorderLayout.NORTH);
        panelDet.add(scrollDesc, BorderLayout.CENTER);

        pest.addTab("Detalles", panelDet);
        pest.addTab("Actividades", new JPanel());
        pest.addTab("Acciones", new JPanel());

        JSplitPane splitDerecho = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scrollTabla, pest);
        splitDerecho.setDividerLocation(200);

        JSplitPane splitPrincipal = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollArbol, splitDerecho);
        splitPrincipal.setDividerLocation(200);

        add(splitPrincipal, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ExamenOr ventana = new ExamenOr();
            ventana.setVisible(true);
        });
    }
}