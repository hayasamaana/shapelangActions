package shapelang.actions.handlers;

import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import shapelangauge.Block;
import shapelangauge.Circle;
import shapelangauge.ModelElement;
import shapelangauge.RootBlock;
import shapelangauge.Triangle;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class CountHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		ISelection selection = window.getActivePage().getSelection();
		int _blockCount = 0, _rootCount = 0, _circleCount = 0, _triangle_count = 0;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredselection = (IStructuredSelection) selection;
			if (structuredselection.size() == 1) {
			   Object obj = structuredselection.getFirstElement();
					if (obj instanceof Block) {
						EList<ModelElement> list=((Block) obj).getModelElements();
						//MessageDialog.openInformation(null, "", list.size()+"");
					      for(ModelElement e: list) {
					    	 
					    	  if (e instanceof Circle) {
					    		  _circleCount++;
					    	  }
					    	  else if (e instanceof Triangle) {
									_triangle_count++;
					    		  
					    	  }
					    	  else if (e instanceof RootBlock) {
									_rootCount++;
								}
					    	  else if (obj instanceof Block) {
					    		  _blockCount++;
								}
					      }
					      
					 }
					    	  
		}
		}
		String str = "Circle="+_circleCount+"\n"+"Triangle="+_triangle_count+"\n+Block="+_blockCount+"\nRootBlock="+_rootCount;
	    MessageDialog.openInformation(null, "Result", str );
		
		return null;
	}
	

}
