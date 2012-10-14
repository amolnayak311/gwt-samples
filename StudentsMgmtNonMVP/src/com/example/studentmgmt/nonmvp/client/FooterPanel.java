/**
 * 
 */
package com.example.studentmgmt.nonmvp.client;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.LayoutPanel;

/**
 * @author Amol
 * 
 */
public class FooterPanel extends Composite {

	public FooterPanel() {
		HTML footer = new HTML("Some Footer text");
		LayoutPanel panel = new LayoutPanel();
		panel.add(footer);
		panel.setWidgetTopBottom(footer, 10, Unit.PCT, 10, Unit.PCT);
		panel.setWidgetLeftRight(footer, 1, Unit.PCT, 1, Unit.PCT);
		initWidget(panel);
	}
}
