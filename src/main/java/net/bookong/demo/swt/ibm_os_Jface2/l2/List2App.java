package net.bookong.demo.swt.ibm_os_Jface2.l2;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

/**
 * List Example
 *
 * @author barryf
 * @see https://www.ibm.com/developerworks/cn/opensource/os-jface2/
 */
public class List2App extends BasicApplication {

    protected List   list;
    protected CCombo combo;

    /**
     * Constructor.
     */
    public List2App(Shell shell, int style){
        super(shell, style); // must always supply parent and style
    }

    /** Configure the form of the container */
    protected static void configureLayout(Control c, FormAttachment left, FormAttachment top, FormAttachment right, FormAttachment bottom) {
        FormData fd = new FormData();
        if (left != null) {
            fd.left = left;
        }
        if (top != null) {
            fd.top = top;
        }
        if (right != null) {
            fd.right = right;
        }
        if (bottom != null) {
            fd.bottom = bottom;
        }
        c.setLayoutData(fd);
    }

    /** Allow subclasses to complete the GUI */
    protected void completeGui(String[] args) {
        setLayout(new FormLayout());

        CCombo c = createCombo(this);
        configureLayout(c, new FormAttachment(0, 5), new FormAttachment(0, 5), new FormAttachment(100, -5), null);

        List l = createList(this);
        configureLayout(l, new FormAttachment(0, 5), new FormAttachment(c, 5), new FormAttachment(100, -5), new FormAttachment(100, -5));
    }

    /** Create the Combo */
    protected CCombo createCombo(Composite parent) {
        combo = new CCombo(parent, SWT.FLAT | SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
        // combo = new CCombo(parent, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
        combo.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                String[] sel = list.getSelection();
                if (sel != null && sel.length > 0) {
                    System.out.println("Selection:");
                    for (int i = 0; i < sel.length; i++) {
                        System.out.println("   " + sel[i]);
                    }
                }
            }

            public void widgetDefaultSelected(SelectionEvent e) {
                widgetSelected(e);
            }
        });
        return combo;
    }

    /** Create the List */
    protected List createList(Composite parent) {
        list = new List(parent, SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
        list.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                String[] sel = list.getSelection();
                if (sel != null && sel.length > 0) {
                    System.out.println("Selection:");
                    for (int i = 0; i < sel.length; i++) {
                        System.out.println("   " + sel[i]);
                    }
                }
            }

            public void widgetDefaultSelected(SelectionEvent e) {
                widgetSelected(e);
            }
        });
        return list;
    }

    /** Set the Combo data model */
    public void setComboContents(String[] data) {
        combo.removeAll();
        for (int i = 0; i < data.length; i++) {
            combo.add(data[i]);
        }
    }

    /** Set the List data model */
    public void setListContents(String[] data) {
        list.removeAll();
        for (int i = 0; i < data.length; i++) {
            list.add(data[i]);
        }
    }

    /** Allow subclasses to initialize the GUI */
    protected void initGui() {
        String[] data = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8", "Item 9", "Item 10" };
        setListContents(data);
        setComboContents(data);
        displayTree(shell);
    }

    /** Main driver */
    public static void main(String[] args) {
        run(List2App.class.getName(), "List1App Example", SWT.NONE, 400, 300, args);
    }
}
