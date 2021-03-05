import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class MyKeyListener_  implements KeyListener {


    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();

        if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}