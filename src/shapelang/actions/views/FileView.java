package shapelang.actions.views;


import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.*;

import shapelangauge.Block;

import org.eclipse.jface.viewers.*;
import org.eclipse.swt.graphics.Image;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.*;
import org.eclipse.ui.internal.dialogs.ViewLabelProvider;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import javax.inject.Inject;


/**
 * This sample class demonstrates how to plug-in a new
 * workbench view. The view shows data obtained from the
 * model. The sample creates a dummy model on the fly,
 * but a real implementation would connect to the model
 * available either in this or another plug-in (e.g. the workspace).
 * The view is connected to the model using a content provider.
 * <p>
 * The view uses a label provider to define how model
 * objects should be presented in the view. Each
 * view can present the same model objects using
 * different labels and icons, if needed. Alternatively,
 * a single label provider can be shared between views
 * in order to ensure that objects of the same type are
 * presented in the same way everywhere.
 * <p>
 */

public class FileView extends ViewPart implements ISelectionListener {

	
	
	private TableViewer viewer;
	
	
	@Override
	public void createPartControl(Composite parent) {
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
        // since data provider is array we need to support it with array
		viewer.setContentProvider(ArrayContentProvider.getInstance());
		
		viewer.setLabelProvider(new LabelProvider());

		// add this view to the global selection listener
		getSite().getPage().addSelectionListener(this);
		//initilize the view with current selection
	   selectionChanged(null, 	getSite().getPage().getSelection());
	
	}

	
	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// TODO Auto-generated method stub
		viewer.setInput(getFileExtension(selection));
		
		
	}


	private String[] getFileExtension(ISelection selection) {
		// TODO Auto-generated method stub
		String ext[]=new String[2];
		ext[0]="The file extension is";
		ext[1]="";
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredselection = (IStructuredSelection) selection;
			if (!structuredselection.isEmpty()) {
			   Object obj = structuredselection.getFirstElement();
					if (obj instanceof IFile) { 
						String s=((IFile)obj).getFileExtension();
						if(s.equalsIgnoreCase("shapelangauge")) {
								ext[0]+=" shape language model";
						}
						
					}
					
		
	        }
      }
		return ext;
	}
}
