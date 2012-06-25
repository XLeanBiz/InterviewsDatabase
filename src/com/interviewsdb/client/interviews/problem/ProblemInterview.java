package com.interviewsdb.client.interviews.problem;

import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.interviewsdb.client.InitializeInterviewDatabase;
import com.interviewsdb.client.interviews.ProblemRateListbox;
import com.interviewsdb.client.utilities.FormField;

public class ProblemInterview extends VerticalPanel {

	public static JSONObject interview = new JSONObject();

	public static RichTextArea problemUnderstand = new RichTextArea();

	public static RichTextArea haveProblem = new RichTextArea();

	public static RichTextArea whyHaveProblem = new RichTextArea();

	public static ProblemRateListbox problemRateField;

	public static RichTextArea howSolvingProblem = new RichTextArea();

	public static RichTextArea make5Problem = new RichTextArea();

	public static RichTextArea openComments = new RichTextArea();

	public ProblemInterview() {

		this.setSpacing(20);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		
		String customerName = ConvertJson.convertToString(interview
				.get("customerName"));
		this.add(FormField.getStringField("Interviewee", customerName));

		String problem = ConvertJson
				.convertToString(InitializeInterviewDatabase.companyData
						.get("Problem"));
		this.add(FormField.getStringField("Problem", problem));

		ClickHandler clickHandler = new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				ButtonSaveProblemInterview.prepareInterviewJson();
				SaveProblemInterviewField.save();
			}
		};

		String problemUnderstandValue = ConvertJson.convertToString(interview
				.get("problemUnderstand"));
		problemUnderstand.setHTML(problemUnderstandValue);
		problemUnderstand.addClickHandler(clickHandler);
		this.add(FormField.getVerticalFormField(
				"What do you understand from this problem?", problemUnderstand));
		problemUnderstand.setSize("500px", "80px");

		String haveProblemValue = ConvertJson.convertToString(interview
				.get("haveProblem"));
		haveProblem.setHTML(haveProblemValue);
		haveProblem.addClickHandler(clickHandler);
		this.add(FormField.getVerticalFormField("Do you have this problem?",
				haveProblem));
		haveProblem.setSize("500px", "80px");

		String whyHaveProblemValue = ConvertJson.convertToString(interview
				.get("whyHaveProblem"));
		whyHaveProblem.setHTML(whyHaveProblemValue);
		whyHaveProblem.addClickHandler(clickHandler);
		this.add(FormField.getVerticalFormField("Why?", whyHaveProblem));
		whyHaveProblem.setSize("500px", "80px");

		String problemRate = ConvertJson.convertToString(interview
				.get("problemRate"));
		problemRateField = new ProblemRateListbox(problemRate);
		problemRateField.addClickHandler(clickHandler);
		this.add(FormField.getVerticalFormField(
				"How do you rate this problem?", problemRateField));

		String howSolvingProblemValue = ConvertJson.convertToString(interview
				.get("howSolvingProblem"));
		howSolvingProblem.setHTML(howSolvingProblemValue);
		howSolvingProblem.addClickHandler(clickHandler);
		this.add(FormField.getVerticalFormField(
				"How are you solving this problem?", howSolvingProblem));
		howSolvingProblem.setSize("500px", "80px");

		String make5ProblemValue = ConvertJson.convertToString(interview
				.get("make5Problem"));
		make5Problem.setHTML(make5ProblemValue);
		make5Problem.addClickHandler(clickHandler);
		this.add(FormField.getVerticalFormField(
				"What will make this problem a 5?", make5Problem));
		make5Problem.setSize("500px", "80px");

		String openCommentsValue = ConvertJson.convertToString(interview
				.get("openComments"));
		openComments.setHTML(openCommentsValue);
		openComments.addClickHandler(clickHandler);
		this.add(FormField.getVerticalFormField("Comments?", openComments));
		openComments.setSize("500px", "80px");

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.add(new ButtonSaveProblemInterview());
	}
}
