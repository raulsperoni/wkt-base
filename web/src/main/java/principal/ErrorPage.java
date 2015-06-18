package principal;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.model.Model;

import java.io.PrintWriter;
import java.io.StringWriter;

@SuppressWarnings("serial")
public class ErrorPage extends Inicio {

    WebMarkupContainer well = new WebMarkupContainer("well");
    Model<String> stacktracemodel = new Model<String>();
    private boolean mostrarDetalles = false;
    TextArea<String> stacktrace = new TextArea<String>("stacktrace", stacktracemodel) {

        @Override
        public boolean isVisible() {
            return mostrarDetalles;
        }

    };
    AjaxLink<Void> link = new AjaxLink<Void>("link") {

        @Override
        public void onClick(AjaxRequestTarget target) {
            mostrarDetalles = !mostrarDetalles;
            target.add(stacktrace);

        }
    };

    public ErrorPage() {
        super("Error");
    }

    public ErrorPage(Exception ex) {
        String mensaje = " ";
    /*	if (getUsuario() != null)
			mensaje += getUsuario().getNombreRed();*/
        mensaje += ", lamentablemente ha ocurrido un error.";
        Label etiq = new Label("error", Model.of(mensaje));
        add(etiq);

        add(link);

        well.setOutputMarkupId(true);
        well.setOutputMarkupPlaceholderTag(true);
        add(well);

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String stacktracetext = sw.toString();

        stacktracemodel.setObject(stacktracetext);
        stacktrace.setOutputMarkupId(true);
        stacktrace.setOutputMarkupPlaceholderTag(true);
        well.add(stacktrace);

    }

}
