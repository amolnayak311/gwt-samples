/**
 * 
 */
package com.example.studentmgmt.nonmvp.client;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.DockLayoutPanel;

/**
 * @author Amol
 *
 */
public class MainPanel extends DockLayoutPanel {

	public MainPanel() {
		super(Unit.EM);		
		addNorth(new HeaderPanel(), 5);		
		addSouth(new FooterPanel(), 2);
		addWest(new MenuPanel(), 15);
		add(new AddStudentPanel());		
	}
}
