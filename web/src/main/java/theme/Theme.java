package theme;

import componentes.FooterPanel;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.filter.FilteredHeaderItem;
import org.apache.wicket.markup.head.filter.JavaScriptFilteredIntoFooterHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.protocol.http.ClientProperties;
import org.apache.wicket.protocol.http.request.WebClientInfo;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

@SuppressWarnings("serial")
public class Theme extends WebPage {

    private String pageTitle;

    public Theme() {

    }

    public Theme(String pageTitle) {
        this.pageTitle = pageTitle;
        add(new Label("pageTitle", this.pageTitle));
        // add(new Label("pageTagline", this.pageTitle));

        add(new FooterPanel("footer"));
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);

        response.render(CssHeaderItem.forReference(new CssResourceReference(Theme.class, "css/bootstrap.css")));

        response.render(CssHeaderItem.forReference(new CssResourceReference(Theme.class, "css/style.css")));

        WebClientInfo clientInfo = (WebClientInfo) getSession().getClientInfo();
        ClientProperties properties = clientInfo.getProperties();

        response.render(new FilteredHeaderItem(JavaScriptHeaderItem.forReference(new JavaScriptResourceReference(
                Theme.class, "js/jquery-1.11.0.min.js")),
                JavaScriptFilteredIntoFooterHeaderResponse.HEADER_FILTER_NAME));

        response.render(new FilteredHeaderItem(JavaScriptHeaderItem.forReference(new JavaScriptResourceReference(
                Theme.class, "js/bootstrap.min.js")),
                JavaScriptFilteredIntoFooterHeaderResponse.HEADER_FILTER_NAME));

        if (properties.isBrowserInternetExplorer() && properties.getBrowserVersionMajor() <= 8) {

            response.render(new FilteredHeaderItem(JavaScriptHeaderItem.forReference(new JavaScriptResourceReference(
                    Theme.class, "js/html5shiv.js")),
                    JavaScriptFilteredIntoFooterHeaderResponse.HEADER_FILTER_NAME));
            response.render(new FilteredHeaderItem(JavaScriptHeaderItem.forReference(new JavaScriptResourceReference(
                    Theme.class, "js/respond.min.js")),
                    JavaScriptFilteredIntoFooterHeaderResponse.HEADER_FILTER_NAME));
        }

    }

}
