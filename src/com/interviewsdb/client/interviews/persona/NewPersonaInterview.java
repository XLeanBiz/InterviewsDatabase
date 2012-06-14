package com.interviewsdb.client.interviews.persona;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.interviewsdb.client.InitializeInterviewDatabase;
import com.interviewsdb.client.interviews.ProblemRateListbox;
import com.interviewsdb.client.utilities.ConvertJson;
import com.interviewsdb.client.utilities.FormField;

public class NewPersonaInterview extends VerticalPanel {

	public static RichTextArea describeYourself = new RichTextArea();

	public static RichTextArea routine = new RichTextArea();

	public static RichTextArea mainProblem = new RichTextArea();

	public static ProblemRateListbox mainProblemRateField;

	public static RichTextArea solutionMainProblem = new RichTextArea();

	public static RichTextArea secondMainProblem = new RichTextArea();

	public static ProblemRateListbox secondProblemRateField;

	public static RichTextArea solutionSecondProblem = new RichTextArea();

	public static RichTextArea otherProblems = new RichTextArea();

	public static RichTextArea openComments = new RichTextArea();

	public NewPersonaInterview(JSONObject interview) {

		this.setSpacing(20);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		//String company = ConvertJson.convertToString(interview.get("company"));
		// this.add(FormField.getStringField("Company", company));

		String customerName = ConvertJson.convertToString(interview
				.get("customerName"));
		this.add(FormField.getStringField("Interviewee", customerName));

		String personaName = ConvertJson
				.convertToString(InitializeInterviewDatabase.companyData
						.get("Persona"));
		this.add(FormField.getStringField("Persona", personaName));

		String describeYourselfValue = ConvertJson.convertToString(interview
				.get("describeYourself"));
		describeYourself.setHTML(describeYourselfValue);
		this.add(FormField.getVerticalFormField(
				"How do you describe yourself as a " + personaName + "?",
				describeYourself));
		describeYourself.setSize("500px", "80px");

		String routineValue = ConvertJson.convertToString(interview
				.get("rountine"));
		routine.setHTML(routineValue);
		this.add(FormField.getVerticalFormField("How is your routine as a "
				+ personaName + "?", routine));
		routine.setSize("500px", "80px");

		String mainProblemValue = ConvertJson.convertToString(interview
				.get("mainProblem"));
		mainProblem.setHTML(mainProblemValue);
		this.add(FormField.getVerticalFormField(
				"What is your main problem as a " + personaName + "?",
				mainProblem));
		mainProblem.setSize("500px", "80px");

		String mainProblemRate = ConvertJson.convertToString(interview
				.get("mainProblemRate"));
		mainProblemRateField = new ProblemRateListbox(mainProblemRate);
		this.add(FormField.getVerticalFormField(
				"How do you rate this problem?", mainProblemRateField));

		String solutionMainProblemValue = ConvertJson.convertToString(interview
				.get("solutionMainProblem"));
		solutionMainProblem.setHTML(solutionMainProblemValue);
		this.add(FormField.getVerticalFormField(
				"How are you solving this problem today?", solutionMainProblem));
		solutionMainProblem.setSize("500px", "80px");

		String secondMainProblemValue = ConvertJson.convertToString(interview
				.get("secondMainProblem"));
		secondMainProblem.setHTML(secondMainProblemValue);
		this.add(FormField.getVerticalFormField(
				"What is your second main problem as a " + personaName + "?",
				secondMainProblem));
		secondMainProblem.setSize("500px", "80px");

		String secondProblemRate = ConvertJson.convertToString(interview
				.get("secondProblemRate"));
		secondProblemRateField = new ProblemRateListbox(secondProblemRate);
		this.add(FormField.getVerticalFormField(
				"How do you rate this problem?", secondProblemRateField));

		String solutionSecondProblemValue = ConvertJson
				.convertToString(interview.get("solutionSecondProblem"));
		solutionSecondProblem.setHTML(solutionSecondProblemValue);
		this.add(FormField.getVerticalFormField(
				"How are you solving this problem today?",
				solutionSecondProblem));
		solutionSecondProblem.setSize("500px", "80px");

		String otherProblemsValue = ConvertJson.convertToString(interview
				.get("otherProblems"));
		otherProblems.setHTML(otherProblemsValue);
		this.add(FormField.getVerticalFormField("Other Problems?",
				otherProblems));
		otherProblems.setSize("500px", "80px");

		String openCommentsValue = ConvertJson.convertToString(interview
				.get("openComments"));
		openComments.setHTML(openCommentsValue);
		this.add(FormField.getVerticalFormField("Open comments:", openComments));
		openComments.setSize("500px", "80px");

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.add(new ButtonSavePersonaInterview(interview));
	}
}
