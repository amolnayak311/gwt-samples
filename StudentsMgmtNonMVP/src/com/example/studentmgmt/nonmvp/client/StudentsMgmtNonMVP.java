/**
 * 
 */
package com.example.studentmgmt.nonmvp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * The entry point of the application
 * @author Amol
 *
 */
public class StudentsMgmtNonMVP implements EntryPoint {

	/* (non-Javadoc)
	 * @see com.google.gwt.core.client.EntryPoint#onModuleLoad()
	 */
	@Override
	public void onModuleLoad() {			
		RootLayoutPanel.get().add(new MainPanel());		
	}

}
