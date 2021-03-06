/*
 * generated by Xtext
 */
package org.agileware.natural.cucumber.ui;

import org.agileware.natural.common.AbstractAnnotationDescriptor;
import org.agileware.natural.cucumber.ui.syntaxcoloring.HighlightingConfiguration;
import org.agileware.natural.cucumber.ui.syntaxcoloring.LexicalHighlightingCalculator;
import org.agileware.natural.cucumber.ui.syntaxcoloring.SemanticHighlightingCalculator;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.builder.IXtextBuilderParticipant;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkHelper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;

/**
 * Use this class to register components to be used within the IDE.
 */
public class CucumberUiModule extends AbstractCucumberUiModule {
	
	public final static String[] STEPS = { "Given", "When", "Then", "And", "But" };
	private static final String CUCUMBER_PACKAGE = "cucumber.api.java.en";

	public CucumberUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	@Override
	public Class<? extends IHyperlinkHelper> bindIHyperlinkHelper() {
		return CucumberHyperlinkHelper.class;
	}

	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return HighlightingConfiguration.class;
	}

	public Class<? extends AbstractAntlrTokenToAttributeIdMapper> bindAbstractAntlrTokenToAttributeIdMapper() {
		return LexicalHighlightingCalculator.class;
	}
	
	public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return SemanticHighlightingCalculator.class;
	}

	@Override
	public Class<? extends IXtextBuilderParticipant> bindIXtextBuilderParticipant() {
		return BuilderParticipant.class;
	}
	
//	public Class<? extends ISyntaxErrorMessageProvider> bindISyntaxErrorMessageProvider() {
//		return SyntaxErrorMessageProvider.class;
//	}
	
	public Class<? extends AbstractAnnotationDescriptor> bindAnnotationDescriptor() {
		return CucumberAnnotationDescriptor.class;
	}
	
	public static class CucumberAnnotationDescriptor extends AbstractAnnotationDescriptor {

		@Override
		public String[] getNames() {
			return STEPS;
		}

		@Override
		public String getPackage() {
			return CUCUMBER_PACKAGE;
		}
	}
}
