package com.example.studentmgmt.nonmvp.client;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;

public class AddStudentPanel extends Composite {

	private final TextBox studentName;
	private final HTML studentNameLabel;

	private final HTML genderLabel;
	private final RadioButton maleGenderRB;
	private final RadioButton femaleGenderRB;

	private final HTML datePickerLabel;
	private final DateBox dateOfBirth;

	private final HTML classLabel;
	private ListBox classListBox;

	private final HTML subjectLabel;
	private final ListBox subjects;

	private final HTML extraClassesLabel;
	private final CheckBox extraClassesBox;

	private final HTML extraSubjectsLabel;
	private final ListBox extraSubjects;

	private final Button resetFields;
	private final Button submit;

	private final Map<String, String> subjectsMap = new HashMap<String, String>();

	public AddStudentPanel() {
		// initialize the subjects, get this from the cache or using RPC call

		subjectsMap.put("English", "1");
		subjectsMap.put("French", "2");
		subjectsMap.put("German", "3");
		subjectsMap.put("Mathematics", "4");
		subjectsMap.put("Chemistry", "5");
		subjectsMap.put("Physics", "6");
		subjectsMap.put("Biology", "7");
		subjectsMap.put("Computers", "8");
		subjectsMap.put("Social Science", "9");

		LayoutPanel layoutPanel = new LayoutPanel();
		FlexTable table = new FlexTable();
		table.setCellPadding(5);
		table.setCellSpacing(5);

		int columnCounter = 0;
		int rowCounter = 0;

		studentNameLabel = new HTML("Student Name:&nbsp;");
		table.setWidget(rowCounter, columnCounter++ % 2, studentNameLabel);

		studentName = new TextBox();
		studentName.setVisibleLength(50);
		table.setWidget(rowCounter++, columnCounter++ % 2, studentName);

		genderLabel = new HTML("Gender:&nbsp;");
		table.setWidget(rowCounter, columnCounter++ % 2, genderLabel);

		// Add a table to add the two radio buttons
		FlexTable genderRbtable = new FlexTable();
		genderRbtable.setCellPadding(2);
		genderRbtable.setCellSpacing(2);
		maleGenderRB = new RadioButton("gender", "Male&nbsp;", true);
		femaleGenderRB = new RadioButton("gender", "Female&nbsp;", true);
		genderRbtable.setWidget(0, 0, maleGenderRB);
		genderRbtable.setWidget(0, 1, femaleGenderRB);
		table.setWidget(rowCounter++, columnCounter++ % 2, genderRbtable);

		datePickerLabel = new HTML("Date Of Birth:&nbsp;");
		table.setWidget(rowCounter, columnCounter++ % 2, datePickerLabel);

		dateOfBirth = new DateBox();
		dateOfBirth.setFormat(new DateBox.DefaultFormat(DateTimeFormat
				.getFormat(PredefinedFormat.DATE_MEDIUM)));

		table.setWidget(rowCounter++, columnCounter++ % 2, dateOfBirth);

		classLabel = new HTML("Class:&nbsp;");
		table.setWidget(rowCounter, columnCounter++ % 2, classLabel);

		createClassDropdown();
		table.setWidget(rowCounter++, columnCounter++ % 2, classListBox);

		subjectLabel = new HTML("Subjects:&nbsp;");
		table.setWidget(rowCounter, columnCounter++ % 2, subjectLabel);

		subjects = new ListBox(true);
		createSubjectMultiSelect(subjects);
		table.setWidget(rowCounter++, columnCounter++ % 2, subjects);

		extraClassesLabel = new HTML("Enroll for Extra classes:&nbsp;");
		table.setWidget(rowCounter, columnCounter++ % 2, extraClassesLabel);

		extraClassesBox = new CheckBox();
		addExtraCheckboxListener();
		table.setWidget(rowCounter++, columnCounter++ % 2, extraClassesBox);

		extraSubjectsLabel = new HTML("Extra Subjects:&nbsp;");
		extraSubjectsLabel.setVisible(false);
		table.setWidget(rowCounter, columnCounter++ % 2, extraSubjectsLabel);

		extraSubjects = new ListBox(true);
		extraSubjects.setVisible(false);
		createSubjectMultiSelect(extraSubjects);
		table.setWidget(rowCounter++, columnCounter++ % 2, extraSubjects);

		resetFields = new Button("&nbsp;&nbsp;Reset&nbsp;&nbsp;");
		submit = new Button("&nbsp;&nbsp;Submit&nbsp;&nbsp;");

		FlexTable buttonsFt = new FlexTable();
		buttonsFt.setCellSpacing(10);
		buttonsFt.setWidget(0, 0, resetFields);
		buttonsFt.setWidget(0, 1, submit);
		table.getFlexCellFormatter().setColSpan(rowCounter, columnCounter % 2,
				2);
		table.setWidget(rowCounter, columnCounter++ % 2, buttonsFt);

		layoutPanel.add(table);
		layoutPanel.setWidgetLeftRight(table, 1, Unit.PCT, 1, Unit.PCT);
		layoutPanel.setWidgetTopBottom(table, 1, Unit.PCT, 1, Unit.PCT);
		initWidget(layoutPanel);
	}

	/**
	 * 
	 */
	private void createSubjectMultiSelect(ListBox subjects) {
		subjects.setVisibleItemCount(4);
		for (Entry<String, String> entry : subjectsMap.entrySet()) {
			subjects.addItem(entry.getKey(), entry.getValue());
		}
	}

	private void addExtraCheckboxListener() {
		extraClassesBox.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				CheckBox box = (CheckBox) event.getSource();
				boolean isChecked = box.getValue();
				if (isChecked) {
					extraSubjectsLabel.setVisible(true);
					extraSubjects.setVisible(true);
				} else {
					extraSubjectsLabel.setVisible(false);
					extraSubjects.setVisible(false);
					// unselect all
					for (int i = 0; i < extraSubjects.getItemCount(); i++) {
						extraSubjects.setItemSelected(i, false);
					}
				}
			}
		});
	}

	/**
	 * 
	 */
	private void createClassDropdown() {
		classListBox = new ListBox();
		// Hardcode values, should be
		classListBox.addItem("--Select--", "0");
		classListBox.addItem("First", "1");
		classListBox.addItem("Second", "2");
		classListBox.addItem("Third", "3");
		classListBox.addItem("Fourth", "4");
	}
}
