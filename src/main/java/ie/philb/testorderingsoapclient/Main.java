/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.philb.testorderingsoapclient;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import ie.philb.testorderingsoapclient.ui.MainFrame;
import ie.philb.testorderingsoapclient.ws.ServiceException_Exception;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author philb
 */
public class Main {

    public Main() {
    }

    public void run() throws ServiceException_Exception {
        Application app = Application.getApplication();

    }

    public static void main(String[] args)  {
        
        try {
            UIManager.setLookAndFeel(new WindowsLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
