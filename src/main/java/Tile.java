import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;

public class Tile extends Box {
    
    public Tile(int scaledSize) {
        super(BoxLayout.X_AXIS);
        this.setSize(scaledSize, scaledSize);
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        this.setBackground(Color.WHITE);
        this.setVisible(true);
    }
}
