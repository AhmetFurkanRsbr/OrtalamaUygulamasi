import javax.swing.*;
import java.awt.*;

public class TamEkran {
    TamEkran(JFrame window, boolean isTamEkranyap){

        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();

        if(isTamEkranyap){
            device.setFullScreenWindow(window);
        }else {
            device.setFullScreenWindow(null);
            window.setSize(1600,1400);
            window.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - window.getSize().width )/2,(Toolkit.getDefaultToolkit().getScreenSize().height - window.getSize().height )/2);

        }

    }
}
