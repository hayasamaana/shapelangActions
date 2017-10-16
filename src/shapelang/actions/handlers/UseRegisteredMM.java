package shapelang.actions.handlers;

import java.io.File;
import java.io.ObjectInputStream.GetField;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.activities.WorkbenchActivityHelper;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.ui.part.ViewPart;

import shapelangauge.resource.shapelanguage.mopp.ShapelanguageResourceFactory;

public class UseRegisteredMM   {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		new UseRegisteredMM();
	
		ResourceSet rs = new ResourceSetImpl();
		//rs.getResourceFactoryRegistry().getExtensionToFactoryMap()
		//.put("shapelanguage", new ShapelanguageResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
		.put("ecore", new EcoreResourceFactoryImpl());
		
		
		URI uri=URI.createFileURI("C:\\Users\\haya\\git\\shapelangActions\\src\\shapelang\\actions\\handlers\\a.shapelanguage");
		//System.out.println(uri);
		
		Resource res=rs.getResource(uri,true);
		Iterator<EObject> i = res.getAllContents();
		while (i.hasNext()) {
			Object o = i.next();
			System.out.println(o);
		}
		
	}

	
}
