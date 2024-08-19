package com.group_finity.mascot.action;

import com.group_finity.mascot.Mascot;
import com.group_finity.mascot.exception.VariableException;
import com.group_finity.mascot.script.VariableMap;

import java.awt.*;
import java.net.URI;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class OpenURL extends ComplexAction {

    private static final Logger log = Logger.getLogger(OpenURL.class.getName());

    public static final String PARAMETER_URL = "URL";

    private static final String DEFAULT_URL = "https://www.kinitopet.com/";

    public OpenURL(ResourceBundle schema, VariableMap params, Action... actions) {
        super(schema, params, actions);
    }

    @Override
    public boolean hasNext() throws VariableException {
        seek();
        return super.hasNext();
    }

    @Override
    protected void setCurrentAction(final int currentAction) throws VariableException {
        super.setCurrentAction(currentAction);
    }

    @Override
    public void init(Mascot mascot) throws VariableException {
        super.init(mascot);

        Desktop desktop = Desktop.isDesktopSupported( ) ? Desktop.getDesktop( ) : null;
        String URL_VALUE = eval( getSchema( ).getString( PARAMETER_URL ), String.class, DEFAULT_URL );

        try {
            if( desktop != null && desktop.isSupported( Desktop.Action.BROWSE ) )
                desktop.browse( new URI( URL_VALUE ) );
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
