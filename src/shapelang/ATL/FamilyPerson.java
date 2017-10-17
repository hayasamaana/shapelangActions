package shapelang.ATL;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.dialogs.MessageDialog;

import families.impl.FamilyImpl;
import shapelang.actions.handlers.RegisterMetaModeel;
import shapelanguage.ATL.files.FamilyToPerson;


public class FamilyPerson {

	public static String runTransformation(File _file) {
		// TODO Auto-generated method stub
		URI uri=URI.createFileURI(_file.getPath());
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
		.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
				new XMIResourceFactoryImpl());

		
		// Then you can load and save resources in the different
		// formats using a resource set:
		ResourceSet rs = new ResourceSetImpl();

		// Load xmi resource
		Resource resource = rs.getResource(uri, true);
		     EObject obj= resource.getContents().get(0);
		     if(obj instanceof FamilyImpl) {
		    	 
		    	//new  RegisterMetaModeel(new File(uri.toString()));
		    	// Generate the target filename
					final String targetFile =uri.toString().substring(0,uri.toString().lastIndexOf('.'))+"person.ecore";
		            // call atl transformation
					MessageDialog.openInformation(null, "", targetFile);
					// uri represent input model as xmi
					FamilyToPerson.main(new String[] {uri.toString(),targetFile});
		 		 return targetFile;
		     }

		return null;
	}

}
