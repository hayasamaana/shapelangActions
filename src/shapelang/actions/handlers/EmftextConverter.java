package shapelang.actions.handlers;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import shapelangauge.resource.shapelanguage.mopp.ShapelanguageResourceFactory;


public class EmftextConverter {

	public void convert(final IFile ifile) {
		// TODO Auto-generated method stub
		String location=ifile.getFullPath().toString();
		File file=new File(location);
		
		
		//=================
		//register XMI resource factory for all other extensions
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
		.put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		// Then you can load and save resources in the different 
		 // formats using a resource set:
		ResourceSet rs=new ResourceSetImpl();
		
		String extension=ifile.getFileExtension();
		
		
		//register extesntion
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
		.put(extension, new ShapelanguageResourceFactory());
		
		
		String pathWithoutExtension=location.substring(0,location.lastIndexOf('.'));
		// target .ecore
		//create an empty ecore resource 
		Resource target = rs.createResource(
		     URI.createURI(pathWithoutExtension+extension +".ecore"));
		// source .shapelanguage
		Resource source=rs.getResource(URI.createURI(location), true);
   
      // convert .shapelanguage to .ecore  
        target.getContents().addAll(source.getContents());
      //save the dsl resource (this will automatically use the shapeLanguage Printer)
        try {
			target.save(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
