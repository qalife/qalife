package pages;

import java.util.ResourceBundle;
import static java.util.ResourceBundle.getBundle;

public class LoginPage extends Page{
    private final ResourceBundle resourceBundle;
    private final String url;
    private final String explicitTime;
    public final String googleBtnSearchLoc;
    public final String jsonendpoint;

    public LoginPage() {
        resourceBundle = getBundle("pages.LoginPage");
        url = this.getResourceBundle().getString("url");
        explicitTime = this.getResourceBundle().getString("explicitTime");
        googleBtnSearchLoc = this.getResourceBundle().getString("googleBtnSearchLoc");
        jsonendpoint = this.getResourceBundle().getString("jsonendpoint");
    }
    @Override
    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }
    @Override
    public String getUrl() {
        return url;
    }
    @Override
    public int getExplicitTime() {
        int expTime = Integer.parseInt(explicitTime);
        return expTime;
    }
}

