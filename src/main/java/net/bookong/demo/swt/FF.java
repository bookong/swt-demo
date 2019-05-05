package net.bookong.demo.swt;

import org.eclipse.swt.widgets.Composite;


public class FF extends Composite {

    /**
     * Create the composite.
     * @param parent
     * @param style
     */
    public FF(Composite parent, int style){
        super(parent, style);

    }

    @Override
    protected void checkSubclass() {
        // Disable the check that prevents subclassing of SWT components
    }

}
