package com.group_finity.mascot.action;

import java.util.List;

import com.group_finity.mascot.animation.Animation;
import com.group_finity.mascot.script.VariableMap;

/**
 * Original Author: Yuki Yamada of Group Finity (http://www.group-finity.com/Shimeji/)
 * Currently developed by Shimeji-ee Group.
 */
@Deprecated
public class MoveWithTurn extends Move
{
    public MoveWithTurn( java.util.ResourceBundle schema, final List<Animation> animations, final VariableMap params )
    {
        super( schema, animations, params );
        if( animations.size( ) < 2 )
            throw new IllegalArgumentException( "animations.size<2" );
        else
            animations.get( animations.size( ) - 1 ).setTurn( true );
    }
}
