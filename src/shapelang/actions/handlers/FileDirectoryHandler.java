package shapelang.actions.handlers;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.internal.resources.Project;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.internal.IChangeListener;

import shapelangauge.Block;

@SuppressWarnings("restriction")
public class FileDirectoryHandler extends AbstractHandler implements IHandler,ISelectionListener {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO Auto-generated method stub
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		 window.getActivePage().addSelectionListener(this);
		 //register
		 selectionChanged(null,window.getActivePage().getSelection());
		
			   
		
		
		return null;
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// TODO Auto-generated method stub
		MessageDialog.openInformation(null, "title", getFileExtension(selection));
		
	}
	private String getFileExtension(ISelection selection) {
		// TODO Auto-generated method 
		String st="The file extension is";
		
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredselection = (IStructuredSelection) selection;
			if (!structuredselection.isEmpty()) {
			   Object obj = structuredselection.getFirstElement();
					if (obj instanceof IFile) { 
						String s=((IFile)obj).getFileExtension();
						if(s!=null) {
						  if(s.equalsIgnoreCase("shapelangauge")) {
								st+=" shape language model";
						   }
						}
						
						
					}
					
						else {
							st+=" Unknown!!!";
						}
					
					
		
	        }
      }
		return st;
	}

	
}
