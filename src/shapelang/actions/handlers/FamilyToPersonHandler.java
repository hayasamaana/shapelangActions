package shapelang.actions.handlers;
import java.io.File;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import shapelang.ATL.FamilyPerson;


public class FamilyToPersonHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO Auto-generated method stub
		// Get the active window
		IWorkbenchWindow window =
				HandlerUtil.getActiveWorkbenchWindowChecked(event);

		// Get the selected resource (file)
		Object element = ((IStructuredSelection) window
				.getSelectionService().getSelection()).getFirstElement();
		IFile file = Platform.getAdapterManager()
				.getAdapter(element, IFile.class);

		// Perform the transformation
		String targetFile;
		File _file=new File(file.getFullPath().toOSString());
		
		targetFile=new FamilyPerson().runTransformation(_file);
		
		// Refresth the Project Explorer to show the new file
				try {
					((IResource) element).getProject()
							.refreshLocal(IResource.DEPTH_INFINITE, null);
				} catch (CoreException e) {
					e.printStackTrace();
				}
		return null;
		
	}

	
}
