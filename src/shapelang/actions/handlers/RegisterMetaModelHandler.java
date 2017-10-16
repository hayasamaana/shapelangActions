package shapelang.actions.handlers;

import java.io.File;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

public class RegisterMetaModelHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO Auto-generated method stub
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);

		// Get the selected resource (file)
		Object element = ((IStructuredSelection) window.getSelectionService().getSelection()).getFirstElement();
		IFile ifile = Platform.getAdapterManager().getAdapter(element, IFile.class);
		// register Meta Model
		String location = ifile.getFullPath().toString();
		File file = new File(location);
		RegisterMetaModeel mm = new RegisterMetaModeel(file);
        
		return null;
	}

}
