package codigo;

import javax.swing.*;

public class main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {

                calculadora c1 = new calculadora();


            }

        });
    }
}


