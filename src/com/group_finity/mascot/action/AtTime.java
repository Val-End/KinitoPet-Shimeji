package com.group_finity.mascot.action;

import com.group_finity.mascot.exception.LostGroundException;
import com.group_finity.mascot.exception.VariableException;
import com.group_finity.mascot.script.VariableMap;

import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AtTime extends ComplexAction{
    private static int lastMinute = 0;

    private static final Logger log = Logger.getLogger(AtTime.class.getName());

    public static final String PARAMETER_HOUR = "Hour";
    public static final String PARAMETER_MINUTE = "Minute";

    private static final int DEFAULT_HOUR = 0;
    private static final int DEFAULT_MINUTE = 0;

    public AtTime(ResourceBundle schema, VariableMap params, Action... actions) {
        super(schema, params, actions);
    }

    @Override
    public boolean hasNext() throws VariableException {
        seek();
        return super.hasNext();
    }

    @Override
    protected void tick() throws LostGroundException, VariableException {
        int minuteNow = LocalTime.now().getMinute();
        if(minuteNow != lastMinute) {
            log.log(Level.INFO, "Minute Update");
            lastMinute = LocalTime.now().getMinute();

            int hourNow = LocalTime.now().getHour();
            int xmlHour = eval( getSchema( ).getString( PARAMETER_HOUR ), Integer.class, DEFAULT_HOUR );
            int xmlMinute = eval( getSchema( ).getString( PARAMETER_MINUTE ), Integer.class, DEFAULT_MINUTE );

            if(xmlHour == hourNow && xmlMinute == minuteNow) {
                
            }
        }
        super.tick();
    }
}
