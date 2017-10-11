package shapelang.actions.handlers;

import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import shapelangauge.Block;
import shapelangauge.Circle;
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
			// Object obj = structuredselection.getFirstElement();
			if (structuredselection.size() == 1) {
				Iterator it = structuredselection.iterator();
				while (it.hasNext()) {
					Object obj = it.next();
					if (obj instanceof Block) {
						_blockCount++;

					} else if (obj instanceof RootBlock) {
						_rootCount++;
					} else if (obj instanceof Circle) {
						_circleCount++;
					} else if (obj instanceof Triangle) {
						_triangle_count++;
					}

				}
			}

		}
		String str = "";
		str.format("RootBlock=%d\nBlock=%d\nCircle=%d\nTriangle=%d\n", _blockCount, _rootCount, _circleCount,
				_triangle_count);
		MessageDialog.openInformation(window.getShell(), "Actions", str);

		return null;
	}

}
