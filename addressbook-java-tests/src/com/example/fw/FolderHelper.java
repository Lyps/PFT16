package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.netbeans.jemmy.operators.*;

public class FolderHelper extends HelperBase {	
	
	public FolderHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}
	
	public Folders getFolders() {	
		List<String> list = new ArrayList<String>();
		JTreeOperator tree = new JTreeOperator(mainFrame);
		Object[] children = tree.getChildren(tree.getRoot());
		for (Object child : children) {
			list.add("" + child);
		}
		return new Folders(list);
	}	
	
	public String createFolder(String folderName) {
		manager.getMenuHelper().pushCreateFolder();
		JDialogOperator dialog = new JDialogOperator(mainFrame);
		new JTextFieldOperator(dialog).setText(folderName);
		new JButtonOperator(dialog,"OK").push();
		return waitMessageDialog("Warning", 3000);
	}
	
	public void deleteFolder(int index) {
		JTreeOperator tree = new JTreeOperator(mainFrame);
		List<String> childrenList = new ArrayList<String>();
		Object[] children = tree.getChildren(tree.getRoot());
		for (Object child : children) {
			childrenList.add("" + child);
		}
		manager.getToolBarHelper().pushDeleteElement();
		JDialogOperator dialog = new JDialogOperator(mainFrame);
		new JButtonOperator(dialog, "Yes").push();
	}

	public int getTreeSize() {
		JTreeOperator tree = new JTreeOperator(mainFrame);
		return tree.getChildCount(tree);
	}	

}
 