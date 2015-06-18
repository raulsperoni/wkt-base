package componentes;

import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigator;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.markup.html.navigation.paging.IPagingLabelProvider;

/**
 * Created with IntelliJ IDEA. User: gonzalo Date: 11/10/13 Time: 01:22 PM
 */
@SuppressWarnings("serial")
public class BootstrapAjaxPagingNavigator extends AjaxPagingNavigator {
    private Size size;

    public BootstrapAjaxPagingNavigator(String id, IPageable pageable) {
        super(id, pageable);
        this.size = Size.normal;
    }

    public BootstrapAjaxPagingNavigator(String id, IPageable pageable, IPagingLabelProvider labelProvider) {
        super(id, pageable, labelProvider);
        this.size = Size.normal;
    }

    public BootstrapAjaxPagingNavigator(String id, IPageable pageable, IPagingLabelProvider labelProvider, Size size) {
        super(id, pageable, labelProvider);
        this.size = size;
    }

    public BootstrapAjaxPagingNavigator(String id, IPageable pageable, Size size) {
        super(id, pageable);
        this.size = size;
    }

    @Override
    public String getVariation() {
        if (size == Size.normal)
            return "";
        return size.toString();
    }

    public void setTamanio(Size size) {
        this.size = size;
    }

    public enum Size {
        small, normal, large
    }

}
