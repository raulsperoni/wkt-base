package componentes;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.feedback.IFeedbackMessageFilter;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

import java.io.Serializable;

/**
 * Created by gonzalo on 27/03/14.
 */
@SuppressWarnings("serial")
public class BootstrapFeedbackPanel extends FeedbackPanel {

    private int nombreId = 0;

    public BootstrapFeedbackPanel(String id) {
        super(id);
    }

    public BootstrapFeedbackPanel(String id, IFeedbackMessageFilter filter) {
        super(id, filter);
    }

    @Override
    protected String getCSSClass(final FeedbackMessage message) {
        String s;
        switch (message.getLevel()) {
            case FeedbackMessage.ERROR:
            case FeedbackMessage.FATAL:
                s = "alert alert-dismissable alert-danger";
                break;
            case FeedbackMessage.WARNING:
                s = "alert alert-dismissable alert-warning";
                break;
            case FeedbackMessage.DEBUG:
                s = "alert alert-dismissable alert-primary";
                break;
            case FeedbackMessage.SUCCESS:
                s = "alert alert-dismissable alert-success";
                break;
            case FeedbackMessage.INFO:
            default:
                s = "alert alert-dismissable alert-info";
                break;
        }
        return s;
    }

    @Override
    protected Component newMessageDisplayComponent(String id, FeedbackMessage message) {
        Serializable serializable = message.getMessage();
        Label label = new Label(id, (serializable == null) ? "" : serializable.toString()) {
            @Override
            public Component add(Behavior... behavior) {
                super.add(new AttributeModifier("id", "mensaje" + nombreId++));
                return this;
            }
        };
        label.setEscapeModelStrings(super.getEscapeModelStrings());
        return label;
    }
}
