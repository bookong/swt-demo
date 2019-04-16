package net.bookong.demo.swt.gef;

import org.eclipse.draw2d.ButtonGroup;
import org.eclipse.draw2d.ButtonModel;
import org.eclipse.draw2d.ChangeEvent;
import org.eclipse.draw2d.ChangeListener;
import org.eclipse.draw2d.CheckBox;
import org.eclipse.draw2d.Clickable;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.ToggleModel;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * @author jiangxu
 * @see https://blog.csdn.net/niujiabinbin/article/details/51302847
 */
public class Draw2D_example {

    public static void main(String args[]) {
        final Label label = new Label("Press a button!");
        Shell shell = new Shell();

        LightweightSystem lws = new LightweightSystem(shell);
        Figure parent = new Figure();
        parent.setLayoutManager(new XYLayout());
        lws.setContents(parent);

        Clickable above = new CheckBox("I'm above!");
        parent.add(above, new Rectangle(10, 10, 80, 20));
        ButtonModel aModel = new ToggleModel();
        aModel.addChangeListener(new ChangeListener() {

            public void handleStateChanged(ChangeEvent e) {
                label.setText("Above");
            }
        });
        above.setModel(aModel);

        Clickable below = new CheckBox("I'm below!");
        parent.add(below, new Rectangle(10, 40, 80, 20));
        ButtonModel bModel = new ToggleModel();
        bModel.addChangeListener(new ChangeListener() {

            public void handleStateChanged(ChangeEvent e) {
                label.setText("Below");
            }
        });
        below.setModel(bModel);

        ButtonGroup bGroup = new ButtonGroup();
        bGroup.add(aModel);
        bGroup.add(bModel);
        bGroup.setDefault(bModel);

        parent.add(label, new Rectangle(10, 70, 80, 20));
        shell.setSize(130, 120);
        shell.open();
        shell.setText("Example");
        Display display = Display.getDefault();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) display.sleep();
        }
    }
}
