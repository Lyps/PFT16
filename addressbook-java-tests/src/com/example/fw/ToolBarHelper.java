package com.example.fw;

import org.netbeans.jemmy.operators.JButtonOperator;

public class ToolBarHelper extends HelperBase {
	public ToolBarHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}

	public void pushDeleteElement() {
		new JButtonOperator(mainFrame, 2).push();
	}

}