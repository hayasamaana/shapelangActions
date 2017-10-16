package shapelang.actions.handlers;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;

public class RegisterMetaModeel {

	public RegisterMetaModeel(File file) {
		// TODO Auto-generated constructor stub
		URI uri = URI.createFileURI(file.getPath());
		// MessageDialog.openInformation(null, "", uri + "");
		ResourceSet rs = new ResourceSetImpl();
		Resource source = rs.getResource(uri, true);
		EObject mypackage = source.getContents().get(0);
		if (mypackage.eClass().getName().equals("EPackage")) {

		}
		MessageDialog.openInformation(null, "", source.getContents().get(0).toString() + "");

	}

}
