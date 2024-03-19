import javax.swing.*;

public class GUI extends JFrame {
    GUI (String title){
        super(title);
        guiComponent();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,600);
        setVisible(true);
    }

    void guiComponent(){
        add(new Pyramid());
    }


}
