/**
 * 
 */
package com.example.studentmgmt.nonmvp.client;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.StackLayoutPanel;

/**
 * @author Amol
 *
 */
public class MenuPanel extends StackLayoutPanel {

	public MenuPanel() {
		super(Unit.EM);
		add(new HTML("Stack One"), new HTML("Student Management"), 2);
		add(new HTML("No Reports Yet"), new HTML("Reports"), 2);
	}	
}

