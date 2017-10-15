package shapelang.actions.handlers;

import java.io.File;
import java.io.IOException;
import java.rmi.registry.Registry;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import langsrc.*;
import shapelangauge.impl.ShapelangaugeFactoryImpl;
import shapelangauge.resource.shapelanguage.mopp.ShapelanguageResourceFactory;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class ResourceRegisterHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		
		// Get the selected resource (file)
		Object element = ((IStructuredSelection) window
				.getSelectionService().getSelection()).getFirstElement();
		IFile ifile = Platform.getAdapterManager().getAdapter(element, IFile.class);
		// Perform the transformation
		
		EmftextConverter emfconv= new EmftextConverter();
		emfconv.convert(ifile);
		return null;
	}

	
}
