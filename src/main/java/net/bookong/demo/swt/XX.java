package net.bookong.demo.swt;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;


public class XX extends WizardPage {

    /**
     * Create the wizard.
     */
    public XX(){
        super("wizardPage");
        setTitle("Wizard Page title");
        setDescription("Wizard Page description");
    }

    /**
     * Create contents of the wizard.
     * @param parent
     */
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);

        setControl(container);
    }

}
