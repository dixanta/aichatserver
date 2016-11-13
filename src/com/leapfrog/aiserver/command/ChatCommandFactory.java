/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.aiserver.command;

import java.util.HashMap;

/**
 *
 * @author USER
 */
public class ChatCommandFactory {
    
    private static HashMap<String,ChatCommand> commands=initCommands();
            
    private static HashMap<String,ChatCommand> initCommands(){
        HashMap<String,ChatCommand> cmds=new HashMap<>();
        cmds.put("pm", new PMCommand());
        cmds.put("list", new ListCommand());
        cmds.put("block", new BlockCommand());
        cmds.put("unblock", new UnblockCommand());
        cmds.put("autoreply", new AutoReplyCommand());
        cmds.put("web", new WebCommand());
        return cmds;
    }
    
    public static ChatCommand get(String param){
        return (commands.containsKey(param))? commands.get(param):null;
    }
}
