package codigo;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import static java.awt.Component.RIGHT_ALIGNMENT;

public class calculadora extends JFrame {
    private JPanel p1, pResult,pBotones;
    private JLabel bSalir,bMinimizar,lResultado,lOperado,lTitulo;
    private JButton boton[] = new JButton[35];
    int xx,xy;
    public calculadora(){
        this.setSize(420,685);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));

        paneles();
        pack();
        setVisible(true);


    }
    public void paneles(){
        p1= new JPanel();
        p1.setBackground(new Color(50, 50, 50));
        p1.setSize(420,40);
        p1.setLayout(new BoxLayout(p1,BoxLayout.LINE_AXIS));            //Se alineara de manera horizontal
        p1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT); //Indica q se alinee de derecha a izq
        p1.setPreferredSize(new Dimension(420,40));
        p1.setMinimumSize(new Dimension(420,40));
        p1.setMaximumSize(new Dimension(420,40));
        panelSup();
        this.add(p1);

        pResult = new JPanel();
        pResult.setBackground(new Color(81, 82, 82));
        pResult.setSize(420,100);
        pResult.setLayout(null);

        pResult.setPreferredSize(new Dimension(420,100));
        pResult.setMinimumSize(new Dimension(420,100));
        pResult.setMaximumSize(new Dimension(420,100));
        panelResultado();
        this.add(pResult);

        pBotones = new JPanel();
        pBotones.setBackground(new Color(52, 52, 52));
        pBotones.setSize(420,445);
        pBotones.setPreferredSize(new Dimension(420,445));
        pBotones.setMinimumSize(new Dimension(420,445));
        pBotones.setMaximumSize(new Dimension(420,445));

        panelBotones();
        this.add(pBotones);


    }
    public void panelSup(){
        bSalir= new JLabel();
        bSalir.setSize(29,30);
        bSalir.setLocation(385,5);
        bSalir.setIcon(new ImageIcon("src/imagenes/salir.png"));
        p1.add(bSalir);
        bMinimizar= new JLabel();
        bMinimizar.setSize(29,30);
        bMinimizar.setLocation(351,5);
        bMinimizar.setIcon(new ImageIcon("src/imagenes/minim.png"));
        p1.add(bMinimizar);
        bMinimizar.setVisible(true);
        bSalir.setVisible(true);
        lTitulo = new JLabel("Calculadora - Kioshi Okamoto                      ");
        lTitulo.setSize(300,30);
        p1.add(lTitulo);
        lTitulo.setVisible(true);
        lTitulo.setFont(new Font("Gotham",Font.PLAIN,18));
        lTitulo.setForeground(new Color(161, 162, 163));

        bSalir.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                bSalir.setIcon(new ImageIcon("src/imagenes/salirPressed.png"));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                bSalir.setIcon(new ImageIcon("src/imagenes/salir.png"));
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
                bSalir.setIcon(new ImageIcon("src/imagenes/salir.png"));
            }
        });
        bMinimizar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setExtendedState(JFrame.ICONIFIED);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                bMinimizar.setIcon(new ImageIcon("src/imagenes/minimPressed.png"));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                bMinimizar.setIcon(new ImageIcon("src/imagenes/minim.png"));
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
                bMinimizar.setIcon(new ImageIcon("src/imagenes/minim.png"));
            }
        });
        p1.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                xx=e.getX();
                xy=e.getY();
            }
        });
        p1.addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                setLocation(x-xx,y-xy);
            }
        });
    }
    public void panelResultado(){
        lOperado = new JLabel("TEST");
        pResult.add(lOperado);
        lOperado.setBounds(270,20,130,24);
        lOperado.setHorizontalAlignment(SwingConstants.RIGHT);
        lOperado.setFont(new Font("Gotham",Font.PLAIN,24));
        lOperado.setForeground(new Color(161, 162, 163));

        lResultado = new JLabel("TEST");
        pResult.add(lResultado);
        lResultado.setBounds(270,45,130,36);
        lResultado.setHorizontalAlignment(SwingConstants.RIGHT);
        lResultado.setFont(new Font("Gotham",Font.BOLD,36));
        lResultado.setForeground(new Color(223, 224, 224));

    }
    public void panelBotones(){
        pBotones.setLayout(new GridLayout(7,5));
        creaBotones();
        for(int i=0;i<boton.length;i++){
            pBotones.add(boton[i]);

        }
        
    }
    public void creaBotones(){
        for(int i=0; i<boton.length;i++){
            boton[i]=new JButton();
            boton[i].setBackground(new Color(51, 51, 51));
            boton[i].setFont(new Font("Gotham",Font.PLAIN,18));
            boton[i].setForeground(new Color(223, 224, 224));
            boton[i].setFocusable(true);
            boton[i].setBorder(BorderFactory.createLineBorder(new Color(73, 73, 73)));
            if(i>=16 && i<=18 || i>=21 && i<=23 || i>=26 && i<=28){
                boton[i].setBackground(new Color(38, 38, 39));
            }
        }
        boton[0].setText("2do");
        boton[1].setText("π");
        boton[2].setText("e");
        boton[3].setText("C");
        boton[4].setText("<-");
        boton[5].setText("x^2");
        boton[6].setText("1/x");
        boton[7].setText("|x|");
        boton[8].setText("exp");
        boton[9].setText("mod");
        boton[10].setText("x^3");
        boton[11].setText("(");
        boton[12].setText(")");
        boton[13].setText("n!");
        boton[14].setText("/");
        boton[15].setText("x^y");
        boton[16].setText("7");
        boton[17].setText("8");
        boton[18].setText("9");
        boton[19].setText("x");
        boton[20].setText("10^x");
        boton[21].setText("4");
        boton[22].setText("5");
        boton[23].setText("6");
        boton[24].setText("-");
        boton[25].setText("log");
        boton[26].setText("1");
        boton[27].setText("2");
        boton[28].setText("3");
        boton[29].setText("+");
        boton[30].setText("ln");
        boton[31].setText("+/-");
        boton[32].setText("0");
        boton[33].setText(".");
        boton[34].setText("=");
    }


}
