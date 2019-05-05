package net.bookong.demo.swt;

import org.eclipse.jface.wizard.Wizard;


public class XV extends Wizard {

    public XV(){
        setWindowTitle("New Wizard");
    }

    @Override
    public void addPages() {
        addPage(new XX());
    }

    @Override
    public boolean performFinish() {
        return false;
    }

}
