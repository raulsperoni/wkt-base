package componentes;

import org.apache.wicket.ajax.attributes.AjaxCallListener;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.markup.html.AjaxLink;

@SuppressWarnings("serial")
public abstract class AjaxLinkConfirmation<T> extends AjaxLink<T> {

    private final String textoConfirmacion;

    public AjaxLinkConfirmation(String id, String textoConfirmacion) {
        super(id);
        this.textoConfirmacion = textoConfirmacion;
    }

    @Override
    protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {
        super.updateAjaxAttributes(attributes);

        AjaxCallListener ajaxCallListener = new AjaxCallListener();
        ajaxCallListener.onPrecondition("return confirm('" + textoConfirmacion + "');");
        attributes.getAjaxCallListeners().add(ajaxCallListener);
    }

}
